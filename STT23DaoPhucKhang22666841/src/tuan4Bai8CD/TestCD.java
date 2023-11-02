package tuan4Bai8CD;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class TestCD {

	static CDList listCD;
	public static void main(String[] args) throws Exception {
		listCD = new CDList();
		int opt;
		try {
			do {
				opt = menu();
				switch (opt) {
				case 1: 
				{
					listCD.add(createCD());
					displayTitle();
					displayCDList(listCD);
					break;
				}
				case 2: 
				{
					deleteCD();
					displayTitle();
					displayCDList(listCD);
					break;
				}
				case 3: 
				{
					createDefaulCD();
					displayTitle();
					displayCDList(listCD);
					break;
				}
				case 4: 
				{
					System.out.println("Tổng số CD là: " + listCD.tongSoCD());
					break;
				}
				case 5: 
				{
					System.out.println("Tổng giá thành là: " + listCD.tongGiaThanh());
					break;
				}
				case 6: 
				{
					listCD.sortListCDGiaThanh();
					displayTitle();
					displayCDList(listCD);
					break;
				}
				case 7: 
				{
					listCD.sortListCDTua();
					displayTitle();
					displayCDList(listCD);
					break;
				}
				case 8: 
				{
					displayTitle();
					displayCDList(listCD);
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
		String s = "";
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

	private static CD createCD() {
		int maCD;
		String tuaCD;
		String caSi;
		int soBaiHat;
		double giaThanh;
		LocalDate ngayPhatHanh;
		maCD = inputInt("Nhập mã CD: ");
		while(listCD.isExistingCD(maCD)) {
			System.out.println("Mã CD đã tồn tại. Vui lòng nhập lại");
			maCD = inputInt("Nhập mã CD: ");
		}
		tuaCD = inputString("Nhập tựa CD: ");
		caSi = inputString("Nhập tên ca sĩ: ");
		soBaiHat = inputInt("Nhập số bài hát: ");
		giaThanh = inputDouble("Nhập giá: ");
		ngayPhatHanh = inputLocalDate("Nhập ngày phát hành: ");
		CD cd = new CD(maCD, tuaCD, caSi, soBaiHat, giaThanh, ngayPhatHanh);
		return cd;
	}

	private static void deleteCD() throws Exception {
		int maCD = inputInt("Nhập mã CD cần xóa: ");
		CD cd = listCD.searchCD(maCD);
		if (cd != null) {
			displayTitle();
			System.out.printf("%7d\t", listCD.indexOfList(maCD) + 1);
			System.out.println(cd);
			String confirm = inputString("Bạn có chắc muốn xóa CD này?");
			if (confirm.equalsIgnoreCase("y")) {
				listCD.delete(maCD);
				System.out.println("Đã xóa thành công");
			}else 
				System.out.println("Xóa thất bại");
		}else 
			System.out.println("CD này không tồn tại");
	}
	
	private static void createDefaulCD() throws Exception {
		CD cd1 = new CD(123, "Quê em mùa nước lũ", "Phương Mỹ Chi", 10, 200000, LocalDate.of(2020, 12, 2));
		CD cd2 = new CD(124, "Luyễn Tiếc", "Ngọc Lan", 10, 150000, LocalDate.of(1989, 1, 1));
		listCD.add(cd1);
		listCD.add(cd2);
	}

	private static void displayTitle() {
		String str = String.format("%7s %10s %30s %30s %15s %20s %20s", "STT", "Mã CD", "Tựa CD", "Ca sĩ", "Số bài hát", "Giá thành", "Ngày phát hành");
		System.out.println(str);
	}

	private static void displayCDList(CDList listCD) {
		CD[] allCD = listCD.getAll();
		displayCD(allCD, listCD.count);
	}

	private static void displayCD(CD[] list, int sptThuc) {
		for (int i = 0; i < sptThuc; i++) {
			System.out.printf("%7d\t", i + 1);
			System.out.println(list[i]);
		}
	}

	public static int menu() {
		int option;
		System.out.println("*****Menu*****\n"
				+ "1.Thêm CD mới\n"
				+ "2.Xóa CD\n"
				+ "3.Nhập cứng\n"
				+ "4.Tổng số CD\n"
				+ "5.Tổng giá\n"
				+ "6.Sắp xếp giảm dần theo giá CD\n"
				+ "7.Sắp xếp tăng dần theo tựa CD\n"
				+ "8.Xuất bảng\n"
				+ "9.Thoát\n");
		option = inputInt("Mời bạn nhập: ");
		return option;
	}
}
