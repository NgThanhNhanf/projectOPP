package Order;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import Model.Product;
 
public class Order {
    private int orderID;
    private LocalDate orderDate;
    private String customerPhone;
    private String customerName; // Thêm thuộc tính customerName
    private List<OrderDetail> orderDetails;

    public Order () {}

    public Order(int orderID, String customerName, String customerPhone) {
        this.orderID = orderID;
        this.orderDate = LocalDate.now(); 
        this.customerName = customerName; // Lưu tên khách hàng
        this.customerPhone = customerPhone;
        this.orderDetails = new ArrayList<>();
    }

    // Tính tổng toàn bộ đơn
    public double calculateTotal() {
        double total = 0;
        for (OrderDetail detail : orderDetails) {
            total += detail.calculateSubTotal();
        }
        return total;
    }

    // Thêm đơn hàng vào order details
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

    // Xóa đơn hàng khỏi order details
    public void removeProduct(Product product) {
        orderDetails.removeIf(detail -> detail.getProduct().equals(product));
    }

    // Chi tiết đơn hàng
    public void displayOrder () {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│                 #"+displayFormat.formatID(getOrderID())+"                   │");
        System.out.println("│Ten khach hang:  "+ customerName +" │");
        System.out.println("│So dien thoai:   "+ customerPhone +"                │");
        System.out.println("│Ngay in don:  "+ getOrderDate()+"                   │");
        System.out.println("├───────────────────────────────────────────┤");
        for (OrderDetail detail : orderDetails) {
            System.out.println("│#" + detail.getProduct().getProductID() + " - " + detail.getProduct().getProductName() + " [x" + detail.getQuantity() + "]:          $" + displayFormat.formatPrice(detail.calculateSubTotal()) + "│");
        }
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("│Total:                         $"+ displayFormat.formatPrice(calculateTotal()) +"│");
        System.out.println("├───────────────────────────────────────────┤");
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

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomer(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    // Thêm getter và setter cho customerName
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}