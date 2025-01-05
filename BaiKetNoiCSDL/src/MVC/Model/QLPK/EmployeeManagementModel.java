package MVC.Model.QLPK;

public class EmployeeManagementModel {
    private String maNhanVien;
    private String matKhau;
    private String ngaySinh;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String viTri;
    private int luong;
    private String maQuyen;

    // Constructor
    public EmployeeManagementModel(String maNhanVien, String matKhau, String ngaySinh, String hoTen, String soDienThoai, String email, String viTri, int luong, String maQuyen) {
        this.maNhanVien = maNhanVien;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.viTri = viTri;
        this.luong = luong;
        this.maQuyen = maQuyen;
    }

    // Getters and Setters
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }
    
}