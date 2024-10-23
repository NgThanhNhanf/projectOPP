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
    public User(String userName, String password, String id, String name) {
        this.userName = userName;
        this.password = password;
        this.userId = id;
        role = false;
    }
    public void enterUser() {
        System.out.println("│ Id         : ");
        userId = sc.nextLine();
        System.out.println("│ Username         : ");
        userName = sc.nextLine();
        System.out.println("│ Password         : ");
        password = sc.nextLine();
    }
    public void displayUser() {
        System.out.printf("│ ID            : %-24s │\n", userId);
        System.out.printf("│ Username      : %-24s │\n", userName);
        System.out.printf("│ Password      : %-24s │\n", password);
        System.out.println("");
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
}
