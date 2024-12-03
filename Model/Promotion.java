package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Promotion {
    private static final String promoCode = "COLOANOOP"; // mã giảm giá duy nhất
    private static int discountCode = 0; // % giảm giá
    private static final LocalDate startDate = LocalDate.of(2024, 1, 1); // ngày bắt đầu mặc định
    private static final LocalDate endDate = LocalDate.of(2025, 1, 1);   // ngày kết thúc mặc định
    private static final List<Product> applicableProducts = new ArrayList<>(); // sản phẩm áp dụng mã giảm giá
    private static final Scanner sc = new Scanner(System.in);

    // Lấy mã giảm giá
    public static String getPromoCode() {
        return promoCode;
    }

    // Lấy % giảm giá
    public static int getDiscountCode() {
        return discountCode;
    }

    // Đặt % giảm giá với kiểm tra hợp lệ
    public static void setDiscountCode(int newDiscountCode) {
        if (newDiscountCode >= 1 && newDiscountCode <= 100) {
            discountCode = newDiscountCode;
        } else {
            throw new IllegalArgumentException("Mã giảm giá phải từ 1 đến 100.");
        }
    }

    // Hỗ trợ nhập mã giảm giá từ bàn phím
    public static void inputDiscountCode() {
        System.out.print("Nhập mã giảm giá: ");
        while (true) {
            try {
                int inputCode = sc.nextInt();
                setDiscountCode(inputCode); // Gọi setter để kiểm tra
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Giá trị không hợp lệ. Vui lòng nhập số nguyên.");
                sc.nextLine(); // Xóa bộ đệm
            }
        }
    }

    // Lấy ngày bắt đầu
    public static LocalDate getStartDate() {
        return startDate;
    }

    // Lấy ngày kết thúc
    public static LocalDate getEndDate() {
        return endDate;
    }

    // Kiểm tra ngày hiện tại có hợp lệ trong thời gian khuyến mãi không
    public static boolean isValidDay() {
        LocalDate today = LocalDate.now();
        return !today.isBefore(startDate) && !today.isAfter(endDate);
    }

    // Thêm sản phẩm vào danh mục khuyến mãi
    public static void addProductPromo(Product product) {
        if (!applicableProducts.contains(product)) {
            applicableProducts.add(product);
            System.out.println("Sản phẩm " + product.getProductName() + " đã được thêm vào danh mục khuyến mãi.");
        } else {
            System.out.println("Sản phẩm đã tồn tại trong danh mục khuyến mãi.");
        }
    }

    // Xóa sản phẩm khỏi danh mục khuyến mãi
    public static void removeProductPromo(Product product) {
        if (applicableProducts.remove(product)) {
            System.out.println("Sản phẩm " + product.getProductName() + " đã được xóa khỏi danh mục khuyến mãi.");
        } else {
            System.out.println("Sản phẩm không tồn tại trong danh mục khuyến mãi.");
        }
    }

    // Lấy danh sách sản phẩm áp dụng khuyến mãi
    public static List<Product> getApplicableProducts() {
        return new ArrayList<>(applicableProducts);
    }

    // Áp dụng % giảm giá cho sản phẩm
    public static double applyDiscount(Product product) {
        if (isValidDay() && applicableProducts.contains(product)) {
            return product.getPrice() * (1 - discountCode / 100.0);
        }
        return product.getPrice(); // Trả về giá cũ nếu không hợp lệ
    }

    // Hiển thị các sản phẩm trong danh mục khuyến mãi
    public static void displayApplicableProducts() {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.printf("║ Mã giảm giá: %-24s      ║\n", promoCode);
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ Các sản phẩm khuyến mãi:                   ║");

        for (Product product : applicableProducts) {
            System.out.println("╠────────────────────────────────────────────╣");
            System.out.printf("║ %-35s %d %% ║\n", product.getProductName(), discountCode);
        }
        System.out.println("╚════════════════════════════════════════════╝");
    }
}
