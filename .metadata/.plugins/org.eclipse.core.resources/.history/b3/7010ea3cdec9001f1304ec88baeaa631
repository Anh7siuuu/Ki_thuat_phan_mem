package MVC.View.QLPK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AppointmentManagementView extends JFrame {

    public JTextField appointmentIDField;
    public JTextField patientIDField;
    public JTextField doctorIDField;
    public JTextField dateField;
    public JTextField timeField;
    public JTextField serviceIDField;
    public JButton searchButton;
    public JButton addButton;
    public JButton updateButton;
    public JButton deleteButton;

    public AppointmentManagementView() {
        setTitle("Appointment Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Appointment ID field
        JLabel appointmentIDLabel = new JLabel("Appointment ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(appointmentIDLabel, gbc);

        appointmentIDField = new JTextField();
        appointmentIDField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(appointmentIDField, gbc);

        // Patient ID field
        JLabel patientIDLabel = new JLabel("Patient ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(patientIDLabel, gbc);

        patientIDField = new JTextField();
        patientIDField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(patientIDField, gbc);

        // Doctor ID field
        JLabel doctorIDLabel = new JLabel("Doctor ID:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(doctorIDLabel, gbc);

        doctorIDField = new JTextField();
        doctorIDField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(doctorIDField, gbc);

        // Date field
        JLabel dateLabel = new JLabel("Date:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(dateLabel, gbc);

        dateField = new JTextField();
        dateField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(dateField, gbc);

        // Time field
        JLabel timeLabel = new JLabel("Time:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(timeLabel, gbc);

        timeField = new JTextField();
        timeField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(timeField, gbc);

        // Service ID field
        JLabel serviceIDLabel = new JLabel("Service ID:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(serviceIDLabel, gbc);

        serviceIDField = new JTextField();
        serviceIDField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 5;
        mainPanel.add(serviceIDField, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        searchButton = new JButton("Search");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        buttonPanel.add(searchButton);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

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
    
    public static void main(String[] args) {
        new AppointmentManagementView();
    }
}