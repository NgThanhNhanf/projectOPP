package Model;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> listInventory;

    // Khởi tạo danh sách sản phẩm
    public Inventory() {
        listInventory = new ArrayList<>();
    }

    // Thêm sản phẩm vào danh sách
    public void addProduct(Product product) {
        listInventory.add(product);
    }

    // Hiển thị thông tin tất cả sản phẩm trong danh sách
    public void display() {
        for (int i = 0; i < listInventory.size(); i++) {
            System.out.println(listInventory.get(i));
        }
        System.out.println();
    }

    // Lấy sản phẩm theo mã sản phẩm
    public Product getProductByID(int productID) {
        for (Product product : listInventory) {
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null;
    }

    // Nhận thêm hàng vào kho
    public void receiveStock(Product product, int quantity) {
        for (int i = 0; i < listInventory.size(); i++) {
            Product currentProduct = listInventory.get(i);
            if (currentProduct.getProductID() == product.getProductID()) {
                if (currentProduct.updateStock(quantity)) {
                    System.out.println("San pham " + currentProduct + " da duoc them " + quantity + " san pham");
                }
                return;
            }
        }
    }



    // Tính tổng giá trị của tất cả sản phẩm trong kho
    public double totalPrice() {
        double total = 0;
        for (Product product : listInventory) {
            total += product.getPrice() * product.getStock();
        }
        return total;
    }
}