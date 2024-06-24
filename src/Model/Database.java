/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Muhammad Rayhan Faridh
 */
public class Database {

    public static Database instance;
    private final String dbPath = "database/";
    private final String dbName = "siforkomnet.db";
    private final String url = "jdbc:sqlite:" + dbPath + dbName;
    private boolean isLogin = false;

    private Database() {
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
