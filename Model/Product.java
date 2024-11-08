package Model;

<<<<<<< HEAD
public class Product {
    private int productID;
    private String productName;
    private double price;
    private int stock;

    // Constructor mặc định
    public Product() {}

    // Constructor với các tham số
    public Product(int productID, String productName, double price, int stock) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    // Lấy mã sản phẩm
=======
import java.util.Scanner;

//Product : sản phẩm
public abstract class Product {
    private int productID;
    private String productName;
    private int price;
   Scanner sc = new Scanner(System.in);

   public Product() {}

    public Product(int productID, String productName, int price){
        this.productID = productID;
        this.productName = productName;
        this.price = price;
     }
    //getter & setter cho cac attribute
>>>>>>> main
    public int getProductID() {
        return productID;
    }

    // Thiết lập mã sản phẩm
    public void setProductID(int productID) {
        this.productID = productID;
    }

    // Lấy tên sản phẩm
    public String getProductName() {
        return productName;
    }

    // Thiết lập tên sản phẩm
    public void setProductName(String productName) {
        this.productName = productName;
    }

<<<<<<< HEAD
    // Lấy giá sản phẩm
    public double getPrice() {
        return price;
    }

    // Thiết lập giá sản phẩm
    public void setPrice(double price) {
        this.price = price;
    }

    // Lấy số lượng tồn kho
    public int getStock() {
        return stock;
    }

    // Thiết lập số lượng tồn kho
    public void setStock(int stock) {
        this.stock = stock;
    }

    // Hiển thị thông tin sản phẩm
    public void displayInfor() {
        System.out.println("Thong tin san pham : ");
        System.out.println("Ma san pham: " + getProductID() + "\nTen san pham: " + getProductName() + "\nGia tien: " + getPrice() + "\nSo luong ton kho: " + getStock());
    }

    // Cập nhật số lượng tồn kho
    public boolean updateStock(int quantity) {
        int newStock = this.stock + quantity;
        if (newStock < 0) {
            System.out.println("so luong ton kho khong hop le!!");
            return false;
        } else {
            this.stock = newStock;
            return true;
        }
    }

    // Phương thức toString để hiển thị thông tin sản phẩm
    @Override
    public String toString() {
        return "Ma san pham: " + getProductID() + ", Ten san pham: " + getProductName() + ", Gia tien: " + getPrice() + ", So luong ton kho: " + getStock();
    }
}
=======
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //phương thức trừu tượng nhap thông tin sản phẩm
    public abstract void inp();
    //in thong tin full cua san pham trong kho hang
    public void displayInfor(){
        System.out.println("Ma san pham " + getProductID() + "\nTen san pham: " + getProductName() + "\nDon gia: " + getPrice());
    }

    public void editProductID(){
        System.out.print("new id: ");
        int newID = sc.nextInt();
        setProductID(newID);
        System.out.print("Thay doi thanh cong");
    }

    public void editProductName(){
        System.out.print("new name: ");
        String newName = sc.nextLine();
        setProductName(newName);
        System.out.print("thay doi thanh cong");
    }
    public void editProductPrice() {
        System.out.print("new price: ");
        int newPrice = sc.nextInt();
        setPrice(newPrice);
        System.out.print("thay doi thanh cong");

    }
    public abstract void editALLAttributeProduct();
    public abstract void editProduct();
}
>>>>>>> main
