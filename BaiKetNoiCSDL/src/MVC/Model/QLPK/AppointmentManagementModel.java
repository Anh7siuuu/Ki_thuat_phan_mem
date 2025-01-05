package MVC.Model.QLPK;

	public class AppointmentManagementModel {
	    private String maLichHen;
	    private String maBenhNhan;
	    private String maBacSi;
	    private String ngayKham;
	    private String buoiKham;
	    private String dichVu;

	    // Constructor
	    public AppointmentManagementModel(String maLichHen, String maBenhNhan, String maBacSi, String ngayKham, String buoiKham, String dichVu) {
	        this.maLichHen = maLichHen;
	        this.maBenhNhan = maBenhNhan;
	        this.maBacSi = maBacSi;
	        this.ngayKham = ngayKham;
	        this.buoiKham = buoiKham;
	        this.dichVu = dichVu;
	    }

	    // Getters and Setters
	    public String getMaLichHen() {
	        return maLichHen;
	    }

	    public void setMaLichHen(String maLichHen) {
	        this.maLichHen = maLichHen;
	    }

	    public String getMaBenhNhan() {
	        return maBenhNhan;
	    }

	    public void setMaBenhNhan(String maBenhNhan) {
	        this.maBenhNhan = maBenhNhan;
	    }

	    public String getMaBacSi() {
	        return maBacSi;
	    }

	    public void setMaBacSi(String maBacSi) {
	        this.maBacSi = maBacSi;
	    }

	    public String getNgayKham() {
	        return ngayKham;
	    }

	    public void setNgayKham(String ngayKham) {
	        this.ngayKham = ngayKham;
	    }

	    public String getBuoiKham() {
	        return buoiKham;
	    }

	    public void setBuoiKham(String buoiKham) {
	        this.buoiKham = buoiKham;
	    }

	    public String getDichVu() {
	        return dichVu;
	    }

	    public void setDichVu(String dichVu) {
	        this.dichVu = dichVu;
	    }
}
