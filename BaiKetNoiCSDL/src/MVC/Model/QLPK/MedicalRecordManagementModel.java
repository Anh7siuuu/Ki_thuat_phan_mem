package MVC.Model.QLPK;

public class MedicalRecordManagementModel {
    private String maBenhAn;
    private String maLichHen;
    private String tenBenh;
    private String donThuoc;

    // Constructor
    public MedicalRecordManagementModel(String maBenhAn, String maLichHen, String tenBenh, String donThuoc) {
        this.maBenhAn = maBenhAn;
        this.maLichHen = maLichHen;
        this.tenBenh = tenBenh;
        this.donThuoc = donThuoc;
    }

    // Getters and Setters
    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getMaLichHen() {
        return maLichHen;
    }

    public void setMaLichHen(String maLichHen) {
        this.maLichHen = maLichHen;
    }

    public String getTenBenh() {
        return tenBenh;
    }

    public void setTenBenh(String tenBenh) {
        this.tenBenh = tenBenh;
    }

    public String getDonThuoc() {
        return donThuoc;
    }

    public void setDonThuoc(String donThuoc) {
        this.donThuoc = donThuoc;
    }
}

