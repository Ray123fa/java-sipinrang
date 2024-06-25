/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import Model.UserModel;

/**
 *
 * @author Muhammad Rayhan Faridh
 */
public class CsvController {
    private UserModel model;

    public void exportToCsv(List<UserModel> users, String path) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.append("No,NIM,Fullname,Birthday,Angkatan,Divisi,Status\n");

            Integer i = 0;
            for (UserModel user : users) {
                i += 1;
                
                writer.append(i.toString()).append(",");
                writer.append(user.getNim()).append(",");
                writer.append(user.getFullname()).append(",");
                writer.append(user.getBirthday().toString()).append(",");
                writer.append(String.valueOf(user.getAngkatan())).append(",");
                writer.append(user.getDivisi()).append(",");
                writer.append(user.getStatus()).append(",\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
