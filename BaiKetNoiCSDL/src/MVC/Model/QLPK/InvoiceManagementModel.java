package MVC.Model.QLPK;

	public class InvoiceManagementModel {
	    private String maHoaDon;
	    private String maNhanVien;
	    private String maBenhNhan;
	    private String ngayLapHoaDon;
	    private double soTienThanhToan;
	    private String phuongThucThanhToan;
	    private String noiDungThanhToan;

	    // Constructor
	    public InvoiceManagementModel(String maHoaDon, String maNhanVien, String maBenhNhan, String ngayLapHoaDon, double soTienThanhToan, String phuongThucThanhToan, String noiDungThanhToan) {
	        this.maHoaDon = maHoaDon;
	        this.maNhanVien = maNhanVien;
	        this.maBenhNhan = maBenhNhan;
	        this.ngayLapHoaDon = ngayLapHoaDon;
	        this.soTienThanhToan = soTienThanhToan;
	        this.phuongThucThanhToan = phuongThucThanhToan;
	        this.noiDungThanhToan = noiDungThanhToan;
	    }

	    // Getters and Setters
	    public String getMaHoaDon() {
	        return maHoaDon;
	    }

	    public void setMaHoaDon(String maHoaDon) {
	        this.maHoaDon = maHoaDon;
	    }

	    public String getMaNhanVien() {
	        return maNhanVien;
	    }

	    public void setMaNhanVien(String maNhanVien) {
	        this.maNhanVien = maNhanVien;
	    }

	    public String getMaBenhNhan() {
	        return maBenhNhan;
	    }

	    public void setMaBenhNhan(String maBenhNhan) {
	        this.maBenhNhan = maBenhNhan;
	    }

	    public String getNgayLapHoaDon() {
	        return ngayLapHoaDon;
	    }

	    public void setNgayLapHoaDon(String ngayLapHoaDon) {
	        this.ngayLapHoaDon = ngayLapHoaDon;
	    }

	    public double getSoTienThanhToan() {
	        return soTienThanhToan;
	    }

	    public void setSoTienThanhToan(double soTienThanhToan) {
	        this.soTienThanhToan = soTienThanhToan;
	    }

	    public String getPhuongThucThanhToan() {
	        return phuongThucThanhToan;
	    }

	    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
	        this.phuongThucThanhToan = phuongThucThanhToan;
	    }

	    public String getNoiDungThanhToan() {
	        return noiDungThanhToan;
	    }

	    public void setNoiDungThanhToan(String noiDungThanhToan) {
	        this.noiDungThanhToan = noiDungThanhToan;
	    }
	}
