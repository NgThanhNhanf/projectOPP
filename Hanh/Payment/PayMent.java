package Payment;

public interface PayMent {
     void pay(double amount,double priceItem);
     void refund(double amount);
     boolean isValid(String details);

}
