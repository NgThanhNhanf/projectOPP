import java.util.*;
import java.time.*;
import Model.Product;
import Model.Shoes;
import Model.Accessory;
import Model.Inventory;
import Model.Clothing;
import Model.Promotion;

import Payment.PayMent;
import Payment.WalletPayment;
import Payment.CardPayment;
import Payment.CashPayment;
import Payment.Bill;

public class Entry {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
      //   Product product2 = new Shoes(2,"Giay nike ",200,30,43,"Trang");
      //   Product product3 = new Clothing(3,"Quan tay den",200,20,"XL","Cao cap");
      //   Product product4 = new Accessory(4,"Vong tay",16,10,"Vai");

      //   Inventory inventory = new Inventory();
      //   inventory.addInventory(product2);
      //   inventory.addInventory(product3);
      //   inventory.addInventory(product4);
        

      //   System.out.println("Thong tin san pham trong kho hang: ");
      //   inventory.display();

      //   inventory.receiveStock(product3,50);
      //   inventory.issueStock(product2,10);

      //   System.out.println("thong tin san pham trong kho hang sau khi them/bot: ");
      //   inventory.display();

      //   double sum = inventory.totalPrice();
      //   System.out.println("Tong gia tri cua kho hang: " + sum);

      //   Promotion code = new Promotion("123", 0.2, "01-10-2024 10:10:10", "25-10-2024 10:10:10");
      
      //   code.addProductPromo(product4);
      //   code.addProductPromo(product2);
      //   code.addProductPromo(product3);
      //   //in ra thong tin san pham giam gia 
      //   code.displayApplicableProducts();
  
      //   code.removeProductPromo(product2);
  
      //   //in ra thong tin san pham giam gia sau khi loai 1 san pham bat ki ra
      //   code.displayApplicableProducts();
      
      // product2.addProductInCart(sc);
      // product3.addProductInCart(sc);

      // Bill bill = new Bill();
      // bill.addProductInBill(product2);
      // bill.addProductInBill(product3);
      // CashPayment cash = new CashPayment();
      // System.out.print("nhap so tien khach hang can thanh toan: ");
      // double money = sc.nextDouble();
      //   cash.pay(bill,money);
      Inventory inventory = new Inventory();
      Promotion promotion = new Promotion();
      List<Product> listCart = new ArrayList<>();
      while(true){
        System.out.println("1.Them san pham trong kho hang");
        System.out.println("2.In thong tin san pham trong kho hang");
        System.out.println("3.Cap nhat san pham trong kho hang");
        System.out.println("4.tinh tong gia tri cua kho hang");
        System.out.println("5.Cap nhap danh muc khuyen mai");
        System.out.println("6.In thong tin cac san pham duoc khuyen mai");
        System.out.println("7.Them san pham vao gio hang");
        System.out.println("8.Chon phuong thuc thanh toan");
        System.out.println("9.In ra thong tin thanh toan");
        System.out.println("10.Thoat");
        int lc;
        System.out.print("nhap luc chon:");
        lc = sc.nextInt();
        switch (lc) {
          case 1:
          while(true){
            System.out.println("1.Clothing");
            System.out.println("2.Accessory");
            System.out.println("3.Shoes");
            int inp;
            System.out.println("Chon san pham can them: ");
            inp = sc.nextInt();
            if(inp == 1){
              Product product = new Clothing();
              product.inp();
              inventory.addInventory(product);
            }else if(inp == 2) {
              Product product  = new Accessory();
              product.inp();
              inventory.addInventory(product);
            }else if(inp == 3){
              Product product = new Shoes();
              product.inp();
              inventory.addInventory(product);
            }else break;
          }
          break;

          case 2:
          System.out.println("thong tin san pham trong kho hang");
          inventory.display();  
          break;
          
          case 3:
          while(true){
            System.out.println("1.Them so luong cua 1 san pham trong kho");
            System.out.println("2.Bot so luong cua 1 san pham trong kho");
            int inp;
            System.out.println("Ban muon them hay bot ? Nhap lua chon: ");
            inp = sc.nextInt();
            if(inp == 1){
              boolean findProduct = false;
              String nameProduct;
              System.out.print("nha ten san pham: ");
              nameProduct = sc.nextLine();
              System.out.print("nhap so luong muon them: ");
              int quantily = sc.nextInt();
              for(Product p : inventory.getListInventory()){
                if(p.getProductName().equals(nameProduct)){
                    inventory.receiveStock(p, quantily);
                    findProduct = true;
                    System.out.println("Them thanh cong");
                }else  {
                  findProduct = false;
                  System.out.println("khong tim thay san pham");
                  break;
                }
              }
            }else if(inp == 2){
              boolean findProduct = false;
              String nameProduct;
              System.out.print("nha ten san pham: ");
              nameProduct = sc.nextLine();
              System.out.print("nhap so luong muon Bot: ");
              int quantily = sc.nextInt();
              for(Product p : inventory.getListInventory()){
                if(p.getProductName().equals(nameProduct)){
                    inventory.issueStock(p, quantily);
                    findProduct = true;
                    System.out.println("Bot thanh cong");
                }else{
                  findProduct = false;
                  System.out.println("khong tim thay san pham");
                  break;
                }
              }
            }else {
              break;
            }
          }
          break;

          case 4:
          System.out.println("Tong gia tri kho hang: " + inventory.totalPrice());
          break;

          case 5:
            while(true){
              System.out.println("1.them san pham vao danh muc khuyen mai!");
              System.out.println("2.Xoa san pham khoi danh muc khuyen mai!");
              int chosse;
              System.out.print("nhap lua chon: ");
              chosse = sc.nextInt();
              if(chosse == 1){
                int IDproduct;
                System.out.print("nhap ma san pham muon them: ");
                IDproduct = sc.nextInt();
                for(Product product : inventory.getListInventory()){
                  if(inventory.getListInventory().contains(IDproduct)){
                    promotion.addProductPromo(product);
                  }else{
                    System.out.println("khong tim thay san pham!"); break;
                  }
                }
              }else if(chosse == 2){
                int IDproduct;
                System.out.print("nhap ma san pham muon xoa: ");
                IDproduct = sc.nextInt();
                for(Product product : inventory.getListInventory()){
                  if(inventory.getListInventory().contains(IDproduct)){
                    promotion.removeProductPromo(product);
                  }else{
                    System.out.println("khong tim thay san pham!"); break;
                  }
                }
              }else break;
            }
          break;

          case 6:
            promotion.displayApplicableProducts();
            break;

          case 7:
            while(true){
              System.out.println("1.Clothing");
              System.out.println("2.Accessory");
              System.out.println("3.Shoes");
              
              int cart;
              System.out.print("chon san pham ban muon mua: ");
              cart = sc.nextInt();

              if(cart == 1){
                Product product = new Clothing();
                product.inp();
                if(product.addProductInCart(product)){
                  listCart.add(product);
                  System.out.println("da them " + product.getProductName() + "vao gio hang");
                }
              }else if(cart == 2){
                Product product = new Accessory();
                product.inp();
                if(product.addProductInCart(product)){
                  listCart.add(product);
                  System.out.println("da them " + product.getProductName() + "vao gio hang");
                }
              }else if(cart == 3){
                Product product = new Shoes();
                product.inp();
                if(product.addProductInCart(product)){
                  listCart.add(product);
                  System.out.println("da them " + product.getProductName() + "vao gio hang");
                }
              }else {
                System.out.println("ket thuc mua hang");break;
              }
            }
            break;

            case 8:
            
        }
      }
    }
}
