package MVC.Controller.QLPK;

import MVC.View.QLPK.ReportView;
import MVC.View.QLPK.MainView;

import javax.swing.*;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;

public class ReportController {
    private Connection connection;
    private ReportView view;

    public ReportController(ReportView view) throws SQLException, ClassNotFoundException {
        this.view = view;
        initializeDatabaseConnection();
        initListeners();
    }

    private void initializeDatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongKham;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "Quangthai17.";
        connection = DriverManager.getConnection(url, username, password);
    }

    private void initListeners() {
        view.searchButton.addActionListener(e -> generateReport());
        view.returnButton.addActionListener(e -> returnToMainView());
    }

    private void generateReport() {
        String selectedReport = (String) view.reportTypeBox.getSelectedItem();
        try {
            switch (selectedReport) {
                case "Revenue Report":
                    displayResult(formatCurrency(getRevenueReport()));
                    break;
                case "Expense Report":
                    displayResult(formatCurrency(getExpenseReport()));
                    break;
                case "Profit Report":
                    long revenue = getRevenueReport();
                    long expense = getExpenseReport();
                    long profit = revenue - expense;
                    displayResult(formatCurrency(profit));
                    break;
                case "Human Resource Report":
                    displayResult(String.valueOf(getHumanResourceReport()));
                    break;
                default:
                    showError("Invalid report type selected.");
            }
        } catch (SQLException ex) {
            showError("An error occurred while generating the report: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    private void returnToMainView() {
        view.dispose();
        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            new MainController(mainView);
        });
    }

    private long getRevenueReport() throws SQLException {
        String query = "SELECT SUM(CAST(soTienThanhToan AS BIGINT)) AS totalRevenue FROM Invoice";
        return executeLongQuery(query, "totalRevenue");
    }

    private long getExpenseReport() throws SQLException {
        String[] queries = {
            "SELECT SUM(CAST(luong AS BIGINT)) AS totalDoctorSalary FROM Doctor",
            "SELECT SUM(CAST(luong AS BIGINT)) AS totalEmployeeSalary FROM Employee",
            "SELECT SUM(CAST(giaTien AS BIGINT)) AS totalEquipmentCost FROM Equipment"
        };

        long totalExpense = 0;
        for (String query : queries) {
            if (query.contains("Doctor")) {
                totalExpense += executeLongQuery(query, "totalDoctorSalary");
            } else if (query.contains("Employee")) {
                totalExpense += executeLongQuery(query, "totalEmployeeSalary");
            } else if (query.contains("giaTien")) {
                totalExpense += executeLongQuery(query, "totalEquipmentCost");
            }
        }
        return totalExpense;
    }


    private int getHumanResourceReport() throws SQLException {
        String[] queries = {
            "SELECT COUNT(*) AS doctorCount FROM Doctor",
            "SELECT COUNT(*) AS employeeCount FROM Employee"
        };

        int totalResources = 0;
        for (String query : queries) {
            if (query.contains("Doctor")) {
                totalResources += executeIntQuery(query, "doctorCount");
            } else if (query.contains("Employee")) {
                totalResources += executeIntQuery(query, "employeeCount");
            }
        }
        return totalResources;
    }
    private long executeLongQuery(String query, String columnLabel) throws SQLException {
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getLong(columnLabel); // Lấy dữ liệu theo nhãn cột chính xác
            }
        } catch (SQLException e) {
            showError("Error executing query: " + query + ". Details: " + e.getMessage());
            throw e;
        }
        return 0;
    }


    private int executeIntQuery(String query, String columnLabel) throws SQLException {
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt(columnLabel);
            }
        }
        return 0;
    }

    private String formatCurrency(long amount) {
        return NumberFormat.getNumberInstance(Locale.US).format(amount);
    }

    private void displayResult(String result) {
        view.resultField.setText(result);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(view, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        try {
            ReportView view = new ReportView();
            new ReportController(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
