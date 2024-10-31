package Payment;

import java.util.Date;
import Model.Product;

public class CardPayment implements PayMent{
    private String cardNumber; //số thẻ
    private Date expiryDate; //ngày hết hạn
    private double balance; // số dư

    public CardPayment(String cardNumber,Date expiryDate){
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(Bill bill,double amount) {
        double priceItem = bill.sumAllBill();
        if(isValid(cardNumber)){
            System.out.println("So tien can thanh toan:" + priceItem);
            if(amount > priceItem){
                balance = amount - priceItem;
                System.out.println("Thanh toan thanh cong!");
                bill.inBill("The ngan hang");
            }else System.out.println("Thanh toan khong thanh cong");
        }else{
            System.out.println("so the khong hop le!");
            return;
        }
    }

    public double getBalance(){
        return  balance;
    }

    @Override
    public void refund(double amount) {
        if (balance > 0) {
            System.out.println("Hoan tra: " + balance);
        } else {
            System.out.println("Khong co so du de hoan tra.");
        }
    }

    @Override
    public boolean isValid(String details) {
       for(char x : details.toCharArray()){
           if(!Character.isDigit(x)) return false;
       }
       if(details.length() != 16) return false;
       return true;
    }
}
