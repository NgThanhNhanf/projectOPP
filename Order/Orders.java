package Order;

import File.fileWork;
import Model.*;
import Person.Customer;
import Person.Customers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Orders implements fileWork {
    private static List<Order> orders = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Khởi tạo danh sách đơn hàng
    public Orders() {
    }

    // Chỉnh sửa đơn hàng theo mã đơn hàng trong iventory của orderUI
    public static void edit(int orderID) {
        for (Order order : orders) {
            if (order.getOrderID() == orderID) {
                if (order.isOrderStatus()) {
                    boolean completed = false;
                    while (!completed) {
                        order.displayOrderDetails();
                        System.out.println("┌───────────────────────────────────────────┐");
                        System.out.println("│1. Quay lai                                │");
                        System.out.println("└───────────────────────────────────────────┘");
                        System.out.print("Chon 1 de quay lai: ");
                        int choice;
                        do {
                            try {
                                choice = scanner.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.print("Lua chon chi bao gom chu so. Vui long nhap lai: ");
                                scanner.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                            }
                        } while (true);
                        scanner.nextLine();
                        switch (choice) {
                            case 1:
                                return;
                            default:
                                System.out.println("Lua chon khong hop le.");
                                break;
                        }
                    }
                }
                boolean complete = false;
                while (!complete) {
                    order.displayOrderDetails();
                    System.out.println("│1. Them San pham                           │");
                    System.out.println("│2. Xoa san pham                            │");
                    System.out.println("│3. Xac nhan thanh toan                     │");
                    System.out.println("│4. Quay lai                                │");
                    System.out.println("└───────────────────────────────────────────┘");
                    System.out.print("Chon mot tuy chon: ");
                    int choice;
                    do {
                        try {
                            choice = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.print("Lua chon chi bao gom chu so. Vui long nhap lai: ");
                            scanner.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                        }
                    } while (true);
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            Inventory.display();
                            boolean loop;
                            do {
                                System.out.print("Nhap ma san pham:");
                                int productID;
                                do {
                                    try {
                                        productID = scanner.nextInt();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.print("Lua chon chi bao gom chu so. Vui long nhap lai: ");
                                        scanner.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                                    }
                                } while (true);
                                scanner.nextLine();
                                System.out.print("Nhap so luong:");
                                int quantity;
                                do {
                                    try {
                                        quantity = scanner.nextInt();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.print("Lua chon chi bao gom chu so. Vui long nhap lai: ");
                                        scanner.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                                    }
                                } while (true);
                                scanner.nextLine();
                                Product product = null;
                                for (Product cur : Inventory.getListInventory().keySet()) {
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

                                System.out.print("Ban co muon nhap them san pham? (Nhap y de tiep tuc): ");
                                String answer = scanner.nextLine();
                                loop = answer.equalsIgnoreCase("y");
                            } while (loop);
                            break;
                        case 2:
                            boolean loop1;
                            do {
                                System.out.print("Nhap ma san pham:");
                                int trashID;
                                do {
                                    try {
                                        trashID = scanner.nextInt();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                                        scanner.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                                    }
                                } while (true);
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

                                System.out.print("Ban co muon xoa them san pham? (Nhap y de tiep tuc): ");
                                String answer = scanner.nextLine();
                                loop1 = answer.equalsIgnoreCase("y");
                            } while (loop1);
                            break;
                        case 3:
                            if (OrdersUI.payment(order, order.getCustomer())) {
                                order.setOrderStatus(true);
                                complete = true;
                            }
                            complete = true;
                            break;
                        case 4:
                            if (order.getOrderDetails().isEmpty()) {
                                System.out.println("Don hang khong co san pham nao. Xoa don hang.");
                                orders.remove(order);
                            }
                            complete = true;
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
        for (Order order : orders) order.displayOrder();
    }

    // Thêm đơn hàng
    public static void addOrder(Order order) {
        if (!order.getOrderDetails().isEmpty()) {
            orders.add(order);
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
                        System.out.println("┌───────────────────────────────────────────┐");
                        System.out.println("│              KHONG THE XOA !!!            │");
                        System.out.println("│        Do don hang da duoc thanh toan     │");
                        System.out.println("├───────────────────────────────────────────┤");
                        System.out.println("│ 1. Quay lai                               │");
                        System.out.println("└───────────────────────────────────────────┘");
                        System.out.print("Vui long chon 1 de quay lai: ");
                        while (true) {
                            try {
                                int tmp = scanner.nextInt();
                                scanner.nextLine();
                                if (tmp == 1) {
                                    break;
                                } else {
                                    System.out.print("Lua chon khong hop le. Vui long nhap lai: ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.print("Lua chon chi bao gom chu so. Vui long nhap lai: ");
                                scanner.nextLine(); // Clear invalid input
                            }
                        }
                    return;
                } else {
                    // Trả lại sản phẩm về kho
                    order.returnItemsToInventory();
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
    //    File myFile = new File("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Order\\orderData.txt");
        File myFile = new File("D:\\Workspace\\Test\\temp\\projectOPP\\Order\\orderData.txt");
        // File myFile = new File("C:\\OOP\\projectOPP\\Order\\orderData.txt");
        Scanner scf = new Scanner(myFile);
        while (scf.hasNextLine()) {
            String line = scf.nextLine();
            String[] arrstr = line.split("\\|");
            int orderID = Integer.parseInt(arrstr[0]);
            String customerName = arrstr[1];
            String customerPhone = arrstr[2];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
            LocalDate orderDate = LocalDate.parse(arrstr[3], formatter);
            boolean orderStatus = Boolean.parseBoolean(arrstr[arrstr.length - 1]);

            Customer customer = null;
            if (!customerName.equals("null") && !customerPhone.equals("null")) {
                customer = Customers.findCustomer(customerPhone);
                if (customer == null) {
                    customer = new Customer();
                    customer.setName(customerName);
                    customer.setPhone(customerPhone);
                    Customers.addCustomer(customer);
                }
            }

            Order newOrder = new Order(orderID, customer);
            newOrder.setOrderDate(orderDate);
            newOrder.setOrderStatus(orderStatus);
            if (customer != null) customer.addOrder(newOrder);

            for (int i = 4; i < arrstr.length - 1; i += 2) {
                newOrder.addProduct(Inventory.getProductByID(Integer.parseInt(arrstr[i])),
                        Integer.parseInt(arrstr[i + 1]));
            }
            Orders.addOrder(newOrder);
        }
        scf.close();
    }


    // Dùng set để kiểm tra và tạo id
    public static int generateID() {
        Set<Integer> existingIds = new HashSet<>();
        for (Order order : orders) {
            existingIds.add(order.getOrderID());
        }

        int idCounter = 1;
        while (existingIds.contains(idCounter)) {
            idCounter++;
        }
        return idCounter;
    }

    @Override
    public void writeFile() throws IOException {
        // FileWriter("D:\\Study\\OOP\\projectOPP\\Order\\orderData.txt");
    //   FileWriter myFile = new FileWriter("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Order\\orderData.txt");
        FileWriter myFile = new FileWriter("D:\\Workspace\\Test\\temp\\projectOPP\\Order\\orderData.txt");
        // FileWriter myFile = new FileWriter("C:\\OOP\\projectOPP\\Order\\orderData.txt");
        for (Order cur : orders) {
            myFile.write(cur.getOrderID() + "|");
            if (cur.getCustomer() != null) {
                myFile.write(cur.getCustomer().getName() + "|" + cur.getCustomer().getPhone());
            } else {
                myFile.write("null|null");
            }
            myFile.write("|" + cur.getOrderDate());
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