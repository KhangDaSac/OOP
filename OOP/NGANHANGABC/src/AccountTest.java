import java.util.Scanner;

import static java.lang.System.exit;

public class AccountTest {
    public static void main(String[] args) {
        AccountList list = new AccountList();
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Thêm tài khoản\n" +
                    "2. Số TK hiện có\n" +
                    "3. In thông tin tất cả TK\n" +
                    "4. Nạp tiền vào TK\n" +
                    "5. Rút tiền\n" +
                    "6. Chuyển tiền\n" +
                    "7. Kết thúc");
            System.out.println("Chon chuc nang: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Nhap stk: ");
                    long stk = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Nhap ten: ");
                    String name = sc.nextLine();
                    System.out.println("Nhap so tien: ");
                    double balance = sc.nextDouble();
                    Account acc = new Account(stk, name, balance);
                    list.addAccount(acc);
                    break;
                }
                case 2: {
                    System.out.println("So TK hien co: " + list.getCount());
                    break;
                }
                case 3: {
                    System.out.println("Danh sach TK: ");
                    System.out.println(String.format("%-10s %-20s %-20s %-20s", "STK", "Ten", "So du", "Trang thai"));
                    list.display();
                    break;
                }
                case 4: {
                    System.out.println("Nhap stk: ");
                    long stk = sc.nextLong();
                    System.out.println("Nhap so tien: ");
                    double amount = sc.nextDouble();
                    list.find(stk).napTien(amount);
                    break;
                }
                case 5: {
                    System.out.println("Nhap stk: ");
                    long stk = sc.nextLong();
                    System.out.println("Nhap so tien: ");
                    double amount = sc.nextDouble();
                    list.find(stk).rutTien(amount);
                    break;
                }
                case 6: {
                    System.out.println("Nhap stk nguoi gui: ");
                    long stk1 = sc.nextLong();
                    System.out.println("Nhap stk nguoi nhan: ");
                    long stk2 = sc.nextLong();
                    System.out.println("Nhap so tien: ");
                    double amount = sc.nextDouble();
                    list.find(stk1).chuyenKhoan(list.find(stk2), amount);
                    break;
                }
                case 7: {
                    System.out.println("Ket thuc!");
                    exit(0);
                }
            }

        } while(true);
    }
}