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

    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Promotion(String promoCode,double discountCode,String beginDate,String lastDate){
        this.promoCode = promoCode;
        this.discountCode = discountCode;
        this.startDate = LocalDateTime.parse(beginDate, format);
        this.endDate = LocalDateTime.parse(lastDate, format);
        this.applicableProducts = new ArrayList<>();
    }
    //addProduct,removeProduct,isvalidDay,displayApplicableProducts, applyDiscount
    public double getDiscountCode(){
        return discountCode;
    }

    public void setDiscountCode(double discountCode){
        if(discountCode < 0 && discountCode > 1) this.discountCode = 0;
        else this.discountCode = discountCode;
    }

    public String getPromoCode(){
        return promoCode;
    }

    public void setPromoCode(String promoCode){
        this.promoCode = promoCode;
    }

    public List<Product> getApplicableProducts(){
        return applicableProducts;
    }

   public  boolean isvalidDay(){
    LocalDateTime day = LocalDateTime.now();
    return !day.isBefore(startDate) && !day.isAfter(endDate); 
    }

    public void addProductPromo(Product product){
        if(!applicableProducts.contains(product)){
            applicableProducts.add(product);
            System.out.println("san pham " + product.getProductName() + " duoc them vao danh muc giam gia");
        }else{
            System.out.println("san pham da co trong danh muc giam gia");
        }
    }

    public void removeProductPromo(Product product){
        if(applicableProducts.remove(product)){
            System.out.println("san pham " + product.getProductName() + " da duoc xoa khoi danh muc khuyen mai");
        }else{
            System.out.println("san pham khong co trong danh muc khuyen mai");
        }
    }

    public double applyDiscount(Product product){
        if(isvalidDay() && applicableProducts.contains(product)){
            return product.getPrice() * (1 - this.discountCode/100.0);
        }
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