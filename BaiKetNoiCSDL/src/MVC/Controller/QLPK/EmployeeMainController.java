package MVC.Controller.QLPK;

import java.sql.SQLException;
import MVC.View.QLPK.EmployeeMainView;
import MVC.View.QLPK.PatientManagementView;
import MVC.View.QLPK.InvoiceManagementView;
import MVC.View.QLPK.LoginView;
import MVC.View.QLPK.EquipmentManagementView;
import MVC.View.QLPK.AppointmentManagementView;

public class EmployeeMainController {
    private EmployeeMainView employeeMainView;

    public EmployeeMainController(EmployeeMainView employeeMainView) {
        this.employeeMainView = employeeMainView;
        initController();
    }

    // Hàm này để thiết lập các sự kiện lắng nghe
    private void initController() {
        // Thiết lập sự kiện lắng nghe khi người dùng ấn vào nút AppointmentManagement
        employeeMainView.addAppointmentManagementListener(e -> {
            try {
                openAppointmentManagementView();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            }
        });

        // Tương tự với các nút cho các chức năng còn lại
        employeeMainView.addEquipmentManagementListener(e -> {
            try {
                openEquipmentManagementView();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            }
        });

        employeeMainView.addInvoiceManagementListener(e -> {
            try {
                openInvoiceManagementView();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            }
        });

        employeeMainView.addPatientManagementListener(e -> {
            try {
                openPatientManagementView();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            }
        });

        // Thêm sự kiện đăng xuất (Log Out)
        employeeMainView.addLogoutListener(e -> {
            try {
                openLoginView();
            } catch (ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
            }
        });
    }

    // Đây là phương thức để mở các giao diện con khi người dùng click vào các nút
    private void openAppointmentManagementView() throws ClassNotFoundException, SQLException {
        AppointmentManagementView appointmentManagementView = new AppointmentManagementView();
        new AppointmentManagementController(appointmentManagementView); // Khởi tạo controller cho AppointmentManagement
        appointmentManagementView.setVisible(true);
    }

    private void openEquipmentManagementView() throws ClassNotFoundException, SQLException {
        EquipmentManagementView equipmentManagementView = new EquipmentManagementView();
        new EquipmentManagementController(equipmentManagementView); // Khởi tạo controller cho EquipmentManagement
        equipmentManagementView.setVisible(true);
    }

    private void openInvoiceManagementView() throws ClassNotFoundException, SQLException {
        InvoiceManagementView invoiceManagementView = new InvoiceManagementView();
        new InvoiceManagementController(invoiceManagementView); // Khởi tạo controller cho InvoiceManagement
        invoiceManagementView.setVisible(true);
    }

    private void openPatientManagementView() throws ClassNotFoundException, SQLException {
        PatientManagementView patientManagementView = new PatientManagementView();
        new PatientManagementController(patientManagementView); // Khởi tạo controller cho PatientManagement
        patientManagementView.setVisible(true);
    }

    // Phương thức mở giao diện LoginView khi nhấn Log Out
    private void openLoginView() throws ClassNotFoundException, SQLException {
        LoginView loginView = new LoginView(); // Tạo đối tượng LoginView

        // Khởi tạo controller cho LoginView, truyền các tham số cần thiết
        new LoginController(
            loginView, 
            loginView.getUsernameField(), 
            loginView.getPasswordField(), 
            loginView.getLoginButton()
        ); // Khởi tạo controller cho LoginView

        loginView.setVisible(true); // Hiển thị LoginView
        employeeMainView.dispose(); // Đóng cửa sổ EmployeeMainView khi người dùng đăng xuất
    }

    // Phương thức main để chạy ứng dụng
    public static void main(String[] args) {
        EmployeeMainView employeeMainView = new EmployeeMainView();
        new EmployeeMainController(employeeMainView); // Khởi tạo controller cho EmployeeMainView
    }
}
