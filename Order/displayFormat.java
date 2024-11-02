package Order;

public class displayFormat {
    // format cho giá tiền
    public static String formatPrice(double number) {
        String strNumber = Double.toString(number);
        while (strNumber.length() < 11) {
            strNumber = "0" + strNumber; // Thêm 0 vào trước
        }
        return strNumber;
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
