package Accounts;

import java.util.*;

public class User {
    private String userName;
    private String password;
    private String userId;
    private boolean role;
    Scanner sc = new Scanner(System.in);
    public User() {
        role = false;
    }
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public User(String userName, String password, String id) {
        this.userName = userName;
        this.password = password;
        this.userId = id;
        role = false;
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
        System.out.printf("│ ID            : %-24s │\n", userId);
        System.out.printf("│ Username      : %-24s │\n", userName);
        System.out.printf("│ Password      : %-24s │\n", password);
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
    public boolean getRole() {
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
    public void setRole(boolean role) {
        this.role = role;
    }
    public void editUserName() {
        String newUserName; 
        System.out.printf("│ Username      : %-24s │\n", userName);
        System.out.println("│ New username         : ");
        newUserName = sc.nextLine();
        setUserName(newUserName);
    }
    public void editUserId() {
        String newUserId;
        System.out.printf("│ ID            : %-24s │\n", userId);
        System.out.println("│ New ID         : ");
        newUserId = sc.nextLine();
        setUserId(newUserId);
    }
    public void editPasseword() {
        String newPassword;
        System.out.printf("│ Password      : %-24s │\n", password);
        System.out.println("│ New password         : ");
        newPassword = sc.nextLine();
        setPassword(newPassword);
    }
    public void editUser() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│           Chon thong tin can sua          │");
        System.out.println("├───────────────────────────────────────────┤");
        System.out.printf("│ 1.User name            : %-24s │");
        System.out.printf("│ 2.User id            : %-24s │");
        System.out.printf("│ 3.Password            : %-24s │");
        int choose; 
        boolean complete = false;
        while (!complete) {
            choose = sc.nextInt();
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
                default:
                System.out.println("│           Lua chon khong hop le           │");
                    break;
            }
            if (complete) {
                System.out.println("│             Sua doi thanh cong            │");
            }
        }
    }
}
