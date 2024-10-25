package Payment;

public interface PayMent {
     void pay(double amount,double priceItem); //thanh toán
     void refund(double amount); //số dư trả về
     boolean isValid(String details); // kiểm tra ngày hợp lệ

}
