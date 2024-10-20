package Payment;

import java.util.Date;

public class CardPayment implements PayMent{
    private String cardNumber;
    private Date expiryDate;
    private double balance;

    public CardPayment(String cardNumber,Date expiryDate){
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount, double priceItem) {
        if(isValid(cardNumber)){
            System.out.println("So tien can thanh toan:" + priceItem);
            if(amount > priceItem){
                balance = amount - priceItem;
                System.out.println("Thanh toan thanh cong!");
                bill(amount,priceItem);
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
            System.out.println("Hoàn trả: " + balance);
        } else {
            System.out.println("Không có số dư để hoàn trả.");
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


    public void bill(double amount,double priceItem) {
        Bill.printBill("Thẻ ngân hàng");
        Bill.printBillDetails(priceItem, amount, getBalance());
        Bill.printBillFooter();
    }
}
