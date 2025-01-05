package MVC.Model.QLPK;

public class EquipmentManagementModel {
    private String maVatTu;
    private String tenVatTu;
    private double giaTien;
    private String tinhTrangThietBi;
    private String hanSuDung;
    private String ngayNhapKho;
    private String nhaCungCap;

    // Constructor
    public EquipmentManagementModel(String maVatTu, String tenVatTu, double giaTien, String tinhTrangThietBi, String hanSuDung, String ngayNhapKho, String nhaCungCap) {
        this.maVatTu = maVatTu;
        this.tenVatTu = tenVatTu;
        this.giaTien = giaTien;
        this.tinhTrangThietBi = tinhTrangThietBi;
        this.hanSuDung = hanSuDung;
        this.ngayNhapKho = ngayNhapKho;
        this.nhaCungCap = nhaCungCap;
    }

    // Getters and Setters
    public String getMaVatTu() {
        return maVatTu;
    }

    public void setMaVatTu(String maVatTu) {
        this.maVatTu = maVatTu;
    }

    public String getTenVatTu() {
        return tenVatTu;
    }

    public void setTenVatTu(String tenVatTu) {
        this.tenVatTu = tenVatTu;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getTinhTrangThietBi() {
        return tinhTrangThietBi;
    }

    public void setTinhTrangThietBi(String tinhTrangThietBi) {
        this.tinhTrangThietBi = tinhTrangThietBi;
    }

    public String getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(String hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public String getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(String ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
}