package Search;
import java.util.*;
import Model.Inventory;
import Model.Product;

public class SearchByID implements SearchMethod {
    Scanner sc = new Scanner(System.in);
    public void search(){
        boolean ktID = false;
        do{
            
            System.out.print("Nhap ma san pham can tim : ");
            int isProductID = sc.nextInt();
            Product resProductID = Inventory.getProductByID(isProductID);
            if(resProductID != null){
                ktID = true;
                resProductID.displayInfor();
            }else{
                sc.nextLine();
                System.out.println("Ma san pham khong ton tai. Ban co muon nhap lai ? (y / n)");
                
                String chooseID = sc.nextLine();
                ktID = !chooseID.equalsIgnoreCase("y");
            }
        }while(!ktID);
    }
}
