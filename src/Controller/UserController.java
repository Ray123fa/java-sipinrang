/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.UserModel;
import View.MainFrame;
import View.LoginFrame;
import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 *
 * @author Muhammad Rayhan Faridh
 */
public class UserController {

    private final UserModel userModel;
    private MainFrame mainFrame;

    public UserController() {
        this.userModel = new UserModel();
    }

    // Create
    public void addUser(String nim, String fullname, LocalDate birthday, int angkatan, String divisi, String status, String role) {
        userModel.addMember(nim, fullname, birthday, angkatan, divisi, status, role);
    }

    // Update
    public void updateUser(String nim, String fullname, LocalDate birthday, int angkatan,
            String divisi, String status, String role) {
        userModel.updateMember(nim, fullname, birthday, angkatan, divisi, status, role);
    }

    public void updateUser(String nim, String username, String fullname, LocalDate birthday, int angkatan,
            String divisi, String status, String role) {
        userModel.updateMember(nim, username, fullname, birthday, angkatan, divisi, status, role);
    }

    public void changePassword(String nim, String oldPass, String newPass) {
        userModel.changePassword(nim, oldPass, newPass);
    }

    public UserModel getUser(String nim) {
        return userModel.getUser(nim);
    }

    public void login(String usernameOrNim, String password) {
        boolean isExist = userModel.auth(usernameOrNim, password);
        if (isExist) {
            this.mainFrame = new MainFrame(userModel);
            mainFrame.setVisible(true);
        }
    }

    public boolean logout() {
        if (userModel.logout()) {
            new LoginFrame().setVisible(true);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Gagal logout!");
            return false;
        }
    }
}
