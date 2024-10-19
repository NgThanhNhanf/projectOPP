package Payment;

public class CashPayment implements PayMent{
    private double balance;
    @Override
    public void pay(double amount,double priceItem) {
        System.out.println("so tien can thanh toan: " + priceItem);
        if(amount >= priceItem){
            balance = amount - priceItem;
            System.out.println("Thanh toán thành công! số dư: " + getBalance());
            bill(amount,priceItem);
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
            System.out.println("Số tiền thối lại :  " + balance);
        } else {
            System.out.println("Không có số dư");
        }
    }

    @Override
    public boolean isValid(String details) {
        return true;
    }


    public void bill(double amount,double priceItem) {
        Bill.printBill("Tiền Mặt");
        Bill.printBillDetails(priceItem, amount, getBalance());
        Bill.printBillFooter();
    }
}
