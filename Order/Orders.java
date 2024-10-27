package Order;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import Model.*;

public class Orders {
    private List<Order> orders;
    Random random = new Random();

    // Khởi tạo danh sách đơn hàng
    public Orders() {
        this.orders = new ArrayList<>();
    }

    // Chỉnh sửa đơn hàng theo mã đơn hàng trong iventory của orderUI
    public void edit(int orderID, Inventory inventory, OrdersUI ordersUI) {
        for (Order order : orders) {
            if (order.getOrderID() == orderID) {
                while (true) {
                    order.displayOrder();
                    System.out.println("│1. Them San pham                           │");
                    System.out.println("│2. Xoa san pham                            │");
                    System.out.println("│3. Quay lai                                │");
                    System.out.println("└───────────────────────────────────────────┘");
                    System.out.print("Chon mot tuy chon: ");
                    Scanner scanner = new Scanner(System.in);
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1: 
                            inventory.display();
                            boolean loop;
                            do {
                                System.out.print("Nhap ma san pham:");
                                int productID = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nhap so luong:");
                                int quantity = scanner.nextInt();
                                scanner.nextLine();
                                Product product = inventory.getProductByID(productID);
                                if (product != null) {
                                    order.addProduct(product, quantity);
                                    System.out.println("San pham da duoc them vao đon hang.");
                                } else {
                                    System.out.println("Khong tim thay san pham.");
                                }
                                System.out.print("Ban co muon nhap them san pham? (y/n): ");
                                String answer = scanner.nextLine();
                                loop = answer.equalsIgnoreCase("y");
                            } while (loop);
                            break;
                        case 2:
                            order.displayOrder();
                            boolean loop1;
                            do {
                                order.displayOrder();
                                System.out.print("Nhap ma san pham:");
                                int trashID = scanner.nextInt();
                                Product trashItem = inventory.getProductByID(trashID);
                                if (trashItem != null) {
                                    order.removeProduct(trashItem);
                                    System.out.println("San pham da duoc xoa khoi don hang.");
                                } else {
                                    System.out.println("Khong tim thay san pham.");
                                }
                                System.out.print("Ban co muon xoa them san pham? (y/n): ");
                                String answer = scanner.nextLine();
                                loop1 = answer.equalsIgnoreCase("y");
                            } while (loop1);
                            break;
                        case 3: 
                            ordersUI.viewOrders(inventory);
                            return;
                        default:
                            System.out.println("Lua chon khong hop le.");
                            break;
                    }
                    System.out.println("Cap nhat don hang thanh cong.");
                    break;
                }
            }
        }
        System.out.println("Khong tim thay don hang.");
    }

    // Hiển thị danh sách đơn hàng
    public void displayOrders() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│                 ORDER LIST                │");
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("|#ID                                   Total|");
        for (Order order : orders) {
            System.out.println("|#" + order.getOrderID() + "                             $" + order.calculateTotal() + "|");
        }
    }

    // Tạo mã đơn hàng ngẫu nhiên và kiểm tra tính duy nhất
    public int generateId() {
        int id;
        boolean exists;
        do {
            id = random.nextInt(1000); 
            exists = false;
            for (Order order : orders) {
                if (order.getOrderID() == id) {
                    exists = true;
                    break;
                }
            }
        } while (exists);
        return id;
    }

    // Thêm đơn hàng
    public void addOrder(Order order) {
        orders.add(order); 
        System.out.println("Don hang da duoc them vao.");
    }

    // Xóa đơn hàng theo mã đơn hàng
    public void deleteOrder(int orderID) {
        orders.removeIf(order -> order.getOrderID() == orderID);
        System.out.println("Da xoa don hang.");
    }

    // Lấy danh sách đơn hàng
    public List<Order> getOrders() {
        return orders;
    }

    // Thiết lập danh sách đơn hàng
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}