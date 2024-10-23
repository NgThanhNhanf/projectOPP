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

    public Order(int orderID, Customer customer) {
        this.orderID = orderID;
        this.orderDate = LocalDate.now(); // Thời gian xuất bill
        this.customer = customer;
        this.orderDetails = new ArrayList<>();
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderDetail detail : orderDetails) total += detail.calculateSubTotal();
        return total;
    }

    public void addProduct(Product product, int quantity) {
        OrderDetail detail = new OrderDetail(this, product, quantity);
        orderDetails.add(detail);
    }

    public void removeProduct(Product product) {
        orderDetails.removeIf(detail -> detail.getProduct().equals(product));
    }

    public void displayOrder() {
        System.out.println("Ma don hang: #" + orderID);
        System.out.println("Ngay xuat bill: " + orderDate);
        System.out.println("Ten khach: " + customer.getName());
        System.out.println("Chi tiet don hang:");
        for (OrderDetail detail : orderDetails) {
            System.out.println("San pham " + detail.getProduct().getProductName() + "x" + detail.getQuantity() + ": " + detail.calculateSubTotal() + " VND.");
        }
        System.out.println("Tong tien: " + calculateTotal());
    }

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