package Menu;
import java.util.*;

import Accounts.User;
import Accounts.UserUI;
import Accounts.Users;
import Model.ProductUI;
import Order.OrdersUI;
import Person.Customers;
import Person.EmployeeUI;
import Person.Employees;

import java.io.*;
public class MainMenu {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Users.fileInit();
        Employees.fileInit();
        Customers.fileInit();
        loginUI();
        Users.fileClose();
        Employees.fileClose();
        Customers.fileClose();
    }
    public static void MenuM() {
        boolean complete = false;
        while(!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Menu Chinh                │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Don hang                               │");
            System.out.println("│ 2. Khach hang                             │");
            System.out.println("│ 3. Nhan vien                              │");
            System.out.println("│ 4. San pham                               │");
            System.out.println("│ 5. Kho hang                               │");
            System.out.println("│ 6. Thong ke                               │");
            System.out.println("│ 7. Tai khoan                              │");
            System.out.println("│ 8. Dang xuat                              │");
            System.out.println("│ 9. Thoat                                  │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.println("Nhap lua chon:");
            int choose = sc.nextInt(); sc.nextLine();
            switch (choose) {
                case 1: 
                    OrdersUI.rootMenu();
                    break;
                case 2:
                    
                    break;
                case 3:
                    EmployeeUI.mainMenu();
                    break;
                case 4:
                    ProductUI.rootMenu();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    UserUI.rootMenu();
                    break;
                case 8:
                    break;
                case 9:
                    complete = true;
                    break;
                default: 
                    System.out.println("Lua chon khong hop le vui long nhap lai");
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
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1: 
                    System.out.println("-Chon dang nhap.");
                    user = login.login();
                    if (user != null) {
                        if (user.getRole().equals("M")) {
                            System.out.println("Here2");
                            MenuM();
                        }
                    }
                    break;
                case 2:
                    System.out.println("-Chon dang ky.");
                    user = login.register();
                    if (user != null) {
                        if (user.getRole().equals("M")) {
                            MenuM();
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
