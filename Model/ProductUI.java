package Model;

import Search.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import Order.*;

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
            System.out.println("│ 4. Thong tin giam gia                     │");
            System.out.println("│ 5. Thoat                                  │");
            System.out.println("└───────────────────────────────────────────┘");

            System.out.print("Nhap lua chon: ");
            int choose;
            do {
                try {
                    choose = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                    sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                }
            } while (true);
            switch (choose) {
                case 1:
                //NOTE : cap nhap san pham trong kho hang
                    Inventory.display();
                    boolean isInventory = false;
                    while(!isInventory){
                        System.out.println("├───────────────────────────────────────────┤");
                        System.out.println("│ 1. Chon san pham                          │");
                        System.out.println("│ 2. Sua san pham                           │");
                        System.out.println("│ 3. Xoa san pham                           │");
                        System.out.println("│ 4. Thoat                                  │");
                        System.out.println("└───────────────────────────────────────────┘");
                        System.out.print("nhap lua chon:");
                        int choice;
                        do {
                            try {
                                choice = sc.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                                sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                            }
                        } while (true);
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
                               int productIDEdit;
                                do {
                                    try {
                                        productIDEdit = sc.nextInt();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                                        sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                                    }
                                } while (true);
            
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
                        do {
                            try {
                                lc = sc.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                                sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                            }
                        } while (true);
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
                        do {
                            try {
                                quantily = sc.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                                sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                            }
                        } while (true);
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
                    boolean isSearch = false;
                    while(!isSearch){
                        System.out.println("┌───────────────────────────────────────────┐");
                        System.out.println("│       Lua chon tim kiem                   │");
                        System.out.println("├───────────────────────────────────────────┤");
                        System.out.println("│ 1.Tim kiem theo ma                        │");
                        System.out.println("│ 2.Tim kiem theo ten                       │");
                        System.out.println("│ 3.Tim kiem theo ngay                      │");
                        System.out.println("│ 4.Tim kiem theo size                      │");
                        System.out.println("│ 5.Tim kiem theo vat lieu                  │");
                        System.out.println("│ 6.Tim kiem theo gia tien                  │");
                        System.out.println("│ 7.Thoat                                   │");
                        System.out.println("├───────────────────────────────────────────┤");

                        System.out.print("Nhap lua chon: ");
                        int lc;
                        do {
                            try {
                                lc = sc.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                                sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                            }
                        } while (true);
                        
                        switch (lc) {
                            case 1:
                                SearchMethod search1 = new SearchByID();
                                search1.search();
                                break;
                            case 2:
                                sc.nextLine();
                                SearchMethod search2 = new SearchByName();
                                search2.search();
                                break;
                            case 3:
                                break;
                            case 4:
                                SearchMethod search4 = new SearchBySize();
                                search4.search();
                                break;
                            case 5:
                                sc.nextLine();
                                SearchMethod search5 = new SearchByMaterial();
                                search5.search();
                                break;
                            case 6:
                               SearchMethod search6 = new SearchByPrice();
                               search6.search();
                                break;
                            case 7:
                                System.out.println("thoat");
                                isSearch = true;
                                break;
                            default:
                                break;
                        }

                    }
                    break;
                case 4:
                    Promotion promotion = new Promotion();
                    boolean isPromotion = false;
                    while(!isPromotion){
                        System.out.println("-----Thong tin--------");
                        System.out.println("1.them san pham vao danh muc giam gia");
                        System.out.println("2.xoa san pham khoi danh muc giam gia");
                        System.out.println("3.San pham giam gia");
                        System.out.println("4.thoat!");

                        System.out.print("nhap lua chon: ");
                        int choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                            sc.nextLine();
                            System.out.println("nhap them san pham can them: ");
                            String nameProductPromotionInAdd = sc.nextLine();
                            for(Product product : Inventory.getListInventory().keySet()){
                                if(product.getProductName().equals(nameProductPromotionInAdd)){
                                    promotion.inpPromocodeandDiscount();
                                    promotion.inpDate();
                                    promotion.applyDiscount(product);
                                    promotion.addProductPromo(product);
                                }
                            }
                                break;
                            case 2:
                            sc.nextLine();
                                System.out.print("nhap ten san pham can xoa: ");
                                String nameProductPromotion = sc.nextLine();
                                for(Product product : promotion.getApplicableProducts()) {
                                    if(product.getProductName().equals(nameProductPromotion)){
                                        promotion.removeProductPromo(product);
                                    }
                                }
                                break;
                            case 3:
                                promotion.displayApplicableProducts();
                                break;
                            case 4:
                                isPromotion = true;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 5:
                    complete = true;
                    break;
                default:
                    break;
            }
        }
    }
}
