package Model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory{
    //mang luu 1 cai list cac san pham trong kho 
    private static HashMap<Product, Integer> listInventory = new HashMap<>();
    public Inventory(){}
    
    public HashMap<Product, Integer> getListInventory(){
        return listInventory;
    }
    // them san pham vao kho hang
    public void addInventory(Product product, int quanlity){
        listInventory.put(product, listInventory.getOrDefault(product, 0) + quanlity);
        System.out.println("Them san pham vao kho thanh cong!!!");
    }

    public void deleteInventory(Product product, int quanlity){
        if(quanlity > 0){
            listInventory.put(product, listInventory.getOrDefault(product, 0) + (-quanlity));
            System.out.println("Them san pham vao kho thanh cong!!!");
        }
    }

    public void display(){
        for(Product product : listInventory.keySet()) {
            product.displayInfor();
            System.out.println("so luong ton:" + listInventory.get(product));
            System.out.println("----------------");
        }
    }

    //tính tổng giá trị các sản phẩm trong kho hàng
    public double totalPrice(){
        double total = 0;
        for(Product product : listInventory.keySet()){
            // tổng = giá tiền của 1 sản phẩm(bất kì) * số lượng sản phẩm đó trong kho
            total += product.getPrice() * listInventory.get(product);
        }
        //trả về tổng của tất cả sản phẩm
        return total;
    }
}