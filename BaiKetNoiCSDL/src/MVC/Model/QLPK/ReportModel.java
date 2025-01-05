package MVC.Model.QLPK;

public class ReportModel {
      private int luong;
      private int soTienThanhToan;
      private int giaTien;
      
      public ReportModel(int luong, int soTienThanhToan, int giaTien) {
    	  this.luong = luong;
    	  this.soTienThanhToan = soTienThanhToan;
    	  this.giaTien = giaTien;
      }
      //getter and setter
      public int getLuong() {
    	  return luong;
      }
      
      public void setLuong(int luong) {
    	  this.luong = luong;
      }
      
      public int getSoTienThanhToan() {
    	  return soTienThanhToan;
      }
      
      public void setSoTienThanhToan(int soTienThanhToan) {
    	  this.soTienThanhToan = soTienThanhToan;
      }
      
      public int getGiaTien() {
    	  return giaTien;
      }
      
      public void setGiaTien(int giaTien) {
    	  this.giaTien = giaTien;
      }
}

