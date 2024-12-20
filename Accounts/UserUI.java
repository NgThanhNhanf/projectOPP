package Accounts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserUI {
    static List<String> idUser;
    static Scanner sc = new Scanner(System.in);

    public static void rootMenu() {
        boolean complete = false;
        int choose;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Tai khoan                 │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Danh sach tai khoan                    │");
            System.out.println("│ 2. Tim kiem                               │");
            System.out.println("│ 3. Thoat                                  │");
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
            
            switch (choose) {
                case 1:
                    System.out.println("Danh sach tai khoan.");
                    idUser = new ArrayList<>();
                    controlListUsers();
                    break;
                case 2:
                    System.out.println("Tim kiem");
                    searchUser();
                    break;
                case 3:
                    complete = true;
                    return;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }

    public static void controlUser(User choosedUser) {
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│              Thong tin ca nhan            │");
            System.out.println("├───────────────────────────────────────────┤");
            choosedUser.displayUser();
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│1. Sua thong tin tai khoan                 │");
            System.out.println("│2. Xoa tai khoan                           │");
            System.out.println("│3. Thoat                                   │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.println("Nhap lua chon: ");
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
            switch (choose) {
                case 1:
                    choosedUser.editUser();
                    break;
                case 2:
                    boolean tmp = false;
                    while (!tmp) {
                        System.out.println("Ban co chac chan muon xoa nhan vien nay?");
                        System.out.println("┌───────────────────────────────────────────┐");
                        System.out.println("│1. Xoa                                     │");
                        System.out.println("│2. Thoat                                   │");
                        System.out.println("└───────────────────────────────────────────┘");
                        System.out.print("Nhap lua chon: ");
                        int confirm;
                        do {
                            try {
                                confirm = sc.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                                sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                            }
                        } while (true);
                        switch (confirm) {
                            case 1:
                                Users.removeUser(choosedUser.getUserId());
                                System.out.println("Xoa thanh cong!");
                                tmp = true;
                                break;
                            case 2:
                                tmp = true;
                                System.out.println("Thoat");
                                return;
                            default:
                                System.out.println("Lua chon khong hop le vui long nhap lai");
                                break;
                        }
                    }
                    complete = true;
                    break;
                case 3:
                    complete = true;
                    System.out.println("Thoat");
                    return;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }

    public static void controlListUsers() {
        boolean complete = false;
        while (!complete) {
            Users.displayUsers();
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│1. Chon tai khoan de thuc hien chuc nang   │");
            System.out.println("│2. Tim kiem                                │");
            System.out.println("│3. Thoat                                   │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.println("Nhap lua chon: ");
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
            
            switch (choose) {
                case 1:
                    System.out.print("Nhap STT: ");
                    int index;
                    do {
                        try {
                            index = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                            sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                        }
                    } while (true);
            
                    User choosedUser = Users.getUser(idUser.get(--index));
                    controlUser(choosedUser);
                    break;
                case 2:
                    searchUser();
                    break;
                case 3:
                    complete = true;
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
        List<String> arrID = searcher.searching(search);
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
            
            switch (choose) {
                case 1:
                    System.out.println("Nhap STT:");
                    int index;
                    do {
                        try {
                            index = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                            sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                        }
                    } while (true);
            
                    sc.nextLine();
                    controlUser(arrUserS.get(--index));
                    break;
                case 2:
                    complete = true;
                    return;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }
}