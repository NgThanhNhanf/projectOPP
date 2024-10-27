package Person;

import Order.Order; 
import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private String customerID; // ID khách hàng
    private List<Order> orderHistory; ///

    public Customer() {
        super();
        this.orderHistory = new ArrayList<>();
    }

    public Customer(String name, String phone) {
        super(name, phone);
    } 

    public Customer(String name, Birth dob, String address, String phone, String email, String customerID) {
        super(name, dob, address, phone, email);
        this.customerID = customerID;
        this.orderHistory = new ArrayList<>();
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void addOrderToHistory(Order order) {
        orderHistory.add(order);
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("│ Mã khách hàng   : %-24s │\n", this.customerID);
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("│         Lịch sử đơn hàng                 │");
        if (orderHistory.isEmpty()) {
            System.out.println("│ Không có đơn hàng nào                     │");
        } else {
            for (Order order : orderHistory) {
                System.out.println("│ Đơn hàng ID: " + order.getOrderID() + "                 │");
            }
        }
        System.out.println("└───────────────────────────────────────────┘");
    }
}