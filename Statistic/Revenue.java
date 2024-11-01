package Statistic;

import java.time.LocalDate;
import java.util.SortedMap;
import java.util.TreeMap;
import Order.*;
    // cho order đọc file trước sau đó thống kê sẽ lấy từ order
    // dùng tree map để lưu từng date (LocalDate) rồi dùng submap để có thể truy suất từng tháng năm
    // dung mảng 3 chiều và 1 mảng động để chứa
    // dùng 3 lớp: 
    // + lớp năm chứa 12 tháng, và năm 
    // + lớp tháng thì chứa 31 ngày
    // + lớp ngày chứa ngày
public class Revenue {
    static SortedMap <LocalDate, Integer> revenueMap = new TreeMap<>();
    static SortedMap <LocalDate, OrderDetail> quantityProductMap = new TreeMap<>();
    // lấy các đơn hàng từ order để thống kê cho từng ngày
    public static void init() {
        for (Order cur : Orders.getOrders()) {
            revenueMap.put(cur.getOrderDate(), revenueMap.getOrDefault(cur.getOrderDate(), 0 ) + cur.getValue());
        }
    }
    // lấy doanh thu hóa đơn trong khoảng từ start đến end
    public static int getRevenueInRange(LocalDate start, LocalDate end) {
        int ans = 0;
        SortedMap <LocalDate, Integer> rangeMap = revenueMap.subMap(start, end);
        for (LocalDate cur : rangeMap.keySet()) {
            ans += rangeMap.get(cur);
        }
        return ans;
    }
    // lấy doanh thu hóa đơn trong 1 tháng nào đó
    public static int getRevenueInMonthRange(int month, int year) {
        int dayEnd = 1;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                dayEnd = 31;
                break;
            case 4, 6, 9, 11: 
                dayEnd = 30;
                break;
            case 2:
                dayEnd = 28;
                if ((year%4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    dayEnd = 29;
                }
                break;
            default:
                break;
        }
        return getRevenueInRange(LocalDate.of(year, month, 1), LocalDate.of(year, month, dayEnd));
    }
    // lấy doanh thu hóa đơn trong 1 năm nào đó
    public static int getRevenueInYearRange(int year) {
        return getRevenueInRange(LocalDate.of(year, 1, 1), LocalDate.of(year, 12, 31));
    }
}
