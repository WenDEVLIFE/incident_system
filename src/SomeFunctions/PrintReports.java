package SomeFunctions;

import model.IncidentModel;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class PrintReports {

    private static PrintReports instance;

    public static PrintReports getInstance() {
        if (instance == null) {
            instance = new PrintReports();
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
        fileChooser.setDialogTitle("Save CSV Report");
        fileChooser.setSelectedFile(new File(statusFilter.replace(" ", "") + "Report_" + timeRange + ".csv"));

        int result = fileChooser.showSaveDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Save cancelled.");
            return;
        }

        File file = fileChooser.getSelectedFile();
        if (!file.getName().endsWith(".csv")) {
            file = new File(file.getAbsolutePath() + ".csv");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String[] headers = {"ID", "Incident", "Date", "Time", "Location", "Status", "People Involved","Description", "Narratives", "Reporting Officer"};
            writer.write(String.join(",", headers));
            writer.newLine();

            for (IncidentModel incident : filteredIncidents) {
                String[] values = {
                        escape(incident.getId()),
                        escape(incident.getIncident()),
                        escape(incident.getDate()),
                        escape(incident.getTime()),
                        escape(incident.getLocation()),
                        escape(incident.getStatus()),
                        escape(incident.getPeopleInvolved()),
                        escape(incident.getDescription()),
                        escape(incident.getNarratives()),
                        escape(incident.getOfficerInCharge())
                };
                writer.write(String.join(",", values));
                writer.newLine();
            }

            JOptionPane.showMessageDialog(null, "✅ CSV saved at:\n" + file.getAbsolutePath());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ CSV generation failed:\n" + e.getMessage());
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
