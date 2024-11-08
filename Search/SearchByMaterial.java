package Search;
import java.util.*;

import Model.Clothing;
import Model.Inventory;
import Model.Product;
public class SearchByMaterial implements SearchMethod {
    Scanner sc = new Scanner(System.in);
    public void search() {
        Scanner sc = new Scanner(System.in);
    
        do {
            boolean ktProductMaterial = false;
            System.out.print("Nhap chat lieu san pham can tim: ");
            String isProductMaterial = sc.nextLine();
            
            for (Product product : Inventory.getListInventory().keySet()) {
                if (product instanceof Clothing) {
                    Clothing clothing = (Clothing) product;
                    if (clothing.getMaterial().toLowerCase().contains(isProductMaterial.toLowerCase())) {
                        System.out.println("├───────────────────────────────────────────┤");
                        product.displayInfor();
                        ktProductMaterial = true;
                    }
                }
            }
            if (!ktProductMaterial) {
                System.out.println("Chat lieu san pham khong ton tai. Ban co muon nhap lai? (y / n)");
                String chooseMaterial = sc.nextLine();
                if (!chooseMaterial.equalsIgnoreCase("y")) {
                    break;
                }
            } else {
                break;
            }
        } while (true);
    
        System.out.println("Tim kiem ket thuc.");
    }
    
}
