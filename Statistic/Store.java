package Statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.time.*;
import java.time.format.*;

import Model.Product;
import Order.Orders;
import Order.Order;
import Model.Inventory;
import Model.Promotion;

public class Store {
    private LocalDate day;
    private static HashMap<Orders,Integer> statistic = new HashMap<>();
    private static List<Order> listOnDay = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static boolean isValidDay(String str) {
        try {
            LocalDate.parse(str,format);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public  void statisticInDay() {
        //Thống kê theo ngày dựa trên ngày in đơn
        String dayOrder;
        do {
            System.out.print("nhap ngay/thang ");
             dayOrder = sc.nextLine();
            if(!isValidDay(dayOrder)){
            System.out.println("du lieu ban nhap khong hop le!Vui long nhap lai");
            }
        }while(!isValidDay(dayOrder));
        this.day = LocalDate.parse(dayOrder,format);
        for(Order order : Orders.getOrders()){
            if(order.getOrderDate().isEqual(day) && order.isOrderStatus()){
                listOnDay.add(order);
            }
        }   
    }

    public static void solve() {
        boolean isStatistic = false;
        while(!isStatistic) {
            System.out.println("Chon cach thong ke");
            System.out.println("1.Thong ke theo ngay");
            System.out.println("2.Thong ke theo thang");
            System.out.println("3.thong ke theo nam");
            int choice;
            System.out.print("nhap lua chon: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    statisticInDay();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
    }
}
