package Payment;

import Model.Product;

public class CashPayment implements PayMent{
    private double balance;

    @Override
    public void pay(Bill bill,double amount) {
        double allPriceItem = bill.sumAllBill();
        System.out.println("so tien can thanh toan: " + allPriceItem);
        if(amount >= allPriceItem){
            balance = amount - allPriceItem;
            System.out.println("Thanh toan thanh cong! so du: " + getBalance());
            bill.inBill("Tien mat");
        } else {
            System.out.println("thanh toan khong thanh cong");
            return;
        }
    }

    public double getBalance(){
        return balance;
    };
    @Override
    public void refund(double amount) {
        if (balance > 0) {
            System.out.println("So tien thoi lai :  " + balance);
        } else {
            System.out.println("Khong co so du");
        }
    }

    @Override
    public boolean isValid(String details) {
        return true;
    }
}
