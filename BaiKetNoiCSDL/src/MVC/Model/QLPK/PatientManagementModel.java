package MVC.Model.QLPK;
//Tính năng này dành cho Nhân Viên 
public class PatientManagementModel {
    private String maBenhNhan;
    private String matKhau;
    private String ngaySinh;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String ngheNghiep;
    private String maQuyen; // Foreign key to Permission

    public PatientManagementModel(String maBenhNhan, String matKhau, String ngaySinh, String hoTen,
                        String soDienThoai, String email, String ngheNghiep, String maQuyen) {
        this.maBenhNhan = maBenhNhan;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.ngheNghiep = ngheNghiep;
        this.maQuyen = maQuyen;
    }

    // Getters and Setters
    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
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

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }
}

