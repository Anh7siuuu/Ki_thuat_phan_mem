package MVC.View.QLPK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JButton doctorManagementButton;
    private JButton employeeManagementButton;
    private JButton reportButton;
    private JButton permissionManagementButton;

    public MainView() {
        setTitle("Main Menu");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sử dụng JPanel với BoxLayout để sắp xếp các nút theo chiều dọc
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Thêm khoảng cách xung quanh

        // Tạo nút quản lý bác sĩ
        doctorManagementButton = createButton("Quản lý bác sĩ");
        employeeManagementButton = createButton("Quản lý nhân viên");
        reportButton = createButton("Báo cáo");
        permissionManagementButton = createButton("Quản lý quyền");

        // Thêm các nút vào mainPanel
        mainPanel.add(doctorManagementButton);
        mainPanel.add(Box.createVerticalStrut(20)); // Khoảng cách giữa các nút
        mainPanel.add(employeeManagementButton);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(reportButton);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(permissionManagementButton);

        // Thêm mainPanel vào JFrame
        add(mainPanel, BorderLayout.CENTER);

        // Hiển thị giao diện
        setLocationRelativeTo(null); // Căn giữa màn hình
        setVisible(true);
    }

    // Phương thức tạo nút với kích thước đồng nhất và kiểu dáng đẹp
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa nút
        button.setPreferredSize(new Dimension(200, 40)); // Kích thước nút
        button.setMaximumSize(new Dimension(200, 40)); // Giới hạn kích thước tối đa
        return button;
    }

    // Thêm listener cho từng nút
    public void addDoctorManagementListener(ActionListener listener) {
        doctorManagementButton.addActionListener(listener);
    }

    public void addEmployeeManagementListener(ActionListener listener) {
        employeeManagementButton.addActionListener(listener);
    }

    public void addReportListener(ActionListener listener) {
        reportButton.addActionListener(listener);
    }

    public void addPermissionListener(ActionListener listener) {
        permissionManagementButton.addActionListener(listener);
    }
}