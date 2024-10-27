package Model;

public class Accessory extends Product {
    private String type;

    public Accessory() {}

    public Accessory(String type) {
        this.type = type;
    }

    public Accessory(int productID, String productName, double price, int stock, String type) {
        super(productID, productName, price, stock);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void displayInfor() {
        super.displayInfor();
        System.out.println("loai phu kien: " + getType());
    }

    @Override
    public String toString() {
        return super.toString() + ", looi phu kien: " + getType();
    }
}