package Order;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import Model.Clothing;
import Model.Product;
import Model.Shoes;
import Person.Customer;

public class Order {
    private int orderID;
    private LocalDate orderDate;
    private Customer customer; 
    private List<OrderDetail> orderDetails;
    private boolean orderStatus; // true: Đã thanh toán, false: Chưa thanh toán

    public Order() {
        this.orderStatus = false; // Mặc định chưa thanh toán
    }

    public Order(int orderID, Customer customer) {
        this.orderID = orderID;
        this.orderDate = LocalDate.now(); 
        this.customer = customer;
        this.orderDetails = new ArrayList<>();
        this.orderStatus = false; // Mặc định chưa thanh toán
    }

    // Tính tổng toàn bộ đơn
    public double calculateTotal() {
        double total = 0;
        for (OrderDetail detail : orderDetails) {
            total += detail.calculateSubTotal();
        }
        return total;
    }

    // Thêm sản phẩm vào order details
    public void addProduct(Product product, int quantity) {
        for (OrderDetail detail : orderDetails) {
            if (detail.getProduct().getProductID() == product.getProductID()) {
                detail.setQuantity(detail.getQuantity() + quantity);
                return;
            }
        }
        OrderDetail detail = new OrderDetail(product, quantity);
        orderDetails.add(detail);
    }

    // Xóa sản phẩm khỏi order details
    public void removeProduct(Product product) {
        orderDetails.removeIf(detail -> detail.getProduct().getProductID() == product.getProductID());
    }

    // Hiển thị đơn hàng
    public void displayOrder() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│                 #" + orderID + "                   │");
        System.out.println("│Ten khach hang:  " + customer.getName() + " │");
        System.out.println("│So dien thoai:   " + customer.getPhone() + "                │");
        System.out.println("│Ngay in don:  " + orderDate + "                   │");
        System.out.println("│Trang thai:     " + (orderStatus ? "<Da thanh toan>" : "<Chua thanh toan>") + "      │");
        System.out.println("├───────────────────────────────────────────┤");
        for (OrderDetail detail : orderDetails) {
            System.out.println("│#" + detail.getProduct().getProductID() + " - " + detail.getProduct().getProductName() + " [x" + detail.getQuantity() + "]:      " + displayFormat.formatPrice(detail.calculateSubTotal()) + " VND│");
        }
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("│Total:                          " + displayFormat.formatPrice(calculateTotal()) + " VND│");
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

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
}