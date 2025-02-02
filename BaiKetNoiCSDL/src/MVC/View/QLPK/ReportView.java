package MVC.View.QLPK;

import javax.swing.*;
import java.awt.*;

public class ReportView extends JFrame {
    public JComboBox<String> reportTypeBox;
    public JButton searchButton;
    public JButton returnButton; // Nút Return
    public JTextField resultField;

    public ReportView() {
        // Frame setup
        setTitle("Report Management");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Components
        JLabel reportTypeLabel = new JLabel("Select Report Type:");
        reportTypeBox = new JComboBox<>(new String[]{
            "Revenue Report", "Expense Report", "Profit Report", "Human Resource Report"
        });

        searchButton = new JButton("Search");
        returnButton = new JButton("Return"); // Khởi tạo nút Return

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(15);
        resultField.setEditable(false);
        
        JLabel currencyLabel = new JLabel("VND");

        // Layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(reportTypeLabel, gbc);

        gbc.gridx = 1;
        add(reportTypeBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(searchButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(returnButton, gbc); // Thêm nút Return vào layout

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(resultLabel, gbc);

        gbc.gridx = 1;
        add(resultField, gbc);

        gbc.gridx = 2;
        add(currencyLabel, gbc);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ReportView();
    }
}