package MVC.Controller.QLPK;

import java.sql.SQLException;
import MVC.View.QLPK.DoctorMainView;
import MVC.View.QLPK.MedicalRecordManagementView;

public class DoctorMainController {
      private DoctorMainView doctorMainView;
      public DoctorMainController(DoctorMainView doctorMainView) {
          this.doctorMainView = doctorMainView;
          initController();
      }
      
      //Hàm này để thiết lập các sự kiện lắng nghe
      private void initController() {
    	  // Thiết lập sự kiện lắng nghe khi người dùng ấn vào nút DoctorManagement trên giao diện Main
          doctorMainView.addMedicalRecordManagemenListener(e -> {
  			try {
  				openMedicalRecordManagementView();
  			} catch (ClassNotFoundException e1) {
  				e1.printStackTrace();
  			} catch (SQLException e1) {
  				e1.printStackTrace();
  			}
  		});
      }
           
      
      // Đây là phương thức để mở giao diện con
      private void openMedicalRecordManagementView() throws ClassNotFoundException, SQLException {
    	  MVC.View.QLPK.MedicalRecordManagementView  medicalRecordManagementView = new MedicalRecordManagementView(); // Tạo một đối tượng DoctorManagementView
    	  new MedicalRecordManagementController(medicalRecordManagementView); //Khởi tạo lớp controller được gán đối tượng DoctorManagementView vừa tạo
    	  medicalRecordManagementView.setVisible(true); //Hiển thị giao diện của phần DoctorManagement lên màn hình
      }
    	  
      public static void main(String[] args) {
          DoctorMainView doctorMainView = new DoctorMainView();
          new DoctorMainController(doctorMainView);
      }
}