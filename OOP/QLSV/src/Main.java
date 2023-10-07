import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien(22666811, "Nguyen Phi Hung", 10, 10);
        SinhVien sv2 = new SinhVien(22669691, "Bui Thien Hoang", 8.5, 8.5);

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap MSSV: ");
        int mssv = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap Ho va Ten: ");
        String hoten = sc.nextLine();
        System.out.println("Nhap Diem LT: ");
        double diemLT = sc.nextDouble();
        System.out.println("Nhap Diem TH: ");
        double diemTH = sc.nextDouble();

        SinhVien sv3 = new SinhVien(mssv, hoten, diemLT, diemTH);
        System.out.println(String.format("%-9s %-30s %10s %10s %10s", "masv",
                "hoten", "diemlt", "diemth", "diemtb"));
        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);
    }


}
