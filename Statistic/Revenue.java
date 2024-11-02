package Statistic;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;
import Order.*;
    // ----------lấy doanh thu theo ngày tháng năm-------------------
    // cho order đọc file trước sau đó thống kê sẽ lấy từ order
    // dùng tree map để lưu từng date (LocalDate) rồi dùng submap để có thể truy suất từng tháng năm
    // -----------lấy số lượng bán sp trong 1 thời gian nào đó-------------
    // dùng HashMap <String tên sp, SortedMap> SortedMap lưu theo ngày. SortedMap<LocalDate, int>
    // -----------lấy thống kê theo khách hàng--------------------
    // 
    //
    //
    //
public class Revenue {
    private static SortedMap <LocalDate, Integer> revenueMap = new TreeMap<>();
    private static HashMap<String, SortedMap<LocalDate, Integer>> quantityProductMap = new HashMap<>();
    // lấy các đơn hàng từ order để thống kê cho từng ngày
    public static void init() {
        for (Order cur : Orders.getOrders()) {
            revenueMap.put(cur.getOrderDate(), revenueMap.getOrDefault(cur.getOrderDate(), 0 ) + cur.calculateTotal());
            for(OrderDetail detail : cur.getOrderDetails()) {
                SortedMap<LocalDate, Integer> defaultMap = new TreeMap<>();
                SortedMap<LocalDate, Integer> quantity = quantityProductMap.getOrDefault(detail.getProduct().getProductName(), defaultMap);
                quantity.put(cur.getOrderDate(), quantity.getOrDefault(cur.getOrderDate(), 0) + detail.getQuantity());
                quantityProductMap.put(detail.getProduct().getProductName(), quantity);
            }
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
