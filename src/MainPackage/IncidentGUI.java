/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MainPackage;

import SomeFunctions.Helper;
import model.IncidentModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class IncidentGUI extends javax.swing.JFrame {

    DefaultTableModel casesTableModel;
    DefaultTableModel pendingTableModel;
     DefaultTableModel underInvestigationTableModel;
    DefaultTableModel resolvedTableModel;
    List<IncidentModel > casesList = new ArrayList<>();
    List <IncidentModel> pendingList = new ArrayList<>();
    List <IncidentModel> underInvestigationList = new ArrayList<>();
    List <IncidentModel> resolvedList = new ArrayList<>();

    /**
     * Creates new form IncedentGUI
     */
    public IncidentGUI() {
        initComponents();
        setTitle("Incidents");
        setResizable(false);

        String [] columnNames = {"ID", "Type of Incident", "Date", "Time", "Location", "Description", "Narratives", "People Involved", "Reporting Officer", "Status"};
        casesTableModel = new DefaultTableModel(columnNames, 0);
        jTable1.setModel(casesTableModel);

        // Set the table model for the pending tab
        pendingTableModel = new DefaultTableModel(columnNames, 0);
        jTable2.setModel(pendingTableModel);

        // Set the table model for the under investigation tab
        underInvestigationTableModel = new DefaultTableModel(columnNames, 0);
        jTable3.setModel(underInvestigationTableModel);

        // Set the table model for the resolved tab
        String [] resolvedColumnNames = {"ID", "Type of Incident", "Date", "Time", "Location", "Resolved Description", "People Involved", "Reporting Officer", "Resolved By", "Status" };
        resolvedTableModel = new DefaultTableModel(resolvedColumnNames, 0);
        jTable4.setModel(resolvedTableModel);


        // Load existing incidents into the table
        loadIncidents();

        SearchCasesField.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String searchText = SearchCasesField.getText().toLowerCase();
                casesTableModel.setRowCount(0); // Clear the table before adding filtered rows

                if (searchText.isEmpty()){
                    loadIncidents();

                    return;
                }

                for (IncidentModel incident : casesList) {
                    if (incident.getIncident().toLowerCase().contains(searchText) ||
                            incident.getDate().toLowerCase().contains(searchText) ||
                            incident.getTime().toLowerCase().contains(searchText) ||
                            incident.getLocation().toLowerCase().contains(searchText) ||
                            incident.getDescription().toLowerCase().contains(searchText) ||
                            incident.getNarratives().toLowerCase().contains(searchText) ||
                            incident.getPeopleInvolved().toLowerCase().contains(searchText) ||
                            incident.getOfficerInCharge().toLowerCase().contains(searchText)) {
                        casesTableModel.addRow(new Object[]{
                                incident.getId(),
                                incident.getIncident(),
                                incident.getDate(),
                                incident.getTime(),
                                incident.getLocation(),
                                incident.getDescription(),
                                incident.getNarratives(),
                                incident.getPeopleInvolved(),
                                incident.getOfficerInCharge(),
                                incident.getStatus()
                        });
                    }
                }


            }
        });

        SearchPendingField.addActionListener(
                evt -> {
                    String searchText = SearchPendingField.getText().toLowerCase();
                    pendingTableModel.setRowCount(0); // Clear the table before adding filtered rows

                    if (searchText.isEmpty()){
                        loadIncidents();

                        return;
                    }

                    for (IncidentModel incident : pendingList) {
                        if (incident.getIncident().toLowerCase().contains(searchText) ||
                                incident.getDate().toLowerCase().contains(searchText) ||
                                incident.getTime().toLowerCase().contains(searchText) ||
                                incident.getLocation().toLowerCase().contains(searchText) ||
                                incident.getDescription().toLowerCase().contains(searchText) ||
                                incident.getPeopleInvolved().toLowerCase().contains(searchText) ||
                                incident.getOfficerInCharge().toLowerCase().contains(searchText)) {
                            pendingTableModel.addRow(new Object[]{
                                    incident.getId(),
                                    incident.getIncident(),
                                    incident.getDate(),
                                    incident.getTime(),
                                    incident.getLocation(),
                                    incident.getDescription(),
                                    incident.getPeopleInvolved(),
                                    incident.getOfficerInCharge(),
                                    incident.getStatus()
                            });
                        }
                    }
                }
        );

        SearchInvestigationField.addActionListener(
                evt -> {
                    String searchText = SearchInvestigationField.getText().toLowerCase();
                    underInvestigationTableModel.setRowCount(0); // Clear the table before adding filtered rows

                    if (searchText.isEmpty()){
                        loadIncidents();

                        return;
                    }

                    for (IncidentModel incident : underInvestigationList) {
                        if (incident.getIncident().toLowerCase().contains(searchText) ||
                                incident.getDate().toLowerCase().contains(searchText) ||
                                incident.getTime().toLowerCase().contains(searchText) ||
                                incident.getLocation().toLowerCase().contains(searchText) ||
                                incident.getDescription().toLowerCase().contains(searchText) ||
                                incident.getPeopleInvolved().toLowerCase().contains(searchText) ||
                                incident.getOfficerInCharge().toLowerCase().contains(searchText)) {
                            underInvestigationTableModel.addRow(new Object[]{
                                    incident.getId(),
                                    incident.getIncident(),
                                    incident.getDate(),
                                    incident.getTime(),
                                    incident.getLocation(),
                                    incident.getDescription(),
                                    incident.getPeopleInvolved(),
                                    incident.getOfficerInCharge(),
                                    incident.getStatus()
                            });
                        }
                    }
                }
        );


        SearchResolveField.addActionListener(
                evt -> {
                    String searchText = SearchResolveField.getText().toLowerCase();
                    resolvedTableModel.setRowCount(0); // Clear the table before adding filtered rows

                    if (searchText.isEmpty()){
                        loadIncidents();

                        return;
                    }

                    for (IncidentModel incident : resolvedList) {
                        if (incident.getIncident().toLowerCase().contains(searchText) ||
                                incident.getDate().toLowerCase().contains(searchText) ||
                                incident.getTime().toLowerCase().contains(searchText) ||
                                incident.getLocation().toLowerCase().contains(searchText) ||
                                incident.getDescription().toLowerCase().contains(searchText) ||
                                incident.getPeopleInvolved().toLowerCase().contains(searchText) ||
                                incident.getOfficerInCharge().toLowerCase().contains(searchText)) {
                            resolvedTableModel.addRow(new Object[]{
                                    incident.getId(),
                                    incident.getIncident(),
                                    incident.getDate(),
                                    incident.getTime(),
                                    incident.getLocation(),
                                    incident.getDescription(),
                                    incident.getPeopleInvolved(),
                                    incident.getOfficerInCharge(),
                                    incident.getStatus()
                            });
                        }
                    }
                }
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        SearchCasesField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        SearchPendingField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        SearchInvestigationField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        SearchResolveField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(0, 204, 204));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Type of Incidenbt", "Date", "Time", "Location", "Description", "People Involved", "Reporting Officer", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        SearchCasesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchCasesFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Search Incident, ID and etc:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchCasesField, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchCasesField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("All Cases                                    ", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Type of Incidenbt", "Date", "Time", "Location", "Description", "People Involved", "Reporting Officer", "Status"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Investigate");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 204, 204));
        jButton5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        SearchPendingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchPendingFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Search Incident, ID and etc:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(792, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchPendingField, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchPendingField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 436, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Pending                                       ", jPanel2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Type of Incidenbt", "Date", "Time", "Location", "Description", "People Involved", "Reporting Officer", "Status"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jButton6.setBackground(new java.awt.Color(0, 204, 204));
        jButton6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("Resolve");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 204, 204));
        jButton7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        SearchInvestigationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchInvestigationFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Search Incident, ID and etc:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchInvestigationField, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchInvestigationField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(88, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Under Investigation             ", jPanel3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Type of Incidenbt", "Date", "Time", "Location", "Description", "People Involved", "Reporting Officer", "Status"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jButton9.setBackground(new java.awt.Color(0, 204, 204));
        jButton9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 0, 0));
        jButton9.setText("Delete");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        SearchResolveField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchResolveFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Search Incident, ID and etc:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchResolveField, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchResolveField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 441, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(93, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Resolve                                                                                                      ", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // This is for the add incidents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JDialog addIncidentDialog = new JDialog(this, "Add Incident", true);
        addIncidentDialog.setLayout(null);
        addIncidentDialog.setSize(400, 500);

        // Labels and text fields for input
        JLabel lblIncidentType = new JLabel("Type of Incident:");
        lblIncidentType.setBounds(20, 20, 120, 25);
        JTextField txtIncidentType = new JTextField();
        txtIncidentType.setBounds(150, 20, 200, 25);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(20, 60, 120, 25);
        JTextField txtDate = new JTextField();
        txtDate.setBounds(150, 60, 200, 25);

        JLabel lblTime = new JLabel("Time:");
        lblTime.setBounds(20, 100, 120, 25);
        JTextField txtTime = new JTextField();
        txtTime.setBounds(150, 100, 200, 25);

        JLabel lblLocation = new JLabel("Location:");
        lblLocation.setBounds(20, 140, 120, 25);
        JTextField txtLocation = new JTextField();
        txtLocation.setBounds(150, 140, 200, 25);

        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setBounds(20, 180, 120, 25);
        JTextField txtDescription = new JTextField();
        txtDescription.setBounds(150, 180, 200, 25);

        JLabel lblNarrative = new JLabel("Narrative:");
        lblNarrative.setBounds(20, 200, 120, 25);
        JTextField txtNarrative = new JTextField();
        txtNarrative.setBounds(150, 200, 200, 25);


        JLabel lblPeopleInvolved = new JLabel("People Involved:");
        lblPeopleInvolved.setBounds(20, 220, 120, 25);
        JTextField txtPeopleInvolved = new JTextField();
        txtPeopleInvolved.setBounds(150, 220, 200, 25);

        JLabel lblOfficer = new JLabel("Officer In Charge:");
        lblOfficer.setBounds(20, 260, 120, 25);
        JTextField txtOfficer = new JTextField();
        txtOfficer.setBounds(150, 260, 200, 25);

        // Buttons
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(80, 320, 100, 30);
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 320, 100, 30);

        // Add components to dialog
        addIncidentDialog.add(lblIncidentType);
        addIncidentDialog.add(txtIncidentType);
        addIncidentDialog.add(lblDate);
        addIncidentDialog.add(txtDate);
        addIncidentDialog.add(lblTime);
        addIncidentDialog.add(txtTime);
        addIncidentDialog.add(lblLocation);
        addIncidentDialog.add(txtLocation);
        addIncidentDialog.add(lblDescription);
        addIncidentDialog.add(txtNarrative);
        addIncidentDialog.add(lblNarrative);
        addIncidentDialog.add(txtDescription);
        addIncidentDialog.add(lblPeopleInvolved);
        addIncidentDialog.add(txtPeopleInvolved);
        addIncidentDialog.add(lblOfficer);
        addIncidentDialog.add(txtOfficer);
        addIncidentDialog.add(btnSave);
        addIncidentDialog.add(btnCancel);

        // Button actions
        btnSave.addActionListener(e -> {
            // Save logic here
            String incidentType = txtIncidentType.getText();
            String date = txtDate.getText();
            String time = txtTime.getText();
            String location = txtLocation.getText();
            String description = txtDescription.getText();
            String peopleInvolved = txtPeopleInvolved.getText();
            String officer = txtOfficer.getText();
            String narrative = txtNarrative.getText();


            // Validate date format (e.g., YYYY-MM-DD)
            if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                JOptionPane.showMessageDialog(addIncidentDialog, "Invalid date format. Please use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validate time format (e.g., HH:MM)
            if (!time.matches("\\d{2}:\\d{2} (AM|PM)")) {
                JOptionPane.showMessageDialog(addIncidentDialog, "Invalid time format. Please use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (incidentType.isEmpty() || narrative.isEmpty() || date.isEmpty() || time.isEmpty() || location.isEmpty() || description.isEmpty() || peopleInvolved.isEmpty() || officer.isEmpty()) {
                JOptionPane.showMessageDialog(addIncidentDialog, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Map<String, Object> incidentData = new HashMap<>();
            incidentData.put("incidentType", incidentType);
            incidentData.put("date", date);
            incidentData.put("time", time);
            incidentData.put("location", location);
            incidentData.put("description", description);
            incidentData.put("peopleInvolved", peopleInvolved);
            incidentData.put("officer", officer);
            incidentData.put("narrative", narrative);

           Helper insert = new Helper();
           insert.insertIncident(incidentData, addIncidentDialog);

            loadIncidents();
        });

        btnCancel.addActionListener(e -> addIncidentDialog.dispose());

        addIncidentDialog.setLocationRelativeTo(this);
        addIncidentDialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // This is for edit data
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JDialog updateIncidentDialog = new JDialog(this, "Update Incident", true);

        updateIncidentDialog.setLayout(null);
        updateIncidentDialog.setSize(400, 500);
        // Labels and text fields for input
        JLabel lblIncidentType = new JLabel("Type of Incident:");
        lblIncidentType.setBounds(20, 20, 120, 25);
        JTextField txtIncidentType = new JTextField((String) jTable1.getValueAt(selectedRow, 1));
        txtIncidentType.setBounds(150, 20, 200, 25);
        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(20, 60, 120, 25);
        JTextField txtDate = new JTextField((String) jTable1.getValueAt(selectedRow, 2));
        txtDate.setBounds(150, 60, 200, 25);
        JLabel lblTime = new JLabel("Time:");
        lblTime.setBounds(20, 100, 120, 25);
        JTextField txtTime = new JTextField((String) jTable1.getValueAt(selectedRow, 3));
        txtTime.setBounds(150, 100, 200, 25);
        JLabel lblLocation = new JLabel("Location:");
        lblLocation.setBounds(20, 140, 120, 25);
        JTextField txtLocation = new JTextField((String) jTable1.getValueAt(selectedRow, 4));
        txtLocation.setBounds(150, 140, 200, 25);
        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setBounds(20, 180, 120, 25);

        JLabel lblNarrative = new JLabel("Narrative:");
        lblNarrative.setBounds(20, 200, 120, 25);
        JTextField txtNarrative = new JTextField((String) jTable1.getValueAt(selectedRow, 5));
        txtNarrative.setBounds(150, 200, 200, 25);

        JTextField txtDescription = new JTextField((String) jTable1.getValueAt(selectedRow, 6));
        txtDescription.setBounds(150, 180, 200, 25);
        JLabel lblPeopleInvolved = new JLabel("People Involved:");
        lblPeopleInvolved.setBounds(20, 220, 120, 25);
        JTextField txtPeopleInvolved = new JTextField((String) jTable1.getValueAt(selectedRow, 7));
        txtPeopleInvolved.setBounds(150, 220, 200, 25);

        JLabel lblOfficer = new JLabel("Officer In Charge:");
        lblOfficer.setBounds(20, 260, 120, 25);
        JTextField txtOfficer = new JTextField((String) jTable1.getValueAt(selectedRow, 8));

        txtOfficer.setBounds(150, 260, 200, 25);

        // Buttons
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(80, 320, 100, 30);
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 320, 100, 30);
        // Add components to dialog
        updateIncidentDialog.add(lblIncidentType);
        updateIncidentDialog.add(txtIncidentType);
        updateIncidentDialog.add(lblDate);
        updateIncidentDialog.add(txtDate);
        updateIncidentDialog.add(lblTime);
        updateIncidentDialog.add(txtTime);
        updateIncidentDialog.add(lblLocation);
        updateIncidentDialog.add(txtLocation);
        updateIncidentDialog.add(lblDescription);
        updateIncidentDialog.add(txtDescription);
        updateIncidentDialog.add(lblNarrative);
        updateIncidentDialog.add(txtNarrative);
        updateIncidentDialog.add(lblPeopleInvolved);
        updateIncidentDialog.add(txtPeopleInvolved);
        updateIncidentDialog.add(lblOfficer);
        updateIncidentDialog.add(txtOfficer);
        updateIncidentDialog.add(btnSave);
        updateIncidentDialog.add(btnCancel);

        // Button actions
        btnSave.addActionListener(e -> {
            // Save logic here
            String incidentType = txtIncidentType.getText();
            String date = txtDate.getText();
            String time = txtTime.getText();
            String location = txtLocation.getText();
            String description = txtDescription.getText();
            String peopleInvolved = txtPeopleInvolved.getText();
            String officer = txtOfficer.getText();
            String narrative = txtNarrative.getText();

            // Validate date format (e.g., YYYY-MM-DD)
            if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                JOptionPane.showMessageDialog(updateIncidentDialog, "Invalid date format. Please use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validate time format (e.g., HH:MM)
            if (!time.matches("\\d{2}:\\d{2} (AM|PM)")) {
                JOptionPane.showMessageDialog(updateIncidentDialog, "Invalid time format. Please use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (incidentType.isEmpty() || date.isEmpty() || time.isEmpty() || location.isEmpty() || description.isEmpty() || peopleInvolved.isEmpty() || officer.isEmpty()) {
                JOptionPane.showMessageDialog(updateIncidentDialog, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Map<String, Object> incidentData = new HashMap<>();
            incidentData.put("incidentType", incidentType);
            incidentData.put("date", date);
            incidentData.put("time", time);
            incidentData.put("location", location);
            incidentData.put("description", description);
            incidentData.put("peopleInvolved", peopleInvolved);
            incidentData.put("officer", officer);
            incidentData.put("id", jTable1.getValueAt(selectedRow, 0));
            incidentData.put("narrative", narrative);

           Helper update = new Helper();
           update.updateIncident(incidentData, selectedRow, updateIncidentDialog);

           loadIncidents();

        });

        btnCancel.addActionListener(e -> updateIncidentDialog.dispose());

        updateIncidentDialog.setLocationRelativeTo(this);
        updateIncidentDialog.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    // This is for delete cases
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this incident?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String incidentId = (String) jTable1.getValueAt(selectedRow, 0);
            Helper deleteHelper = new Helper();
            deleteHelper.deleteIncident(incidentId);
            loadIncidents();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    // Update pending status to under investigation
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to investigate.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String incidentId = (String) jTable2.getValueAt(selectedRow, 0);

        // Update the status of the incident to "Under Investigation"
        Helper updateHelper = new Helper();
        updateHelper.updateIncidentStatus(incidentId, "Under Investigation", "resolvedtype", "resolvedby");

        loadIncidents();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        int selectedRow = jTable3.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to resolve.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String incidentId = (String) jTable3.getValueAt(selectedRow, 0);

        JDialog resolveIncidentDialog = new JDialog(this, "Resolve Incident", true);
        resolveIncidentDialog.setLayout(null);
        resolveIncidentDialog.setSize(400, 250);

        // Labels and text fields for input
        JLabel lblResolveDescription = new JLabel("Resolve Description:");
        lblResolveDescription.setBounds(20, 20, 150, 25);
        JTextField txtResolveDescription = new JTextField();
        txtResolveDescription.setBounds(180, 20, 200, 25);

        JLabel lblResolvedBy = new JLabel("Resolved By:");
        lblResolvedBy.setBounds(20, 60, 150, 25);
        JTextField txtResolvedBy = new JTextField();
        txtResolvedBy.setBounds(180, 60, 200, 25);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(150, 120, 100, 30);

        resolveIncidentDialog.add(lblResolveDescription);
        resolveIncidentDialog.add(txtResolveDescription);
        resolveIncidentDialog.add(lblResolvedBy);
        resolveIncidentDialog.add(txtResolvedBy);
        resolveIncidentDialog.add(btnSave);

        btnSave.addActionListener(e -> {
            String resolveDescription = txtResolveDescription.getText().trim();
            String resolvedBy = txtResolvedBy.getText().trim();

            if (resolveDescription.isEmpty() || resolvedBy.isEmpty()) {
                JOptionPane.showMessageDialog(resolveIncidentDialog, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Helper updateHelper = new Helper();
            updateHelper.updateIncidentToResolved(incidentId, "Resolved", resolveDescription, resolvedBy);

            resolveIncidentDialog.dispose();
            loadIncidents();
        });

        resolveIncidentDialog.setLocationRelativeTo(this);
        resolveIncidentDialog.setVisible(true);

    }//GEN-LAST:event_jButton6ActionPerformed

    // delete resolved
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        int selectedRow = jTable4.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this incident?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String incidentId = (String) jTable4.getValueAt(selectedRow, 0);
            Helper deleteHelper = new Helper();
            deleteHelper.deleteIncident(incidentId);
            loadIncidents();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    // delete under investigation
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        int selectedRow = jTable3.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this incident?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String incidentId = (String) jTable3.getValueAt(selectedRow, 0);
            Helper deleteHelper = new Helper();
            deleteHelper.deleteIncident(incidentId);
            loadIncidents();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    // delete pending cases
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this incident?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String incidentId = (String) jTable2.getValueAt(selectedRow, 0);
            Helper deleteHelper = new Helper();
            deleteHelper.deleteIncident(incidentId);
            loadIncidents();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void SearchCasesFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchCasesFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchCasesFieldActionPerformed

    private void SearchPendingFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchPendingFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchPendingFieldActionPerformed

    private void SearchInvestigationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchInvestigationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchInvestigationFieldActionPerformed

    private void SearchResolveFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchResolveFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchResolveFieldActionPerformed


    void loadIncidents() {
        casesList.clear();
        pendingList.clear();
        underInvestigationList.clear();
        resolvedList.clear();

        casesTableModel.setRowCount(0);
        pendingTableModel.setRowCount(0);
        underInvestigationTableModel.setRowCount(0);
        resolvedTableModel.setRowCount(0);

        Helper helper = new Helper();
        casesList = helper.getAllIncidents();
        pendingList = helper.getPendingIncidents();
        underInvestigationList = helper.getUnderInvestigationIncidents();
        resolvedList = helper.getResolvedIncidents();

        for (IncidentModel incident : casesList) {
            casesTableModel.addRow(new Object[]{
                    incident.getId(),
                    incident.getIncident(),
                    incident.getDate(),
                    incident.getTime(),
                    incident.getLocation(),
                    incident.getDescription(),
                    incident.getNarratives(),
                    incident.getPeopleInvolved(),
                    incident.getOfficerInCharge(),
                    incident.getStatus()
            });
        }

        for (IncidentModel incident : pendingList) {
            pendingTableModel.addRow(new Object[]{
                    incident.getId(),
                    incident.getIncident(),
                    incident.getDate(),
                    incident.getTime(),
                    incident.getLocation(),
                    incident.getDescription(),
                    incident.getNarratives(),
                    incident.getPeopleInvolved(),
                    incident.getOfficerInCharge(),
                    incident.getStatus()
            });
        }

        for (IncidentModel incident : underInvestigationList) {
            underInvestigationTableModel.addRow(new Object[]{
                    incident.getId(),
                    incident.getIncident(),
                    incident.getDate(),
                    incident.getTime(),
                    incident.getLocation(),
                    incident.getDescription(),
                    incident.getNarratives(),
                    incident.getPeopleInvolved(),
                    incident.getOfficerInCharge(),
                    incident.getStatus()
            });
        }

        for (IncidentModel incident : resolvedList) {
            resolvedTableModel.addRow(new Object[]{
                    incident.getId(),
                    incident.getIncident(),
                    incident.getDate(),
                    incident.getTime(),
                    incident.getLocation(),
                    incident.getDescription(),
                    incident.getNarratives(),
                    incident.getPeopleInvolved(),
                    incident.getOfficerInCharge(),
                    incident.getStatus()
            });
        }


    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IncidentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IncidentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IncidentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IncidentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IncidentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SearchCasesField;
    private javax.swing.JTextField SearchInvestigationField;
    private javax.swing.JTextField SearchPendingField;
    private javax.swing.JTextField SearchResolveField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
