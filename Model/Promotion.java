package Model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
// import Order.*;

import java.util.Scanner;

public class Promotion {
    private static final String promoCode = "CoLoanOOP"; // mã giảm giá
    private static  int discountCode; // % giảm 
    private static final LocalDate startDate = LocalDate.of(2024,01,01);
    private static final LocalDate endDate = LocalDate.of(2025,01,01);
    private static List<Product> applicableProducts = new ArrayList<>(); // sản phẩm đc áp dụng mã giảm giá

    //lớp này để định dạng ngày và giờ(W3school)
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //ofPattern: dùng để phân tách ngày và giờ và loại bỏ chữ T ở giữa 
    static  Scanner sc = new Scanner(System.in);

    public static boolean isValidformat(String str){
        try {
            LocalDate.parse(str, format);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }
    
    //lấy ra phần % giảm giá(thêm vào đây nếu lúc nào cần thôi)
    public double getDiscountCode(){
        return discountCode;
    }

    public String getPromoCode(){
        return promoCode;
    }
    //thêm vào nếu lúc nào cần truy xuất đến cái list
    public static List<Product> getApplicableProducts(){
        return applicableProducts;
    }

    public static void nhapDiscountCode() {
        System.out.print("nhap ma giam gia: ");
     do {
        try {
            discountCode = sc.nextInt();
            if(discountCode >= 1 && discountCode <= 100) {
                break;
            }else {
                System.out.println("ma giam gia phai tu 0-> 100!");
            }
        } catch(Exception e) {
            System.out.println("lua chon chi bao gom so nguyen!Vui long nhap lai");
        }
     } while(true);
    }

   public static  boolean isvalidDay(){
    //hàm now() để lấy ra cái ngày giờ hiện tại 
    LocalDate day = LocalDate.now();
    if(startDate == null || endDate == null || (startDate == null && endDate == null)){
        System.out.println("ngay bat dau va ket thuc chua duoc khoi tao"); return false;
    }
    //day là cái ngày hiện tại thì kiểm tra nó có nằm trong khoảng ngày khuyến mãi hay không 
    return !day.isBefore(startDate) && !day.isAfter(endDate); 
    }
    //thêm sản phẩm vào danh mục khuyến mãi 
    public static void addProductPromo(Product product){
        //contains: kiểm tra xem trong cái list sản phẩm khuyến mãi đã có hay chưa 
        if(!applicableProducts.contains(product)){
            applicableProducts.add(product);
            System.out.println("san pham " + product.getProductName() + " duoc them vao danh muc giam gia");
        }else{
            System.out.println("san pham da co trong danh muc giam gia");
        }
    }
    //xóa sản phẩm ra khỏi danh mục khuyến mãi 
    public static  void removeProductPromo(Product product){
        if(applicableProducts.remove(product)){
            System.out.println("san pham " + product.getProductName() + " da duoc xoa khoi danh muc khuyen mai");
        }else{
            System.out.println("san pham khong co trong danh muc khuyen mai");
        }
    }
    //áp dụng % khuyến mãi vào sản phẩm
    public static  double applyDiscount(Product product){
        //kiểm tra ngày hợp lệ và sp có trong list
        if(isvalidDay() && applicableProducts.contains(product) && (discountCode >= 1 && discountCode <= 100)){
            //sp khuyến mãi = giá sp gốc * (1- %khuyến mãi)
            return product.getPrice() * (1 - discountCode/100.0);
        }
        //trả về giá sản phẩm sau khi khuyến mãi 
        return product.getPrice();
    }

    public static void displayApplicableProducts() {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.printf("║ Ma giam gia: %-24s      ║\n", promoCode);  
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ Cac San pham khuyen mai:                   ║");
        
        for (Product product : applicableProducts) {
            System.out.println("╠────────────────────────────────────────────╣");
            System.out.printf("║ %-35s %d ║\n",product.getProductName(), discountCode);
        }
        System.out.println("╚════════════════════════════════════════════╝");
    }

    
}