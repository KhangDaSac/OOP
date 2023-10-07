package tuan1Bai1HinhChuNhat;

import java.util.Scanner;

public class TestBai1HinhChuNhat {
	public static void main(String[] args) {
		int opt;
		try {
			do {
				opt = menu();
				switch (opt) {
				case 1: 
				{
					xuatTieuDe();
					nhapCungHCN();
					break;
				}
				case 2: 
				{
					HinhChuNhat hcn = nhapMemHCN();
					xuatTieuDe();
					System.out.println(hcn);
					break;
				}
				case 3:
				{
					System.out.println("Good bye");
					break;
				}
				}
			}while(opt != 3);
		} catch (Exception err) {
			System.err.println(err.getMessage());
		}
	}

	public static void xuatTieuDe() {
		String str = String.format("%10s %10s %10s %10s", "Chiều dài", "Chiều rộng", "Chu vi", "Diện tích");
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

	public static HinhChuNhat nhapMemHCN() throws Exception {
		float dai, rong;
		dai = nhapSoThuc("Nhập chiều dài: ");
		rong = nhapSoThuc("Nhập chiều rộng: ");
		HinhChuNhat hcn = new HinhChuNhat(dai, rong);
		return hcn;
	}

	public static void nhapCungHCN() throws Exception {
		HinhChuNhat cn1 = new HinhChuNhat();
		cn1.setChieuDai(7);
		cn1.setChieuRong(5);
		HinhChuNhat cn2 = new HinhChuNhat(10, 3);
		System.out.println(cn1);
		System.out.println(cn2);

	}

	public static int menu() {
		int chon;
		System.out.println("*****Menu*****\n"
				+ "1.Nhập cứng\n"
				+ "2.Nhập mềm\n"
				+ "3.Thoát\n");
		chon = nhapSoNguyen("Mời bạn nhập");
		return chon;
	}
}
