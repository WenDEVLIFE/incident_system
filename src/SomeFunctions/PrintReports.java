package SomeFunctions;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import model.IncidentModel;

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
        fileChooser.setDialogTitle("Save PDF Report");
        fileChooser.setSelectedFile(new java.io.File(statusFilter.replace(" ", "") + "Report_" + timeRange + ".pdf"));

        int result = fileChooser.showSaveDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Save cancelled.");
            return;
        }

        java.io.File file = fileChooser.getSelectedFile();
        if (!file.getName().endsWith(".pdf")) {
            file = new java.io.File(file.getAbsolutePath() + ".pdf");
        }

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph(statusFilter + " Incidents Report (" + timeRange.toUpperCase() + ")", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("Generated on: " + today.format(formatter)));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.addCell("ID");
            table.addCell("Incident");
            table.addCell("Date");
            table.addCell("Location");
            table.addCell("Status");

            for (IncidentModel incident : filteredIncidents) {
                table.addCell(incident.getId());
                table.addCell(incident.getIncident());
                table.addCell(incident.getDate());
                table.addCell(incident.getLocation());
                table.addCell(incident.getStatus());
            }

            document.add(table);
            document.close();

            JOptionPane.showMessageDialog(null, "PDF saved at:\n" + file.getAbsolutePath());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "PDF generation failed:\n" + e.getMessage());
            e.printStackTrace();
        }
    }
}
