package Order;

import java.util.Scanner;
import Model.Product;
import Person.Customer;
import Person.Customers;
import Model.Inventory;

public class OrdersUI {
    private static Scanner scanner = new Scanner(System.in);

    // Thêm sản phẩm vào đơn hàng
    public static void addNewOrder() {
        System.out.print("Nhap so dien thoai: ");
        String phone = scanner.nextLine();

        Customer customer = Customers.findCustomer(phone);
        if (customer == null) {
            customer = new Customer();
            customer.setPhone(phone);
            customer.enterPerson();
            Customers.addCustomer(customer);
        }

        int orderID = Orders.getOrders().size() + 1;
        Order newOrder = new Order(orderID, customer);

        boolean tiepTuc;
        do {
            // Hiển thị danh sách sản phẩm từ kho.
            Inventory.display();

            System.out.print("Nhap ma san pham: ");
            int productID = scanner.nextInt();
            scanner.nextLine(); // Thêm dòng này để đọc bỏ ký tự xuống dòng

            Product product = Inventory.getProductByID(productID); // Truy xuất trực tiếp bằng productID

            if (product != null) {
                System.out.print("Nhap so luong: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                int stock = Inventory.getListInventory().getOrDefault(product, 0);
                if (stock >= quantity) {
                    newOrder.addProduct(product, quantity); // Thêm sản phẩm vào đơn hàng
                    Inventory.deleteInventory(product, quantity); // Cập nhật số lượng hàng tồn kho
                } else {
                    System.out.println("So luong san pham trong kho khong du.");
                }
            } else {
                System.out.println("San pham khong ton tai.");
            }

            System.out.print("Ban co muon nhap them san pham? (y/n): ");
            String answer = scanner.nextLine();
            tiepTuc = answer.equalsIgnoreCase("y");
        } while (tiepTuc);

        if (!newOrder.getOrderDetails().isEmpty()) {
            boolean validChoice = false;
            while (!validChoice) {
                System.out.println("┌───────────────────────────────────────────┐");
                System.out.println("│        Chon trang thai don hang           │");
                System.out.println("├───────────────────────────────────────────┤");
                System.out.println("│1. Thanh Toan                              │");
                System.out.println("│2. Them vao hang doi                       │");
                System.out.println("│3. Huy thiet lap                           │");
                System.out.println("└───────────────────────────────────────────┘");
                System.out.print("Nhap lua chon: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        if (!payment(newOrder,customer)) break;
                        newOrder.setOrderStatus(true);
                        Orders.addOrder(newOrder);
                        customer.addOrder(newOrder);
                        validChoice = true;
                        System.out.println("Don hang da duoc thanh toan va luu lai.");
                        break;
                    case 2:
                        newOrder.setOrderStatus(false);
                        Orders.addOrder(newOrder);
                        customer.addOrder(newOrder);
                        validChoice = true;
                        System.out.println("Don hang da duoc them vao hang doi va luu lai.");
                        break;
                    case 3:
                        newOrder.returnItemsToInventory();
                        System.out.println("Huy thiet lap don hang.");
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long chon lai.");
                }
            }
        } else System.out.println("Don hang rong. Khong them don hang.");
    }

    public static boolean payment(Order order, Customer customer) {
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│        Chon phuong thuc thanh toan        │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│1. Momo                                    │");
            System.out.println("│2. Tien mat                                │");
            System.out.println("│3. Quay lai                                │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("Nhap lua chon: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Nhap so dien thoai Momo: ");
                    String momoPhone = scanner.nextLine();
                    if (momoPhone.equals(customer.getPhone())) {
                        System.out.print("Xac nhan thanh toan qua Momo? (y/n): ");
                        String confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("y")) {
                            validChoice = true;
                            return true;
                        }
                    } else {
                        System.out.println("So dien thoai khong khop voi khach hang.");
                    }
                    break;
                case 2:
                    double totalAmount = order.calculateTotal();
                    order.displayOrder();
                    boolean paymentSuccess = false;
                    while (!paymentSuccess) {
                        System.out.print("Nhap so tien khach dua: ");
                        double amountGiven = scanner.nextDouble();
                        scanner.nextLine();
                        if (amountGiven >= totalAmount) {
                            double change = amountGiven - totalAmount;
                            System.out.println("┌───────────────────────────────────────────┐");
                            System.out.printf("│Tien khach dua:  %-7s%-7s VND│\n", ' ',displayFormat.formatPrice(amountGiven));
                            System.out.println("│Tien du cua khach:                " + displayFormat.formatPrice(change) + " VND│");
                            System.out.println("├───────────────────────────────────────────┤");
                            System.out.println("│           Thanh toan thanh cong           │");
                            System.out.println("└───────────────────────────────────────────┘");
                            paymentSuccess = true;
                            validChoice = true;
                            return true;
                        } else {
                            System.out.println("So tien khong du. Vui long nhap lai.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Quay lai.");
                    validChoice = true;
                    return false;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        }
        return false;
    }

    // Xem danh sách đơn hàng
    public static void viewOrders() {
        boolean complete = false;
        while (!complete) {
            Orders.displayOrders(); // Truy cập phương thức tĩnh
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Xem don hang                           │");
            System.out.println("│ 2. Xoa don hang                           │");
            System.out.println("│ 3. Quay lai                               │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("Chon mot tuy chon: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    editOrder();
                    break;
                case 2:
                    System.out.print("Nhap ma don hang can xoa: ");
                    int orderID = scanner.nextInt();
                    scanner.nextLine();
                    Orders.deleteOrder(orderID);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        }
    }

    // Chỉnh sửa đơn hàng
    public static void editOrder() {
        System.out.print("Nhap ma don hang can sua: ");
        int orderID = scanner.nextInt();
        scanner.nextLine();
        Orders.edit(orderID); // Truy cập phương thức tĩnh
    }

    // Menu gốc
    public static void rootMenu() {
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 MENU ORDER                │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Them don hang moi                      │");
            System.out.println("│ 2. Danh sach don hang                     │");
            System.out.println("│ 3. Thoat                                  │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("Chon mot tuy chon: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addNewOrder();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    System.out.println("Thoat.");
                    complete = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        }
    }
}