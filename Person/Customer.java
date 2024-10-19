package Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
    private String orderID;
    private String product;
    private double price;

    public Order(String orderID, String product, double price) {
        this.orderID = orderID;
        this.product = product;
        this.price = price;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderID + ", Product: " + product + ", Price: $" + price;
    }
}

public class Customer extends Person {
    private String customerID;
    private List<Order> orderHistory;
    private Scanner sc;

    public Customer() {
        this.orderHistory = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.println("├───────────────────────────────────────────┤");
        System.out.print("│ Nhập mã khách hàng: ");
        customerID = sc.nextLine();

        boolean tiepTuc;
        do {
            System.out.println("├───────────────────────────────────────────┤");
            System.out.print("│ Nhập mã đơn hàng: ");
            String orderID = sc.nextLine();
            System.out.print("│ Nhập tên sản phẩm: ");
            String product = sc.nextLine();

            double price = 0;
            boolean isValidPrice = false;
            do {
                try {
                    System.out.print("│ Nhập giá sản phẩm: ");
                    price = Double.parseDouble(sc.nextLine());
                    isValidPrice = true;
                } catch (NumberFormatException e) {
                    System.out.println("├───────────────────────────────────────────┤");
                    System.out.println("│ Lỗi: Vui lòng nhập một số hợp lệ cho giá sản phẩm!");
                    System.out.println("├───────────────────────────────────────────┤");
                }
            } while (!isValidPrice);

            Order order = new Order(orderID, product, price);
            placeOrder(order);

            System.out.println("├───────────────────────────────────────────┤");
            System.out.print("│ Bạn có muốn nhập thêm đơn hàng? (y/n): ");
            String answer = sc.nextLine();
            tiepTuc = answer.equalsIgnoreCase("y");
        } while (tiepTuc);
        System.out.println("└───────────────────────────────────────────┘");
    }

    @Override
    public void xuat() {
        super.xuat();
        viewOrderHistory();
    }

    public void viewOrderHistory() {
        super.xuat();
        if (orderHistory.isEmpty()) {
            System.out.println("│ Lịch sử đặt hàng: Không có đơn hàng nào    │");
        } else {
            int cnt = 1;
            for (Order order : orderHistory) {
                System.out.println("├───────────────────────────────────────────┤");
                System.out.printf("│ Đơn hàng %2d                               │\n", cnt++);
                System.out.println("├───────────────────────────────────────────┤");
                System.out.printf("│ Mã đơn hàng  : %-27s│\n", order.getOrderID());
                System.out.printf("│ Sản phẩm     : %-27s│\n", order.getProduct());
                System.out.printf("│ Giá sản phẩm : $%-26.2f│\n", order.getPrice());
            }
        }
        System.out.println("└───────────────────────────────────────────┘");
    }

    public void placeOrder(Order order) {
        orderHistory.add(order);
        System.out.println("│ Sản phẩm đã được đặt:\n│ [" + order.toString() + "]");
    }
}
