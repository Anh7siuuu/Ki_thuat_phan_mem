package MVC.Controller.QLPK;

import MVC.View.QLPK.DoctorMainView;
import MVC.View.QLPK.FindEquipmentView;


import javax.swing.*;
import java.sql.*;
import java.text.DecimalFormat;

public class FindEquipmentController {
    private Connection connection;
    private FindEquipmentView view;

    public FindEquipmentController(FindEquipmentView view) throws SQLException, ClassNotFoundException {
        this.view = view;

        // Initialize database connection
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongKham;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "Quangthai17.";
        connection = DriverManager.getConnection(url, username, password);

        loadEquipmentTypes();

        view.searchButton.addActionListener(e -> searchEquipment());
        view.returnButton.addActionListener(e -> returnToDoctorMainView());
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

    private void returnToDoctorMainView() {
        try {
            connection.close();
        } catch (SQLException e) {
            showError("Error closing database connection.", e);
        }
        view.dispose();
        DoctorMainView doctorMainView = new DoctorMainView();
        new DoctorMainController(doctorMainView);
        doctorMainView.setVisible(true);
    }

    private void showError(String message, Exception ex) {
        JOptionPane.showMessageDialog(view, message);
        ex.printStackTrace();
    }
    
    public static void main(String[] args) {
        try {
            FindEquipmentView view = new FindEquipmentView();
            new FindEquipmentController(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}