package Model;

//Accessory: phụ kiện
//class này bonus thêm
public class Accessory extends Product{
    private String type;

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
        System.out.println("loại phụ kiện: " + getType());
    }
}
