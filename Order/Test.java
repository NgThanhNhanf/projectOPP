package Order;

import Model.*;

// Hàm chạy test
public class Test {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Clothing product1 = new Clothing(1, "Ao thun", 100000, 10, "M", "Cotton");
        inventory.addProduct(product1);
        Clothing product2 = new Clothing(2, "Quan jean", 200000, 5, "L", "Denim");
        inventory.addProduct(product2);
        Shoes product3 = new Shoes(3, "Giay the thao", 300000, 8, 40, "Xanh duong");
        inventory.addProduct(product3);
        Accessory product4 = new Accessory(4, "Non", 50000, 15, "Non ket");
        inventory.addProduct(product4);
        Accessory product5 = new Accessory(5, "Tui deo cheo", 150000, 7, "Da");
        inventory.addProduct(product5);

        // Khoi tao OrderUI va hien thi menu (Khởi tạo OrderUI và hiển thị menu)
        OrdersUI ordersUI = new OrdersUI();
        ordersUI.rootMenu(inventory);
    }
}

