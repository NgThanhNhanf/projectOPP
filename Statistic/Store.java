package Statistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;

import Model.Product;
import Order.Orders;
import Order.Order;
import Model.Inventory;
import Model.Promotion;

public class Store {
    private static  LocalDate day;
    private static HashMap<Orders,Integer> statistic = new HashMap<>();
    private static List<Order> listOnDay = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static SimpleDateFormat sformat = new SimpleDateFormat("MM-yyyy");


    public static boolean isValid(String str) {
        try {
            LocalDate.parse(str,format);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public static  void statisticInDay() {
        sc.nextLine();
        //Thống kê theo ngày dựa trên ngày in đơn
        boolean check = false;
        String dayOrder;
        int totalInDay = 0;
        do {
            System.out.print("nhap ngay/thang/nam: ");
             dayOrder = sc.nextLine();
            if(!isValid(dayOrder)){
            System.out.println("du lieu ban nhap khong hop le!Vui long nhap lai");
            }
        }while(!isValid(dayOrder));
        day = LocalDate.parse(dayOrder,format);
        for(Order order : Orders.getOrders()){
            if(order.getOrderDate().isEqual(day) && order.isOrderStatus()){
                listOnDay.add(order);
                check = true;
            }
        }
        if(check) {
            System.out.println("Thong tin cac san pham ban dc trong ngay/thang/nam:" + dayOrder);
            for(Order it : listOnDay){
                it.displayOrder();
                totalInDay += it.calculateTotal();
            }
            System.out.println("Doanh thu trong ngay: " + dayOrder + " la: " + totalInDay + ".000 VND");
        }else {
            System.out.println("khong co don hang trong ngay");
            check = false;
        }
    }

    public static void statisticInMonth() {
        System.out.print("nhap thang-nam: ");
        String monthOfYear = sc.nextLine();
        String[] str = monthOfYear.split("-");
        int month = Integer.parseInt(str[0]);
        int year = Integer.parseInt(str[1]);
        int dayEnd = 1;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                dayEnd = 31;
                break;
            case 4 , 6, 9, 11:
                dayEnd = 30;
                break;
            case 2:
                dayEnd = 28;
                if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
                    dayEnd = 29;
                }
            default:
                break;
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