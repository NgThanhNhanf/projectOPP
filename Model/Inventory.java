package Model;

import java.util.ArrayList;

public class Inventory{
    //mang luu 1 cai list cac san pham trong kho 
    private ArrayList<Product> listInventory;
    public Inventory(){
        listInventory = new ArrayList<>();
        //ham constructor tao 1 cai list kho hang
    }
    // them san pham vao kho hang
   public void addInventory(Product product){
    for(Product p : listInventory){
        //kiem tra cai san pham muon them co ton tai trong kho hay khong ? 
        if(p.getProductID() == product.getProductID()){
            System.out.println("San pham da ton tai trong kho!"); 
            return;
        }
    }
    listInventory.add(product);
    System.out.println("San pham " + product.getProductName() + " da duoc them vao kho");
   }

 public void display(){
        for(Product product : listInventory) {
            product.displayInfor();
            System.out.println("----------------");
        }
 }
 //cap nhap so luong san pham ve kho hang 
   public void receiveStock(Product product,int quantity){
        if(product.updateStock(quantity)){
            //neu nhu so luong them hop le thi in ra da them vao kho .. san pham
            System.out.println(product.getProductName() + "đã được thêm " + quantity + "sản phẩm");
        }
   }
   //cap nhap so luong san pham trong kho hang(bot di)
   public void issueStock(Product product,int quantity){
        if(product.updateStock(-quantity)){
            //so luong san pham hop le(quantily) => bớt đi thì là - quantily
            System.out.println(product.getProductName() + "đã bớt đi " + quantity + "sản phẩm");
        }
   }
   //tính tổng giá trị các sản phẩm trong kho hàng
   public double totalPrice(){
       double total = 0;
       for(Product product : listInventory){
        // tổng = giá tiền của 1 sản phẩm(bất kì) * số lượng sản phẩm đó trong kho
           total += product.getPrice() * product.getStock();
       }
       //trả về tổng của tất cả sản phẩm
       return total;
   }
}