package tuan3Bai7SinhVien;

import java.util.Scanner;

public class TestSinhVien {
	static SinhVienList danhSanhSinhVien;
	public static void main(String[] args) throws Exception {
		danhSanhSinhVien = new SinhVienList();
			int opt;
			try {
				do {
					opt = menu();
					switch (opt) {
					case 1: 
					{
						danhSanhSinhVien.add(createSinhVien());
						displayTitle();
						displayDanhSachSinhVien();
						break;
					}
					case 2: 
					{
						deleteSinhVien();
						displayTitle();
						displayDanhSachSinhVien();
						break;
					}
					case 3: 
					{
						createDefaulSinhVien();
						displayTitle();
						displayDanhSachSinhVien();
						break;
					}
					case 4: 
					{
						danhSanhSinhVien.sortSinhVien();
						displayTitle();
						displayDanhSachSinhVien();
						break;
					}
					case 5: 
					{
						displayTitle();
						displayDanhSachSinhVien();
						break;
					}
					case 6:
					{
						System.out.println("Good bye");
						break;
					}
					}
				}while(opt != 6);
				
			} catch (Exception err) {
				System.err.println(err.getMessage());
			}
	}
	
	public static int inputInt(String str) {
		System.out.println(str);
		int num = 0;
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		return num;
	}
	
	public static String inputString(String str) {
		System.out.println(str);
		String s;
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		return s;
	}
	
	public static long inputLong(String str) {
		System.out.println(str);
		long num = 0;
		Scanner sc = new Scanner(System.in);
		num = sc.nextLong();
		return num;
	}
	
	public static double inputDouble(String str) {
		System.out.println(str);
		double num = 0;
		Scanner sc = new Scanner(System.in);
		num = sc.nextLong();
		return num;
	}
	
	private static SinhVien createSinhVien() throws Exception {
		SinhVien sv;
		long maSinhVien;
		String hoVaTen;
		String diaChi;
		String soDienThoai;
		maSinhVien = inputLong("Nhập mã sinh viên: ");
		while(danhSanhSinhVien.isExistingSinhVien(maSinhVien)) {
			System.out.println("Mã số sinh viên đã tồn tại. Vui lòng nhập lại");
			maSinhVien = inputLong("Nhập mã sinh viên: ");
		}
		hoVaTen = inputString("Nhập tên sinh viên: ");
		diaChi = inputString("Nhập địa chỉ: ");
		soDienThoai = inputString("Nhập số điện thoại ");
		sv = new SinhVien();
		sv.setMaSinhVien(maSinhVien);
		sv.setHoVaTen(hoVaTen);
		sv.setDiaChi(diaChi);
		sv.setSoDienThoai(soDienThoai);
		return sv;
	}
	
	private static void deleteSinhVien() throws Exception {
		long maSinhVien = inputLong("Nhập mã sinh viên cần xóa: ");
		SinhVien sv = danhSanhSinhVien.searchSinhVien(maSinhVien);
		if (sv != null) {
			displayTitle();
			System.out.printf("%7d ", danhSanhSinhVien.indexOfSinhVien(maSinhVien) + 1);
			System.out.println(sv);
			String confirm = inputString("Bạn có chắc muốn xóa sinh viên này?");
			if (confirm.equalsIgnoreCase("y")) {
				danhSanhSinhVien.delete(maSinhVien);
				System.out.println("Đã xóa thành công");
			}else 
				System.out.println("Xóa thất bại");
		}else 
			System.out.println("Sinh viên không tồn tại");
	}

	private static void displayDanhSachSinhVien() {
		SinhVien[] allSinhVien = danhSanhSinhVien.getAllSinhVien();
		displaySinhVien(allSinhVien);
	}

	private static void displayTitle() {
		String str = String.format("%7s %20s %20s %30s %20s","STT", "Mã sinh viên","Họ và tên", "Địa chỉ", "Số điện thoại");
		System.out.println(str);
	}
	
	private static void createDefaulSinhVien() throws Exception {
		SinhVien sv1 = new SinhVien(1235, "Đào Phúc Khang", "Đông Tháp", "0123456788");
		SinhVien sv2 = new SinhVien(1234, "Nguyễn Hoàng Khánh", "Kiêng Giang", "0123456789");
		SinhVien sv3 = new SinhVien(1100, "Nguyễn Văn A", "Hà Nội", "0123123123");
		danhSanhSinhVien.add(sv1);
		danhSanhSinhVien.add(sv2);
		danhSanhSinhVien.add(sv3);
	}
	
	private static void displaySinhVien(SinhVien[] list) {
		for (int i = 0; i < danhSanhSinhVien.count; i++) {
			System.out.printf("%7d ", i + 1);
			System.out.println(list[i]);
		}
	}
	
	public static int menu() {
		int option;
		System.out.println("*****Menu*****\n"
				+ "1.Thêm sinh viên\n"
				+ "2.Xóa sinh viên\n"
				+ "3.Nhập cứng\n"
				+ "4.Sắp xếp\n"
				+ "5.Xuất bảng\n"
				+ "6.Thoát\n");
		option = inputInt("Mời bạn nhập: ");
		return option;
	}
}
