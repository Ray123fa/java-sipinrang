/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.UserController;
import Model.UserModel;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author Muhammad Rayhan Faridh
 */
public class EditProfilePanel extends javax.swing.JPanel {

    private final UserModel member;

    /**
     * Creates new form EditProfilePanel
     */
    public EditProfilePanel(UserModel user) {
        initComponents();
        this.member = user;
        setFormValue(user);

        JComponent editor = angkatanSpinner.getEditor();
        JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor;
        JFormattedTextField formattedTextField = spinnerEditor.getTextField();
        formattedTextField.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        dataMembersPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        nimLabel = new javax.swing.JLabel();
        fullnameLabel = new javax.swing.JLabel();
        fullnameField = new javax.swing.JTextField();
        birthdayLabel = new javax.swing.JLabel();
        birthdayDate = new com.toedter.calendar.JDateChooser();
        angkatanLabel = new javax.swing.JLabel();
        angkatanSpinner = new javax.swing.JSpinner();
        divisiLabel = new javax.swing.JLabel();
        divisiDropdown = new javax.swing.JComboBox<>();
        statusLabel = new javax.swing.JLabel();
        statusDropdown = new javax.swing.JComboBox<>();
        roleLabel = new javax.swing.JLabel();
        roleDropdown = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        nimField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();

        setLayout(new java.awt.CardLayout());

        mainPanel.setBackground(new java.awt.Color(255, 252, 230));
        mainPanel.setLayout(new java.awt.CardLayout());

        dataMembersPanel.setBackground(new java.awt.Color(255, 252, 230));

        titlePanel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titlePanel.setText("UPDATE PROFILE");

        nimLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nimLabel.setText("NIM:");

        fullnameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fullnameLabel.setText("Nama Lengkap:");

        fullnameField.setEditable(false);
        fullnameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        birthdayLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        birthdayLabel.setText("Tanggal Lahir:");

        birthdayDate.setDateFormatString("yyyy-MM-dd");
        birthdayDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        angkatanLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        angkatanLabel.setText("Angkatan STIS:");

        angkatanSpinner.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        angkatanSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(angkatanSpinner, ""));
        angkatanSpinner.setEnabled(false);
        angkatanSpinner.setValue(64);

        divisiLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        divisiLabel.setText("Divisi:");

        divisiDropdown.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        divisiDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BPH", "Pengembangan", "Pelatihan", "HPD", "Umum" }));
        divisiDropdown.setSelectedItem("");
        divisiDropdown.setEnabled(false);

        statusLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statusLabel.setText("Status:");

        statusDropdown.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statusDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Nonaktif" }));
        statusDropdown.setSelectedItem("");
        statusDropdown.setEnabled(false);

        roleLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        roleLabel.setText("Role:");

        roleDropdown.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        roleDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bph", "koor", "member" }));
        roleDropdown.setSelectedItem("");
        roleDropdown.setEnabled(false);

        btnUpdate.setBackground(new java.awt.Color(0, 123, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("SIMPAN");
        btnUpdate.setBorder(null);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(108, 117, 125));
        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("RESET");
        btnReset.setBorder(null);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        nimField.setEditable(false);
        nimField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usernameLabel.setText("Username:");

        usernameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout dataMembersPanelLayout = new javax.swing.GroupLayout(dataMembersPanel);
        dataMembersPanel.setLayout(dataMembersPanelLayout);
        dataMembersPanelLayout.setHorizontalGroup(
            dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataMembersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataMembersPanelLayout.createSequentialGroup()
                        .addGroup(dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(dataMembersPanelLayout.createSequentialGroup()
                        .addGroup(dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dataMembersPanelLayout.createSequentialGroup()
                                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(usernameField))
                            .addGroup(dataMembersPanelLayout.createSequentialGroup()
                                .addComponent(angkatanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(198, 198, 198)
                                .addComponent(angkatanSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dataMembersPanelLayout.createSequentialGroup()
                                .addComponent(divisiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(divisiDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dataMembersPanelLayout.createSequentialGroup()
                                .addComponent(nimLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nimField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dataMembersPanelLayout.createSequentialGroup()
                                .addComponent(birthdayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(birthdayDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(dataMembersPanelLayout.createSequentialGroup()
                                .addComponent(fullnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fullnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dataMembersPanelLayout.createSequentialGroup()
                                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(statusDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(dataMembersPanelLayout.createSequentialGroup()
                                .addComponent(roleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(roleDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(dataMembersPanelLayout.createSequentialGroup()
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        dataMembersPanelLayout.setVerticalGroup(
            dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataMembersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nimLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(nimField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fullnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fullnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(birthdayDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(birthdayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(angkatanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(angkatanSpinner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(divisiDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dataMembersPanelLayout.createSequentialGroup()
                        .addComponent(divisiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statusDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dataMembersPanelLayout.createSequentialGroup()
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roleDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dataMembersPanelLayout.createSequentialGroup()
                        .addComponent(roleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addGroup(dataMembersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(181, 181, 181))
        );

        mainPanel.add(dataMembersPanel, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private boolean btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String nim = nimField.getText();
            String username = usernameField.getText();
            String fullname = fullnameField.getText();
            LocalDate birthday = birthdayDate.getDate().toInstant()
                    .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            int angkatan = (int) angkatanSpinner.getValue();
            String divisi = divisiDropdown.getSelectedItem().toString();
            String status = statusDropdown.getSelectedItem().toString();
            String role = roleDropdown.getSelectedItem().toString();

            if (username.isEmpty() || birthday == null) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            UserController userController = new UserController();
            userController.updateUser(nim, username, fullname, birthday, angkatan, divisi, status, role);
            return true;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        setFormValue(member);
    }//GEN-LAST:event_btnResetActionPerformed

    private void setFormValue(UserModel user) {
        nimField.setText(user.getNim());
        usernameField.setText(user.getUsername());
        fullnameField.setText(user.getFullname());
        birthdayDate.setDate(Date.valueOf(user.getBirthday()));
        angkatanSpinner.setValue(user.getAngkatan());
        divisiDropdown.setSelectedItem(user.getDivisi());
        statusDropdown.setSelectedItem(user.getStatus());
        roleDropdown.setSelectedItem(user.getRole());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel angkatanLabel;
    private javax.swing.JSpinner angkatanSpinner;
    private com.toedter.calendar.JDateChooser birthdayDate;
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel dataMembersPanel;
    private javax.swing.JComboBox<String> divisiDropdown;
    private javax.swing.JLabel divisiLabel;
    private javax.swing.JTextField fullnameField;
    private javax.swing.JLabel fullnameLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField nimField;
    private javax.swing.JLabel nimLabel;
    private javax.swing.JComboBox<String> roleDropdown;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JComboBox<String> statusDropdown;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel titlePanel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
