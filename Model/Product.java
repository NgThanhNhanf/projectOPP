package Model;

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