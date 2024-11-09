package Order;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import File.fileWork;
import Model.*;
import Person.Customer;
import Person.Customers;

public class Orders implements fileWork {
    private static List<Order> orders = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Khởi tạo danh sách đơn hàng
    public Orders() {}

    // Chỉnh sửa đơn hàng theo mã đơn hàng trong iventory của orderUI
    public static void edit(int orderID) {
        for (Order order : orders) {
            if (order.getOrderID() == orderID) {
                if (order.isOrderStatus()) {
                    System.out.println("Don hang da thanh toan. Khong the sua.");
                    return;
                }
                while (true) {
                    order.displayOrder();
                    System.out.println("│1. Them San pham                           │");
                    System.out.println("│2. Xoa san pham                            │");
                    System.out.println("│3. Xac nhan thanh toan                     │");
                    System.out.println("│4. Quay lai                                │");
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
                                System.out.print("Nhap so luong:");
                                int quantity = scanner.nextInt();
                                scanner.nextLine();
                                Product product = null;
                                for(Product cur : Inventory.getListInventory().keySet()) {
                                    if (cur.getProductID() == productID) {
                                        product = cur;
                                        break;
                                    }
                                }   
                                if (product != null) {
                                    int stock = Inventory.getListInventory().getOrDefault(product, 0);
                                    if (stock >= quantity) {
                                        order.addProduct(product, quantity);
                                        Inventory.deleteInventory(product, quantity);
                                        System.out.println("San pham da duoc them vao don hang.");
                                    } else {
                                        System.out.println("So luong san pham trong kho khong du.");
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
                            System.out.print("Xac nhan thanh toan don hang nay? (y/n): ");
                            String confirm = scanner.nextLine();
                            if (confirm.equalsIgnoreCase("y")) {
                                order.setOrderStatus(true);
                                System.out.println("Thanh toan thanh cong.");
                            }
                            break;
                        case 4:
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
        System.out.println("│  #ID            status            Total   │");
        for (Order order : orders) {
            System.out.printf("│#%-6s    %-17s    %-7s VND│\n", displayFormat.formatID(order.getOrderID()), order.isOrderStatus() ? "<Da thanh toan>" : "<Chua thanh toan>", displayFormat.formatPrice(order.calculateTotal()));
        }
    }
    // Nạp chồng phương thức để hiển thị lịch sử đơn hàng của riêng khách hàng đó theo số điện thoại 
    //tính đa hình
    public static void displayOrders(String customerPhone) {
        boolean found = false;
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│              Lich su don hang             │");
        System.out.println("├───────────────────────────────────────────┤");
        for (Order order : orders) {
            if (order.getCustomer().getPhone().equals(customerPhone) && order.isOrderStatus()) {
                System.out.printf("│#%-6s   %-17s    %-7s VND│\n", displayFormat.formatID(order.getOrderID()), order.isOrderStatus() ? "<Da thanh toan>" : "<Chua thanh toan>", displayFormat.formatPrice(order.calculateTotal()));
                found = true;
            }
        }
        if (!found) {
            System.out.println("│     Khong co don hang nao duoc tim thay   │");
        }
        System.out.println("└───────────────────────────────────────────┘");
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
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getOrderID() == orderID) {
                if (order.isOrderStatus()) {
                    System.out.println("Don hang da thanh toan. Khong the xoa.");
                    return;
                } else {
                    iterator.remove();
                    System.out.println("Da xoa don hang.");
                    return;
                }
            }
        }
        System.out.println("Khong tim thay don hang.");
    }

    // Lấy danh sách đơn hàng
    public static List<Order> getOrders() {
        return orders;
    }

    // Thiết lập danh sách đơn hàng
    public static void setOrders(List<Order> orders) {
        Orders.orders = orders;
    }
    @Override 
    public void readFile() throws FileNotFoundException {
        // File myFile = new File("D:\\Study\\OOP\\projectOPP\\Order\\orderData.txt");
        File myFile = new File("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Order\\orderData.txt");
        // File myFile = new File("D:\\Workspace\\Test\\temp\\projectOPP\\Order\\orderData.txt");
        // File myFile = new File("C:\\OOP\\projectOPP\\Order\\orderData.txt");
        Scanner scf = new Scanner(myFile);
        while (scf.hasNextLine()) {
            String line = scf.nextLine();
            String [] arrstr = line.split("\\|");
            int orderID = Integer.parseInt(arrstr[0]);
            String customerName = arrstr[1];
            String customerPhone = arrstr[2];
            // Thêm biến đọc trạng thái đơn hàng
            boolean orderStatus = Boolean.parseBoolean(arrstr[arrstr.length - 1]);
            Customer customer = new Customer();
            customer.setName(customerName);
            customer.setPhone(customerPhone);
            Order newOrder = new Order(orderID, customer);
            // Thêm trạng thái đơn hàng vào
            newOrder.setOrderStatus(orderStatus);

            for (int i = 3; i < arrstr.length-1; i += 2) {
                newOrder.addProduct(Inventory.getProductByID(Integer.parseInt(arrstr[i])), Integer.parseInt(arrstr[i + 1]));
            }
            Orders.addOrder(newOrder);
        }
        scf.close();
    } 
    @Override 
    public  void writeFile() throws IOException {
        // FileWriter myFile = new FileWriter("D:\\Study\\OOP\\projectOPP\\Order\\orderData.txt");4
        // FileWriter myFile = new FileWriter("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Order\\orderData.txt");
        FileWriter myFile = new FileWriter("D:\\Workspace\\Test\\temp\\projectOPP\\Order\\orderData.txt");
        for (Order cur : orders) {
            myFile.write(cur.getOrderID() + "|" + cur.getCustomer().getName() + "|" + cur.getCustomer().getPhone());
            for (OrderDetail d : cur.getOrderDetails()) {
                myFile.write("|" + d.getProduct().getProductID() + "|" + d.getQuantity());
            }
            myFile.write("|" + cur.isOrderStatus()); // Ghi thêm trạng thái vào file
            myFile.write('\n');
        }
        myFile.close();
    }

    public static void fileInit() throws FileNotFoundException {
        Orders orders = new Orders();
        orders.readFile();
    }

    public static void fileClose() throws IOException {
        Orders orders = new Orders();
        orders.writeFile();
    }
}