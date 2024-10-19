package Model;

//Product : sản phẩm
public class Product {
    private int productID;
    private String productName;
    private double price;
    private static int stock;

    public Product() {

    }

    public Product(int productID,String productName,double price,int stock){
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.stock = stock; //stock: số lượng tồn kho của sản phẩm
    }

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

    public static int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void displayInfor(){
        System.out.println("thông tin sản phẩm : ");
        System.out.println("Mã sản phẩm: " + getProductID() + "\nTên sản phẩm: " + getProductName() + "\nGiá tiền: " + getPrice() + "\nSố lượng tồn kho: " + getStock());

    }
    //quanlity : số lượng sản phẩm đc thêm vào hoặc bán đi

    public static boolean updateStock(int quantily) {
        int newStock = getStock();
        if(quantily > 0){
            newStock += quantily;
        }else if(quantily < 0){
            newStock -= quantily;
        }
        if(newStock < 0){
            System.out.println("số lượng tồn kho không hợp lệ!!");
            return false;
        }
        else return true;
    }
}
