package Payment;

import Model.Product;

public class WalletPayment implements PayMent{
    private String soDienThoai;
    private double balance;
    public WalletPayment(String soDienThoai){
        this.soDienThoai = soDienThoai;
    }
    @Override
    public void pay(Bill bill,double amount) {
        double allPriceItem = bill.sumAllBill();
        if(!isValid(soDienThoai)){
            System.out.println("So tien can thanh toan: " + allPriceItem);
            if(amount > allPriceItem){
                balance = amount - allPriceItem;
                System.out.println("Thanh toan thanh cong!");
                bill.inBill("Vi dien tu");
            }else System.out.println("Thanh toan khong thanh cong");
        }else{
            System.out.println("So dien thoai khong hop le!");
            return;
        }
    }
    public double getBalance(){
        return balance;
    }
    @Override
    public void refund(double amount) {
        if (balance > 0) {
            System.out.println("Hoan tra: " + balance);
        } else {
            System.out.println("Khong co so du de hoan tra .");
        }
    }

    @Override
    public boolean isValid(String details) {
        for(char x : details.toCharArray()){
            if(!Character.isDigit(x)) return false;
        }
        if(details.length() != 9) return false;
        return true;
    }
}
