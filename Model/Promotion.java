package Model;

import File.fileWork;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Promotion implements fileWork {
    private static final String promoCode = "COLOANOOP"; // mã giảm giá duy nhất
    private static final LocalDate startDate = LocalDate.of(2024, 1, 1); // ngày bắt đầu mặc định
    private static final LocalDate endDate = LocalDate.of(2025, 1, 1);   // ngày kết thúc mặc định
    private static final HashMap<Integer, Integer> applicableProducts = new HashMap<>(); // <ProductID, DiscountValue>
    private static final Scanner sc = new Scanner(System.in);

    // Lấy mã giảm giá
    public static String getPromoCode() {
        return promoCode;
    }

    // Sửa phương thức getDiscountCode
    public static int getDiscountCode(int productID) {
        return applicableProducts.getOrDefault(productID, 0);
    }

    // Sửa phương thức inputDiscountCode để trả về giá trị discount
    public static int inputDiscountCode() {
        System.out.print("Nhap gia tri giam gia (gia tri la so phan tram): ");
        while (true) {
            try {
                int inputCode = sc.nextInt();
                if (inputCode >= 1 && inputCode <= 100) {
                    return inputCode;
                }
                throw new IllegalArgumentException("Gia tri ma giam dao dong tu (1 - 100)%.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Vui long nhap lai.");
            } catch (Exception e) {
                System.out.println("Gia tri khong hop le. Vui long nhap lai so nguyen.");
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

    // Thêm sản phẩm vào danh mục khuyến mãi với giá trị giảm giá cụ thể
    public static void addProductPromo(Product product, int discount) {
        int productID = product.getProductID();
        if (!applicableProducts.containsKey(productID)) {
            applicableProducts.put(productID, discount);
            System.out.println("San pham " + product.getProductName() + " da duoc them vao danh muc khuyen mai.");
        } else {
            System.out.println("San pham da ton tai trong danh muc khuyen mai.");
        }
    }

    // Xóa sản phẩm khỏi danh mục khuyến mãi
    public static void removeProductPromo(Product product) {
        int productID = product.getProductID();
        if (applicableProducts.containsKey(productID)) {
            applicableProducts.remove(productID);
            System.out.println("San pham" + product.getProductName() + " da duoc xoa khoi danh muc khuyen mai.");
        } else {
            System.out.println("San pham khong ton tai trong danh muc khuyen mai.");
        }
    }

    // Lấy danh sách sản phẩm áp dụng khuyến mãi
    public static HashMap<Integer, Integer> getApplicableProducts() {
        return new HashMap<>(applicableProducts);
    }

    // Sửa phương thức applyDiscount
    public static double applyDiscount(Product product) {
        if (isValidDay() && applicableProducts.containsKey(product.getProductID())) {
            int discount = applicableProducts.get(product.getProductID());
            return product.getPrice() * (1 - discount / 100.0);
        }
        return product.getPrice(); // Trả về giá cũ nếu không hợp lệ
    }

    // Hiển thị các sản phẩm trong danh mục khuyến mãi với giá trị giảm giá cụ thể
    public static void displayApplicableProducts() {
        System.out.printf("│ Ma giam gia: %-29s│\n", promoCode);
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("│ Cac san pham khuyen mai:                  │");
        if (applicableProducts.isEmpty()) {
            System.out.println("│   Khong co san pham khuyen mai            │");
        } else {
            for (Map.Entry<Integer, Integer> entry : applicableProducts.entrySet()) {
                Product product = Inventory.getProductByID(entry.getKey());
                if (product != null) {
                    System.out.printf("│ #%06d - %-27s %3d%%│\n", 
                        product.getProductID(), 
                        product.getProductName(), 
                        entry.getValue());
                }
            }
        }
        System.out.println("├───────────────────────────────────────────┤");
    }

    @Override
    public void readFile() throws FileNotFoundException {
        File file = new File("D:\\Workspace\\Test\\temp\\projectOPP\\Model\\promotion.txt");
        if (!file.exists()) return;
        Scanner scf = new Scanner(file);
        while (scf.hasNextLine()) {
            String line = scf.nextLine();
            String[] arr = line.split("\\|");
            applicableProducts.put(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
        scf.close();
    }

    @Override
    public void writeFile() throws IOException {
        FileWriter fw = new FileWriter("D:\\Workspace\\Test\\temp\\projectOPP\\Model\\promotion.txt");
        for (Map.Entry<Integer, Integer> entry : applicableProducts.entrySet()) {
            fw.write(entry.getKey() + "|" + entry.getValue() + "\n");
        }
        fw.close();
    }

    public static void fileInit() throws FileNotFoundException {
        Promotion promotion = new Promotion();
        promotion.readFile();
    }

    public static void fileClose() throws IOException {
        Promotion promotion = new Promotion();
        promotion.writeFile();
    }
}
