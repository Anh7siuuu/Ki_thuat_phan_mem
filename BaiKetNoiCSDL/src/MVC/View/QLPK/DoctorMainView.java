package MVC.View.QLPK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DoctorMainView extends JFrame {
    private JButton MedicalRecordManagemenButton;
 
    public DoctorMainView() {
        setTitle("Main Menu");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sử dụng JPanel với BoxLayout để sắp xếp các nút theo chiều dọc
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Thêm khoảng cách xung quanh

        // Tạo nút quản lý bác sĩ
        MedicalRecordManagemenButton = createButton("Quản lí bệnh án");

        // Thêm các nút vào mainPanel
        mainPanel.add(MedicalRecordManagemenButton);
        mainPanel.add(Box.createVerticalStrut(20)); // Khoảng cách giữa các nút

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
    public void addMedicalRecordManagemenListener(ActionListener listener) {
    	MedicalRecordManagemenButton.addActionListener(listener);
    }
    
    public static void main(String[] args) {
    	new DoctorMainView();
    }
}