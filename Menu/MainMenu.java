package Menu;
import java.util.*;

import Accounts.Users;
import Person.Employees;

import java.io.*;
public class MainMenu {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Users.fileInit();
        Employees.fileInit();
        loginUI();
        Users.displayUsers();
        Users.fileClose();
        Employees.fileClose();
    }
    public static void Menu() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│                 Menu Chinh                │");
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("│ 1. Tao don hang                           │");
        System.out.println("│ 2. Khach hang                             │");
        System.out.println("│ 3. Nhan vien                              │");
        System.out.println("│ 4. San pham                               │");
        System.out.println("│ 5. Kho hang                               │");
        System.out.println("│ 6. Thoát                                  │");
        System.out.println("└───────────────────────────────────────────┘");
    }
    public static void loginUI() throws FileNotFoundException {
        Login login = new Login();
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
                    if (login.login()) {
                        Menu();
                    }
                    break;
                case 2:
                    System.out.println("-Chon dang ky.");
                    if (login.register()) {
                        Menu();
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
