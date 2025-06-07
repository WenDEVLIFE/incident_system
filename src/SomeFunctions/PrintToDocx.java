package SomeFunctions;
import java.io.File;
import java.io.FileOutputStream;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.usermodel.*;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
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
            XWPFParagraph title = document.createParagraph();
            title.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun titleRun = title.createRun();
            titleRun.setText(statusFilter + " Report (" + timeRange + ")");
            titleRun.setBold(true);
            titleRun.setFontSize(16);

            for (IncidentModel incident : filteredIncidents) {
                XWPFParagraph paragraph = document.createParagraph();
                XWPFRun run = paragraph.createRun();
                run.setText("ID: " + escape(incident.getId()));
                run.addBreak();
                run.setText("Incident: " + escape(incident.getIncident()));
                run.addBreak();
                run.setText("Date: " + escape(incident.getDate()));
                run.addBreak();
                run.setText("Time: " + escape(incident.getTime()));
                run.addBreak();
                run.setText("Location: " + escape(incident.getLocation()));
                run.addBreak();
                run.setText("Status: " + escape(incident.getStatus()));
                run.addBreak();
                run.setText("People Involved: " + escape(incident.getPeopleInvolved()));
                run.addBreak();
                run.setText("Description: " + escape(incident.getDescription()));
                run.addBreak();
                run.setText("Narratives: " + escape(incident.getNarratives()));
                run.addBreak();
                run.setText("Reporting Officer: " + escape(incident.getOfficerInCharge()));

                // Add a page break after each incident
                document.createParagraph().setPageBreak(true);
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
}
