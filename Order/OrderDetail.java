package Order;
 
import Model.Product;

public class OrderDetail {
    private Order order; //Đơn hàng.
    private Product product; // Sản phẩm
    private int quantity; //số lượng

    // Constructor mặc định
    OrderDetail() {
    }

    // Constructor với các tham số
    OrderDetail(Order order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    // Tính đơn giá
    public double calculateSubTotal() {
        return product.getPrice() * quantity;
    }

    // Lấy đơn hàng
    public Order getOrder() {
        return order;
    }

    // Thiết lập đơn hàng
    public void setOrder(Order order) {
        this.order = order;
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