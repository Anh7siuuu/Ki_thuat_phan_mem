package MVC.Controller.QLPK;

import MVC.Model.QLPK.MedicalRecordManagementModel;
import MVC.View.QLPK.MedicalRecordManagementView;

import javax.swing.*;
import java.sql.*;

	public class MedicalRecordManagementController {
	    private Connection connection;
	    private MedicalRecordManagementView view;

	    public MedicalRecordManagementController(MedicalRecordManagementView view) throws SQLException, ClassNotFoundException {
	        this.view = view;

	        // Initialize database connection
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongKham;encrypt=true;trustServerCertificate=true";
	        String username = "sa";
	        String password = "Quangthai17.";
	        connection = DriverManager.getConnection(url, username, password);

	        view.searchButton.addActionListener(e -> searchMedicalRecord());
	        view.addButton.addActionListener(e -> addMedicalRecord());
	        view.updateButton.addActionListener(e -> updateMedicalRecord());
	        view.deleteButton.addActionListener(e -> deleteMedicalRecord());
	    }

	    private void searchMedicalRecord() {
	        String medicalRecordID = view.medicalRecordIDField.getText();

	        if (!medicalRecordID.isEmpty()) {
	            try (PreparedStatement preparedStatement = connection.prepareStatement(
	                    "SELECT * FROM MedicalRecord WHERE maBenhAn = ?")) {
	                preparedStatement.setString(1, medicalRecordID);
	                ResultSet resultSet = preparedStatement.executeQuery();

	                if (resultSet.next()) {
	                    view.appointmentIDField.setText(resultSet.getString("maLichHen"));
	                    view.diseaseNameField.setText(resultSet.getString("tenBenh"));
	                    view.prescriptionArea.setText(resultSet.getString("donThuoc"));
	                } else {
	                    JOptionPane.showMessageDialog(view, "Medical record not found.");
	                }
	            } catch (SQLException ex) {
	                JOptionPane.showMessageDialog(view, "An error occurred while searching for the medical record.");
	                ex.printStackTrace();
	            }
	        } else {
	            JOptionPane.showMessageDialog(view, "Please enter a Medical Record ID.");
	        }
	    }

	    private void addMedicalRecord() {
	        try (PreparedStatement preparedStatement = connection.prepareStatement(
	                "INSERT INTO MedicalRecord (maBenhAn, maLichHen, tenBenh, donThuoc) VALUES (?, ?, ?, ?)")) {
	            preparedStatement.setString(1, view.medicalRecordIDField.getText());
	            preparedStatement.setString(2, view.appointmentIDField.getText());
	            preparedStatement.setString(3, view.diseaseNameField.getText());
	            preparedStatement.setString(4, view.prescriptionArea.getText());
	            preparedStatement.executeUpdate();

	            JOptionPane.showMessageDialog(view, "Medical record added successfully.");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(view, "An error occurred while adding the medical record.");
	            ex.printStackTrace();
	        }
	    }

	    private void updateMedicalRecord() {
	        try (PreparedStatement preparedStatement = connection.prepareStatement(
	                "UPDATE MedicalRecord SET maLichHen = ?, tenBenh = ?, donThuoc = ? WHERE maBenhAn = ?")) {
	            preparedStatement.setString(1, view.appointmentIDField.getText());
	            preparedStatement.setString(2, view.diseaseNameField.getText());
	            preparedStatement.setString(3, view.prescriptionArea.getText());
	            preparedStatement.setString(4, view.medicalRecordIDField.getText());
	            preparedStatement.executeUpdate();

	            JOptionPane.showMessageDialog(view, "Medical record updated successfully.");
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(view, "An error occurred while updating the medical record.");
	            ex.printStackTrace();
	        }
	    }

	    private void deleteMedicalRecord() {
	        String medicalRecordID = view.medicalRecordIDField.getText();

	        if (!medicalRecordID.isEmpty()) {
	            try (PreparedStatement preparedStatement = connection.prepareStatement(
	                    "DELETE FROM MedicalRecord WHERE maBenhAn = ?")) {
	                preparedStatement.setString(1, medicalRecordID);
	                preparedStatement.executeUpdate();

	                JOptionPane.showMessageDialog(view, "Medical record deleted successfully.");

	                // Clear fields after deletion
	                view.medicalRecordIDField.setText("");
	                view.appointmentIDField.setText("");
	                view.diseaseNameField.setText("");
	                view.prescriptionArea.setText("");
	            } catch (SQLException ex) {
	                JOptionPane.showMessageDialog(view, "An error occurred while deleting the medical record.");
	                ex.printStackTrace();
	            }
	        } else {
	            JOptionPane.showMessageDialog(view, "Please enter a Medical Record ID to delete.");
	        }
	    }

	    public static void main(String[] args) {
	        try {
	            MedicalRecordManagementView view = new MedicalRecordManagementView();
	            new MedicalRecordManagementController(view);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

