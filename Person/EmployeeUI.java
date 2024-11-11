package Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeeUI {
    static List<String> phoneInList; 
    static Scanner sc = new Scanner(System.in);
    public static void mainMenu() {
        boolean complete = false;
        while(!complete) {
            EmployeeUI.phoneInList = new ArrayList<>();
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Nhan Vien                 │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│1. Danh sach nhan vien                     │");
            System.out.println("│2. Them nhan vien                          │");
            System.out.println("│3. Tim kiem                                │");
            System.out.println("│4. Thoat                                   │");
            System.out.println("└───────────────────────────────────────────┘");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Danh sach nhan vien");
                    Employees.viewEmployee();
                    controlListEmployees();
                    break;
                case 2:
                    System.out.println("Them nhan vien");
                    Employee newEmployee = new Employee();
                    newEmployee.enterPerson();
                    break;
                case 3:
                    System.out.println("Tim kiem");
                    searchEmployee();
                    break;
                case 4:
                    System.out.println("Thoat");
                    return;
                default:
                    break;
            }
        }
    }
    public static void controlEmployee(Employee choosedEmployee) {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│             Thông tin cá nhân             │");
        System.out.println("├───────────────────────────────────────────┤");
        choosedEmployee.displayPerson();
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│1. Sua thong tin                           │");
            System.out.println("│2. Xoa nhan vien                           │");
            System.out.println("│3. Thoat                                   │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.println("Nhap lua chon:");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    choosedEmployee.editPerson();
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
                                System.out.println("Xoa thanh cong!");
                                Employees.deleteEmployee(choosedEmployee.getID());
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
                    complete = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }
    public static void controlListEmployees() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│1. Chon nhan vien de thuc hien chuc nang   │");
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
                    Employee choosedEmployee = Employees.findEmployee(phoneInList.get(--index));
                    controlEmployee(choosedEmployee);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }
    public static void searchEmployee() {
        sc.nextLine();
        System.out.print("Tim kiem nhan vien: ");
        String search = sc.nextLine();
        Employees searcher = new Employees();
        List<String> arrID = searcher.searching(search);
        Collections.sort(arrID, Comparator.comparingInt(String::length));
        List<Employee> arrEmployeeS = new ArrayList<>();
        for (String cur : arrID) {
            arrEmployeeS.add(Employees.getEmployee(cur));
        }
        for (int i = 0; i < arrEmployeeS.size(); ++i) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.printf("│ STT            : %-24s │\n", i+1);
            System.out.printf("│ ID            : %-25s │\n", arrEmployeeS.get(i).getID());
            System.out.printf("│ Ten            : %-24s │\n", arrEmployeeS.get(i).getName());
            System.out.println("└───────────────────────────────────────────┘"); 
        }
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│1. Chon nhan vien de thuc hien chuc nang   │");
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
                    controlEmployee(arrEmployeeS.get(--index));
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