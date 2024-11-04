// FILE: OrdersUI.java

package Order;

import java.util.Scanner;
import Model.Product;
import Model.Inventory;

public class OrdersUI {
    private static Scanner scanner = new Scanner(System.in);

    // Thêm sản phẩm vào đơn hàng
    public static void addNewOrder() {
        System.out.print("Nhap ten khach hang: ");
        String name = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String phone = scanner.nextLine();
        Order newOrder = new Order(Orders.generateId(), displayFormat.formatName(name), phone); // Truy cập phương thức
                                                                                                // tĩnh

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

        if (!newOrder.getOrderDetails().isEmpty())
            Orders.addOrder(newOrder); // Truy cập phương thức tĩnh
        else
            System.out.println("Don hang rong. Khong them don hang.");
    }

    // Xem danh sách đơn hàng
    public static void viewOrders() {
        boolean complete = false;
        while (!complete) {
            Orders.displayOrders(); // Truy cập phương thức tĩnh
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Chinh sua don hang                     │");
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