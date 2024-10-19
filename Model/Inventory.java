package Model;

import java.util.ArrayList;

public class Inventory{
    private ArrayList<Product> listInventory;
    public Inventory(){
        listInventory = new ArrayList<>();
    }

   public void addInventory(){
        Product prd =  new Product();
        listInventory.add(prd);
   }

   public void display(){
    for(int i = 0; i < listInventory.size();i++){
        System.out.println(listInventory.get(i));
    }
    System.out.println();
   }
   public void receiveStock(Product product,int quanlity){
        for(int i = 0; i < listInventory.size();i++){
            if(listInventory.get(i).updateStock(quanlity)){
                System.out.println("san pham " + listInventory.get(i) + "da dc them " + quanlity + "san pham");
            }
        }
   }
   public void issueStock(Product product,int quantily){

   }
   public double totalPrice(){
       return 0;
   }
}