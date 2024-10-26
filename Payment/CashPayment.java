package Payment;

import Model.Product;

public class CashPayment implements PayMent{
    private double balance;
    @Override
    public void pay(double amount,double priceItem) {
        System.out.println("so tien can thanh toan: " + priceItem);
        if(amount >= priceItem){
            balance = amount - priceItem;
            System.out.println("Thanh toan thanh cong! so du: " + getBalance());
            bill(amount,priceItem,product);
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


    public void bill(double amount,double priceItem,Product product) {
        Bill.printBill("Tien mat");
        Bill.printBillDetails(priceItem, amount, getBalance(),product);
        Bill.printBillFooter();
    }
}
