package Person;

import java.util.List;
import java.util.Scanner;

import Order.Order;

import java.util.ArrayList;

public class Customer extends Person {
    private List<Order> orderHistory; 
    Scanner sc = new Scanner(System.in);
    public Customer(){
        orderHistory = new ArrayList<>();
    }
    public Customer(String name, Birth dob, String address, String phone, String email) {
        super(name, dob, address, phone, email);
    }
    //  problem: order have customer and customer have order too
    public void displayHistoryOrder() {
        
    }
}
