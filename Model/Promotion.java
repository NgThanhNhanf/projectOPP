package Model;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Promotion {
    private String promoCode; // mã giảm giá
    private double discountCode; // % giảm 
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Product> applicableProducts; // sản phẩm đc áp dụng mã giảm giá
    
    //lớp này để định dạng ngày và giờ(W3school)
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    //ofPattern: dùng để phân tách ngày và giờ và loại bỏ chữ T ở giữa 
    public Promotion(String promoCode,double discountCode,String beginDate,String lastDate){
        this.promoCode = promoCode;
        this.discountCode = discountCode;
        //hàm parse: dùng để chuyển đổi kiểu format(ngày giờ) ở trên sang dạng 1 chuỗi  
        this.startDate = LocalDateTime.parse(beginDate, format);
        this.endDate = LocalDateTime.parse(lastDate, format);
        this.applicableProducts = new ArrayList<>();
        //tạo 1 list các sản phẩm khuyến mãi
    }
    //lấy ra phần % giảm giá(thêm vào đây nếu lúc nào cần thôi)
    public double getDiscountCode(){
        return discountCode;
    }

    public void setDiscountCode(double discountCode){
        //kiểm tra cái % giảm giá có hợp lệ trong khoảng từ 0 -> 1
        if(discountCode < 0 && discountCode > 1) this.discountCode = 0;
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
            System.out.printf("║ %-35s %5.0f‰ ║\n",product.getProductName(), discountCode * 100);
        }
        System.out.println("╚════════════════════════════════════════════╝");
    }
    
}