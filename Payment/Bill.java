package Payment;

import java.util.ArrayList;
import java.util.List;

import Model.Product;

public class Bill {
    private List<Product> listBill;

    public Bill(){
        listBill = new ArrayList<>();
    }

    public void addProductInBill(Product product){
      listBill.add(product);
    }
    public static void printBillHeader(String paymentMethod) {
        System.out.println("╔════════════╦═══════════════════════════════╦══════════╦════════════╗");
        System.out.printf("║   Hoa don thanh toan - %-15s            ║%n", paymentMethod.toUpperCase());
        System.out.println("╠════════════╦═══════════════════════════════╦══════════╦════════════╣");
        System.out.printf("║ %-10s ║ %-29s ║ %-8s ║ %-10s ║%n", 
                          "Ma sp", "Ten san pham", "So luong", "Gia(VND)");
        System.out.println("╠════════════╬═══════════════════════════════╬══════════╬════════════╣");
    }
    public double sumAllBill(){
        double total = 0;
        for(Product product : listBill){
            total += product.totalProduct();
        }
        return total;
    }
    public void printBillContent() {
        for (Product product : listBill) {
            System.out.printf("║ %-10s ║ %-29s ║ %-8d ║ %10.2f ║%n", 
                product.getProductID(), product.getProductName(), 
                product.getQuantilyPurchased(), product.totalProduct());
        }
    }

    public void printBillTotal() {
        System.out.println("╠════════════╩═══════════════════════════════╩══════════╩════════════╣");
        System.out.printf("║ Tong tien: %6.2f VND %n", sumAllBill());
    }
    public static void printBillFooter() {
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
        System.out.println("║       Cam on quy khach,hen gap lai!                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
    }

    public void inBill(String paymentMethod){
        printBillHeader(paymentMethod);
        printBillContent();
        printBillTotal();
        printBillFooter();
    }
}
