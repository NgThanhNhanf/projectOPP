package Order;

import java.util.Scanner;
import Person.Customer;
import Model.Product;
import Model.Inventory;


public class OrdersUI {
    private Orders allOrders;
    private Scanner scanner;

    // Hàm khởi tạo phi tham số
    public OrdersUI() {
        this.allOrders = new Orders();
        this.scanner = new Scanner(System.in);
    }

    // Thêm sản phẩm vào đơn hàng
    public void addNewOrder(Inventory inventory) {
        System.out.print("Nhap ten khach hang: ");
        String name = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String phone = scanner.nextLine();
        Customer customer = new Customer(name, phone); // Tạo khách hàng mới
        Order newOrder = new Order(allOrders.generateId(), customer); // Tạo sản phẩm mới có mã và khách hàng

        boolean tiepTuc;
        do {
            // Hiển thị danh sách sản phẩm từ kho.
            inventory.display();

            System.out.print("Nhap ma san pham: ");
            int productID = scanner.nextInt();
            Product product = inventory.getProductByID(productID); // Lấy sản phẩm từ kho theo ID

            if (product != null) {
                System.out.print("Nhap so luong: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                if (product.getStock() >= quantity) {
                    newOrder.addProduct(product, quantity); // Thêm sản phẩm vào đơn hàng
                    inventory.receiveStock(product, -quantity); // Cập nhật số lượng hàng tồn kho
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

        allOrders.addOrder(newOrder);
    }

    // Xem danh sách đơn hàng
    public void viewOrders(Inventory inventory) {
        while (true) {
            allOrders.displayOrders();
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│ 1. Chinh sua don hang                     │");
            System.out.println("│ 2. Quay lai                               │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.print("Chon mot tuy chon: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    editOrder(inventory);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        }
    }

    // Chỉnh sửa đơn hàng
    public void editOrder(Inventory inventory) {
        System.out.print("Nhap ma don hang can sua: ");
        int orderID = scanner.nextInt();
        scanner.nextLine();
        allOrders.edit(orderID, inventory, this);
    }

    // Menu gốc
    public void rootMenu(Inventory inventory) {
        while (true) {
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
                    addNewOrder(inventory);
                    break;
                case 2:
                    viewOrders(inventory);
                    break;
                case 3:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
            if (choice == 3) break;
        }
    }

    // Lấy danh sách orders
    public Orders getAllOrders() {
        return allOrders;
    }
}