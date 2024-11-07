package Model;

import java.util.HashMap;

public class Inventory{
    //mang luu 1 cai list cac san pham trong kho 
    private static HashMap<Product, Integer> listInventory = new HashMap<>();
    public Inventory(){}
    
    public HashMap<Product, Integer> getListInventory() {
        return listInventory;
    }

    // them san pham vao kho hang
    public static void addInventory(Product product, int quanlity){
        listInventory.put(product, listInventory.getOrDefault(product, 0) + quanlity);
        System.out.println("Them san pham vao kho thanh cong!!!");
    }

    public static void deleteInventory(Product product, int quanlity){
        if(quanlity > 0){
            listInventory.put(product, listInventory.getOrDefault(product, 0) + (-quanlity));
            System.out.println("da bot di"  + listInventory.values() + "san pham");
        }
    }

    public static void removeInventory(String productName){
        for(Product product : listInventory.keySet()){
            if(product.getProductName().equals(productName)){
                listInventory.remove(product);
            }else {
                System.out.println("khong tim thay san pham trong kho"); break;
            }
        }
        System.out.println("Xoa san pham thanh cong");
    }

    public static void display(){
        for(Product product : listInventory.keySet()) {
            product.displayInfor();
            System.out.println("so luong ton:" + listInventory.get(product));
            System.out.println("----------------");
        }
    }

    //tính tổng giá trị các sản phẩm trong kho hàng
    public static double totalPrice(){
        double total = 0;
        for(Product product : listInventory.keySet()){
            // tổng = giá tiền của 1 sản phẩm(bất kì) * số lượng sản phẩm đó trong kho
            total += product.getPrice() * listInventory.get(product);
        }
        //trả về tổng của tất cả sản phẩm
        return total;
    }

    // Phương thức tìm sản phẩm theo ID
    public static Product getProductByID(int productID) {
        for(Product product : listInventory.keySet()){
            if(product.getProductID() == productID){
                return product;
            }
        }
        return null;
    }
    
    public static boolean findProduct(String productName){
        for(Product product : listInventory.keySet()){
            if(product.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }

    public static Product getProductByName(String productName){
        for(Product product : listInventory.keySet()){
            if(product.getProductName().equals(productName)){
                return product;
            }
        }
        return null;
    }
}