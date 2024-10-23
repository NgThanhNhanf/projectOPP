package Order;

import Model.Product;

public class OrderDetail {
    private Order order; //Đơn hàng.
    private Product product; // Sản phẩm
    private int quantity; //số lượng

    OrderDetail() {
    }

    OrderDetail(Order order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    // Tính đơn giá
    public double calculateSubTotal() {
        return product.getPrice() * quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}