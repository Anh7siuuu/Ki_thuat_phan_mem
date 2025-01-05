package MVC.Controller.QLPK;

import java.sql.SQLException;
import MVC.View.QLPK.EmployeeMainView;
import MVC.View.QLPK.PatientManagementView;
import MVC.View.QLPK.InvoiceManagementView;
import MVC.View.QLPK.EquipmentManagementView;
import MVC.View.QLPK.AppointmentManagementView;


public class EmployeeMainController {
      private EmployeeMainView employeeMainView;
      public EmployeeMainController(EmployeeMainView employeeMainView) {
          this.employeeMainView = employeeMainView;
          initController();
      }
      
      //Hàm này để thiết lập các sự kiện lắng nghe
      private void initController() {
    	  // Thiết lập sự kiện lắng nghe khi người dùng ấn vào nút DoctorManagement trên giao diện Main
          employeeMainView.addAppointmentManagementListener(e -> {
  			try {
  				openAppointmentManagementView();
  			} catch (ClassNotFoundException e1) {
  				e1.printStackTrace();
  			} catch (SQLException e1) {
  				e1.printStackTrace();
  			}
  		});
           
          // Tương tự với các nút cho các chức năng còn lại
          employeeMainView.addEquipmentManagementListener(e -> {
        	  try {
    				openEquipmentManagementView();
    			} catch (ClassNotFoundException e1) {
    				e1.printStackTrace();
    			} catch (SQLException e1) {
    				e1.printStackTrace();
    			} 
        });
          
          employeeMainView.addInvoiceManagementListener(e -> {
        	  try {
    				openInvoiceManagementView();
    			} catch (ClassNotFoundException e1) {
    				e1.printStackTrace();
    			} catch (SQLException e1) {
    				e1.printStackTrace();
    			} 
        });
          
          employeeMainView.addPatientManagementListener(e -> {
        	  try {
    				openPatientManagementView();
    			} catch (ClassNotFoundException e1) {
    				e1.printStackTrace();
    			} catch (SQLException e1) {
    				e1.printStackTrace();
    			} 
        });
      }
      
      // Đây là phương thức để mở giao diện con
      private void openAppointmentManagementView() throws ClassNotFoundException, SQLException {
    	  MVC.View.QLPK.AppointmentManagementView  appointmentManagementView = new AppointmentManagementView(); // Tạo một đối tượng DoctorManagementView
    	  new AppointmentManagementController(appointmentManagementView); //Khởi tạo lớp controller được gán đối tượng DoctorManagementView vừa tạo
    	  appointmentManagementView.setVisible(true); //Hiển thị giao diện của phần DoctorManagement lên màn hình
      }
      
      private void openEquipmentManagementView() throws ClassNotFoundException, SQLException {
    	  MVC.View.QLPK.EquipmentManagementView  employeeManagementView = new EquipmentManagementView();
    	  new EquipmentManagementController(employeeManagementView);
    	  employeeManagementView.setVisible(true);
      }
    	  
      private void openInvoiceManagementView() throws ClassNotFoundException, SQLException {
          MVC.View.QLPK.InvoiceManagementView  permissionView = new InvoiceManagementView();
          new InvoiceManagementController (permissionView);
          permissionView.setVisible(true);
      }
      
      private void openPatientManagementView() throws ClassNotFoundException, SQLException {
          MVC.View.QLPK.PatientManagementView  patientManagementView = new PatientManagementView();
          new PatientManagementController(patientManagementView);
          patientManagementView.setVisible(true);
      }
    	  
      public static void main(String[] args) {
          EmployeeMainView employeeMainView = new EmployeeMainView();
          new EmployeeMainController(employeeMainView);
      }
}
