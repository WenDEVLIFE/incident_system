package SomeFunctions;
import java.io.File;
import java.io.FileInputStream;
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
import org.apache.poi.util.Units;

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
                        "This Incident details an incident involving " + escape(incident.getPeopleInvolved()) +
                                ", which took place at " + escape(incident.getLocation()) + " on " + escape(incident.getDate()) +
                                " at around " + escape(incident.getTime()) + ". The incident has been classified as \"" +
                                escape(incident.getIncident()) + "\", and is currently marked with the status of \"" +
                                escape(incident.getStatus()) + "\".\n\n" +
                                "According to the report, the incident unfolded as follows: " + escape(incident.getDescription()) +
                                ". Further accounts and additional narratives provided regarding this matter include: " +
                                escape(incident.getNarratives()) + ".\n\n" +
                                "This report has been formally submitted by Officer " + escape(incident.getOfficerInCharge()) + ".";
                run.setText(reportText);

                // Add right-aligned paragraph
                XWPFParagraph leftParagraph = document.createParagraph();
                leftParagraph.setAlignment(ParagraphAlignment.LEFT);
                leftParagraph.setSpacingBefore(500);


                XWPFRun leftRun1 = leftParagraph.createRun();
                leftRun1.setFontSize(12);
                leftRun1.setText("Type of Incident: " + incident.getIncident());
                leftRun1.addBreak();

                XWPFRun leftRun3 = leftParagraph.createRun();
                leftRun3.setFontSize(12);
                leftRun3.setText("Time: " + incident.getTime());
                leftRun3.addBreak();

                XWPFRun leftRun2 = leftParagraph.createRun();
                leftRun2.setFontSize(12);
                leftRun2.setText("Date: " + incident.getDate());
                leftRun2.addBreak();

                XWPFRun leftRun4 = leftParagraph.createRun();
                leftRun4.setFontSize(12);
                leftRun4.setText("Location: " + incident.getLocation());
                leftRun4.addBreak();

                XWPFRun leftRun6 = leftParagraph.createRun();
                leftRun6.setFontSize(12);
                leftRun6.setText("People Involved: " + incident.getPeopleInvolved());
                leftRun6.addBreak();

                XWPFRun leftRun7 = leftParagraph.createRun();
                leftRun7.setFontSize(12);
                leftRun7.setText("Reporting Officer:" + incident.getOfficerInCharge());
                leftRun7.addBreak();


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

    private void addTitle(XWPFDocument document, String statusFilter, String timeRange) {
        // Add the logo on the left side
        XWPFParagraph logoParagraph = document.createParagraph();
        logoParagraph.setAlignment(ParagraphAlignment.LEFT); // Align the logo to the left
        XWPFRun logoRun = logoParagraph.createRun();
        try (FileInputStream logoStream = new FileInputStream("src/Picture/pnp.png")) { // Replace with the actual path to your logo
            logoRun.addPicture(logoStream, Document.PICTURE_TYPE_PNG, "logo.png", Units.toEMU(50), Units.toEMU(50)); // Adjust size as needed
        } catch (Exception e) {
            System.out.println("❌ Failed to add logo: " + e.getMessage());
        }

        // Add the text centered to the right
        XWPFParagraph textParagraph = document.createParagraph();
        textParagraph.setAlignment(ParagraphAlignment.CENTER); // Align the text to the right
        textParagraph.setIndentationLeft(300); // Adjust indentation to simulate center-right alignment

        XWPFRun textRun = textParagraph.createRun();
        textRun.setBold(true);
        textRun.setFontSize(16);
        textRun.setText("REPUBLIC OF THE PHILIPPINES\n");
        textRun.addBreak();
        textRun.setText("PROVINCE OF AURORA\n");
        textRun.addBreak();
        textRun.setText("MUNICIPALITY OF SAN LUIS\n");
        textRun.addBreak();
        textRun.setText("BARANGAY 03");

        XWPFParagraph titleParagraph3 = document.createParagraph();
        titleParagraph3.setSpacingBefore(400); // Add spacing before the paragraph (value in twips)
        titleParagraph3.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun5 = titleParagraph3.createRun();
        titleRun5.setText("Incident Report");
        titleRun5.setBold(true);
        titleRun5.setFontSize(18);
    }
}
