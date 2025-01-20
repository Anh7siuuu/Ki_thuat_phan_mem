package MVC.Controller.QLPK;

import MVC.Model.QLPK.DoctorManagementModel;
import MVC.View.QLPK.DoctorManagementView;
import MVC.View.QLPK.DoctorManagementView;
import MVC.View.QLPK.MainView;

import javax.swing.*;
import java.sql.*;

public class DoctorManagementController {
    private Connection connection;
    private DoctorManagementView view;

    public DoctorManagementController(DoctorManagementView view) {
        this.view = view;

        try {
            // Initialize database connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongKham;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String pass = "Quangthai17.";
            connection = DriverManager.getConnection(url, username, pass);

            loadDoctorIDs();
            initListeners();
        } catch (Exception e) {
            showError("Failed to connect to the database.", e);
        }
    }
    
    // Gan cac bien hanh dong cho cac nut
    private void initListeners() {
        view.searchButton.addActionListener(e -> searchDoctor());
        view.addButton.addActionListener(e -> addDoctor());
        view.updateButton.addActionListener(e -> updateDoctor());
        view.deleteButton.addActionListener(e -> deleteDoctor());
        view.returnButton.addActionListener(e -> returnToMainView());
    }

    // Tải danh sách ID của bác sĩ và hiển thị nó trong hộp Box
    private void loadDoctorIDs() {
        try (Statement stm = connection.createStatement();
             ResultSet resultSet = stm.executeQuery("SELECT maBacSi FROM Doctor")) {
            view.doctorIDBox.removeAllItems();
            while (resultSet.next()) {
                view.doctorIDBox.addItem(resultSet.getString("maBacSi"));
            }
        } catch (SQLException ex) {
            showError("Failed to load doctor IDs.", ex);
        }
    }
    
    
    private void searchDoctor() {
        String selectedDoctorID = (String) view.doctorIDBox.getSelectedItem();
        if (selectedDoctorID == null) {
            showMessage("Please select a doctor ID to search.");
            return;
        }

        String query = "SELECT * FROM Doctor WHERE maBacSi = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, selectedDoctorID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                view.doctorIDField.setText(resultSet.getString("maBacSi"));
                view.passwordField.setText(resultSet.getString("matKhau"));
                view.dobField.setText(resultSet.getString("ngaySinh"));
                view.nameField.setText(resultSet.getString("hoTen"));
                view.phoneField.setText(resultSet.getString("soDienThoai"));
                view.emailField.setText(resultSet.getString("email"));
                view.positionField.setText(resultSet.getString("viTri"));
                view.salaryField.setText(String.valueOf(resultSet.getInt("luong")));
                view.permissionIDField.setText(resultSet.getString("maQuyen"));
            } else {
                showMessage("Doctor not found.");
            }
        } catch (SQLException ex) {
            showError("An error occurred while searching for the doctor.", ex);
        }
    }

    private void addDoctor() {
        String query = "INSERT INTO Doctor (maBacSi, matKhau, ngaySinh, hoTen, soDienThoai, email, viTri, luong, maQuyen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, view.doctorIDField.getText());
            preparedStatement.setString(2, view.passwordField.getText());
            preparedStatement.setString(3, view.dobField.getText());
            preparedStatement.setString(4, view.nameField.getText());
            preparedStatement.setString(5, view.phoneField.getText());
            preparedStatement.setString(6, view.emailField.getText());
            preparedStatement.setString(7, view.positionField.getText());
            preparedStatement.setInt(8, Integer.parseInt(view.salaryField.getText()));
            preparedStatement.setString(9, view.permissionIDField.getText());
            preparedStatement.executeUpdate();

            showMessage("Doctor added successfully.");
            loadDoctorIDs();
        } catch (SQLException ex) {
            showError("An error occurred while adding the doctor.", ex);
        }
    }

    private void updateDoctor() {
        String query = "UPDATE Doctor SET matKhau = ?, ngaySinh = ?, hoTen = ?, soDienThoai = ?, email = ?, viTri = ?, luong = ?, maQuyen = ? WHERE maBacSi = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, view.passwordField.getText());
            preparedStatement.setString(2, view.dobField.getText());
            preparedStatement.setString(3, view.nameField.getText());
            preparedStatement.setString(4, view.phoneField.getText());
            preparedStatement.setString(5, view.emailField.getText());
            preparedStatement.setString(6, view.positionField.getText());
            preparedStatement.setInt(7, Integer.parseInt(view.salaryField.getText()));
            preparedStatement.setString(8, view.permissionIDField.getText());
            preparedStatement.setString(9, view.doctorIDField.getText());
            preparedStatement.executeUpdate();

            showMessage("Doctor updated successfully.");
        } catch (SQLException ex) {
            showError("An error occurred while updating the doctor.", ex);
        }
    }

    private void deleteDoctor() {
        String selectedDoctorID = (String) view.doctorIDBox.getSelectedItem();
        if (selectedDoctorID == null) {
            showMessage("No doctor selected to delete.");
            return;
        }

        String query = "DELETE FROM Doctor WHERE maBacSi = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, selectedDoctorID);
            preparedStatement.executeUpdate();

            showMessage("Doctor deleted successfully.");
            loadDoctorIDs();
            clearFields();
        } catch (SQLException ex) {
            showError("An error occurred while deleting the doctor.", ex);
        }
    }

    private void clearFields() {
        view.doctorIDField.setText("");
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
        DoctorManagementView doctorManagementView = new DoctorManagementView();
        new DoctorManagementController(doctorManagementView); 
    }
}