public class SinhVien {
    private int maSv;
    private String hoTen;
    private double diemLT;
    private double diemTH;

    public SinhVien() {
        this(0, "NULL", 0.0, 0.0);
    }

    public SinhVien(int maSv, String hoTen, double diemLT, double diemTH) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }

    public int getMaSv() {
        return maSv;
    }

    public void setMaSv(int maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(double diemLT) {
        this.diemLT = diemLT;
    }

    public double getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(double diemTH) {
        this.diemTH = diemTH;
    }

    public double diemTB() {
        return (diemLT + diemTH) / 2;
    }

    @Override
    public String toString() {
        return String.format("%-9s %-30s %10.2f %10.2f %10.2f", maSv, hoTen,
                diemLT, diemTH, diemTB());
    }
}
