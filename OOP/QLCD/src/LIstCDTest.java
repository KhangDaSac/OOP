import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LIstCDTest {
    public static void main(String[] args) {
       ListCD listCD = new ListCD(10);
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Them CD");
            System.out.println("2. Hien thi danh sach CD");
            System.out.println("3. Tinh tong gia thanh");
            System.out.println("4. Sap xep theo tua CD");
            System.out.println("5. Sap xep theo gia thanh");
            System.out.println("6. Tim kiem theo ma CD");
            System.out.println("7. Thoat");
            System.out.println("Chon chuc nang: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhap ma CD: ");
                    int maCD = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhap tua CD: ");
                    String tuaCD = sc.nextLine();
                    System.out.println("Nhap so bai hat: ");
                    int soBaiHat = sc.nextInt();
                    System.out.println("Nhap gia thanh: ");
                    double giaThanh = sc.nextDouble();
                    CD cd = new CD(maCD, tuaCD, soBaiHat, giaThanh);
                    listCD.add(cd);
                    break;
                case 2:
                    listCD.display();
                    break;
                case 3:
                    System.out.println("Tong gia thanh: " + listCD.gia());
                    break;
                case 4:
                    listCD.sortTuaCD();
                    listCD.display();
                    break;
                case 5:
                    listCD.sortGTCD();
                    listCD.display();
                    break;
                case 6:
                    System.out.println("Nhap ma CD can tim: ");
                    int maCDTim = sc.nextInt();
                    CD cdTim = listCD.find(maCDTim);
                    if (cdTim == null)
                        System.out.println("Khong tim thay CD co ma " + maCDTim);
                    else
                        System.out.println(cdTim);
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }   while (true);
    }
}
