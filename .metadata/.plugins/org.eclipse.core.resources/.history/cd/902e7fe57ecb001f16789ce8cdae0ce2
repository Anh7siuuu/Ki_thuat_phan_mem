package MVC.Controller.QLPK;

import MVC.Model.QLPK.EmployeeManagementModel;
import MVC.View.QLPK.EmployeeManagementView;
import MVC.View.QLPK.MainView;

import javax.swing.*;
import java.sql.*;

public class EmployeeManagementController {
    private Connection connection;
    private EmployeeManagementView view;

    public EmployeeManagementController(EmployeeManagementView view) {
        this.view = view;

        try {
            // Initialize database connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongKham;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String pass = "Phucthan@2004";
            connection = DriverManager.getConnection(url, username, pass);

            loadEmployeeIDs();
            initListeners();
        } catch (Exception e) {
            showError("Failed to connect to the database.", e);
        }
    }

    private void initListeners() {
        view.searchButton.addActionListener(e -> searchEmployee());
        view.addButton.addActionListener(e -> addEmployee());
        view.updateButton.addActionListener(e -> updateEmployee());
        view.deleteButton.addActionListener(e -> deleteEmployee());
        view.returnButton.addActionListener(e -> returnToMainView());
    }

    private void loadEmployeeIDs() {
        String query = "SELECT maNhanVien FROM Employee";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            view.employeeIDBox.removeAllItems();
            while (resultSet.next()) {
                view.employeeIDBox.addItem(resultSet.getString("maNhanVien"));
            }
        } catch (SQLException ex) {
            showError("Failed to load employee IDs.", ex);
        }
    }

    private void searchEmployee() {
        String selectedEmployeeID = (String) view.employeeIDBox.getSelectedItem();
        if (selectedEmployeeID == null) {
            showMessage("Please select an employee ID to search.");
            return;
        }

        String query = "SELECT * FROM Employee WHERE maNhanVien = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, selectedEmployeeID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                view.employeeIDField.setText(resultSet.getString("maNhanVien"));
                view.passwordField.setText(resultSet.getString("matKhau"));
                view.dobField.setText(resultSet.getString("ngaySinh"));
                view.nameField.setText(resultSet.getString("hoTen"));
                view.phoneField.setText(resultSet.getString("soDienThoai"));
                view.emailField.setText(resultSet.getString("email"));
                view.positionField.setText(resultSet.getString("viTri"));
                view.salaryField.setText(String.valueOf(resultSet.getInt("luong")));
                view.permissionIDField.setText(resultSet.getString("maQuyen"));
            } else {
                showMessage("Employee not found.");
            }
        } catch (SQLException ex) {
            showError("An error occurred while searching for the employee.", ex);
        }
    }

    private void addEmployee() {
        String query = "INSERT INTO Employee (maNhanVien, matKhau, ngaySinh, hoTen, soDienThoai, email, viTri, luong, maQuyen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, view.employeeIDField.getText());
            preparedStatement.setString(2, view.passwordField.getText());
            preparedStatement.setString(3, view.dobField.getText());
            preparedStatement.setString(4, view.nameField.getText());
            preparedStatement.setString(5, view.phoneField.getText());
            preparedStatement.setString(6, view.emailField.getText());
            preparedStatement.setString(7, view.positionField.getText());
            preparedStatement.setInt(8, Integer.parseInt(view.salaryField.getText()));
            preparedStatement.setString(9, view.permissionIDField.getText());
            preparedStatement.executeUpdate();

            showMessage("Employee added successfully.");
            loadEmployeeIDs();
        } catch (SQLException ex) {
            showError("An error occurred while adding the employee.", ex);
        }
    }

    private void updateEmployee() {
        String query = "UPDATE Employee SET matKhau = ?, ngaySinh = ?, hoTen = ?, soDienThoai = ?, email = ?, viTri = ?, luong = ?, maQuyen = ? WHERE maNhanVien = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, view.passwordField.getText());
            preparedStatement.setString(2, view.dobField.getText());
            preparedStatement.setString(3, view.nameField.getText());
            preparedStatement.setString(4, view.phoneField.getText());
            preparedStatement.setString(5, view.emailField.getText());
            preparedStatement.setString(6, view.positionField.getText());
            preparedStatement.setInt(7, Integer.parseInt(view.salaryField.getText()));
            preparedStatement.setString(8, view.permissionIDField.getText());
            preparedStatement.setString(9, view.employeeIDField.getText());
            preparedStatement.executeUpdate();

            showMessage("Employee updated successfully.");
        } catch (SQLException ex) {
            showError("An error occurred while updating the employee.", ex);
        }
    }

    private void deleteEmployee() {
        String selectedEmployeeID = (String) view.employeeIDBox.getSelectedItem();
        if (selectedEmployeeID == null) {
            showMessage("No employee selected to delete.");
            return;
        }

        String query = "DELETE FROM Employee WHERE maNhanVien = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, selectedEmployeeID);
            preparedStatement.executeUpdate();

            showMessage("Employee deleted successfully.");
            loadEmployeeIDs();
            clearFields();
        } catch (SQLException ex) {
            showError("An error occurred while deleting the employee.", ex);
        }
    }

    private void clearFields() {
        view.employeeIDField.setText("");
        view.passwordField.setText("");
        view.dobField.setText("");
        view.nameField.setText("");
        view.phoneField.setText("");
        view.emailField.setText("");
        view.positionField.setText("");
        view.salaryField.setText("");
        view.permissionIDField.setText("");
    }

    private void returnToMainView() {
        try {
            connection.close();
        } catch (SQLException e) {
            showError("Error closing database connection.", e);
        }
        view.dispose();
        MainView mainView = new MainView();
        new MainController(mainView);
        mainView.setVisible(true);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(view, message);
    }

    private void showError(String message, Exception ex) {
        JOptionPane.showMessageDialog(view, message);
        ex.printStackTrace();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                EmployeeManagementView view = new EmployeeManagementView();
                new EmployeeManagementController(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}