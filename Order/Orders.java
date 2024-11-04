package Order;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import Model.*;

public class Orders {
    private static List<Order> orders = new ArrayList<>();
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    // Khởi tạo danh sách đơn hàng
    public Orders() {}

    // Chỉnh sửa đơn hàng theo mã đơn hàng trong iventory của orderUI
    public static void edit(int orderID) {
        for (Order order : orders) {
            if (order.getOrderID() == orderID) {
                while (true) {
                    order.displayOrder();
                    System.out.println("│1. Them San pham                           │");
                    System.out.println("│2. Xoa san pham                            │");
                    System.out.println("│3. Quay lai                                │");
                    System.out.println("└───────────────────────────────────────────┘");
                    System.out.print("Chon mot tuy chon: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            Inventory.display();
                            boolean loop;
                            do {
                                System.out.print("Nhap ma san pham:");
                                int productID = scanner.nextInt();
                                scanner.nextLine();

                                Product product = Inventory.getProductByID(productID);

                                if (product != null) {
                                    int stock = Inventory.getListInventory().getOrDefault(product, 0);
                                    if (stock > 0) {
                                        System.out.print("Nhap so luong:");
                                        int quantity = scanner.nextInt();
                                        scanner.nextLine();

                                        if (stock >= quantity) {
                                            order.addProduct(product, quantity);
                                            Inventory.deleteInventory(product, quantity);
                                            System.out.println("San pham da duoc them vao don hang.");
                                        } else {
                                            System.out.println("So luong san pham trong kho khong du.");
                                        }
                                    } else {
                                        System.out.println("San pham da het hang.");
                                    }
                                } else {
                                    System.out.println("Khong tim thay san pham.");
                                }

                                System.out.print("Ban co muon nhap them san pham? (y/n): ");
                                String answer = scanner.nextLine();
                                loop = answer.equalsIgnoreCase("y");
                            } while (loop);
                            break;
                        case 2:
                            boolean loop1;
                            do {
                                order.displayOrder();
                                System.out.print("Nhap ma san pham:");
                                int trashID = scanner.nextInt();
                                scanner.nextLine();

                                OrderDetail detailToRemove = null;
                                for (OrderDetail detail : order.getOrderDetails()) {
                                    if (detail.getProduct().getProductID() == trashID) {
                                        detailToRemove = detail;
                                        break;
                                    }
                                }

                                if (detailToRemove != null) {
                                    order.removeProduct(detailToRemove.getProduct());
                                    Inventory.addInventory(detailToRemove.getProduct(), detailToRemove.getQuantity());
                                    System.out.println("San pham da duoc xoa khoi don hang.");
                                } else {
                                    System.out.println("Khong tim thay san pham trong don hang.");
                                }

                                System.out.print("Ban co muon xoa them san pham? (y/n): ");
                                String answer = scanner.nextLine();
                                loop1 = answer.equalsIgnoreCase("y");
                            } while (loop1);
                            break;
                        case 3:
                            if (order.getOrderDetails().isEmpty()) {
                                System.out.println("Don hang khong co san pham nao. Xoa don hang.");
                                orders.remove(order);
                            }
                            return;
                        default:
                            System.out.println("Lua chon khong hop le.");
                            break;
                    }
                    System.out.println("Cap nhat don hang thanh cong.");
                }
            }
        }
        System.out.println("Khong tim thay don hang.");
    }

    // Hiển thị danh sách đơn hàng
    public static void displayOrders() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│                 ORDER LIST                │");
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("│  #ID                              Total   │");
        for (Order order : orders) {
            System.out.println("│#" + displayFormat.formatID(order.getOrderID()) + "                        $" + displayFormat.formatPrice(order.calculateTotal()) + "│");
        }
    }

    // Tạo mã đơn hàng ngẫu nhiên và kiểm tra tính duy nhất
    public static int generateId() {
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
    public static void addOrder(Order order) {
        if (!order.getOrderDetails().isEmpty()) {
            orders.add(order);
            System.out.println("Don hang da duoc them vao.");
        } else {
            System.out.println("Don hang rong. Khong them don hang.");
        }
    }

    // Xóa đơn hàng theo mã đơn hàng
    public static void deleteOrder(int orderID) {
        boolean removed = orders.removeIf(order -> order.getOrderID() == orderID);
        if (removed) {
            System.out.println("Da xoa don hang.");
        } else {
            System.out.println("Khong tim thay don hang.");
        }
    }

    // Lấy danh sách đơn hàng
    public static List<Order> getOrders() {
        return orders;
    }

    // Thiết lập danh sách đơn hàng
    public static void setOrders(List<Order> orders) {
        Orders.orders = orders;
    }
}