package Menu;

import java.util.*;
import Accounts.User;
import Accounts.Users;
import Person.Employees;

public class Login {
    Scanner sc = new Scanner(System.in);
    Login(){}
    public User login() {
        User user;
        boolean complete = false;
        while (!complete) {
            user = new User();
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
                return null;
            }
            System.out.println("-Chon nhap thong tin.");
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Dang nhap                 │");
            System.out.println("├───────────────────────────────────────────┤");
            // Cách nào đẻ lấy role đưa vào main menu
            String userName, password;
            System.out.print("│ Username         : ");
            userName = sc.nextLine();
            System.out.print("│ Password         : ");
            password = sc.nextLine();
            user = new User(userName, password);
            user = Users.checkUser(user);
            if (user != null) {
                System.out.println("└───────────────────────────────────────────┘");
                System.out.println("-Dang nhap thanh cong!");
                return user;
            } else {
                System.out.println("-Tai khoan hoac mat khau khong dung. Hay thu lai!");
            }
        }
        return null;
    }
    // TODO: kiểm tra xem id đã được đăng ký hay chưa nếu chưa thì thì cho đăng ký, 
    // nếu đã đăng ký thì cho chọn đăng nhập hoặc nhập lại hoặc thoát ra
    public User register() {
        User user;
        boolean complete = false;
        while (!complete) {
            user = new User();
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
                return null;
            }
            System.out.println("-Chon nhap thong tin");
            user.enterUser();
            boolean kt = false;
            if (Employees.checkId(user.getUserId())) {
                if(Users.findUser(user.getUserId()) == -1) {
                    Users.addUser(user);
                    System.out.println("-Dang ky thanh cong!");
                    complete = true;
                    return user;
                } else {
                    System.out.println("-Danng. Do id da duoc dang ky. Hay thu lai!");
                    kt = true;
                }
            } else {
                System.out.println("-Dang ky khong thanh cong. Do id khong ton tai. Hay thu lai!");
                kt = true;
            }
            while(kt){
                System.out.println("┌───────────────────────────────────────────┐");
                System.out.println("│               Nhap lua chon               │");
                System.out.println("├───────────────────────────────────────────┤");
                System.out.println("│ 1. Nhap lai thong tin.                    │");
                System.out.println("│ 2. Dang nhap.                             │");
                System.out.println("│ 3. Thoat.                                 │");
                System.out.println("└───────────────────────────────────────────┘");
                int choose1 = sc.nextInt();
                switch (choose1) {
                    case 1:
                        register();
                        kt = false;
                        break;
                    case 2:
                        login();
                        kt = false;
                        break;
                    case 3:
                        kt = false;
                        break;
                    default:
                        break;
                }
                sc.nextLine();
            }
        }
        return null;
    }
}