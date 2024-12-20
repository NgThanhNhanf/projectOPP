package Statistic;

import Order.Order;
import Order.Orders;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;
import java.util.ArrayList;
// import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Store {
    private static  LocalDate day;
    // private static HashMap<Integer,List<Order>> listOnQuarter = new HashMap<>();
    private static List<Order> listOnDay = new ArrayList<>();
    private static List<Order> listOnMonth = new ArrayList<>();
    private static List<Order> listOnYear = new ArrayList<>();
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
        //Thống kê theo ngày dựa trên ngày in đơn
        boolean checkDay = false;
        String dayOrder;
        int totalInDay = 0;
        do {
            System.out.print("nhap ngay-thang-nam: ");
             dayOrder = sc.nextLine();
            if(!isValid(dayOrder)){
            System.out.println("du lieu ban nhap khong hop le!Vui long nhap lai");
            }
        }while(!isValid(dayOrder));
        day = LocalDate.parse(dayOrder,format);
        for(Order order : Orders.getOrders()){
            if(order.getOrderDate().isEqual(day) && order.isOrderStatus()){
                listOnDay.add(order);
                checkDay = true;
            }
        }
        if(checkDay) {
            System.out.println("Thong tin cac san pham ban dc trong " + dayOrder +": ");
            for(Order it : listOnDay){
                it.displayOrder();
                totalInDay += it.calculateTotal();
            }
            listOnDay.clear();
            System.out.println("Doanh thu trong ngay: " + dayOrder + " la: " + totalInDay + ".000 VND");
        }else {
            System.out.println("khong co don hang trong ngay");
            checkDay = false;
        }
    }

    public static void statisticInMonth() {
        System.out.print("nhap thang-nam: ");
        String monthOfYear = sc.nextLine();
        String[] str = monthOfYear.split("-");
        int month = Integer.parseInt(str[0]);
        int year = Integer.parseInt(str[1]);
        
        boolean checkMonth = false;
        for(Order order : Orders.getOrders()) {
            String time = order.getOrderDate().toString();
            String[] moy = time.split("-");
            if(moy.length == 3) {
                int m = Integer.parseInt(moy[1]);
                int y = Integer.parseInt(moy[0]);
                if(m == month && y == year && order.isOrderStatus()) {
                    listOnMonth.add(order);
                    checkMonth = true;
                }
            }
            
        }

        int totalInMonth = 0;
        if(checkMonth) {
            System.out.println("thong tin cac san pham ban dc trong thang " + month + " nam " + year+ ": ");
            for(Order it : listOnMonth) {
                it.displayOrder();
                totalInMonth += it.calculateTotal();
            }
            listOnMonth.clear();
            System.out.println("doanh thu trong thang " + month + " nam " + "la: " + totalInMonth + ".000 VND");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        }else {
            System.out.println("khong co don hang trong thang");
            checkMonth = false;
        }
    }

    public static void statisticInYear() {
        System.out.println("nhap nam: ");
        int year;
        do {
            try {
                year = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
            }
        } while (true);
            
        if(year < 2000) {
            System.out.println("vui long nhap nam > 2000");
        }

        boolean checkYear = false;
        for(Order order : Orders.getOrders()) {
            String time = order.getOrderDate().toString();
            String[] ye = time.split("-");
            int y = Integer.parseInt(ye[0]);
            if(y == year && order.isOrderStatus()) {
                listOnYear.add(order);
                checkYear = true;
            }
        }

        int totalInYear = 0;
        if(checkYear) {
            for(Order it : listOnYear) {
                it.displayOrder();
                totalInYear += it.calculateTotal();
            }
            listOnYear.clear();
            System.out.println("doanh thu trong nam " + year + " la: " + totalInYear + ".000 VND");
        }else {
            System.out.println("khong co don hang nao trong nam " + year);
            checkYear = false;
        }
    }
    

    public static void statistic() {
        boolean isStatistic = false;
        while(!isStatistic) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│      Chon cach thong ke                   │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1.Thong ke theo ngay                      │");
            System.out.println("│ 2.Thong ke theo thang                     │");
            System.out.println("│ 3.Thong ke theo nam                       │");
            System.out.println("│ 4.Thoat                                   │");
            System.out.println("├───────────────────────────────────────────┤");
            int choice;
            System.out.print("Nhap lua chon: ");
            do {
                try {
                    choice = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                    sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                }
            } while (true);

            switch (choice) {
                case 1:
                sc.nextLine();
                    statisticInDay();
                    break;
                case 2:
                    sc.nextLine();
                    statisticInMonth();
                    break;
                case 3:
                    sc.nextLine();
                    statisticInYear();
                    break;
                case 4:
                    System.out.println("thoat");
                    isStatistic = true;
                    break;
                default:
                    break;
            }
        }
    }
}