package MVC.Controller.QLPK;

import MVC.View.QLPK.EmployeeMainView;
import MVC.View.QLPK.InvoiceManagementView;
import MVC.View.QLPK.EmployeeMainView;

import javax.swing.*;
import java.sql.*;
import java.text.DecimalFormat;

public class InvoiceManagementController {
    private Connection connection;
    private InvoiceManagementView view;

    public InvoiceManagementController(InvoiceManagementView view) throws SQLException, ClassNotFoundException {
        this.view = view;

        // Initialize database connection
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongKham;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "Quangthai17.";
        connection = DriverManager.getConnection(url, username, password);

        loadInvoiceIDs();

        view.searchButton.addActionListener(e -> searchInvoice());
        view.addButton.addActionListener(e -> addInvoice());
        view.updateButton.addActionListener(e -> updateInvoice());
        view.deleteButton.addActionListener(e -> deleteInvoice());
        view.returnButton.addActionListener(e -> returnToEmployeeMainView());
    }

    private void loadInvoiceIDs() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT maHoaDon FROM Invoice");
            view.invoiceIDBox.removeAllItems();
            while (resultSet.next()) {
                view.invoiceIDBox.addItem(resultSet.getString("maHoaDon"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "An error occurred while loading invoice IDs.");
            ex.printStackTrace();
        }
    }

    private void searchInvoice() {
        String selectedInvoiceID = (String) view.invoiceIDBox.getSelectedItem();

        if (selectedInvoiceID != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Invoice WHERE maHoaDon = ?")) {
                preparedStatement.setString(1, selectedInvoiceID);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    DecimalFormat formatter = new DecimalFormat("###,###,###");
                    view.invoiceIDField.setText(resultSet.getString("maHoaDon"));
                    view.employeeIDField.setText(resultSet.getString("maNhanVien"));
                    view.patientIDField.setText(resultSet.getString("maBenhNhan"));
                    view.dateField.setText(resultSet.getString("ngayLapHoaDon"));
                    view.paymentAmountField.setText(formatter.format(resultSet.getInt("soTienThanhToan")));
                    view.paymentMethodField.setText(resultSet.getString("phuongThucThanhToan"));
                    view.noteField.setText(resultSet.getString("noiDungThanhToan"));
                } else {
                    JOptionPane.showMessageDialog(view, "Invoice not found.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while searching for the invoice.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(view, "Please select an Invoice ID.");
        }
    }

    private void addInvoice() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Invoice (maHoaDon, maNhanVien, maBenhNhan, ngayLapHoaDon, soTienThanhToan, phuongThucThanhToan, noiDungThanhToan) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, view.invoiceIDField.getText());
            preparedStatement.setString(2, view.employeeIDField.getText());
            preparedStatement.setString(3, view.patientIDField.getText());
            preparedStatement.setString(4, view.dateField.getText());
            preparedStatement.setInt(5, Integer.parseInt(view.paymentAmountField.getText().replace(",", "")));
            preparedStatement.setString(6, view.paymentMethodField.getText());
            preparedStatement.setString(7, view.noteField.getText());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(view, "Invoice added successfully.");
            loadInvoiceIDs();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "An error occurred while adding the invoice.");
            ex.printStackTrace();
        }
    }

    private void updateInvoice() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE Invoice SET maNhanVien = ?, maBenhNhan = ?, ngayLapHoaDon = ?, soTienThanhToan = ?, phuongThucThanhToan = ?, noiDungThanhToan = ? " +
                        "WHERE maHoaDon = ?")) {
            preparedStatement.setString(1, view.employeeIDField.getText());
            preparedStatement.setString(2, view.patientIDField.getText());
            preparedStatement.setString(3, view.dateField.getText());
            preparedStatement.setInt(4, Integer.parseInt(view.paymentAmountField.getText().replace(",", "")));
            preparedStatement.setString(5, view.paymentMethodField.getText());
            preparedStatement.setString(6, view.noteField.getText());
            preparedStatement.setString(7, view.invoiceIDField.getText());
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(view, "Invoice updated successfully.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "An error occurred while updating the invoice.");
            ex.printStackTrace();
        }
    }

    private void deleteInvoice() {
        String selectedInvoiceID = (String) view.invoiceIDBox.getSelectedItem();

        if (selectedInvoiceID != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Invoice WHERE maHoaDon = ?")) {
                preparedStatement.setString(1, selectedInvoiceID);
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(view, "Invoice deleted successfully.");
                loadInvoiceIDs();

                // Clear fields after deletion
                view.invoiceIDField.setText("");
                view.employeeIDField.setText("");
                view.patientIDField.setText("");
                view.dateField.setText("");
                view.paymentAmountField.setText("");
                view.paymentMethodField.setText("");
                view.noteField.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "An error occurred while deleting the invoice.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(view, "Please select an Invoice ID to delete.");
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
            InvoiceManagementView view = new InvoiceManagementView();
            new InvoiceManagementController(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}