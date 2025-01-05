package MVC.Model.QLPK;

public class PermissionModel {
    private String maQuyen;
    private String tenQuyen;
    private String cacQuyenSuDung;

    public PermissionModel(String maQuyen, String tenQuyen, String cacQuyenSuDung) {
        this.maQuyen = maQuyen;
        this.tenQuyen = tenQuyen;
        this.cacQuyenSuDung = cacQuyenSuDung;
    }

    // Getters and setters
    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    public String getCacQuyenSuDung() {
        return cacQuyenSuDung;
    }

    public void setCacQuyenSuDung(String cacQuyenSuDung) {
        this.cacQuyenSuDung = cacQuyenSuDung;
    }
}

