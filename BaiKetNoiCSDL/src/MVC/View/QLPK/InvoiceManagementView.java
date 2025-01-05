package MVC.View.QLPK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InvoiceManagementView extends JFrame {
    public JComboBox<String> invoiceIDBox;
    public JTextField invoiceIDField;
    public JTextField employeeIDField;
    public JTextField patientIDField;
    public JTextField dateField;
    public JTextField paymentAmountField;
    public JTextField paymentMethodField;
    public JTextField noteField;
    public JButton searchButton;
    public JButton addButton;
    public JButton updateButton;
    public JButton deleteButton;
    public JButton returnButton; // Added return button

    public InvoiceManagementView() {
        setTitle("Invoice Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Dropdown for invoice IDs
        JLabel invoiceIDBoxLabel = new JLabel("Select Invoice ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(invoiceIDBoxLabel, gbc);

        invoiceIDBox = new JComboBox<>();
        invoiceIDBox.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(invoiceIDBox, gbc);

        // Invoice ID field
        JLabel invoiceIDLabel = new JLabel("Invoice ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(invoiceIDLabel, gbc);

        invoiceIDField = new JTextField();
        invoiceIDField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(invoiceIDField, gbc);

        // Employee ID field
        JLabel employeeIDLabel = new JLabel("Employee ID:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(employeeIDLabel, gbc);

        employeeIDField = new JTextField();
        employeeIDField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(employeeIDField, gbc);

        // Patient ID field
        JLabel patientIDLabel = new JLabel("Patient ID:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(patientIDLabel, gbc);

        patientIDField = new JTextField();
        patientIDField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(patientIDField, gbc);

        // Date field
        JLabel dateLabel = new JLabel("Date:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(dateLabel, gbc);

        dateField = new JTextField();
        dateField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(dateField, gbc);

        // Payment Amount field
        JLabel paymentAmountLabel = new JLabel("Payment Amount:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(paymentAmountLabel, gbc);

        paymentAmountField = new JTextField();
        paymentAmountField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 5;
        mainPanel.add(paymentAmountField, gbc);

        // Payment Method field
        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(paymentMethodLabel, gbc);

        paymentMethodField = new JTextField();
        paymentMethodField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 6;
        mainPanel.add(paymentMethodField, gbc);

        // Note field
        JLabel noteLabel = new JLabel("Note:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(noteLabel, gbc);

        noteField = new JTextField();
        noteField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 7;
        mainPanel.add(noteField, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        searchButton = new JButton("Search");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        returnButton = new JButton("Return"); // Added Return button

        buttonPanel.add(searchButton);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(returnButton); // Add the return button to the panel

        // Add panels to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack(); // Adjust frame size to fit components
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    // Method to attach listener to buttons
    public void addSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addUpdateButtonListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void addReturnButtonListener(ActionListener listener) {
        returnButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        new InvoiceManagementView();
    }
}