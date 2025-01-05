package MVC.Controller.QLPK;

import MVC.Model.QLPK.PatientManagementModel;
import MVC.View.QLPK.PatientManagementView;
import MVC.View.QLPK.EmployeeMainView;

import javax.swing.*;
import java.sql.*;

public class PatientManagementController {
    private Connection connection;
    private PatientManagementView view;

    public PatientManagementController(PatientManagementView view) throws SQLException, ClassNotFoundException {
        this.view = view;

        // Initialize database connection
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongKham;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String pass = "Phucthan@2004";
        connection = DriverManager.getConnection(url, username, pass);

        loadPatientIDs();

        view.addButton.addActionListener(e -> addPatient());
        view.updateButton.addActionListener(e -> editPatient());
        view.deleteButton.addActionListener(e -> deletePatient());
        view.searchButton.addActionListener(e -> searchPatient());
        view.returnButton.addActionListener(e -> returnToEmployeeMainView());
    }

    private void loadPatientIDs() {
        try (Statement stm = connection.createStatement()) {
            ResultSet resultSet = stm.executeQuery("SELECT maBenhNhan FROM Patient");
            view.patientIDBox.removeAllItems();
            while (resultSet.next()) {
                view.patientIDBox.addItem(resultSet.getString("maBenhNhan"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void searchPatient() {
        String selectedPatientID = (String) view.patientIDBox.getSelectedItem();
        if (selectedPatientID != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Patient WHERE maBenhNhan = ?")) {
                preparedStatement.setString(1, selectedPatientID);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    view.patientIDField.setText(resultSet.getString("maBenhNhan"));
                    view.passwordField.setText(resultSet.getString("matKhau"));
                    view.dobField.setText(resultSet.getString("ngaySinh"));
                    view.nameField.setText(resultSet.getString("hoTen"));
                    view.phoneField.setText(resultSet.getString("soDienThoai"));
                    view.emailField.setText(resultSet.getString("email"));
                    view.occupationField.setText(resultSet.getString("ngheNghiep"));
                    view.permissionIDField.setText(resultSet.getString("maQuyen"));
                } else {
                    JOptionPane.showMessageDialog(view, "No data found for the selected patient.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while fetching patient data.");
                ex.printStackTrace();
            }
        }
    }

    private void addPatient() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Patient (maBenhNhan, matKhau, ngaySinh, hoTen, soDienThoai, email, ngheNghiep, maQuyen) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, view.patientIDField.getText());
            preparedStatement.setString(2, view.passwordField.getText());
            preparedStatement.setString(3, view.dobField.getText());
            preparedStatement.setString(4, view.nameField.getText());
            preparedStatement.setString(5, view.phoneField.getText());
            preparedStatement.setString(6, view.emailField.getText());
            preparedStatement.setString(7, view.occupationField.getText());
            preparedStatement.setString(8, view.permissionIDField.getText());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(view, "Patient added successfully.");
            loadPatientIDs();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "An error occurred while adding the patient.");
            ex.printStackTrace();
        }
    }

    private void editPatient() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE Patient SET matKhau = ?, ngaySinh = ?, hoTen = ?, soDienThoai = ?, email = ?, ngheNghiep = ?, maQuyen = ? WHERE maBenhNhan = ?")) {
            preparedStatement.setString(1, view.passwordField.getText());
            preparedStatement.setString(2, view.dobField.getText());
            preparedStatement.setString(3, view.nameField.getText());
            preparedStatement.setString(4, view.phoneField.getText());
            preparedStatement.setString(5, view.emailField.getText());
            preparedStatement.setString(6, view.occupationField.getText());
            preparedStatement.setString(7, view.permissionIDField.getText());
            preparedStatement.setString(8, view.patientIDField.getText());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(view, "Patient updated successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "An error occurred while updating the patient.");
            ex.printStackTrace();
        }
    }

    private void deletePatient() {
        String selectedPatientID = (String) view.patientIDBox.getSelectedItem();
        if (selectedPatientID != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM BenhNhan WHERE maBenhNhan = ?")) {
                preparedStatement.setString(1, selectedPatientID);
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(view, "Patient deleted successfully.");
                loadPatientIDs();

                // Clear fields after deletion
                view.patientIDField.setText("");
                view.passwordField.setText("");
                view.dobField.setText("");
                view.nameField.setText("");
                view.phoneField.setText("");
                view.emailField.setText("");
                view.occupationField.setText("");
                view.permissionIDField.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while deleting the patient.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(view, "No patient selected to delete.");
        }
    }
    
    private void returnToEmployeeMainView() {
        try {
            connection.close();
        } catch (SQLException e) {
            showError("Error closing database connection.", e);
        }
        view.dispose();
        EmployeeMainView employeeMainView = new EmployeeMainView();
        new EmployeeMainController(employeeMainView);
        employeeMainView.setVisible(true);
    }

    private void showError(String message, Exception ex) {
        JOptionPane.showMessageDialog(view, message);
        ex.printStackTrace();
    }

    public static void main(String[] args) {
        try {
            PatientManagementView view = new PatientManagementView();
            new PatientManagementController(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
