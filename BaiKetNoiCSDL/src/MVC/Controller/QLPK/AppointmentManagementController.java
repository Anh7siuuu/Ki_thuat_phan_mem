package MVC.Controller.QLPK;

import MVC.Model.QLPK.AppointmentManagementModel;
import MVC.View.QLPK.AppointmentManagementView;
import MVC.View.QLPK.EmployeeMainView;


import javax.swing.*;
import java.sql.*;

public class AppointmentManagementController {
    private Connection connection; // Biến kết nối với cơ sở dữ liệu
    private AppointmentManagementView view; // Biến tham chiếu đến lịch hẹn

    public AppointmentManagementController(AppointmentManagementView view) throws SQLException, ClassNotFoundException {
        this.view = view; // Gán biến tham chiếu view vào thuộc tính view của lớp

        // Initialize database connection
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongKham;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String pass = "Quangthai17.";
        connection = DriverManager.getConnection(url, username, pass);
          
        view.searchButton.addActionListener(e -> searchAppointment());
        view.addButton.addActionListener(e -> addAppointment());
        view.updateButton.addActionListener(e -> updateAppointment());
        view.deleteButton.addActionListener(e -> deleteAppointment());
        view.returnButton.addActionListener(e -> returnToEmployeeMainView());
    }
    
    
    // Hàm searchAppointment có tác dụng tìm kiếm 
    private void searchAppointment() {
        String appointmentID = view.appointmentIDField.getText(); // Lấy dữ liệu nhập vào trên appointmentIDField
        if (!appointmentID.isEmpty()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Appointment WHERE maLichHen = ?")) {
                preparedStatement.setString(1, appointmentID);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    view.patientIDField.setText(resultSet.getString("maBenhNhan"));
                    view.doctorIDField.setText(resultSet.getString("maBacSi"));
                    view.dateField.setText(resultSet.getString("ngayKham"));
                    view.timeField.setText(resultSet.getString("buoiKham"));
                    view.serviceIDField.setText(resultSet.getString("maDichVu"));
                } else {
                    JOptionPane.showMessageDialog(view, "No appointment found.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while searching for the appointment.");
                ex.printStackTrace();
            }
        }
    }

    private void addAppointment() {
        String doctorID = view.doctorIDField.getText();
        String date = view.dateField.getText();
        String time = view.timeField.getText();

        try (PreparedStatement checkStatement = connection.prepareStatement(
                "SELECT * FROM Appointment WHERE maBacSi = ? AND ngayKham = ? AND buoiKham = ?")) {
            checkStatement.setString(1, doctorID);
            checkStatement.setString(2, date);
            checkStatement.setString(3, time);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(view, "Appointment conflict detected. Please choose another time.");
            } else {
                try (PreparedStatement insertStatement = connection.prepareStatement(
                        "INSERT INTO Appointment (maLichHen, maBenhNhan, maBacSi, ngayKham, buoiKham, maDichVu) VALUES (?, ?, ?, ?, ?, ?)")) {
                    insertStatement.setString(1, view.appointmentIDField.getText());
                    insertStatement.setString(2, view.patientIDField.getText());
                    insertStatement.setString(3, doctorID);
                    insertStatement.setString(4, date);
                    insertStatement.setString(5, time);
                    insertStatement.setString(6, view.serviceIDField.getText());
                    insertStatement.executeUpdate();

                    JOptionPane.showMessageDialog(view, "Appointment added successfully.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "An error occurred while adding the appointment.");
            ex.printStackTrace();
        }
    }

    private void updateAppointment() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE Appointment SET maBenhNhan = ?, maBacSi = ?, ngayKham = ?, buoiKham = ?, maDichVu = ? WHERE maLichHen = ?")) {
            preparedStatement.setString(1, view.patientIDField.getText());
            preparedStatement.setString(2, view.doctorIDField.getText());
            preparedStatement.setString(3, view.dateField.getText());
            preparedStatement.setString(4, view.timeField.getText());
            preparedStatement.setString(5, view.serviceIDField.getText());
            preparedStatement.setString(6, view.appointmentIDField.getText());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(view, "Appointment updated successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "An error occurred while updating the appointment.");
            ex.printStackTrace();
        }
    }

    private void deleteAppointment() {
        String appointmentID = view.appointmentIDField.getText();
        if (!appointmentID.isEmpty()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Appointment WHERE maLichHen = ?")) {
                preparedStatement.setString(1, appointmentID);
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(view, "Appointment deleted successfully.");

                // Clear fields after deletion
                view.appointmentIDField.setText("");
                view.patientIDField.setText("");
                view.doctorIDField.setText("");
                view.dateField.setText("");
                view.timeField.setText("");
                view.serviceIDField.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while deleting the appointment.");
                ex.printStackTrace();
            }
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
            AppointmentManagementView view = new AppointmentManagementView();
            new AppointmentManagementController(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
