package Person;

import Order.Order;
import Order.displayFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Customer extends Person {
    private List<Order> orderHistory;
    Scanner sc = new Scanner(System.in);

    public Customer() {
        super();
        orderHistory = new ArrayList<>();
    }

    public Customer(String name, Birth dob, String address, String phone) {
        super(name, dob, address, phone);
        orderHistory = new ArrayList<>();
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public void displayOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("Khách hàng chưa có đơn hàng nào.");
        } else {
            boolean temp = false;
            while (!temp) {
                System.out.println("┌───────────────────────────────────────────┐");
                System.out.println("│              Lich su don hang             │");
                System.out.println("├───────────────────────────────────────────┤");
                for (Order order : orderHistory) {
                    System.out.printf("│#%06d%-6s %-17s %-7s VND│\n", order.getOrderID(), ' ', "<Da thanh toán>",displayFormat.formatPrice(order.calculateTotal()));
                }
                System.out.println("├───────────────────────────────────────────┤");
                System.out.println("│1. Xem chi tiet                            │");
                System.out.println("│2. Quay lai                                │");
                System.out.println("└───────────────────────────────────────────┘");
                System.out.print("Nhap lua chon: ");
                int choice;
                do {
                    try {
                        choice = sc.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                        sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                    }
                } while (true);
                
                sc.nextLine();
                switch (choice) {
                    case 1:
                        for (Order order : orderHistory) order.displayOrderDetails();
                        boolean confirm = false;
                        while (!confirm) {
                            System.out.println("┌───────────────────────────────────────────┐");
                            System.out.println("│1. Quay lai                                │");
                            System.out.println("└───────────────────────────────────────────┘");
                            System.out.print("Chon 1 de quay lai: ");
                            int choice2;
                            do {
                                try {
                                    choice2 = sc.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                                    sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                                }
                            } while (true);
                            sc.nextLine();
                            switch (choice2) {
                                case 1:
                                    return;
                                default:
                                    System.out.println("Lua chon khong hop le.");
                                    break;
                            }
                        }
                        return;
                    case 2:
                        return;
                    default:
                        System.out.println("Lua chon khong hop le.");
                        break;
                }
            }
        }
    }

    @Override
    public void enterPerson() {
        super.enterPerson();
    }

    @Override
    public void displayPerson() {
        super.displayPerson();
    }

    @Override
    public void editAll() {
        enterPerson();
    }

    @Override
    public void editPerson() {
        boolean complete = false;
        while (!complete) {
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
            System.out.print("Nhap lua chon:");
            int choose;
            do {
                try {
                    choose = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println( "Lua chon chi bao gom chu so. Vui long nhap lai.");
                    sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                }
            } while (true);
            
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
}