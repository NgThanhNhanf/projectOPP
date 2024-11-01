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
      Inventory inventory = new Inventory();
      Promotion promotion = new Promotion();
      Bill bill = new Bill();
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
        System.out.println("9.Thoat");
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
            sc.nextLine();
            String name;
            System.out.println("nhap ten san pham: ");
            name = sc.nextLine();
            int quantily;
            System.out.println("nhap so luong: ");
            quantily = sc.nextInt();
            boolean findproduct = false;
            for(Product product : inventory.getListInventory()){
                if(product.getProductName().equals(name)){
                  if(inp == 1){
                    inventory.receiveStock(product, quantily);
                  }else if(inp == 2){
                    inventory.issueStock(product, quantily);
                  }
                  findproduct = true;
                  break;
                }
            }

            if(!findproduct){
              System.out.println("khong tim thay san pham trong kho");
            }

            System.out.println("ban co muon tiep tuc cap nhap  (y/n) ? :");
            String continueSelect = sc.next();

            if(!continueSelect.equalsIgnoreCase("y") || !continueSelect.equalsIgnoreCase("Y")) break;
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
              boolean findID = true;
              if(chosse == 1){
                int IDproduct;
                System.out.print("nhap ma san pham muon them: ");
                IDproduct = sc.nextInt();
                for(Product product : inventory.getListInventory()){
                  if(product.getProductID() == IDproduct){
                    findID = true;
                    promotion.inpPromocodeandDiscount();
                    promotion.applyDiscount(product);
                    promotion.addProductPromo(product);
                    promotion.inpDate();
                  }
                  }
                  if(!findID) System.out.println("khong tin thay san pham");
              }else if(chosse == 2){
                int IDproduct;
                System.out.print("nhap ma san pham muon xoa: ");
                IDproduct = sc.nextInt();
                for(Product product : inventory.getListInventory()){
                if(product.getProductID() == IDproduct){
                  findID = true;
                  promotion.removeProductPromo(product);
                }
                }
                if(!findID) System.out.println("khong tin thay san pham");
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
            if(listCart.isEmpty()){
              System.out.println("ban chua mua bat ki san pham nao!");
              break;
            }
            for(Product product : listCart){
              bill.addProductInBill(product);
            }
            System.out.print("_________chon 1 phuong thuc thanh toan_____");
            while(true){
              System.out.println("1.Thanh toan bang tien mat");
              System.out.println("2.Thanh toan bang the ngan hang");
              System.out.println("3.Thanh toan bang vi dien tu");
              int choice;
              System.out.println("nhap lua chon cua ban: ");
              choice = sc.nextInt();
              double money;
              System.out.println("so tien khach hang dua: ");
              money = sc.nextDouble();
              if(choice == 1){
                CashPayment cash = new CashPayment();
                cash.pay(bill, money);
              }else if(choice == 2){
                System.out.println("nhap so the: ");
                String number = sc.next();
                LocalDate expiry = LocalDate.of(2028,11,26);
                CardPayment card = new CardPayment(number, expiry);
                card.pay(bill, money);
              }else if(choice == 3){
                System.out.println("nhap so dien thoai: ");
                String numberPhone = sc.next();
                WalletPayment wallet = new WalletPayment(numberPhone);
                wallet.pay(bill, money);
              }else break;
            }
            break;

            case 9:
            System.out.println("ket thuc chuong trinh!");
            break;
        }
      }
    }
}
