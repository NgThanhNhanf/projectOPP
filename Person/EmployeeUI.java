package Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeUI {
    static List<String> phoneInList; 
    static Scanner sc = new Scanner(System.in);
    public static void controlEmployees(int index) {
        Employee choosedEmployee = Employees.findEmployee(phoneInList.get(--index));
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
                                tmp = true;
                                break;
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
    public static void mainMenu() {
        boolean complete = false;
        phoneInList = new ArrayList<>();
        while(!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Nhan Vien                 │");
            Employees.viewEmployee();
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│1. Chon nhan vien                          │");
            System.out.println("│2. Them nhan vien                          │");
            System.out.println("│3. Thoat                                   │");
            System.out.println("└───────────────────────────────────────────┘");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Chon nhan vien");
                    System.out.println("Nhap STT:");
                    int index = sc.nextInt();
                    sc.nextLine();
                    controlEmployees(index);
                    break;
                case 2:
                    System.out.println("Them nhan vien");
                    Employee newEmployee = new Employee();
                    newEmployee.enterPerson();
                    break;
                case 3:
                    System.out.println("Thoat");
                    complete = true;
                    break;
                default:
                    break;
            }
        }
    }
}
