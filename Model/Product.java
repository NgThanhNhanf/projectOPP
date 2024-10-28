package Model;

import java.util.Scanner;

//Product : sản phẩm
public abstract class Product {
    private int productID;
    private String productName;
    private double price;
    private int stock;
    private int quantilyPurchased; //số lượng mua
   Scanner sc = new Scanner(System.in);

   public Product() {

   }

    public Product(int productID,String productName,double price,int stock){
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.stock = stock; //stock: số lượng tồn kho của sản phẩm
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getQuantilyPurchased(){
        return quantilyPurchased;
    }
    //phương thức trừu tượng in thông tin sản phẩm
    public abstract void inp();

    //xuất thông tin sản phẩm
    public  boolean addProductInCart(Scanner sc){
        System.out.print("nhap so luong mua san pham " + productName + ": ");
        //nhập số lượng sản phẩm cần mua 
        int quantity = sc.nextInt();
        //kiểm tra kiểu vdu mình nhập số lượng  là 10 thì suy ra tồn kho sẽ giảm 10 nhưng nếu số lượng mua > tồn kho -> lỗi
        if(!updateStock(-quantity)){
            System.out.print("so luong mua khong hop le! ton kho: " + stock);
            return false;
        }
        //gán số lượng cho cái số lượng mua để lúc in ra bill có thể tính tổng đc 
        quantilyPurchased = quantity;
        return true;
    }
    //in thong tin full cua san pham trong kho hang
    public void displayInfor(){
        System.out.println("Ma san pham " + getProductID() + "\nTen san pham: " + getProductName() + "\nso luong mua: " + getQuantilyPurchased());

    }
    //in thong tin can thiet cua san pham trong hoa don thanh toan
    public void inforBill(){
        System.out.println("\nMa san pham: " + getProductID() + "\nten san pham: " + getProductName() + "\nso luong mua: " + getQuantilyPurchased());
    }

    //hàm này để tính tổng  sản phẩm mình mua (in trong bill)
    public double totalProduct(){
        return this.getQuantilyPurchased() * this.getPrice();
    }

    //quanlity : số lượng sản phẩm đc thêm vào hoặc bán đi
    public boolean updateStock(int quantity) {
        if(quantity == 0){
            System.out.println("So luong ton kho khong thay doi"); return false;    
        }
        //kiem tra so luong nhap vao co hop le hay khong
        else if(quantity < 0 && stock + quantity < 0 ){
            System.out.println("So luong ton kho < 0!!!!!");
            return false;
        }
        //neu hop le => tang so luong ton kho len
        stock += quantity;
        return true;
    }
}
