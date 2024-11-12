package Order;
 
import Model.Product;

public class OrderDetail {
    private Product product; // Sản phẩm
    private int quantity; //số lượng

    // Constructor mặc định
    OrderDetail() {
    }

    // Constructor với các tham số
    OrderDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Tính tổng món hàng
    public double calculateSubTotal() {
        return product.getPrice() * quantity;
    }
    
    // Lấy sản phẩm
    public Product getProduct() {
        return product;
    }

    // Thiết lập sản phẩm
    public void setProduct(Product product) {
        this.product = product;
    }
    
    // Lấy số lượng
    public int getQuantity() {
        return quantity;
    }

    // Thiết lập số lượng
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}