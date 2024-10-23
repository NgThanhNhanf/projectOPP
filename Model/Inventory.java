package Model;

import java.util.ArrayList;

public class Inventory{
    private ArrayList<Product> listInventory;
    public Inventory(){
        listInventory = new ArrayList<>();
    }

   public void addInventory(Product product){
    for(Product p : listInventory){
        if(p.getProductID() == product.getProductID()){
            System.out.println("San pham da ton tai trong kho!");
            return;
        }
    }
    listInventory.add(product);
    System.out.println("San pham " + product.getProductName() + " da duoc them vao kho");
   }

 public void display(){
        for(Product product : listInventory) {
            product.displayInfor();
            System.out.println("----------------");
        }
 }
   public void receiveStock(Product product,int quantity){
        if(product.updateStock(quantity)){
            System.out.println(product.getProductName() + "đã được thêm " + quantity + "sản phẩm");
        }
   }
   public void issueStock(Product product,int quantity){
        if(product.updateStock(-quantity)){
            System.out.println(product.getProductName() + "đã bớt đi " + quantity + "sản phẩm");
        }
   }
   public double totalPrice(){
       double total = 0;
       for(Product product : listInventory){
           total += product.getPrice() * product.getStock();
       }
       return total;
   }
}