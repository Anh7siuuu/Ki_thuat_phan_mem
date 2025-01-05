package MVC.View.QLPK;

import javax.swing.*;
import java.awt.*;

public class PatientManagementView extends JFrame {
    public JComboBox<String> patientIDBox;
    public JTextField patientIDField;
    public JPasswordField passwordField;
    public JTextField nameField;
    public JTextField dobField;
    public JTextField phoneField;
    public JTextField emailField;
    public JTextField occupationField;
    public JTextField permissionIDField;
    public JButton searchButton;
    public JButton addButton;
    public JButton updateButton;
    public JButton deleteButton;
    public JButton returnButton; // Added Return button

    public PatientManagementView() {
        setTitle("Patient Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Dropdown for patient IDs
        JLabel patientIDBoxLabel = new JLabel("Select Patient ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(patientIDBoxLabel, gbc);

        patientIDBox = new JComboBox<>();
        patientIDBox.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(patientIDBox, gbc);

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

        // Password field
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(passwordField, gbc);

        // Name field
        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(nameLabel, gbc);

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(nameField, gbc);

        // Date of Birth field
        JLabel dobLabel = new JLabel("Date of Birth:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(dobLabel, gbc);

        dobField = new JTextField();
        dobField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(dobField, gbc);

        // Phone field
        JLabel phoneLabel = new JLabel("Phone:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(phoneLabel, gbc);

        phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 5;
        mainPanel.add(phoneField, gbc);

        // Email field
        JLabel emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(emailLabel, gbc);

        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 6;
        mainPanel.add(emailField, gbc);

        // Occupation field
        JLabel occupationLabel = new JLabel("Occupation:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(occupationLabel, gbc);

        occupationField = new JTextField();
        occupationField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 7;
        mainPanel.add(occupationField, gbc);

        // Permission ID field
        JLabel permissionIDLabel = new JLabel("Permission ID:");
        gbc.gridx = 0;
        gbc.gridy = 8;
        mainPanel.add(permissionIDLabel, gbc);

        permissionIDField = new JTextField();
        permissionIDField.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 8;
        mainPanel.add(permissionIDField, gbc);

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

    public static void main(String[] args) {
        new PatientManagementView();
    }
}
