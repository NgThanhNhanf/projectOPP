package Model;

import java.util.InputMismatchException;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        while(true) {
            if(price >= 0) {
                this.price = price;
                break;
            }else {
              System.err.println("Gia tien phai lon hon 0");
            }
        }
    }
    //phương thức trừu tượng nhap thông tin sản phẩm
    public abstract void inp();
    //in thong tin full cua san pham trong kho hang
    public void displayInfor(){
        System.out.printf("│#%06d - %-25s",getProductID(), getProductName());
    }

    public void editProductID(){
        System.out.print("Id: ");
        int newID;
        do {
            try {
                newID = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
            }
        } while (true);
            
        setProductID(newID);
        System.out.print("Thay doi thanh cong");
    }

    public void editProductName(){
        System.out.print("Ten: ");
        String newName = sc.nextLine();
        setProductName(newName);
        System.out.print("thay doi thanh cong");
    }
    public void editProductPrice() {
        System.out.print("Gia: ");

        int newPrice;
        do {
            try {
                newPrice = sc.nextInt();
                if(newPrice >= 0) {
                    this.price = newPrice;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
            }
        } while (true);

        setPrice(newPrice);
        System.out.print("Thay doi thanh cong");

    }
    public abstract void editALLAttributeProduct();
    public abstract void editProduct();
}
