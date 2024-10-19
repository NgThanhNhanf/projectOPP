package Payment;

public class Bill {
    public static void printBill(String paymentMethod) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.printf("║      HÓA ĐƠN THANH TOÁN                    ║\n", paymentMethod.toUpperCase());
        System.out.println("╠════════════════════════════════════════════╣");
    }
    public static void printBillDetails(double priceItem, double amount, double change) {
        System.out.println("║  Giá sản phẩm  : " + priceItem + "                  ║");
        System.out.println("║  Tiền khách đưa: " + amount + "                  ║");
        System.out.println("║  Tiền thối lại : " + change + "                   ║");
    }

    public static void printBillFooter() {
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║      CẢM ƠN QUÝ KHÁCH, HẸN GẶP LẠI!        ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }

}
