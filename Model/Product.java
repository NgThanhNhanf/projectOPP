package Model;

//Product : sản phẩm
public class Product {
    private int productID;
    private String productName;
    private double price;
    private int stock;
   
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
    
    public void displayInfor(){
        System.out.println("Ma san pham " + getProductID() + "\nTen san pham: " + getProductName() + "\nGia tien: " + getPrice() + "\nSo luong ton kho: " + getStock());

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
