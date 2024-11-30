package Menu;

import Accounts.User;
import Accounts.UserUI;
import Accounts.Users;
import Model.Inventory;
import Model.ProductUI;
import Order.Orders;
import Order.OrdersUI;
import Person.CustomerUI;
import Person.Customers;
import Person.EmployeeUI;
import Person.Employees;
import Statistic.Store;
import java.io.*;
import java.util.*;

public class MainMenu {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Users.fileInit();
        Employees.fileInit();
        Customers.fileInit();
        Inventory.fileInit();
        Orders.fileInit();
        loginUI();
        Users.fileClose();
        Employees.fileClose();
        Customers.fileClose();
        Inventory.fileClose();
        Orders.fileClose();
    }

    public static void MenuM() {
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Menu Chinh                │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Don hang                               │");
            System.out.println("│ 2. Khach hang                             │");
            System.out.println("│ 3. Nhan vien                              │");
            System.out.println("│ 4. Kho hang                               │");
            System.out.println("│ 5. Thong ke                               │");
            System.out.println("│ 6. Tai khoan                              │");
            System.out.println("│ 7. Dang xuat                              │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("Nhap lua chon: ");
            int choose;
            do {
                try {
                    choose = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                    sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                }
            } while (true);
            sc.nextLine();
            switch (choose) {
                case 1:
                    OrdersUI.rootMenu();
                    break;
                case 2:
                    CustomerUI.mainMenu();
                    break;
                case 3:
                    EmployeeUI.mainMenu();
                    break;
                case 4:
                    ProductUI.rootMenu();
                    break;
                case 5:
                    Store.statistic();
                    break;
                case 6:
                    UserUI.rootMenu();
                    break;
                case 7:
                    complete = true;
                    System.out.println("Dang xuat thanh cong");
                    break;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }

    public static void MenuE() {
        boolean complete = false;
        while(!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Menu Chinh                │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Don hang                               │");
            System.out.println("│ 2. Khach hang                             │");
            System.out.println("│ 3. Dang xuat                              │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("nhap lua chon: ");
            int choose;
            do {
                try {
                    choose = sc.nextInt();
                    break;
                } catch(InputMismatchException e) {
                    System.out.println("lua chon chi bao gom chu so.Vui long nhap lai");
                    sc.nextLine();
                }
            }while(true);

            switch (choose) {
                case 1:
                    OrdersUI.rootMenu();
                    break;
                case 2:
                    CustomerUI.mainMenu();
                    break;
                case 3:
                    complete = true;
                    System.out.println("Dang xuat thanh cong");
                    break;
                default:
                    break;
            }
        }
    }

    public static void loginUI() throws FileNotFoundException {
        Login login = new Login();
        User user;
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Welcome!!                 │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Dang nhap.                             │");
            System.out.println("│ 2. Dang ky.                               │");
            System.out.println("│ 3. Thoat.                                 │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("Nhap lua chon: ");
            int choose;
            do {
                try {
                    choose = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                    sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                }
            } while (true);
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.println("-Chon dang nhap.");
                    user = login.login();
                    if (user != null) {
                        if (user.getRole().equals("M")) {
                            System.out.println("Here2");
                            MenuM();
                        }else if(user.getRole().equals("E")){
                            System.out.println("Here3");
                            MenuE();
                        }
                    }
                    break;
                case 2:
                    System.out.println("-Chon dang ky.");
                    user = login.register();
                    if (user != null) {
                        if (user.getRole().equals("M")) {
                            MenuM();
                        }else if(user.getRole().equals("E")){
                            MenuE();
                        }
                    }
                    break;
                case 3:
                    System.out.println("-Chon thoat.");
                    complete = true;
                    break;
                default:
                    System.out.println("-Lua chon khong hop le, hay thu lai!");
            }
        }
    }
}
