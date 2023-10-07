import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Vehicle xe1 = new Vehicle("Nguyen Van A", "Honda", 100, 35000000);
        Vehicle xe2 = new Vehicle("Nguyen Van B", "Toyota", 3000, 250000000);
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhap owner name: ");
        String name = sc.nextLine();
        System.out.println("Nhap type: ");
        String type = sc.nextLine();
        System.out.println("Nhap dung tich ");
        int dungtich = sc.nextInt();
        System.out.println("Nhap Price: ");
        double price = sc.nextDouble();

        Vehicle xe3 = new Vehicle(name, type, dungtich, price);
        System.out.println(String.format("%-20s %-20s %-10s %-20s %-15s", "Ten chu xe", "Loai xe", "dung tich", "Gia", "Thue"));
        System.out.println(xe1);
        System.out.println(xe2);
        System.out.println(xe3);

    }
}