package Model;

import java.util.Scanner;

//Product : sản phẩm
public abstract class Product {
    private int productID;
    private String productName;
    private double price;
    private int quantilyPurchased; //số lượng mua
   Scanner sc = new Scanner(System.in);

   public Product() {
        
   }

    public Product(int productID,String productName,double price,int stock){
        this.productID = productID;
        this.productName = productName;
        this.price = price;
     }
    //getter & setter cho cac attribute
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantilyPurchased(){
        return quantilyPurchased;
    }
    //phương thức trừu tượng nhap thông tin sản phẩm
    public abstract void inp();
    //in thong tin full cua san pham trong kho hang
    public void displayInfor(){
        System.out.println("Ma san pham " + getProductID() + "\nTen san pham: " + getProductName() + "\nSo luong ton: " + getStock());

    }
    //in thong tin can thiet cua san pham trong hoa don thanh toan
    public void inforBill(){
        System.out.println("\nMa san pham: " + getProductID() + "\nten san pham: " + getProductName() + "\nso luong mua: " + getQuantilyPurchased());
    }

    //hàm này để tính tổng  sản phẩm mình mua (in trong bill)
    public double totalProduct(){
        return this.getQuantilyPurchased() * this.getPrice();
    }
}
