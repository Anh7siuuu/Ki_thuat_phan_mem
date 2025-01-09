package MVC.Controller.QLPK;

import MVC.View.QLPK.EmployeeMainView;
import MVC.View.QLPK.MainView;
import MVC.View.QLPK.DoctorMainView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginController {
    private Connection connection;
    private JFrame loginView;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginController(JFrame loginView, JTextField usernameField, JPasswordField passwordField, JButton loginButton) {
        this.loginView = loginView;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.loginButton = loginButton;

        try {
            // Initialize database connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongKham;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "Quangthai17.";
            connection = DriverManager.getConnection(url, username, password);

            initListeners();
        } catch (Exception e) {
            showError("Failed to connect to the database.", e);
        }
    }

    private void initListeners() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String enteredUsername = usernameField.getText();
        String enteredPassword = new String(passwordField.getPassword());

        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            showMessage("Please enter both username and password.");
            return;
        }

        String query;
        if (enteredUsername.matches("^NV\\d{3}$")) { // Employee ID
            query = "SELECT * FROM Employee WHERE maNhanVien = ? AND matKhau = ?";
        } else if (enteredUsername.matches("^BS\\d{3}$")) { // Doctor ID
            query = "SELECT * FROM Doctor WHERE maBacSi = ? AND matKhau = ?";
        } else if (enteredUsername.equals("QL001") && enteredPassword.equals("Phucthan@2004")) { // Manager
            navigateToManagerView();
            return;
        } else {
            showMessage("Invalid username format.");
            return;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, enteredUsername);
            preparedStatement.setString(2, enteredPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if (enteredUsername.matches("^NV\\d{3}$")) {
                    navigateToEmployeeView();
                } else if (enteredUsername.matches("^BS\\d{3}$")) {
                    navigateToDoctorView();
                }
            } else {
                showMessage("Invalid username or password.");
            }
        } catch (SQLException ex) {
            showError("An error occurred during login.", ex);
        }
    }

    private void navigateToEmployeeView() {
        loginView.dispose();
        EmployeeMainView employeeMainView = new EmployeeMainView();
        employeeMainView.setVisible(true);
    }

    private void navigateToDoctorView() {
        loginView.dispose();
        DoctorMainView doctorMainView = new DoctorMainView(); // Chuyển đến giao diện DoctorMainView
        doctorMainView.setVisible(true);
    }

    private void navigateToManagerView() {
        loginView.dispose();
        MainView mainView = new MainView();
        mainView.setVisible(true);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(loginView, message);
    }

    private void showError(String message, Exception ex) {
        JOptionPane.showMessageDialog(loginView, message);
        ex.printStackTrace();
    }
}