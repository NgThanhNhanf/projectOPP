package Accounts;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UserUI {
    static List<String> idUser;
    static Scanner sc = new Scanner(System.in);
    public static void rootMenu() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│                 Tai khoan                 │");
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("│ 1. Danh sach tai khoan                    │");
        System.out.println("│ 2. Tim kiem                               │");
        System.out.println("│ 3. Thoat                                  │");
        System.out.println("└───────────────────────────────────────────┘");
        boolean complete = false;
        int choose;
        while (!complete) {
            System.out.print("Nhap lua chon: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    idUser = new ArrayList<>();
                    Users.displayUsers();
                    break;
                case 2: 

                    break;
                case 3: 
                    complete = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }
    public static void controlUser() {
            
    }
}
