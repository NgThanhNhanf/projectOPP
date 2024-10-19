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
        
   }
}