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
                    break;
                case 2:
                boolean inpProduct = false;
                    while(true){
                        System.out.println("--------chon loai san pham can them--------------");
                        System.out.println("1.Clothing");
                        System.out.println("2.Accessory");
                        System.out.println("3.Shoes");
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
                    System.out.print("Nhap ten san pham: ");
                    String productName =  sc.nextLine();
                    if(Inventory.findProduct(productName)){
                        while(true){
                            System.out.println("--------------------");
                            System.out.println("1.Them so luong san pham vao kho");
                            System.out.println("2.xoa so luong san pham trong kho");
                            System.out.print("nhap so luong can them /bot: ");
                            int quanlity = sc.nextInt();
                            int choice;
                            System.out.print("nhap lua chon: ");
                            choice = sc.nextInt();
                        }
                    }
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
