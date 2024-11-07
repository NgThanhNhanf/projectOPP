package Model;

import java.util.HashMap;
import java.util.Scanner;
import Model.Inventory;

public class ProductUI {
    static Scanner sc = new Scanner(System.in);
    // TODO: làm theo menu ở dưới là được
    public static void rootMenu() {
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 San Pham                  │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Danh sach san pham                     │");
            System.out.println("│ 2. Them san pham                          │");
            System.out.println("│ 3. Tim kiem                               │");
            System.out.println("│ 4. Thoat                                  │");
            System.out.println("└───────────────────────────────────────────┘");

            System.out.print("Nhap lua chon: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    Inventory.display();
                    boolean isInventory = false;
                    while(!isInventory){
                        // System.out.println("1.Chon san pham!");
                        System.out.println("2.Sua san pham!");
                        System.out.println("3.Xoa san pham!");
                        System.out.println("4.Thoat");
                        System.out.print("nhap lua chon:");
                        int choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.print("nhap ten san pham: ");
                               String name = sc.nextLine();
                               if(Inventory.findProduct(name)){
                                    Inventory.display();
                                    isInventory = true;
                               }
                                break;
                            case 2:
                               System.out.println("nhap ma san pham can sua");
                               int productIDEdit = sc.nextInt();
                               Product productEdit = Inventory.getProductByID(productIDEdit);
                               if(productEdit != null){
                                System.out.println("thong tin san pham hien tai");
                                productEdit.displayInfor();
                                productEdit.editProduct();
                               }else {
                                System.out.println("khong tim thay san pham co id: " + productIDEdit);
                               }
                               break;
                            case 3:
                               sc.nextLine();
                               System.out.print("Nhap ten san pham can xoa: ");
                               String productName = sc.nextLine();
                               Inventory.removeInventory(productName);
                               break;
                            case 4:
                               System.out.println("thoat");
                               isInventory = true;
                               break;
                            default:
                                break;
                        }

                    }
                    break;
                case 2:
                boolean inpProduct = false;
                    while(true){
                        System.out.println("┌───────────────────────────────────────────┐");
                        System.out.println("│        Chon loai san pham can them        │");
                        System.out.println("├───────────────────────────────────────────┤");
                        System.out.println("│ 1. Clothing                               │");
                        System.out.println("│ 2. Accessory                              │");
                        System.out.println("│ 3. Shoes                                  │");
                        System.out.println("│ 4. Thoat                                  │");
                        System.out.println("└───────────────────────────────────────────┘");
                        int lc;
                        Product product;
                        System.out.print("nhap lua chon: ");
                        lc = sc.nextInt();
                        if(lc == 1) {
                            product = new Clothing();
                        }else if(lc == 2){
                            product = new Accessory();
                        }else if(lc == 3){
                            product = new Shoes();
                        }else{
                            System.out.println("lua chon khong hop le!!!");
                            continue;
                        }
                        inpProduct = true;
                        if(inpProduct){
                            product.inp();
                        int quantily;
                        System.out.print("nhap so luong can them: ");
                        quantily = sc.nextInt();
                        Inventory.addInventory(product,quantily);
                        }else{
                            System.out.println("khong them them san pham!");
                            break;
                        }
                        System.out.print("Ban co muon them san pham vao kho hang ? (y/n)");
                        char inp = sc.next().charAt(0);
                        if(inp == ('n') || inp == ('N')){
                            System.out.println("Ket thuc them san pham");
                            break;
                        }
                    }
                    break;
                case 3:
                    
                    break;
                case 4:
                    complete = true;
                    break;
                default:
                    break;
            }
        }
    }
}
