package MVC.Controller.QLPK;

import MVC.View.QLPK.EmployeeMainView;
import MVC.View.QLPK.EquipmentManagementView;
import MVC.Model.QLPK.EquipmentManagementModel;

import javax.swing.*;
import java.sql.*;
import java.text.DecimalFormat;

public class EquipmentManagementController {
    private Connection connection;
    private EquipmentManagementView view;

    public EquipmentManagementController(EquipmentManagementView view) throws SQLException, ClassNotFoundException {
        this.view = view;

        // Initialize database connection
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongKham;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "Quangthai17.";
        connection = DriverManager.getConnection(url, username, password);

        loadEquipmentTypes();

        view.searchButton.addActionListener(e -> searchEquipment());
        view.addButton.addActionListener(e -> addEquipment());
        view.updateButton.addActionListener(e -> updateEquipment());
        view.deleteButton.addActionListener(e -> deleteEquipment());
        view.returnButton.addActionListener(e -> returnToEmployeeMainView());
    }

    private void loadEquipmentTypes() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT tenVatTu FROM Equipment");
            view.equipmentTypeBox.removeAllItems();
            while (resultSet.next()) {
                view.equipmentTypeBox.addItem(resultSet.getString("tenVatTu"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "An error occurred while loading equipment types.");
            ex.printStackTrace();
        }
    }

    private void searchEquipment() {
        String selectedEquipmentType = (String) view.equipmentTypeBox.getSelectedItem();

        if (selectedEquipmentType != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Equipment WHERE tenVatTu = ?")) {
                preparedStatement.setString(1, selectedEquipmentType);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    DecimalFormat formatter = new DecimalFormat("###,###");
                    
                    view.equipmentIDField.setText(resultSet.getString("maVatTu"));
                    view.equipmentNameField.setText(resultSet.getString("tenVatTu"));
                    view.priceField.setText(formatter.format(resultSet.getDouble("giaTien")));
                    view.equipmentStatusField.setText(resultSet.getString("tinhTrangThietBi"));
                    view.stockInDateField.setText(resultSet.getString("ngayNhapKho"));
                    view.supplierField.setText(resultSet.getString("nhaCungCap"));
                    view.dateOfExpireField.setText(resultSet.getString("hanSuDung"));
                } else {
                    JOptionPane.showMessageDialog(view, "Equipment not found.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while searching for the equipment.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(view, "Please select an equipment type.");
        }
    }

    private void addEquipment() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Equipment (maVatTu, tenVatTu, giaTien, tinhTrangThietBi, ngayNhapKho, nhaCungCap, hanSuDung) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, view.equipmentIDField.getText());
            preparedStatement.setString(2, view.equipmentNameField.getText());
            preparedStatement.setDouble(3, Double.parseDouble(view.priceField.getText().replace(",", "")));
            preparedStatement.setString(4, view.equipmentStatusField.getText());
            preparedStatement.setString(5, view.stockInDateField.getText());
            preparedStatement.setString(6, view.supplierField.getText());
            preparedStatement.setString(7, view.dateOfExpireField.getText());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(view, "Equipment added successfully.");
            loadEquipmentTypes();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "An error occurred while adding the equipment.");
            ex.printStackTrace();
        }
    }

    private void updateEquipment() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE Equipment SET tenVatTu = ?, giaTien = ?, tinhTrangThietBi = ?, ngayNhapKho = ?, nhaCungCap = ?, hanSuDung = ? " +
                        "WHERE maVatTu = ?")) {
            preparedStatement.setString(1, view.equipmentNameField.getText());
            preparedStatement.setDouble(2, Double.parseDouble(view.priceField.getText().replace(",", "")));
            preparedStatement.setString(3, view.equipmentStatusField.getText());
            preparedStatement.setString(4, view.stockInDateField.getText());
            preparedStatement.setString(5, view.supplierField.getText());
            preparedStatement.setString(6, view.dateOfExpireField.getText());
            preparedStatement.setString(7, view.equipmentIDField.getText());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(view, "Equipment updated successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "An error occurred while updating the equipment.");
            ex.printStackTrace();
        }
    }

    private void deleteEquipment() {
        String selectedEquipmentID = view.equipmentIDField.getText();

        if (!selectedEquipmentID.isEmpty()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Equipment WHERE maVatTu = ?")) {
                preparedStatement.setString(1, selectedEquipmentID);
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(view, "Equipment deleted successfully.");
                loadEquipmentTypes();

                // Clear fields after deletion
                view.equipmentIDField.setText("");
                view.equipmentNameField.setText("");
                view.priceField.setText("");
                view.equipmentStatusField.setText("");
                view.stockInDateField.setText("");
                view.supplierField.setText("");
                view.dateOfExpireField.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while deleting the equipment.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(view, "Please enter an Equipment ID to delete.");
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
            EquipmentManagementView view = new EquipmentManagementView();
            new EquipmentManagementController(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}