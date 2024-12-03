package Order;
 
import Model.Product;
import Model.Promotion;

public class OrderDetail {
    private Product product; // Sản phẩm
    private int quantity; //số lượng
    private boolean hasPromotion; // Đánh dấu trạng thái giảm giá cho đơn hàng 

    // Constructor mặc định
    public OrderDetail() {
        hasPromotion = false; // Mặc định khởi tạo chưa áp dụng mã
    }

    // Constructor với các tham số
    public OrderDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.hasPromotion = false;
    }

    // Tính tổng món hàng 
    public double calculateSubTotal() {
        if (hasPromotion && Promotion.isValidDay()) {
            return Promotion.applyDiscount(product) * quantity;
        }
        return product.getPrice() * quantity;
    }

    public void applyPromotion() {
        this.hasPromotion = true;
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

    public boolean hasPromotion() {
        return hasPromotion;
    }

    public void setHasPromotion(boolean hasPromotion) {
        this.hasPromotion = hasPromotion;
    }
}