package SomeFunctions;
import java.io.File;
import java.io.FileOutputStream;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.usermodel.*;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.IncidentModel;

public class PrintToDocx {

    private static PrintToDocx instance;

    public static PrintToDocx getInstance() {
        if (instance == null) {
            instance = new PrintToDocx();
        }
        return instance;
    }

    public void printPendingReport(List<IncidentModel> data) {
        showTimeRangeDialog("Pending", data);
    }

    public void printUnderInvestigationReport(List<IncidentModel> data) {
        showTimeRangeDialog("Under Investigation", data);
    }

    private void showTimeRangeDialog(String status, List<IncidentModel> data) {
        JDialog dialog = new JDialog((JFrame) null, "Select Time Range", true);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Select Time Range:");
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JButton dailyButton = new JButton("Daily");
        JButton weeklyButton = new JButton("Weekly");
        JButton monthlyButton = new JButton("Monthly");

        dailyButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        weeklyButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        monthlyButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

        dialog.add(Box.createVerticalStrut(15));
        dialog.add(label);
        dialog.add(Box.createVerticalStrut(10));
        dialog.add(dailyButton);
        dialog.add(Box.createVerticalStrut(5));
        dialog.add(weeklyButton);
        dialog.add(Box.createVerticalStrut(5));
        dialog.add(monthlyButton);
        dialog.add(Box.createVerticalStrut(15));

        dailyButton.addActionListener(e -> {
            generateFilteredReport("daily", data, status);
            dialog.dispose();
        });

        weeklyButton.addActionListener(e -> {
            generateFilteredReport("weekly", data, status);
            dialog.dispose();
        });

        monthlyButton.addActionListener(e -> {
            generateFilteredReport("monthly", data, status);
            dialog.dispose();
        });

        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }


    private void generateFilteredReport(String timeRange, List<IncidentModel> data, String statusFilter) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();

        List<IncidentModel> filteredIncidents = data.stream()
                .filter(incident -> {
                    try {
                        String rawDate = incident.getDate();
                        if (rawDate == null || rawDate.trim().isEmpty()) return false;

                        LocalDate incidentDate = LocalDate.parse(rawDate.trim(), formatter);

                        boolean timeMatch = false;
                        if ("daily".equals(timeRange)) {
                            timeMatch = incidentDate.isEqual(today);
                        } else if ("weekly".equals(timeRange)) {
                            timeMatch = !incidentDate.isBefore(today.minusDays(7)) && !incidentDate.isAfter(today);
                        } else if ("monthly".equals(timeRange)) {
                            timeMatch = incidentDate.getMonth() == today.getMonth() &&
                                    incidentDate.getYear() == today.getYear();
                        }

                        return timeMatch && statusFilter.equalsIgnoreCase(incident.getStatus().trim());

                    } catch (Exception e) {
                        System.out.println("❌ Invalid date format: '" + incident.getDate() + "'");
                        return false;
                    }
                })
                .collect(Collectors.toList());

        if (filteredIncidents.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No incidents found for the selected time range.");
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Word Report");
        fileChooser.setSelectedFile(new File(statusFilter.replace(" ", "") + "Report_" + timeRange + ".docx"));

        int result = fileChooser.showSaveDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Save cancelled.");
            return;
        }

        File file = fileChooser.getSelectedFile();
        if (!file.getName().endsWith(".docx")) {
            file = new File(file.getAbsolutePath() + ".docx");
        }

        try (XWPFDocument document = new XWPFDocument()) {
            // Method to add the title
            addTitle(document, statusFilter, timeRange);

            for (int i = 0; i < filteredIncidents.size(); i++) {
                IncidentModel incident = filteredIncidents.get(i);

                // Add incident details
                XWPFParagraph paragraph = document.createParagraph();
                paragraph.setSpacingBefore(500); // Add space before the paragraph (value in twips)

                XWPFRun run = paragraph.createRun();
                run.setFontSize(12); // Set font size
                String reportText =
                        "The Case ID Number is " + escape(incident.getId()) + ".\n" +
                        "This report pertains to an incident categorized as \"" + escape(incident.getIncident()) + "\".\n" +
                        "The incident occurred on " + escape(incident.getDate()) + " at " + escape(incident.getTime()) + ".\n" +
                        "The location of the incident is specified as " + escape(incident.getLocation()) + ".\n" +
                        "Currently, the status of the incident is \"" + escape(incident.getStatus()) + "\".\n" +
                        "The individuals involved in this incident are: " + escape(incident.getPeopleInvolved()) + ".\n" +
                        "A brief description of the incident is as follows: " + escape(incident.getDescription()) + ".\n" +
                        "Additional narratives provided include: " + escape(incident.getNarratives()) + ".\n" +
                        "This report was filed by the reporting officer, " + escape(incident.getOfficerInCharge());
                run.setText(reportText);

                // Add right-aligned paragraph
                XWPFParagraph rightAlignedParagraph = document.createParagraph();
                rightAlignedParagraph.setAlignment(ParagraphAlignment.RIGHT);
                rightAlignedParagraph.setSpacingBefore(500);

                XWPFParagraph rightAlignedParagraph1 = document.createParagraph();
                rightAlignedParagraph1.setAlignment(ParagraphAlignment.RIGHT);

                XWPFRun rightRun = rightAlignedParagraph.createRun();
                rightRun.setFontSize(12);
                rightRun.setText(incident.getOfficerInCharge());

                XWPFRun rightRun2 = rightAlignedParagraph1.createRun();
                rightRun2.setFontSize(12);
                rightRun2.setText(" - Reporting Officer");

                // Add a page break and re-add the title if this is not the last incident
                if (i < filteredIncidents.size() - 1) {
                    document.createParagraph().setPageBreak(true);
                    addTitle(document, statusFilter, timeRange);
                }
            }

            try (FileOutputStream out = new FileOutputStream(file)) {
                document.write(out);
            }

            JOptionPane.showMessageDialog(null, "✅ Word document saved at:\n" + file.getAbsolutePath());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Word document generation failed:\n" + e.getMessage());
            e.printStackTrace();
        }
    }
    
        private String escape(String value) {
            if (value == null) return "";
            if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
                value = value.replace("\"", "\"\"");
                return "\"" + value + "\"";
            }
            return value;
        }

    // Method to add the title
    private void addTitle(XWPFDocument document, String statusFilter, String timeRange) {
        XWPFParagraph title = document.createParagraph();
        title.setSpacingBefore(400); // Set spacing before the paragraph
        title.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun titleRun1 = title.createRun();
        titleRun1.setText("Incident Report System");
        titleRun1.setBold(true);
        titleRun1.setFontSize(24);

        title.createRun().addBreak(); // Add a line break between titles

        XWPFRun titleRun2 = title.createRun();
        titleRun2.setText(statusFilter + " Report (" + timeRange + ")");
        titleRun2.setBold(true);
        titleRun2.setFontSize(24);

        title.createRun().addBreak();

        XWPFParagraph titleParagraph3 = document.createParagraph();
        titleParagraph3.setSpacingBefore(400); // Add spacing before the paragraph (value in twips)
        titleParagraph3.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun titleRun3 = titleParagraph3.createRun();
        titleRun3.setText("Incident Report");
        titleRun3.setBold(true);
        titleRun3.setFontSize(24);

   
    }
}
