package Order;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import Model.Product;
import Person.Customer;
import Model.Inventory;

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

    // Tính tổng của một đơn
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

    // Khôi phục lại đơn hàng cho iventory khi đơn hàng bị xóa
    public void returnItemsToInventory() {
        for (OrderDetail detail : this.orderDetails) {
            Product product = detail.getProduct();
            int quantity = detail.getQuantity();
            Inventory.addInventory(product, quantity);
        }
    }

    public void displayOrder() {
        System.out.printf("│#%-6s   %-17s %11s VND│\n", displayFormat.formatID(getOrderID()),
            isOrderStatus() ? "<Da thanh toan>" : "<Chua thanh toan>",
                displayFormat.formatPrice(calculateTotal()));
    }
    // Hiển thị chi tiết đơn hàng
    public void displayOrderDetails() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.printf("│                 #%06d                   │\n", orderID);
        String customerName = (customer != null && customer.getName() != null) ? customer.getName() : "<N/A>";
        String customerPhone = (customer != null && customer.getPhone() != null) ? customer.getPhone() : "<xxxxxxxxxx>";
        System.out.printf("│Ten khach hang: %-27s│\n", customerName);
        System.out.printf("│So dien thoai:  %-27s│\n", customerPhone);
        System.out.println("│Ngay in don:   " + orderDate + "                  │");
        System.out.printf("│Trang thai:   %-28s │\n", (orderStatus ? "<Da thanh toan>" : "<Chua thanh toan>"));
        System.out.println("├───────────────────────────────────────────┤");
        for (OrderDetail detail : orderDetails) {
            System.out.printf("│#%03d-%-20s[x%02d]: %7s VND│\n", detail.getProduct().getProductID(),
                    detail.getProduct().getProductName(), detail.getQuantity(),
                    displayFormat.formatPrice(detail.calculateSubTotal()));
        }
        System.out.println("├───────────────────────────────────────────┤");
        System.out.printf("│Total:  %31s VND│\n", displayFormat.formatPrice(calculateTotal()));
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

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
}