package Payment;

import Model.Product;

public class Bill {
    public static void printBill(String paymentMethod) {
        System.out.println("╔════════════════════════════════════════════╗");
        //toUpperCase(): in hoa cái loại thanh toán mình chọn(tiền mặt -> TIỀN MẶT)
        System.out.printf("║      HOA DON THANH TOAN - %-15s  ║%n", paymentMethod.toUpperCase());
        System.out.println("╠════════════════════════════════════════════╣");
    }
    
    public static void printBillDetails(double priceItem, double amount, double change, Product product) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.printf("║  Ma san pham  : %15s            ║%n", product.getProductID());  // ID sản phẩm
        System.out.printf("║  Ten san pham : %15s            ║%n", product.getProductName()); // Tên sản phẩm
        System.out.printf("║  Gia san pham : %15.2f VND        ║%n", priceItem);  // Giá sản phẩm
        System.out.printf("║  Tien khach dua: %15.2f VND       ║%n", amount);  // Tiền khách đưa
        System.out.printf("║  Tiền tra lai : %15.2f VND        ║%n", change);  // Tiền trả lại
        System.out.println("╚════════════════════════════════════════════╝");
    }
    
    
    public static void printBillFooter() {
        System.out.printf("║      CAM ON QUY KHACH, HEN GAP LAI!        ║%n");
        System.out.println("╚════════════════════════════════════════════╝");
    }
    

}
