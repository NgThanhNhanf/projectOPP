package Model;

import java.util.ArrayList;

public class Inventory{
    private ArrayList<Product> listInventory;
    public Inventory(){
        listInventory = new ArrayList<>();
    }

   public void addInventory(Product product){
        listInventory.add(product);
   }

 public void display(){
        for(Product product : listInventory) {
            product.displayInfor();
            System.out.println("----------------");
        }
 }
   public void receiveStock(Product product,int quanlity){
        if(product.updateStock(quanlity)){
            System.out.println(product.getProductName() + "đã được thêm " + quanlity + "sản phẩm");
        }
   }
   public void issueStock(Product product,int quantily){
        if(product.updateStock(-quantily)){
            System.out.println(product.getProductName() + "đã bớt đi " + quantily + "sản phẩm");
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