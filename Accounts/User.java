package Accounts;

import java.util.*;

public class User {
    private String userName;
    private String password;
    private String userId;
    private String role = "";
    Scanner sc = new Scanner(System.in);

    public User() {
        role = "E";
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, String id) {
        this.userName = userName;
        this.password = password;
        this.userId = id;
        role = "E";
    }

    public User(String userName, String password, String id, String role) {
        this.userName = userName;
        this.password = password;
        this.userId = id;
        this.role = role;
    }

    // hàm nhập
    // Problem: cần kiểm tra rỗng
    public void enterUser() {
        System.out.print("│ Id         : ");
        userId = sc.nextLine();
        System.out.print("│ Username         : ");
        userName = sc.nextLine();
        System.out.print("│ Password         : ");
        password = sc.nextLine();
    }

    public void displayUser() {
        System.out.printf("│ ID            : %-25s │\n", userId);
        System.out.printf("│ Username      : %-25s │\n", userName);
        System.out.printf("│ Password      : %-25s │\n", password);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void editUserName() {
        String newUserName;
        System.out.printf("│ Username      : %-24s │\n", userName);
        System.out.print("│ New username         : ");
        newUserName = sc.nextLine();
        setUserName(newUserName);
    }

    public void editUserId() {
        String newUserId;
        System.out.printf("│ ID            : %-24s │\n", userId);
        System.out.print("│ New ID         : ");
        newUserId = sc.nextLine();
        setUserId(newUserId);
    }

    public void editPasseword() {
        String newPassword;
        System.out.printf("│ Password      : %-24s │\n", password);
        System.out.print("│ New password         : ");
        newPassword = sc.nextLine();
        setPassword(newPassword);
    }

    public void editUser() {
        int choose;
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│           Chon thong tin can sua          │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.printf("│ 1.User name: %-29s│\n", ' ');
            System.out.printf("│ 2.User id: %-31s│\n", ' ');
            System.out.printf("│ 3.Password: %-30s│\n", ' ');
            System.out.printf("│ 4.Thoat %-34s│\n", ' ');
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("Nhap lua chon: ");
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
                    editUserName();
                    complete = true;
                    break;
                case 2:
                    editUserId();
                    complete = true;
                    break;
                case 3:
                    editPasseword();
                    complete = true;
                    break;
                case 4:
                    complete = true;
                    break;
                default:
                    System.out.println("│           Lua chon khong hop le           │");
                    break;
            }
            if (complete) {
                System.out.println("┌───────────────────────────────────────────┐");
                System.out.println("│             Sua doi thanh cong            │");
                System.out.println("└───────────────────────────────────────────┘");
            }
        }
    }
}
