package tuan1Bai2SinhVien;

import java.util.Scanner;

public class TestBai2SinhVien {
	public static void main(String[] args) {
		SinhVien sv1 = nhapCungSinhVien();
		SinhVien sv2 = nhapMemSinhVien();
		SinhVien sv3 = nhapConstructorMacDinh();
		inTieuDe();
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
		
	}
	
	public static void inTieuDe() {
		String str = String.format("%10s %20s %10s %10s %10s", "MSSV", "Tên", "Lý Thuyết", "Thực hành", "Điểm TB" );
		System.out.println(str);
	}
	
	public static float nhapSoThuc(String str) {
		System.out.println(str);
		float so = 0;
		Scanner sc = new Scanner(System.in);
		so = sc.nextFloat();
		return so;
	}
	
	public static int nhapSoNguyen(String str) {
		System.out.println(str);
		int so = 0;
		Scanner sc = new Scanner(System.in);
		so = sc.nextInt();
		return so;
	}
	
	public static String nhapChuoi(String str) {
		System.out.println(str);
		String s;
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		return s;
	}
	
	public static SinhVien nhapCungSinhVien() {
		SinhVien sv = new SinhVien(22666841, "Đào Phúc Khang", 9, 9);
		return sv;
	}
	
	public static SinhVien nhapMemSinhVien() {
		int mssv = nhapSoNguyen("Nhập mã sinh viên: ");
		String hoTen = nhapChuoi("Nhập họ và tên: ");
		float LT = nhapSoThuc("Nhập điểm lý thuyết: ");
		float TH = nhapSoThuc("Nhập điểm thực hành: ");
		SinhVien sv = new SinhVien(mssv, hoTen, LT, TH);
		return sv;
	}
	
	public static SinhVien nhapConstructorMacDinh() {
		SinhVien sv = new SinhVien();
		int mssv = nhapSoNguyen("Nhập mã sinh viên: ");
		String hoTen = nhapChuoi("Nhập họ và tên: ");
		float LT = nhapSoThuc("Nhập điểm lý thuyết: ");
		float TH = nhapSoThuc("Nhập điểm thực hành: ");
		sv.setMaSoSinhVien(mssv);
		sv.setHoTen(hoTen);
		sv.setDiemLT(LT);
		sv.setDiemTH(TH);
		return sv;
	}
}
