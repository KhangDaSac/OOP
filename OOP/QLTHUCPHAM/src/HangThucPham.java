import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class HangThucPham {
    private String maHang;
    private String ten;

    private double price;
    private LocalDate ngaysx;
    private LocalDate ngayhh;

    public HangThucPham(String maHang) {
        setMaHang(maHang);
    }

    public HangThucPham(String maHang, String ten, double price, LocalDate ngaysx, LocalDate ngayhh) {
        setMaHang(maHang);
        setTen(ten);
        setPrice(price);
        setNgaysx(ngaysx);
        setNgayhh(ngayhh);
    }

    public String getMaHang() {
        return maHang;
    }

    private void setMaHang(String maHang) {
        if (maHang.equals("NULL"))
            throw new IllegalArgumentException("Ma hang khong duoc bo trong");
        this.maHang = maHang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        if (ten.equals("NULL"))
            throw new IllegalArgumentException("ten khong duoc bo trong");
        this.ten = ten;
    }

    public LocalDate getNgaysx() {
        return ngaysx;
    }

    public void setNgaysx(LocalDate ngaysx) {
        if (ngaysx == null)
            throw new IllegalArgumentException("Ngay san xuat nhap khong hop le");
        this.ngaysx = ngaysx;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Don gia phai lon hon 0");
        this.price = price;
    }

    public LocalDate getNgayhh() {
        return ngayhh;
    }

    public void setNgayhh(LocalDate ngayhh) {
        if (ngayhh == null || ngayhh.isBefore(ngaysx))
            throw new IllegalArgumentException("Ngay het han nhap khong hop le");
        this.ngayhh = ngayhh;
    }

    public boolean testConHan() {
        return LocalDate.now().isBefore(ngayhh);
    }


    public String toString() {
        String nsx = ngaysx.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nhh = ngayhh.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String gia = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(price);
        return String.format("%-10s %-20s %-10s %-15s %-15s %-10s", maHang, ten, gia, nsx, nhh, testConHan() ? "Con han" : "Het han");
    }
}
