package Search;
import Model.Inventory;
import Model.Product;
import java.util.*;

public class SearchByID implements SearchMethod {
    Scanner sc = new Scanner(System.in);
    public void search(){
        boolean ktID = false;
        do{
            
            System.out.print("Nhap ma san pham can tim : ");
            int isProductID;
            do {
                try {
                    isProductID = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                    sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                }
            } while (true);
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
