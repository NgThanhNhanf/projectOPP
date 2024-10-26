package Payment;

import Model.Product;

public interface PayMent {
     void pay(double amount,double priceItem); //thanh toán
     void refund(double amount); //số dư trả về
     boolean isValid(String details); // kiểm tra ngày hợp lệ

     Product product = new Product();

}
