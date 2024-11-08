package Person;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CustomerUI {
    static List<String> phoneInList;
    static Scanner sc = new Scanner(System.in);

    public static void controlCustomer(int index) {
        Customer choosedCustomer = Customers.findCustomer(phoneInList.get(--index));
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│             Thong tin ca nhan             │");
        System.out.println("├───────────────────────────────────────────┤");
        choosedCustomer.displayPerson();
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│1. Sua thong tin                           │");
            System.out.println("│2. Xoa khach hang                          │");
            System.out.println("│3. Thoat                                   │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("Nhap lua chon: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    choosedCustomer.editPerson();
                    break;
                case 2:
                    System.out.println("Ban co chac chan muon xoa khach hang nay?");
                    System.out.println("┌───────────────────────────────────────────┐");
                    System.out.println("│1. Xoa                                     │");
                    System.out.println("│2. Thoat                                   │");
                    System.out.println("└───────────────────────────────────────────┘");
                    boolean tmp = false;
                    while (!tmp) {
                        System.out.print("Nhap lua chon: ");
                        int confirm = sc.nextInt();
                        sc.nextLine();
                        switch (confirm) {
                            case 1:
                                System.out.println("Xoa thanh cong!");
                                Customers.deleteCustomer(choosedCustomer.getPhone());
                                break;
                            case 2:
                                tmp = true;
                                break;
                            default:
                                System.out.println("Lua chon khong hop le, vui long nhap lai.");
                                break;
                        }
                    }
                    break;
                case 3:
                    complete = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai.");
                    break;
            }
        }
    }

    public static void mainMenu() {
        boolean complete = false;
        CustomerUI.phoneInList = new ArrayList<>();
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Khach hang                │");
            Customers.viewCustomer();
            // System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│1. Chon khach hang                         │");
            System.out.println("│2. Them khach hang                         │");
            System.out.println("│3. Thoat                                   │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("Nhap lua chon: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.print("Chon khach hang\nNhap STT: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    controlCustomer(index);
                    break;
                case 2:
                    System.out.println("Them khach hang");
                    Customer newCustomer = new Customer();
                    newCustomer.enterPerson();
                    Customers.addCustomer(newCustomer);
                    break;
                case 3:
                    System.out.println("Thoat");
                    complete = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai.");
                    break;
            }
        }
    }
}