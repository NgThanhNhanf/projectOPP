package Order;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class displayFormat {
    // format cho giá tiền
    public static String formatPrice(double number) {
        number *= 1000; // Thêm lại ba số 0
    
        // Thiết lập định dạng số với dấu chấm làm dấu phân cách hàng nghìn
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator('.');
    
        // Định dạng số với tối đa hai chữ số thập phân
        DecimalFormat df = new DecimalFormat("#,###.##", symbols);
        df.setGroupingUsed(true);
        return df.format(number);
    }

    //format cho ID
    public static String formatID(int number) {
        // Chuyển đổi số int thành chuỗi
        String strNumber = Integer.toString(number);
        while (strNumber.length() < 6) {
            strNumber = "0" + strNumber; // Thêm 0 vào trước
        }
        return strNumber;
    }
    
    // Format cho Tên
    public static String formatName(String name) {
        name = name.trim().replaceAll("\\s+", " ");
        while (name.length() < 25) {
            name += " ";
        }
        return name;
    }
}
