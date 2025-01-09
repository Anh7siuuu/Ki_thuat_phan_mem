package MVC.Controller.QLPK;

import java.sql.SQLException;
import MVC.View.QLPK.MainView;
import MVC.View.QLPK.DoctorManagementView;
import MVC.View.QLPK.EmployeeManagementView;
import MVC.View.QLPK.PermissionView;
import MVC.View.QLPK.ReportView;
import MVC.View.QLPK.LoginView;

public class MainController {
      private MainView mainView;
      public MainController(MainView mainView) {
          this.mainView = mainView;
          initController();
      }
      
      //Hàm này để thiết lập các sự kiện lắng nghe
      private void initController() {
    	  // Thiết lập sự kiện lắng nghe khi người dùng ấn vào nút DoctorManagement trên giao diện Main
          mainView.addDoctorManagementListener(e -> {
  			try {
  				openDoctorManagementView();
  			} catch (ClassNotFoundException e1) {
  				e1.printStackTrace();
  			} catch (SQLException e1) {
  				e1.printStackTrace();
  			}
  		});
           
          // Tương tự với các nút cho các chức năng còn lại
          mainView.addEmployeeManagementListener(e -> {
        	  try {
    				openEmployeeManagementView();
    			} catch (ClassNotFoundException e1) {
    				e1.printStackTrace();
    			} catch (SQLException e1) {
    				e1.printStackTrace();
    			} 
        });
          
          mainView.addReportListener(e -> {
        	  try {
    				openReportView();
    			} catch (ClassNotFoundException e1) {
    				e1.printStackTrace();
    			} catch (SQLException e1) {
    				e1.printStackTrace();
    			} 
        });
          
          mainView.addPermissionListener(e -> {
        	  try {
    				openPermissionView();
    			} catch (ClassNotFoundException e1) {
    				e1.printStackTrace();
    			} catch (SQLException e1) {
    				e1.printStackTrace();
    			} 
        });
          
          mainView.addLogoutListener(e -> {
              try {
                  openLoginView();
              } catch (ClassNotFoundException e1) {
                  e1.printStackTrace();
              } catch (SQLException e1) {
                  e1.printStackTrace();
              }
          });
      }
      
      // Đây là phương thức để mở giao diện con
      private void openDoctorManagementView() throws ClassNotFoundException, SQLException {
    	  MVC.View.QLPK.DoctorManagementView  doctorManagementView = new DoctorManagementView(); // Tạo một đối tượng DoctorManagementView
    	  new DoctorManagementController(doctorManagementView); //Khởi tạo lớp controller được gán đối tượng DoctorManagementView vừa tạo
    	  doctorManagementView.setVisible(true); //Hiển thị giao diện của phần DoctorManagement lên màn hình
      }
      
      private void openEmployeeManagementView() throws ClassNotFoundException, SQLException {
    	  MVC.View.QLPK.EmployeeManagementView  employeeManagementView = new EmployeeManagementView();
    	  new EmployeeManagementController(employeeManagementView);
    	  employeeManagementView.setVisible(true);
      }
    	  
      private void openPermissionView() throws ClassNotFoundException, SQLException {
          MVC.View.QLPK.PermissionView  permissionView = new PermissionView();
          new PermissionController (permissionView);
          permissionView.setVisible(true);
      }
      
      private void openReportView() throws ClassNotFoundException, SQLException {
          MVC.View.QLPK.ReportView  reportView = new ReportView();
          new ReportController(reportView);
          reportView.setVisible(true);
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

          loginView.setVisible(true); // Hiển thị LoginView
          mainView.dispose();  // Đóng cửa sổ DoctorMainView khi người dùng đăng xuất
      }
    	  
      public static void main(String[] args) {
          MainView mainView = new MainView();
          new MainController(mainView);
      }
}
