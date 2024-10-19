package Model;

//Clothing: quần áo,...
public class Clothing extends Product{
    private String size;
    private String material; // material : chất liệu

    public Clothing(int productID, String productName, double price, int stock, String size, String material) {
        super(productID, productName, price, stock);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void displayInfor() {
        super.displayInfor();
        System.out.println("size: " + getSize() + "\nchất liệu: " + getMaterial());
    }
}
