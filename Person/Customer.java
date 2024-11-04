package Person;

import java.util.List;
import java.util.Scanner;
import Order.Order;
import java.util.ArrayList;

public class Customer extends Person {
    private List<Order> orderHistory; 
    Scanner sc = new Scanner(System.in);
    public Customer(){
        orderHistory = new ArrayList<>();
    }
    public Customer(String name, Birth dob, String phone, String email) {
        super(name, dob, phone, email);
    }
    public void displayHistoryOrder() {
        for (Order cur : orderHistory) {
            cur.displayOrder();
        }
    }
    @Override
    public void editPerson() {
        boolean complete = false;
        while(!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│        Chon thong tin can chinh sua       │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Ten                                    │");
            System.out.println("│ 2. Ngay sinh                              │");
            System.out.println("│ 3. Dia chi                                │");
            System.out.println("│ 4. SDT                                    │");
            System.out.println("│ 5. Tat ca                                 │");
            System.out.println("│ 6. Thoat                                  │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.println("Nhap lua chon:");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1: 
                    editName();
                    break;
                case 2:
                    editBirth();
                    break;
                case 3:
                    editAddress();
                    break;
                case 4:
                    editPhone();
                    break;
                case 5:
                    editAll();
                    break;
                case 6:
                    System.out.println("Thoat");
                    complete = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }
    @Override
    public void editAll() {
        Customer newCustomer = new Customer();
        newCustomer.enterPerson();
        setName(newCustomer.getName());
        setBirth(newCustomer.getDob());
        setAddress(newCustomer.getAddress());
        setPhone(newCustomer.getPhone());
    }
}
