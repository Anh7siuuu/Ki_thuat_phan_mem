package MVC.Controller.QLPK;

import java.sql.SQLException;
import MVC.View.QLPK.DoctorMainView;
import MVC.View.QLPK.FindEquipmentView;
import MVC.View.QLPK.MedicalRecordManagementView;
import MVC.View.QLPK.LoginView;

public class DoctorMainController {
    private DoctorMainView doctorMainView;

    public DoctorMainController(DoctorMainView doctorMainView) {
        this.doctorMainView = doctorMainView;
        initController();
    }

    // Hàm này để thiết lập các sự kiện lắng nghe
    private void initController() {
        // Thiết lập sự kiện lắng nghe khi người dùng ấn vào nút MedicalRecordManagement
        doctorMainView.addMedicalRecordManagementListener(e -> {
            try {
                openMedicalRecordManagementView();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            }
        });

        doctorMainView.addFindEquipmentListener(e -> {
            try {
                openFindEquipmentView();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            }
        });

        // Thêm sự kiện đăng xuất (Log Out)
        doctorMainView.addLogoutListener(e -> {
            try {
                openLoginView();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            }
        });
    }

    // Phương thức mở giao diện Medical Record Management
    private void openMedicalRecordManagementView() throws ClassNotFoundException, SQLException {
        MedicalRecordManagementView medicalRecordManagementView = new MedicalRecordManagementView();
        new MedicalRecordManagementController(medicalRecordManagementView); // Khởi tạo controller cho MedicalRecordManagementView
        medicalRecordManagementView.setVisible(true); // Hiển thị giao diện
    }

    // Phương thức mở giao diện Find Equipment
    private void openFindEquipmentView() throws ClassNotFoundException, SQLException {
        FindEquipmentView findEquipmentView = new FindEquipmentView();
        new FindEquipmentController(findEquipmentView); // Khởi tạo controller cho FindEquipmentView
        findEquipmentView.setVisible(true); // Hiển thị giao diện
    }

    // Phương thức mở giao diện LoginView khi nhấn Log Out
    private void openLoginView() throws ClassNotFoundException, SQLException {
        LoginView loginView = new LoginView(); // Tạo đối tượng LoginView

        // Truyền các tham số cần thiết khi khởi tạo LoginController
        new LoginController(
            loginView,
            loginView.getUsernameField(),
            loginView.getPasswordField(),
            loginView.getLoginButton()
        ); // Khởi tạo controller cho LoginView

        doctorMainView.dispose();  // Đóng cửa sổ DoctorMainView khi người dùng đăng xuất
        loginView.setVisible(true); // Hiển thị LoginView
    }

    public static void main(String[] args) {
        DoctorMainView doctorMainView = new DoctorMainView();
        new DoctorMainController(doctorMainView); // Khởi tạo controller cho DoctorMainView
    }
}
