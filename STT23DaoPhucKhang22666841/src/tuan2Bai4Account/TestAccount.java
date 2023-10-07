package tuan2Bai4Account;

import java.util.Scanner;

public class TestAccount {
	static AccountArray accountList;
	public static void main(String[] args) throws Exception {
		accountList = new AccountArray();
			int opt;
			try {
				do {
					opt = menu();
					switch (opt) {
					case 1: 
					{
						accountList.add(createAccount());
						displayTitle();
						displayAccountList();
						break;
					}
					case 2: 
					{
						deleteAccount();
						displayTitle();
						displayAccountList();
						break;
					}
					case 3: 
					{
						createDefaulAccountList();
						displayTitle();
						displayAccountList();
						break;
					}
					case 4: 
					{
						displayTitle();
						displayAccountList();
						break;
					}
					case 5:
					{
						System.out.println("Good bye");
						break;
					}
					}
				}while(opt != 5);
				
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
	
	private static Account createAccount() {
		Account acc;
		long accountNumber;
		String name;
		double balance;
		accountNumber = inputLong("Nhập số tài khoản: ");
		while(accountList.isExistingAccNumber(accountNumber)) {
			System.out.println("Số tài khoản đã tồn tại. Vui lòng nhập lại");
			accountNumber = inputLong("Nhập số tài khoản: ");
		}
		name = inputString("Nhập tên tài khoản: ");
		balance = inputDouble("Nhập số tiền khởi tạo: ");
		acc = new Account(accountNumber, name, balance);
		return acc;
	}
	
	private static void deleteAccount() throws Exception {
		long accountNumber = inputLong("Nhập số tài khoản cần xóa: ");
		Account acc = accountList.searchAccount(accountNumber);
		if (acc != null) {
			displayTitle();
			System.out.printf("%7d ", accountList.indexOfAccount(accountNumber) + 1);
			System.out.println(acc);
			String confirm = inputString("Bạn có chắc muốn xóa tài khoản này?");
			if (confirm.equalsIgnoreCase("y")) {
				accountList.delete(accountNumber);
				System.out.println("Đã xóa thành công");
			}else 
				System.out.println("Xóa thất bại");
		}else 
			System.out.println("Tài khoản không tồn tại");
	}

	private static void displayAccountList() {
		Account[] allAccount = accountList.getAllAccount();
		displayAccount(allAccount);
		
	}

	private static void displayTitle() {
		String str = String.format("%7s %20s %-20s %20s","STT", "Số tài khoản", "Họ và tên", "Số dư");
		System.out.println(str);
	}
	
	private static void createDefaulAccountList() throws Exception {
		Account acc1 = new Account(1017020607, "Lê Hoàng Bảo");
		Account acc2 = new Account(1017046087, "Tạ Văn Ơn", 50000000);
		Account acc3 = new Account(1017061096, "Cù Văn Cần", 10000000);
		Account acc4 = new Account(1017030708, "Bao Bao", 30000000);
		accountList.add(acc1);
		accountList.add(acc2);
		accountList.add(acc3);
		accountList.add(acc4);
	}
	
	private static void displayAccount(Account[] list) {
		for (int i = 0; i < accountList.sptThuc; i++) {
			System.out.printf("%7d ", i + 1);
			System.out.println(list[i]);
		}
	}
	
	public static int menu() {
		int option;
		System.out.println("*****Menu*****\n"
				+ "1.Thêm tài khoản\n"
				+ "2.Xóa tài khoản\n"
				+ "3.Nhập cứng\n"
				+ "4.Xuất bảng\n"
				+ "5.Thoát\n");
		option = inputInt("Mời bạn nhập: ");
		return option;
	}
}
