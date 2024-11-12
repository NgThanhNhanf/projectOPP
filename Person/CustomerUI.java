package Person;

import java.util.Scanner;

import Order.Orders;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomerUI {
    static List<String> phoneInList;
    static Scanner sc = new Scanner(System.in);

    public static void controlCustomer(Customer choosedCustomer) {
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│             Thong tin ca nhan             │");
            System.out.println("├───────────────────────────────────────────┤");
            choosedCustomer.displayPerson();
            System.out.println("│1. Sua thong tin                           │");
            System.out.println("│2. Xem lich su don hang                    │");
            System.out.println("│3. Xoa khach hang                          │");
            System.out.println("│4. Thoat                                   │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("Nhap lua chon: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    choosedCustomer.editPerson();
                    break;
                case 2:
                    choosedCustomer.displayOrderHistory();
                    break;
                case 3:
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
                                tmp = true;
                                complete = true;
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
                case 4:
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
        while (!complete) {
            CustomerUI.phoneInList = new ArrayList<>();
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Khach Hang                │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│1. Danh sach khach hang                    │");
            System.out.println("│2. Tim kiem                                │");
            System.out.println("│3. Thoat                                   │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("Nhap lua chon: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    controlListCustomer();
                    break;
                case 2:
                    searchCustomer();
                    break;
                case 3:
                    System.out.println("Thoat");
                    return;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai.");
                    break;
            }
        }
    }

    public static void controlListCustomer() {
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│            Danh sach khach hang           │");
            Customers.viewCustomer();
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│1. Chon khach hang de thuc hien chuc nang  │");
            System.out.println("│2. Thoat                                   │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("Nhap lua chon: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Nhap STT:");
                    int index = sc.nextInt();
                    sc.nextLine();
                    Customer choosedCustomer = Customers.findCustomer(phoneInList.get(index - 1));
                    controlCustomer(choosedCustomer);
                    break;
                case 2:
                    complete = true;
                    return;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }

    public static void searchCustomer() {
        System.err.print("Tim kiem khach hang: ");
        String search = sc.nextLine();
        Customers searcher = new Customers();
        List<String> arrID = searcher.searching(search);
        Collections.sort(arrID, Comparator.comparingInt(String::length));
        List<Customer> arrCustomerS = new ArrayList<>();
        for (String cur : arrID) {
            arrCustomerS.add(Customers.findCustomer(cur));
        }
        for (int i = 0; i < arrCustomerS.size(); ++i) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.printf("│ STT            : %-24s │\n", i + 1);
            System.out.printf("│ SDT            : %-24s │\n", arrCustomerS.get(i).getPhone());
            System.out.printf("│ Ten            : %-24s │\n", arrCustomerS.get(i).getName());
            System.out.println("└───────────────────────────────────────────┘");
        }
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│1. Chon khach hang de thuc hien chuc nang  │");
        System.out.println("│2. Thoat                                   │");
        System.out.println("└───────────────────────────────────────────┘");
        boolean complete = false;
        while (!complete) {
            System.out.print("Nhap lua chon: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Nhap STT:");
                    int index = sc.nextInt();
                    sc.nextLine();
                    controlCustomer(arrCustomerS.get(--index));
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }
}