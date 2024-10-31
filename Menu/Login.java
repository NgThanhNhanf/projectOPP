package Menu;

import java.util.*;
import Accounts.User;
import Accounts.Users;
import Person.Employees;

public class Login {
    private User user = new User();
    Scanner sc = new Scanner(System.in);
    Login(){}
    public boolean login() {
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Dang nhap                 │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Nhap thong tin.                        │");
            System.out.println("│ 2. Thoat.                                 │");
            System.out.println("└───────────────────────────────────────────┘");
            int choose = sc.nextInt();
            sc.nextLine();
            if (choose == 2) {
                System.out.println("-Chon thoat.");
                return false;
            }
            System.out.println("-Chon nhap thong tin.");
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Dang nhap                 │");
            System.out.println("├───────────────────────────────────────────┤");
            // problem: đăng nhập thì chỉ cần có user name và pass thì phần id để làm gì ?
            // Cách nào đẻ lấy role đưa vào main menu
            String userName, password;
            System.out.print("│ Username         : ");
            userName = sc.nextLine();
            System.out.print("│ Password         : ");
            password = sc.nextLine();
            user = new User(userName, password);
            if (Users.checkUser(user)) {
                System.out.println("└───────────────────────────────────────────┘");
                System.out.println("-Dang nhap thanh cong!");
                return true;
            } else {
                System.out.println("-Tai khoan hoac mat khau khong dung. Hay thu lai!");
            }
        }
        return complete;
    }
    // problem: có cần xác minh lại lần 2
    // Kiểm tra userName và password nhập vào
    public boolean register() {
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                  Dang ky                  │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Nhap thong tin.                        │");
            System.out.println("│ 2. Thoat.                                 │");
            System.out.println("└───────────────────────────────────────────┘");
            int choose = sc.nextInt();
            sc.nextLine();
            
            if (choose == 2) {
                System.out.println("-Chon thoat");
                return false;
            }
            System.out.println("-Chon nhap thong tin");
            user.enterUser();
            if (Employees.checkId(user.getUserId())) {
                Users.addUser(user);
                System.out.println("-Dang ky thanh cong!");
                complete = true;
                return true;
            } else {
                System.out.println("-Dang ky khong thanh cong. Do id khong ton tai. Hay thu lai!");
            }
        }
        return complete;
    }
}