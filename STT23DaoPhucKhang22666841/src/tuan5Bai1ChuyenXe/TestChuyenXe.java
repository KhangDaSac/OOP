package tuan5Bai1ChuyenXe;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import tuan3Bai6HangThucPham.DanhSachHangThucPham;
import tuan3Bai6HangThucPham.HangThucPham;

public class TestChuyenXe {
	static DanhSachChuyenXe listChuyenXe;
	public static void main(String[] args) throws Exception {
		listChuyenXe = new DanhSachChuyenXe();
		int opt;
		try {
			do {
				opt = menu();
				switch (opt) {
				case 1: 
				{
					listChuyenXe.add(createChuyenXe());
					displayTitle();
					displayDanhSachChuyenXe(listChuyenXe);
					break;
				}
				case 2: 
				{
					deleteChuyenXe();
					displayTitle();
					displayDanhSachChuyenXe(listChuyenXe);
					break;
				}
				case 3: 
				{
					createDefaulChuyenXe();
					displayTitle();
					displayDanhSachChuyenXe(listChuyenXe);
					break;
				}
				case 4: 
				{
					displayTitle();
					displayDanhSachChuyenXe(listChuyenXe);
					break;
				}
				case 5: 
				{
					xuatBangTheoXe();
					break;
				}
				case 6:
				{
					xuatDoanhThuTheoXe();
					break;
				}
				case 7: 
				{
					listChuyenXe.sortListChuyenXeTheoMaXe();
					displayTitle();
					displayDanhSachChuyenXe(listChuyenXe);
					break;
				}
				case 8:
				{
					listChuyenXe.sortListChuyenXeTheoDoanhThu();
					displayTitle();
					displayDanhSachChuyenXe(listChuyenXe);
					break;
				}
				case 9:
				{
					System.out.println("Good bye");
					break;
				}
				}
			}while(opt != 9);

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

	private static ChuyenXe createChuyenXe() {
		ChuyenXe xe = new ChuyenXe();
		String opt = inputString("Chọn loại chuyến xe (noi/ngoai): ");
		while (!opt.equalsIgnoreCase("noi") && !opt.equalsIgnoreCase("ngoai")) {
			System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại");
			opt = inputString("Chọn loại chuyến xe (noi/ngoai): ");
		}

		String maChuyenXe = inputString("Nhập mã chuyến xe: ");
		while (listChuyenXe.findIndexOfChuyenXe(maChuyenXe) >= 0) {
			System.out.println("Mã chuyến xe đã tồn tại. Vui lòng nhập lại");
			maChuyenXe = inputString("Nhập mã chuyến xe: ");
		}

		String hoTenTaiXe = inputString("Nhập họ tên tài xế: ");
		int soXe = inputInt("Nhập số xe: ");
		double doanhThu = inputDouble("Nhập doanh thu: ");

		if (opt.equalsIgnoreCase("noi")) {
			int soTuyen = inputInt("Nhập số tuyến: ");
			double soKm = inputDouble("Nhập số km: ");
			xe = new ChuyenXeNoiThanh(maChuyenXe, hoTenTaiXe, soXe, doanhThu, soTuyen, soKm);
		}else if(opt.equalsIgnoreCase("ngoai")) {
			String noiDen = inputString("Nhập nơi đến: ");
			int soNgayDiDuoc = inputInt("Nhập số ngày đi được: ");
			xe = new ChuyenXeNgoaiThanh(maChuyenXe, hoTenTaiXe, soXe, doanhThu, noiDen, soNgayDiDuoc);	
		}
		return xe;
	}

	private static void deleteChuyenXe() throws Exception {
		String maCX = inputString("Nhập mã xe cần xóa: ");
		int index = listChuyenXe.findIndexOfChuyenXe(maCX);

		if (index >= 0) {
			ChuyenXe cx = listChuyenXe.getAll().get(index);
			displayTitle();
			System.out.printf("%10d", index + 1);
			System.out.println(cx);
			String confirm = inputString("Bạn có chắc muốn xóa chuyến xe này (y/n)?");
			if (confirm.equalsIgnoreCase("y")) {
				listChuyenXe.remove(cx);
				System.out.println("Đã xóa thành công");
			}else 
				System.out.println("Xóa thất bại");
		}else 
			System.out.println("Chuyến xe này không tồn tại");
	}

	private static void createDefaulChuyenXe() throws Exception {
		ChuyenXe cx1 = new ChuyenXeNoiThanh("123123", "Nguyễn Văn A", 321654, 1000000, 10, 20);
		ChuyenXe cx2 = new ChuyenXeNoiThanh("101010", "Trần Văn B", 696996, 5000000, 25, 80);
		ChuyenXe cx3 = new ChuyenXeNgoaiThanh("159123", "Nguyễn Văn C", 100200, 8500000, "Hà Nội", 4);
		ChuyenXe cx4 = new ChuyenXeNgoaiThanh("123321", "Lê Văn D", 405060, 4000000, "Đà Nẵng", 2);
		ChuyenXe cx5 = new ChuyenXeNoiThanh("101202", "Dỗ Văn E", 123000, 10000000, 5, 120);
		ChuyenXe cx6 = new ChuyenXeNgoaiThanh("555000", "Lương Văn F", 123789, 9500000, "Hải Phòng", 4);
		listChuyenXe.add(cx1);
		listChuyenXe.add(cx2);
		listChuyenXe.add(cx3);
		listChuyenXe.add(cx4);
		listChuyenXe.add(cx5);
		listChuyenXe.add(cx6);
	}

	private static void displayTitle() {
		String str = String.format("%5s %10s %20s %10s %25s %10s %20s %20s %20s", "STT", "MÃ XE", "TÊN TÀI XẾ", "SỐ XE", "DOANH THU", "SỐ TUYẾN", "SỐ KM", "NƠI ĐẾN", "SỐ NGÀY ĐI ĐƯỢC");
		System.out.println(str);
	}

	private static void displayDanhSachChuyenXe(DanhSachChuyenXe list) {
		ArrayList<ChuyenXe> listCX = list.getAll();
		displayArrayListChuyenXe(listCX);
	}
	
	private static void displayArrayListChuyenXe(ArrayList<ChuyenXe> listCX) {
		String STTTring = "";
		for (ChuyenXe xe : listCX) {
			STTTring = String.format("%5d", listCX.indexOf(xe) + 1);
			System.out.println(STTTring + " " + xe );
		}
	}

	private static void xuatBangTheoXe() {
		String opt = inputString("Chọn loại chuyến xe (noi/ngoai): ");
		while (!opt.equalsIgnoreCase("noi") && !opt.equalsIgnoreCase("ngoai")) {
			System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại");
			opt = inputString("Chọn loại chuyến xe (noi/ngoai): ");
		}
		displayTitle();
		if (opt.equalsIgnoreCase("noi")) displayArrayListChuyenXe(listChuyenXe.danhSachChuyenXeNoiThanh());
		else if (opt.equalsIgnoreCase("ngoai")) displayArrayListChuyenXe(listChuyenXe.danhSachChuyenXeNgoaiThanh());
	}

	private static void xuatDoanhThuTheoXe() {
		String opt = inputString("Chọn loại chuyến xe (noi/ngoai/tatca): ");
		while (!opt.equalsIgnoreCase("noi") && !opt.equalsIgnoreCase("ngoai") && !opt.equalsIgnoreCase("tatca")) {
			System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại");
			opt = inputString("Chọn loại chuyến xe (noi/ngoai/tatca): ");
		}

		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		String doanhThuString = "";
		if (opt.equalsIgnoreCase("noi")) {
			doanhThuString = df.format(listChuyenXe.tongDoanhThuXeNoiThanh());
			System.out.println("Doanh thu xe nội thành là: " + doanhThuString);
		}
		else if (opt.equalsIgnoreCase("ngoai")) {
			doanhThuString = df.format(listChuyenXe.tongDoanhThuXeNgoaiThanh());
			System.out.println("Doanh thu xe ngoại thành là: " + doanhThuString);
		}else if (opt.equalsIgnoreCase("tatca")) {
			doanhThuString = df.format(listChuyenXe.tongDoanhThu());
			System.out.println("Doanh thu tất cả chuyến xe là: " + doanhThuString);
		}
	}

	public static int menu() {
		int option;
		System.out.println("*****Menu*****\n"
				+ "1.Thêm chuyến xe mới\n"
				+ "2.Xóa chuyến xe\n"
				+ "3.Nhập cứng\n"
				+ "4.Xuất bảng tất cả chuyến xe\n"
				+ "5.Xuất bảng xe Nội thành, Ngoại thành\n"
				+ "6.Xuất tổng doanh thu, Doanh thu xe Nội thành, Doanh thu xe Ngoại thành\n"
				+ "7.Sắp xếp tăng dần theo mã xe\n"
				+ "8.Sắp xếp giảm dần theo doanh thu\n"
				+ "9.Thoát\n");
		option = inputInt("Mời bạn nhập: ");
		return option;
	}
}
