/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.LoginFrame;
import com.lambdaworks.crypto.SCryptUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Rayhan Faridh
 */
public class UserModel {

    private int id;
    private String username;
    private String password;
    private String nim;
    private String fullname;
    private LocalDate birthday;
    private int angkatan;
    private String divisi;
    private String status;
    private String role;

    private String hashPassword(String password) {
        return SCryptUtil.scrypt(password, 16, 16, 16);
    }

    private boolean checkPassword(String candidate, String hashed) {
        return SCryptUtil.check(candidate, hashed);
    }

    public boolean isExist(String usernameOrNim) {
        Database db = Database.getInstance();
        String query = "SELECT * FROM users WHERE (username = ? OR nim = ?)";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, usernameOrNim);
            pstmt.setString(2, usernameOrNim);

            ResultSet rs = pstmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean addMember(String nim, String fullname, LocalDate birthday, int angkatan,
            String divisi, String status, String role) {
        Database db = Database.getInstance();
        String query
                = "INSERT INTO users (username, password, nim, fullname, birthday, angkatan, divisi, status, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nim);
            pstmt.setString(2, hashPassword(nim));
            pstmt.setString(3, nim);
            pstmt.setString(4, fullname);
            pstmt.setString(5, birthday.toString());
            pstmt.setInt(6, angkatan);
            pstmt.setString(7, divisi);
            pstmt.setString(8, status);
            pstmt.setString(9, role);

            if (isExist(nim)) {
                JOptionPane.showMessageDialog(null, "Anggota sudah ada!");
                return false;
            }

            if (pstmt.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Anggota berhasil ditambahkan!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Anggota gagal ditambahkan!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Anggota gagal ditambahkan!");
            return false;
        }
    }

    public boolean updateMember(String nim, String fullname, LocalDate birthday, int angkatan,
            String divisi, String status, String role) {
        Database db = Database.getInstance();
        String query
                = "UPDATE users SET fullname = ?, birthday = ?, angkatan = ?, divisi = ?, status = ?, role = ? WHERE nim = ?";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, fullname);
            pstmt.setString(2, birthday.toString());
            pstmt.setInt(3, angkatan);
            pstmt.setString(4, divisi);
            pstmt.setString(5, status);
            pstmt.setString(6, role);
            pstmt.setString(7, nim);

            if (pstmt.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Anggota berhasil diubah!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Anggota gagal diubah!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Anggota gagal diubah!");
            return false;
        }
    }

    public boolean updateMember(String nim, String username, String fullname, LocalDate birthday,
            int angkatan, String divisi, String status, String role) {
        Database db = Database.getInstance();
        String query
                = "UPDATE users SET username = ?, fullname = ?, birthday = ?, angkatan = ?, divisi = ?, status = ?, role = ? WHERE nim = ?";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, fullname);
            pstmt.setString(3, birthday.toString());
            pstmt.setInt(4, angkatan);
            pstmt.setString(5, divisi);
            pstmt.setString(6, status);
            pstmt.setString(7, role);
            pstmt.setString(8, nim);

            if (pstmt.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Profile berhasil diubah!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Profile gagal diubah!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Profile gagal diubah!");
            return false;
        }
    }

    public boolean changePassword(String nim, String oldPass, String newPass) {
        Database db = Database.getInstance();
        String query = "SELECT password FROM users WHERE nim = ?";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nim);

            ResultSet rs = pstmt.executeQuery();

            boolean isValid = checkPassword(oldPass, rs.getString("password"));
            if (isValid) {
                query = "UPDATE users SET password = ? WHERE nim = ?";
                try (PreparedStatement pstmt2 = conn.prepareStatement(query)) {
                    pstmt2.setString(1, hashPassword(newPass));
                    pstmt2.setString(2, nim);

                    if (pstmt2.executeUpdate() == 1) {
                        JOptionPane.showMessageDialog(null, "Password berhasil diubah!");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Password gagal diubah!");
                        return false;
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Password gagal diubah!");
                    return false;
                }
            }
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Password lama salah!");
            return false;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Password lama salah!");
            return false;
        }
    }

    public boolean deleteMember(String nim) {
        Database db = Database.getInstance();
        String query = "DELETE FROM users WHERE nim = ?";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nim);

            if (pstmt.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Anggota berhasil dihapus!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Anggota gagal dihapus!");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Anggota gagal dihapus!");
            return false;
        }
    }

    public boolean auth(String usernameOrNim, String password) {
        Database db = Database.getInstance();
        String query = "SELECT * FROM users WHERE (username = ? OR nim = ?)";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, usernameOrNim);
            pstmt.setString(2, usernameOrNim);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                boolean isValid = checkPassword(password, rs.getString("password"));
                if (isValid) {
                    db.setLogin(true);
                    setId(rs.getInt("id"));
                    setUsername(rs.getString("username"));
                    setNim(rs.getString("nim"));
                    setFullname(rs.getString("fullname"));
                    setBirthday(rs.getString("birthday") != null
                            ? LocalDate.parse(rs.getString("birthday"))
                            : null);
                    setAngkatan(rs.getInt("angkatan"));
                    setDivisi(rs.getString("divisi"));
                    setStatus(rs.getString("status"));
                    setRole(rs.getString("role"));

                    return true;
                }
                JOptionPane.showMessageDialog(new LoginFrame(), "Password salah!");
                return false;
            } else {
                JOptionPane.showMessageDialog(new LoginFrame(), "Username salah!");
                db.setLogin(false);
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new LoginFrame(), "Password salah!");
            db.setLogin(false);
            return false;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new LoginFrame(), "Password salah!");
            db.setLogin(false);
            return false;
        }
    }

    public boolean logout() {
        Database db = Database.getInstance();
        db.setLogin(false);
        return true;
    }

    public ArrayList<UserModel> getUsers(String divisi) {
        Database db = Database.getInstance();
        ArrayList<UserModel> users = new ArrayList<>();

        String query = "SELECT * FROM users WHERE divisi LIKE ? ORDER BY divisi, fullname ASC";
        if (divisi.equals("keseluruhan")) {
            query = "SELECT * FROM users ORDER BY divisi, fullname ASC";
        }

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            if (!divisi.equals("keseluruhan")) {
                pstmt.setString(1, divisi);
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setNim(rs.getString("nim"));
                user.setFullname(rs.getString("fullname"));
                user.setBirthday(
                        rs.getString("birthday") != null ? LocalDate.parse(rs.getString("birthday"))
                        : null);
                user.setAngkatan(rs.getInt("angkatan"));
                user.setDivisi(rs.getString("divisi"));
                user.setStatus(rs.getString("status"));
                user.setRole(rs.getString("role"));

                users.add(user);
            }
        } catch (SQLException e) {
        }

        return users;
    }

    public UserModel getUser(String nim) {
        Database db = Database.getInstance();
        UserModel user = new UserModel();
        String query = "SELECT * FROM users WHERE nim = ?";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nim);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setNim(rs.getString("nim"));
                user.setFullname(rs.getString("fullname"));
                user.setBirthday(
                        rs.getString("birthday") != null ? LocalDate.parse(rs.getString("birthday"))
                        : null);
                user.setAngkatan(rs.getInt("angkatan"));
                user.setDivisi(rs.getString("divisi"));
                user.setStatus(rs.getString("status"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
        }

        return user;
    }

    public Integer getMemberCount(String divisi) {
        Database db = Database.getInstance();
        String query = "SELECT COUNT(*) AS count FROM users WHERE divisi LIKE ?";

        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, divisi);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("count");
            }
        } catch (SQLException e) {
        }

        return 0;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nim
     */
    public String getNim() {
        return nim;
    }

    /**
     * @param nim the nim to set
     */
    public void setNim(String nim) {
        this.nim = nim;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the angkatan
     */
    public int getAngkatan() {
        return angkatan;
    }

    /**
     * @param angkatan the angkatan to set
     */
    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    /**
     * @return the divisi
     */
    public String getDivisi() {
        return divisi;
    }

    /**
     * @param divisi the divisi to set
     */
    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
}
