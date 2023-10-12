package tuan2Bai6HangThucPham;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import tuan2Bai4Account.Account;
import tuan2Bai4Account.AccountArray;

public class TestHangThucPham {
	static DanhSachHangThucPham hangThucPhamList;
	public static void main(String[] args) throws Exception {
		hangThucPhamList = new DanhSachHangThucPham();
			int opt;
			try {
				do {
					opt = menu();
					switch (opt) {
					case 1: 
					{
						hangThucPhamList.add(createThucPham());
						displayTitle();
						displayHangThucPhamList(hangThucPhamList);
						break;
					}
					case 2: 
					{
						deleteThucPham();
						displayTitle();
						displayHangThucPhamList(hangThucPhamList);
						break;
					}
					case 3: 
					{
						createDefaulHangThucPhamList();
						displayTitle();
						displayHangThucPhamList(hangThucPhamList);
						break;
					}
					case 4: 
					{
						displayTitle();
						displayHangThucPhamList(hangThucPhamList.danhSachThucPhamHetHan());
						break;
					}
					case 5: 
					{
						displayTitle();
						displayHangThucPhamList(hangThucPhamList);
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
		if (str != "") System.out.println(str);
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
	
	public static LocalDate inputLocalDate(String str) {
		System.out.println(str);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(sc.nextLine(), pattern);
		return date;
	}
	
	private static HangThucPham createThucPham() {
		HangThucPham thucPham;
		String maHang;
		String tenHang;
		double donGia;
		LocalDate ngaySX;
		LocalDate ngayHH;
		maHang = inputString("Nhập mã hàng: ");
		while(hangThucPhamList.isExistingHangThucPham(maHang)) {
			System.out.println("Mã hàng đã tồn tại. Vui lòng nhập lại");
			maHang = inputString("Nhập số tài khoản: ");
		}
		tenHang = inputString("Nhập tên hàng: ");
		donGia = inputDouble("Nhập số đơn giá: ");
		ngaySX = inputLocalDate("Nhập ngày sản xuất: ");
		ngayHH = inputLocalDate("Nhập ngày hết hạn: ");
		thucPham = new HangThucPham(maHang, tenHang, donGia, ngaySX, ngayHH);
		return thucPham;
	}
	
	private static void deleteThucPham() throws Exception {
		String maHang = inputString("Nhập mã hàng cần xóa: ");
		HangThucPham thuPham = hangThucPhamList.searchHangThucPham(maHang);
		if (thuPham != null) {
			displayTitle();
			System.out.printf("%7d\t", hangThucPhamList.indexOfList(maHang) + 1);
			System.out.println(thuPham);
			String confirm = inputString("Bạn có chắc muốn xóa thực phẩm này?");
			if (confirm.equalsIgnoreCase("y")) {
				hangThucPhamList.delete(maHang);
				System.out.println("Đã xóa thành công");
			}else 
				System.out.println("Xóa thất bại");
		}else 
			System.out.println("Thực phẩm này không tồn tại");
	}

	private static void createDefaulHangThucPhamList() throws Exception {
		HangThucPham tp1 = new HangThucPham("1002", "Mì", 3000, LocalDate.of(2023, 1, 10), LocalDate.of(2023, 10, 10));
		HangThucPham tp2 = new HangThucPham("1003", "Nước ngọt", 10000, LocalDate.of(2020, 12, 1), LocalDate.of(2022, 12, 1));
		HangThucPham tp3 = new HangThucPham("1004", "Bánh", 50000, LocalDate.of(2021, 5, 11), LocalDate.of(2022, 11, 11));
		HangThucPham tp4 = new HangThucPham("1007", "Kẹo", 1000, LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1));
		hangThucPhamList.add(tp1);
		hangThucPhamList.add(tp2);
		hangThucPhamList.add(tp3);
		hangThucPhamList.add(tp4);
	}
	
	private static void displayTitle() {
		String str = String.format("%7s\t%-10s\t%-15s\t%20s\t%-15s\t%-15s\t%-10s", "STT", "Mã hàng", "Tên hàng", "Đơn giá", "Ngày sản xuất", "Ngày hết hạn", "Trạng thái");
		System.out.println(str);
	}
	
	private static void displayHangThucPhamList(DanhSachHangThucPham hangThucPhamList) {
		HangThucPham[] allThucPham = hangThucPhamList.getAllThucPham();
		displayThucPham(allThucPham, hangThucPhamList.sptThuc);
	}
	
	private static void displayThucPham(HangThucPham[] list, int sptThuc) {
		for (int i = 0; i < sptThuc; i++) {
			System.out.printf("%7d\t", i + 1);
			System.out.println(list[i]);
		}
	}
	
	public static int menu() {
		int option;
		System.out.println("*****Menu*****\n"
				+ "1.Thêm thực phẩm mới\n"
				+ "2.Xóa thực phẩm\n"
				+ "3.Nhập cứng\n"
				+ "4.Xuất bảng thực phẩm hết hạn\n"
				+ "5.Xuất bảng tất cả thực phẩm\n"
				+ "6.Thoát\n");
		option = inputInt("Mời bạn nhập: ");
		return option;
	}
}
