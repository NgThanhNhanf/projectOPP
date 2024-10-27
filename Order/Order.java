package Order;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import Model.Product;
import Person.Customer;
 
public class Order {
    private int orderID;
    private LocalDate orderDate;
    private Customer customer;
    private List<OrderDetail> orderDetails;

    public Order () {}

    public Order(int orderID, Customer customer) {
        this.orderID = orderID;
        this.orderDate = LocalDate.now(); 
        this.customer = customer;
        this.orderDetails = new ArrayList<>();
    }

    // Tính tổng toàn bộ đơn
    public double calculateTotal() {
        double total = 0;
        for (OrderDetail detail : orderDetails) total += detail.calculateSubTotal();
        return total;
    }

    // Thêm đơn hàng vào order details
    public void addProduct(Product product, int quantity) {
        OrderDetail detail = new OrderDetail(this, product, quantity);
        orderDetails.add(detail);
    }

    // Xóa đơn hàng khỏi order details
    public void removeProduct(Product product) {
        orderDetails.removeIf(detail -> detail.getProduct().equals(product));
    }

    // Chi tiết đơn hàng
    public void displayOrder () {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│                 #"+getOrderID()+"                │");
        System.out.println("|Ten khach hang:  "+ getCustomer().getName()+"        |");
        System.out.println("|Ngay in don:  "+ getOrderDate()+"                 |");
        System.out.println("├───────────────────────────────────────────┤");
        for (OrderDetail detail : orderDetails) {
            System.out.println("|#" + detail.getProduct().getProductID() + " - " + detail.getProduct().getProductName() + " [x" + detail.getQuantity() + "]: $" + detail.calculateSubTotal() + "                |");
        }
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("|Total:                            $"+ calculateTotal() +"|");
        System.out.println("└───────────────────────────────────────────┘");
    }

    // Getter và Setter
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}