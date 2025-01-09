package MVC.View.QLPK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DoctorMainView extends JFrame {
    private JButton MedicalRecordManagementButton;
    private JButton FindEquipmentButton;
    private JButton logoutButton; // Nút Log Out

    public DoctorMainView() {
        setTitle("Main Menu");
        setSize(400, 500);  // Tăng kích thước cửa sổ để có thêm chỗ cho nút Log Out
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sử dụng JPanel với BoxLayout để sắp xếp các nút theo chiều dọc
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Thêm khoảng cách xung quanh

        // Tạo các nút chức năng
        MedicalRecordManagementButton = createButton("Quản lí bệnh án");
        FindEquipmentButton = createButton("Tìm kiếm vật tư");

        // Tạo nút Log Out
        logoutButton = createButton("Log Out");

        // Thêm các nút vào mainPanel
        mainPanel.add(MedicalRecordManagementButton);
        mainPanel.add(Box.createVerticalStrut(20)); // Khoảng cách giữa các nút
        mainPanel.add(FindEquipmentButton);
        mainPanel.add(Box.createVerticalStrut(20)); // Khoảng cách giữa các nút
        mainPanel.add(logoutButton); // Thêm nút Log Out

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
    public void addMedicalRecordManagementListener(ActionListener listener) {
        MedicalRecordManagementButton.addActionListener(listener);
    }

    public void addFindEquipmentListener(ActionListener listener) {
        FindEquipmentButton.addActionListener(listener);
    }

    // Thêm listener cho nút Log Out
    public void addLogoutListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        new DoctorMainView();
    }
}
