package tuan2Bai5Rational;

import java.util.Scanner;


public class TestRational {
	public static void main(String[] args) {
		int opt;
		Rational ra1, ra2;
		try {
			do {
				opt = menu();
				switch (opt) {
				case 1: 
				{
					ra1 = inputRational("Nhập phân số thứ nhất: ");
					ra2 = inputRational("Nhập phân số thứ hai: ");
					System.out.println("Tổng của " + ra1 + " và " + ra2 + " bằng " + Rational.add(ra1, ra2));
					break;
				}
				case 2: 
				{
					ra1 = inputRational("Nhập phân số thứ nhất: ");
					ra2 = inputRational("Nhập phân số thứ hai: ");
					System.out.println("Hiệu của " + ra1 + " và " + ra2 + " bằng " + Rational.subtract(ra1, ra2));
					break;
				}
				case 3: 
				{
					ra1 = inputRational("Nhập phân số thứ nhất: ");
					ra2 = inputRational("Nhập phân số thứ hai: ");
					System.out.println("Tích của " + ra1 + " và " + ra2 + " bằng " + Rational.multiply(ra1, ra2));
					break;
				}
				case 4: 
				{
					ra1 = inputRational("Nhập phân số thứ nhất: ");
					ra2 = inputRational("Nhập phân số thứ hai: ");
					System.out.println("Thương của " + ra1 + " và " + ra2 + " bằng " + Rational.divide(ra1, ra2));
					break;
				}
				case 5: 
				{
					ra1 = inputRational("Nhập phân số: ");
					System.out.println("Phân số nghịch đảo của " + ra1 + " là: " + ra1.reciprocal());
					break;
				}
				case 6:
				{
					ra1 = inputRational("Nhập phân số thứ nhất: ");
					ra2 = inputRational("Nhập phân số thứ hai: ");
					int compare = Rational.tolerance(ra1, ra2);
					if (compare == 0) System.out.println(ra1 + " = " + ra2);
					else if (compare > 0) System.out.println(ra1 + " > " + ra2);
					else System.out.println(ra1 + " < " + ra2);
					break;
				}
				case 7: {
					System.out.println("Good bye");
					break;
				}
				default:
				{
					System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
					break;
				}
				}
			}while(opt != 7);
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	
	public static Rational inputRational(String str) {
		System.out.println(str);
		String s = inputString("");
		String[] rational = s.split("/");

		while (rational.length > 2 || s == null) {
			System.out.println("Phân số không hợp lệ. Vui lòng nhập lại");
			s = inputString("");
			rational = s.split("/");
		}
		if (rational.length == 1) {
			double numerator = Double.parseDouble(rational[0]);
			return new Rational(numerator, 1);
		}else {
			double numerator = Double.parseDouble(rational[0]);
			double denominator = Double.parseDouble(rational[1]);
			return new Rational(numerator, denominator);
		}
	}
	
	public static int menu() {
		int option;
		System.out.println("*****Menu*****\n"
				+ "1.Cộng 2 phân số\n"
				+ "2.Trừ 2 phân số\n"
				+ "3.Nhân 2 phân số\n"
				+ "4.Chia 2 phân số\n"
				+ "5.Phân số nghịch đảo\n"
				+ "6.So sánh 2 phân số\n"
				+ "7.Thoát");
		option = inputInt("Mời bạn nhập: ");
		return option;
	}
}
