package Model;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
// import Order.*;

import java.util.Scanner;

public class Promotion {
    private String promoCode; // mã giảm giá
    private double discountCode; // % giảm 
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Product> applicableProducts; // sản phẩm đc áp dụng mã giảm giá

    //lớp này để định dạng ngày và giờ(W3school)
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //ofPattern: dùng để phân tách ngày và giờ và loại bỏ chữ T ở giữa 
    Scanner sc = new Scanner(System.in);
    public Promotion(){
        this.applicableProducts = new ArrayList<>();
    }
    public Promotion(String promoCode,double discountCode){
        this.promoCode = promoCode;
        this.discountCode = discountCode;
        this.applicableProducts = new ArrayList<>();
        //tạo 1 list các sản phẩm khuyến mãi
    }

    public static boolean isValidformat(String str){
        try {
            LocalDateTime.parse(str, format);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public void inpPromocodeandDiscount(){
        System.out.println("nhap ma giam gia: ");
        setPromoCode(sc.nextLine());
        System.out.println("nhap phan tram giam gia: ");
        setDiscountCode(sc.nextDouble());
        sc.nextLine();
    }
    public void inpDate(){
        String beginDate;
        do {
            System.out.println("han bat dau: ");
            beginDate = sc.nextLine();
            if(!isValidformat(beginDate)){
                System.out.println("dinh dang ngay khong hop le!Vui long nhap lai: ");
            }
        } while (!isValidformat(beginDate));
        this.startDate = LocalDateTime.parse(beginDate, format);

        String lastDate;
        do {
            System.out.println("han ket thuc: ");
            lastDate = sc.nextLine();
            if(!isValidformat(lastDate)){
                System.out.println("dinh dang ngay khong hop le!Vui long nhap lai: ");
            }
        } while (!isValidformat(lastDate));
        this.endDate = LocalDateTime.parse(lastDate, format);
    }

    public LocalDateTime getStartDate(){
        return startDate;
    }

    public LocalDateTime getEndDate(){
        return endDate;
    }
    
    //lấy ra phần % giảm giá(thêm vào đây nếu lúc nào cần thôi)
    public double getDiscountCode(){
        return discountCode;
    }

    public void setDiscountCode(double discountCode){
        if(discountCode < 0 && discountCode > 100) this.discountCode = 0;
        //kiểm tra cái % giảm giá có hợp lệ trong khoảng từ 0 -> 1ountCode = 0;
        else this.discountCode = discountCode;
    }

    public String getPromoCode(){
        return promoCode;
    }

    public void setPromoCode(String promoCode){
        this.promoCode = promoCode;
    }

    //thêm vào nếu lúc nào cần truy xuất đến cái list
    public List<Product> getApplicableProducts(){
        return applicableProducts;
    }

   public  boolean isvalidDay(){
    //hàm now() để lấy ra cái ngày giờ hiện tại 
    LocalDateTime day = LocalDateTime.now();
    if(startDate == null || endDate == null || (startDate == null && endDate == null)){
        System.out.println("ngay bat dau va ket thuc chua duoc khoi tao"); return false;
    }
    //day là cái ngày hiện tại thì kiểm tra nó có nằm trong khoảng ngày khuyến mãi hay không 
    return !day.isBefore(startDate) && !day.isAfter(endDate); 
    }
    //thêm sản phẩm vào danh mục khuyến mãi 
    public void addProductPromo(Product product){
        //contains: kiểm tra xem trong cái list sản phẩm khuyến mãi đã có hay chưa 
        if(!applicableProducts.contains(product)){
            applicableProducts.add(product);
            System.out.println("san pham " + product.getProductName() + " duoc them vao danh muc giam gia");
        }else{
            System.out.println("san pham da co trong danh muc giam gia");
        }
    }
    //xóa sản phẩm ra khỏi danh mục khuyến mãi 
    public void removeProductPromo(Product product){
        if(applicableProducts.remove(product)){
            System.out.println("san pham " + product.getProductName() + " da duoc xoa khoi danh muc khuyen mai");
        }else{
            System.out.println("san pham khong co trong danh muc khuyen mai");
        }
    }
    //áp dụng % khuyến mãi vào sản phẩm
    public double applyDiscount(Product product){
        //kiểm tra ngày hợp lệ và sp có trong list
        if(isvalidDay() && applicableProducts.contains(product)){
            //sp khuyến mãi = giá sp gốc * (1- %khuyến mãi)
            return product.getPrice() * (1 - this.discountCode/100.0);
        }
        //trả về giá sản phẩm sau khi khuyến mãi 
        return product.getPrice();
    }

    public void displayApplicableProducts() {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.printf("║ Ma giam gia: %-24s      ║\n", promoCode);  
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ Cac San pham khuyen mai:                   ║");
        
        for (Product product : applicableProducts) {
            System.out.println("╠────────────────────────────────────────────╣");
            System.out.printf("║ %-35s %5.0f‰ ║\n",product.getProductName(), discountCode);
        }
        System.out.println("╚════════════════════════════════════════════╝");
    }

    
}