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
        Product product2 = new Shoes(2,"Giay nike ",200,30,43,"Trang");
        Product product3 = new Clothing(3,"Quan tay den",200,20,"XL","Cao cap");
        Product product4 = new Accessory(4,"Vong tay",16,10,"Vai");

        Inventory inventory = new Inventory();
        inventory.addInventory(product2);
        inventory.addInventory(product3);
        inventory.addInventory(product4);
        

        // System.out.println("Thong tin san pham trong kho hang: ");
        // inventory.display();

        // inventory.receiveStock(product1,50);
        // inventory.issueStock(product2,10);

        // System.out.println("thong tin san pham trong kho hang sau khi them/bot: ");
        // inventory.display();

        // double sum = inventory.totalPrice();
        // System.out.println("Tong gia tri cua kho hang: " + sum);

        // Promotion code = new Promotion("123", 0.2, "01-10-2024 10:10:10", "25-10-2024 10:10:10");
      
        // code.addProductPromo(product4);
        // code.addProductPromo(product2);
        // code.addProductPromo(product3);
        // //in ra thong tin san pham giam gia 
        // code.displayApplicableProducts();
  
        // code.removeProductPromo(product2);
  
        // //in ra thong tin san pham giam gia sau khi loai 1 san pham bat ki ra
        // code.displayApplicableProducts();
      
      product2.addProductInCart(sc);
      product3.addProductInCart(sc);

      Bill bill = new Bill();
      bill.addProductInBill(product2);
      bill.addProductInBill(product3);
      CashPayment cash = new CashPayment();
      System.out.print("nhap so tien khach hang can thanh toan: ");
      double money = sc.nextDouble();
        cash.pay(bill,money);
        sc.close();
    }
}
