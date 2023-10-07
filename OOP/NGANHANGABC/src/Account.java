import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private Long stk;
    private String name;
    private Double balance;

    private String trangThai;

    private static final double lai = 0.035;

    public Account() {
        this(999999L, "chua xac dinh", 50d);
    }

    public Account(Long stk, String name, Double balance) {
        setStk(stk);
        setName(name);
        setBalance(balance);
    }

    public Account(Long stk, String name) {
        setStk(stk);
        setName(name);
        this.balance = 50d;
    }

    public Long getStk() {
        return stk;
    }

    public void setStk(Long stk) {
        if (stk <= 0 || stk == 999999L) {
            this.stk = 999999L;
            setTrangThai("So tai khoan khong hop le");
        }
        else this.stk = stk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            this.name = "chua xac dinh";
            setTrangThai("Ten khong hop le");
        }
        else this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        if (balance < 50) {
            this.balance = 50d;
            setTrangThai("So du khong hop le");
        }
        else this.balance = balance;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void napTien(Double amount) {
        if (amount <= 0) {
            System.out.println("Nap tien khong thanh cong do so tien khong hop le");
            return;
        }
        this.balance += amount;
        System.out.println("Nap tien thanh cong");
    }

    public void rutTien(Double amount) {
        if (amount <= 0 || amount > this.balance) {
            System.out.println("Rut tien khong thanh cong do so tien khong hop le");
            return;
        }
        this.balance -= amount;
        System.out.println("Rut tien thanh cong");
    }

    public void chuyenKhoan(Account other, Double amount) {
        if (amount <= 0) {
            System.out.println("Chuyen tien khong thanh cong do so tien khong hop le");
            return;
        }
        this.balance -= amount;
        other.balance += amount;
        System.out.println("Chuyen tien thanh cong");
    }

    public void daoHan() {
        this.balance *= 1.1d;
    }

    public String toString() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(localeVN);
        return String.format("%-10d %-20s %-20s %-20s", stk, name, format.format(balance), trangThai);
    }


}
