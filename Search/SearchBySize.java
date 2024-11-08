package Search;

import java.util.Scanner;
import Model.Clothing;
import Model.Shoes;
import Model.Inventory;
import Model.Product;

public class SearchBySize implements SearchMethod {
    Scanner sc = new Scanner(System.in);
    public void search () {
        boolean isSize = false;
        while(!isSize) {
            System.out.println("Ban muon tim kiem theo size Clothing or Shoes ?");
            System.out.println("1.Size Clothing");
            System.out.println("2.Size Shoes");
            System.out.println("nhap lua chon: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    boolean isClothing = false;
                    System.out.print("Nhap size ban muon tim kiem: ");
                    String x = sc.next();
                    for(Product product : Inventory.getListInventory().keySet()){
                         Clothing clothing = (Clothing) product; //Downcasting
                         if(clothing.getSize().equals(x)){
                            clothing.displayInfor();
                            isClothing = true;
                         }
                    }

                    if(!isClothing) {
                        System.out.println("khong tim thay size nao hop le");
                        System.out.println("ban co muon tim lai ? (y/n)");
                        char it = sc.next().charAt(0);
                        if(it == 'N' || it == 'n'){
                            System.out.println("tim kiem ket thuc");
                            break;
                        }
                    }
                    break;
                case 2:
                boolean isShoes = false;
                    System.out.print("Nhap size ban muon tim kiem: ");
                    int y = sc.nextInt();
                    for(Product product : Inventory.getListInventory().keySet()){
                        Shoes shoes = (Shoes) product;
                        if(shoes.getSize() == y){
                            shoes.displayInfor();
                            isShoes = true;
                        }
                    }
                    if(!isShoes){
                        System.out.println("khong tim thay size nao hop le");
                        System.out.println("ban co muon tim lai ? (y/n)");
                        char v = sc.next().charAt(0);
                        if(v == 'N' || v == 'n'){
                            System.out.println("tim kiem ket thuc"); break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
