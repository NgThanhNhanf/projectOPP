package Model;

import java.util.Scanner;

//Product : sản phẩm
public abstract class Product {
    private int productID;
    private String productName;
    private double price;
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
    //phương thức trừu tượng nhap thông tin sản phẩm
    public abstract void inp();
    //in thong tin full cua san pham trong kho hang
    public void displayInfor(){
        System.out.println("Ma san pham " + getProductID() + "\nTen san pham: " + getProductName() + "\nDon gia: " + getPrice());
    }
}
