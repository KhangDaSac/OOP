import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        HangThucPham h1 = new HangThucPham("0001", "Nuoc hoa", 500000, LocalDate.of(2020, 10, 1), LocalDate.of(2023, 12, 2));
        HangThucPham h2 = new HangThucPham("0002", "Nuoc ngot", 10000, LocalDate.of(2020, 8, 12), LocalDate.of(2021, 8, 21));
        HangThucPham h3 = new HangThucPham("0003", "Sua chua", 15000, LocalDate.of(2020, 4, 19), LocalDate.of(2020, 7, 5));

        System.out.println(String.format("%-10s %-20s %-10s %-15s %-15s %-10s", "Ma Hang", "Ten", "Gia", "Ngay SX", "Ngay HH", "Con Han"));
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
    }
}
