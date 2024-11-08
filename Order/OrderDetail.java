package Order;
 
import Model.Product;

public class OrderDetail {
<<<<<<< HEAD
    private Order order; //Đơn hàng.
=======
>>>>>>> main
    private Product product; // Sản phẩm
    private int quantity; //số lượng

    // Constructor mặc định
    OrderDetail() {
    }

    // Constructor với các tham số
<<<<<<< HEAD
    OrderDetail(Order order, Product product, int quantity) {
        this.order = order;
=======
    OrderDetail(Product product, int quantity) {
>>>>>>> main
        this.product = product;
        this.quantity = quantity;
    }

    // Tính đơn giá
    public double calculateSubTotal() {
        return product.getPrice() * quantity;
    }
<<<<<<< HEAD

    // Lấy đơn hàng
    public Order getOrder() {
        return order;
    }

    // Thiết lập đơn hàng
    public void setOrder(Order order) {
        this.order = order;
    }

=======
    
>>>>>>> main
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