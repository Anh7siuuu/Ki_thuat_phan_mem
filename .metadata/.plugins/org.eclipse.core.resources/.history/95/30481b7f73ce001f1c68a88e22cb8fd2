package MVC.View.QLPK;

import javax.swing.*;
import java.awt.*;

public class MedicalRecordManagementView extends JFrame {
    public JTextField medicalRecordIDField;
    public JTextField appointmentIDField;
    public JTextField diseaseNameField;
    public JTextArea prescriptionArea;
    public JButton searchButton;
    public JButton addButton;
    public JButton updateButton;
    public JButton deleteButton;

    public MedicalRecordManagementView() {
        setTitle("Medical Record Management");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Header Label
        JLabel headerLabel = new JLabel("Medical Record Management", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels and Fields
        JLabel medicalRecordIDLabel = new JLabel("Medical Record ID:");
        JLabel appointmentIDLabel = new JLabel("Appointment ID:");
        JLabel diseaseNameLabel = new JLabel("Disease Name:");
        JLabel prescriptionLabel = new JLabel("Prescription:");

        medicalRecordIDField = new JTextField(25);
        appointmentIDField = new JTextField(25);
        diseaseNameField = new JTextField(25);
        prescriptionArea = new JTextArea(5, 25);
        prescriptionArea.setLineWrap(true);
        prescriptionArea.setWrapStyleWord(true);
        JScrollPane prescriptionScrollPane = new JScrollPane(prescriptionArea);

        // Add components to form panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(medicalRecordIDLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(medicalRecordIDField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(appointmentIDLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(appointmentIDField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(diseaseNameLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(diseaseNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(prescriptionLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(prescriptionScrollPane, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        searchButton = new JButton("Search");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        buttonPanel.add(searchButton);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Add panels to main panel
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set main panel as content pane
        setContentPane(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MedicalRecordManagementView();
    }
}