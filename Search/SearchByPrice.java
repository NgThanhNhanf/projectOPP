package Search;

import Model.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchByPrice implements SearchMethod {
    Scanner sc = new Scanner(System.in);
    public void search() {
        boolean isSeachPrice = false;
        while(!isSeachPrice){
            System.out.println("nhap khoang gia tien: ");
            System.out.print("Tu:  ");
            int minPrice;
            do {
                try {
                    minPrice = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                    sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                }
            } while (true);
            
            System.out.print("Den: ");
            int maxPrice;
            do {
                try {
                    maxPrice = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                    sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                }
            } while (true);

            if(minPrice <= 0 || minPrice > maxPrice){
                System.out.println("gia tri min khong hop le! vui long nhap lai");
                isSeachPrice =false;
                continue;
            }else if(maxPrice <= 0 ||maxPrice < minPrice){
                System.out.println("gia tri max khong hop le! vui long nhap lai");
                isSeachPrice = false;
                continue;
            } 
            System.out.println("Tat ca san pham co gia tien trong khoang " + "[" + minPrice + "," + maxPrice + "]: ");
            for(Product product : Inventory.getListInventory().keySet()){
                if(product.getPrice() >= minPrice && product.getPrice() <= maxPrice){
                    product.displayInfor();
                }

                System.out.print("ban co muon tim tiep khong ? (y/n)");
                char x = sc.nextLine().charAt(0);
                if(x == 'N' || x == 'n'){
                    System.out.println("ket thuc tim kiem!");
                    isSeachPrice = true;
                    break;
                }
            }
        }
    }
}
