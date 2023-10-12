package tuan5Bai2Sach;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import tuan5Bai1ChuyenXe.ChuyenXe;
import tuan5Bai1ChuyenXe.ChuyenXeNgoaiThanh;
import tuan5Bai1ChuyenXe.ChuyenXeNoiThanh;
import tuan5Bai1ChuyenXe.DanhSachChuyenXe;

public class TestSach {
	static DanhSachSach listSach;
	public static void main(String[] args) throws Exception {
		listSach = new DanhSachSach();
		DecimalFormat moneyFormat = new DecimalFormat("###,###,###.00 VND");
		int opt;
		try {
			do {
				opt = menu();
				switch (opt) {
				case 1: 
				{
					listSach.add(createSach());
					displayTitle();
					displayDanhSachSach(listSach);
					break;
				}
				case 2: 
				{
					deleteSach();
					displayTitle();
					displayDanhSachSach(listSach);
					break;
				}
				case 3: 
				{
					createDefaulSach();
					displayTitle();
					displayDanhSachSach(listSach);
					break;
				}
				case 4: 
				{
					displayTitle();
					displayDanhSachSach(listSach);
					break;
				}
				case 5: 
				{
					System.out.println("Tổng thành tiền sách giáo khoa là: " + moneyFormat.format(listSach.sumThanhTienSachGiaoKhoa()));
					break;
				}
				case 6:
				{
					System.out.println("Tổng thành tiền sách tham khảo là: " + moneyFormat.format(listSach.sumThanhTienSachThamKhao()));
					break;
				}
				case 7: 
				{
					System.out.println("Trung bình đơn giá sách giáo khoa là: " + moneyFormat.format(listSach.averageDonGiaSachGiaoKhoa()));
					break;
				}
				case 8:
				{
					System.out.println("Trung bình đơn giá sách tham khảo là: " + moneyFormat.format(listSach.averageDonGiaSachThamKhao()));
					break;
				}
				case 9:
				{
					xuatSachTheoNXB();
					break;
				}
				case 10:
				{
					System.out.println("Good bye");
					break;
				}
				}
			}while(opt != 10);

		} catch (Exception err) {
			System.err.println(err.getMessage());
		}
	}

	public static int inputInt(String str) {
		if (str != "") System.out.println(str);
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
	
	public static boolean inputBoolean(String str) {
		System.out.println(str);
		int num = inputInt("");
		while (num != 0 && num != 1) {
			System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại");
			num = inputInt("");
		}
		return num == 0 ? false : true;
	}
	
	public static LocalDate inputLocalDate(String str) {
		System.out.println(str);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(sc.nextLine(), pattern);
		return date;
	}

	private static Sach createSach() {
		Sach sach = null;
		String opt = inputString("Chọn loại sách giáo khoa hoặc tham khảo (gk/tk): ");
		while (!opt.equalsIgnoreCase("gk") && !opt.equalsIgnoreCase("tk")) {
			System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại");
			opt = inputString("Chọn loại sách giáo khoa hoặc tham khảo (gk/tk): ");
		}

		String maSach = inputString("Nhập mã sách: ");
		while (listSach.findIndexOfChuyenXe(maSach) >= 0) {
			System.out.println("Mã sách đã tồn tại. Vui lòng nhập lại");
			maSach = inputString("Nhập mã sách: ");
		}

		LocalDate ngayNhap = inputLocalDate("Nhập ngày nhập: ");
		double donGia = inputDouble("Nhập đơn giá");
		int soLuong = inputInt("Nhập số lượng: ");
		String nhaXuatBan = inputString("Nhập nhà xuất bản: ");

		if (opt.equalsIgnoreCase("gk")) {
			boolean tinhTrang = inputBoolean("Nhập tình trạng sách (Mới - 1/ Cũ - 0): ");
			sach = new SachGiaoKhoa(maSach,ngayNhap, donGia, soLuong, nhaXuatBan, tinhTrang);
		}else if(opt.equalsIgnoreCase("tk")) {
			double thue = inputDouble("Nhập thuế: ");
			sach = new SachThamKhao(maSach,ngayNhap, donGia, soLuong, nhaXuatBan, thue);
		}
		return sach;
	}

	private static void deleteSach() throws Exception {
		String maSach = inputString("Nhập mã sách cần xóa: ");
		int index = listSach.findIndexOfChuyenXe(maSach);

		if (index >= 0) {
			Sach sach = listSach.getAll().get(index);
			displayTitle();
			System.out.printf("%5d", index + 1);
			System.out.println(sach);
			String confirm = inputString("Bạn có chắc muốn xóa sách này (y/n)?");
			if (confirm.equalsIgnoreCase("y")) {
				listSach.remove(sach);
				System.out.println("Đã xóa thành công");
			}else 
				System.out.println("Xóa thất bại");
		}else 
			System.out.println("Sách này không tồn tại");
	}
	
	private static void xuatSachTheoNXB() {
		String maNXB = inputString("Nhập tên NXB: ");
		ArrayList<Sach> listSachNXB = listSach.danhSachSachNXB(maNXB);
		displayArrayListSach(listSachNXB);
	}

	private static void createDefaulSach() throws Exception {
		Sach s1 = new SachGiaoKhoa("1234", LocalDate.of(2020, 10, 21), 200000, 10, "NXB Giáo dục", true);
		Sach s2 = new SachGiaoKhoa("1010", LocalDate.of(2021, 2, 3), 70000, 50, "NXB Giáo dục", false);
		Sach s3 = new SachGiaoKhoa("1013", LocalDate.of(2019, 12, 1), 50000, 70, "NXB Đại học Huế", false);
		Sach s4 = new SachThamKhao("1122", LocalDate.of(2018, 10, 11), 40000, 80, "NXB Đại học Huế", 5000);
		Sach s5 = new SachThamKhao("1007", LocalDate.of(2021, 1, 17), 30000, 60, "NXB Đại học Sư phạm TPHCM", 10000);
		Sach s6 = new SachThamKhao("1088", LocalDate.of(2020, 8, 12), 40000, 50, "NXB Đại học Sư phạm TPHCM", 15000);
		listSach.add(s1);
		listSach.add(s2);
		listSach.add(s3);
		listSach.add(s4);
		listSach.add(s5);
		listSach.add(s6);
	}

	private static void displayTitle() {
		String str = String.format("%5s %10s %15s %20s %10s %30s %15s %20s %20s", "STT", "MÃ SÁCH", "NGÀY NHẬP", "ĐƠN GIÁ", "SỐ LƯỢNG", "NHÀ XUẤT BẢN", "TÌNH TRẠNG", "THUẾ", "THÀNH TIỀN");
		System.out.println(str);
	}

	private static void displayDanhSachSach(DanhSachSach list) {
		ArrayList<Sach> listS = list.getAll();
		displayArrayListSach(listS);
	}
	
	private static void displayArrayListSach(ArrayList<Sach> listS) {
		String STTTring = "";
		for (Sach sach : listS) {
			STTTring = String.format("%5d", listS.indexOf(sach) + 1);
			System.out.println(STTTring + " " + sach );
		}
	}

	public static int menu() {
		int option;
		System.out.println("*****Menu*****\n"
				+ "1.Thêm sách mới\n"
				+ "2.Xóa sách\n"
				+ "3.Nhập cứng\n"
				+ "4.Xuất bảng tất cả sách\n"
				+ "5.Xuất tổng thành tiền Sách giáo khoa\n"
				+ "6.Xuất tổng thành tiền Sách tham khảo\n"
				+ "7.Xuất trung bình đơn giá của Sách giáo khoa\n"
				+ "8.Xuất trung bình đơn giá của Sách tham khảo\n"
				+ "9.Xuất danh sách theo nhà xuất bản\n"
				+ "10.Thoát\n");
		option = inputInt("Mời bạn nhập: ");
		return option;
	}
}
