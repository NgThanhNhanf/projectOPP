package Search;

import java.util.Scanner;

import Model.Inventory;
import Model.Product;

public class SearchByName implements SearchMethod {
    Scanner sc = new Scanner(System.in);
    public void search(){
        // sc.nextLine();
        boolean ktName = false;
        do{
            System.out.print("Nhap ten san pham can tim : ");
            String isProductName = sc.nextLine();
            Product resProductName = Inventory.getProductByName(isProductName);
            if(resProductName != null){
                ktName = true;
                Inventory.displayProductByName(isProductName);
            }else{
                System.out.println("Ten san pham khong ton tai. Ban co muon nhap lai ? (y / n)");
                
                String chooseName = sc.nextLine();
                ktName = !chooseName.equalsIgnoreCase("y");
            }
        }while(!ktName);
    }
}
