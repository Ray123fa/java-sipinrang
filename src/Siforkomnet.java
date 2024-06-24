/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import View.LoginFrame;
import java.nio.file.*;
import java.io.IOException;

/**
 *
 * @author Muhammad Rayhan Faridh
 */
public class Siforkomnet {

    public static void main(String[] args) {
        copyDatabase();
        new LoginFrame().setVisible(true);
    }

    public static void copyDatabase() {
        String dbPath = "database/";
        String dbName = "siforkomnet.db";
        String url = dbPath + dbName;

        String currentPath = System.getProperty("user.dir");
        String[] paths = currentPath.split("\\\\");

        Path source = Paths.get(currentPath, url).normalize();
        Path destination = Paths.get(currentPath, "dist/" + url).normalize();

        if (paths[paths.length - 1].equals("dist")) {
            source = Paths.get(currentPath, "../" + url).normalize();
            destination = Paths.get(currentPath, url).normalize();
        }

        try {
            if (!Files.exists(destination.getParent())) {
                Files.createDirectories(destination.getParent());
            }
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
