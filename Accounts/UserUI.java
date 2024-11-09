package Accounts;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
                    System.out.println("Danh sach tai khoan.");
                    idUser = new ArrayList<>();
                    Users.displayUsers();
                    controlListUsers();
                    break;
                case 2:
                    System.out.println("Tim kiem");
                    searchUser();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }

    public static void controlUser(User choosedUser) {
        choosedUser.displayUser();
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│1. Sua thong tin tai khoan                 │");
            System.out.println("│2. Xoa tai khoan                           │");
            System.out.println("│3. Thoat                                   │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.println("Nhap lua chon: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    choosedUser.editUser();
                    break;
                case 2:
                    System.out.println("Ban co chac chan muon xoa nhan vien nay?");
                    System.out.println("┌───────────────────────────────────────────┐");
                    System.out.println("│1. Xoa                                     │");
                    System.out.println("│2. Thoat                                   │");
                    System.out.println("└───────────────────────────────────────────┘");
                    boolean tmp = false;
                    while (!tmp) {
                        System.out.print("Nhap lua chon: ");
                        int confirm = sc.nextInt();
                        switch (confirm) {
                            case 1:
                                Users.removeUser(choosedUser.getUserId());
                                System.out.println("Xoa thanh cong!");
                                break;
                            case 2:
                                System.out.println("Thoat");
                                return;
                            default:
                                System.out.println("Lua chon khong hop le vui long nhap lai");
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thoat");
                    return;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }

    public static void controlListUsers() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│1. Chon tai khoan de thuc hien chuc nang   │");
        System.out.println("│2. Tim kiem                                │");
        System.out.println("│3. Thoat                                   │");
        System.out.println("└───────────────────────────────────────────┘");
        boolean complete = false;
        while (!complete) {
            System.out.println("Nhap lua chon: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    int index;
                    System.out.print("Nhap STT: ");
                    index = sc.nextInt();
                    User choosedUser = Users.getUser(idUser.get(--index));
                    controlUser(choosedUser);
                    break;
                case 2:
                    searchUser();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }

    public static void searchUser() {
        sc.nextLine();
        System.out.println("Tim kiem tai khoan");
        String search = sc.nextLine();
        Users searcher = new Users();
        List<String> arrID = searcher.search(search);
        Collections.sort(arrID, Comparator.comparingInt(String::length));
        List<User> arrUserS = new ArrayList<>();
        for (String cur : arrID) {
            arrUserS.add(Users.getUser(cur));
        }
        for (int i = 0; i < arrUserS.size(); ++i) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.printf("│ STT            : %-24s │\n", i + 1);
            System.out.printf("│ ID            : %-25s │\n", arrUserS.get(i).getUserId());
            System.out.printf("│ Ten            : %-24s │\n", arrUserS.get(i).getUserName());
            System.out.println("└───────────────────────────────────────────┘");
        }
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│1. Chon tai khoan de thuc hien chuc nang   │");
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
                    controlUser(arrUserS.get(--index));
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