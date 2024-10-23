package Order;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import Person.Customer;

public class Orders {
    private List<Order> orders;

    public Orders() {
        this.orders = new ArrayList<>();
    }

    public void edit(int orderID) {
        for (Order order : orders) {
            if (order.getOrderID() == orderID) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Tuy chinh don hang #" + orderID);
                System.out.println("Nhap ten khach hang: ");
                String customerName = scanner.nextLine();
                order.getCustomer().setName(customerName);
                System.out.println("Cap nhat don hang thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay don hang.");
    }

    public void displayOrders() {
        for (Order order : orders) {
            order.displayOrder();
            System.out.println("----------------------------");
        }
    }

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Don hang da duoc them vao.");
    }

    public void deleteOrder(int orderID) {
        orders.removeIf(order -> order.getOrderID() == orderID);
        System.out.println("Da xoa don hang.");
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}