package tuan1Bai3Vehicle;

import java.util.Scanner;

import tuan1Bai1HinhChuNhat.HinhChuNhat;

public class TestBai3Vehicle {
	public static void main(String[] args) {
		VehicleArray vehicleList = new VehicleArray();
		int opt;
		try {
			do {
				opt = menu();
				switch (opt) {
				case 1: 
				{
					vehicleList.add(nhapMem());
					
					break;
				}
				case 2: 
				{
					xuatTieuDe();
					for (int i = 0; i < vehicleList.sptThuc; i++) {
						System.out.println(vehicleList.getVehicleArray()[i]);
					}
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
	
	public static Vehicle nhapMem() throws Exception{
		Vehicle veh = new Vehicle();
		veh.setTenChuXe(nhapChuoi("Nhập tên chủ xe: "));
		veh.setLoaiXe(nhapChuoi("Nhập loại xe: "));
		veh.setDungTich(nhapSoNguyen("Nhập dung tích"));
		veh.setGiaTri(nhapSoThuc("Nhập giá trị: "));
		return veh;
	}
	
	public static void xuatTieuDe() {
		String str = String.format("%-20s %-20s %10s %20s %20s", "Tên", "Loại xe", "Dung tích", "Trị giá", "Thuế phải nộp");
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
	
	public static int menu() {
		int chon;
		System.out.println("*****Menu*****\n"
				+ "1.Thêm xe mới\n"
				+ "2.Xuất bảng kê khai tiền thuế trước bạ\n"
				+ "3.Thoát\n");
		chon = nhapSoNguyen("Mời bạn nhập: ");
		return chon;
	}
}

