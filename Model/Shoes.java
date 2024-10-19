package Model;

//Shoes: giày
//class này bonus thêm
public class Shoes extends Product{
    private  int size;
    private String color;

    public Shoes(int size, String color) {
        this.size = size;
        this.color = color;
    }

    public Shoes(int productID, String productName, double price, int stock, int size, String color) {
        super(productID, productName, price, stock);
        this.size = size;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void displayInfor() {
        super.displayInfor();
        System.out.println("size giày: " + getSize() + "\nMàu giày: " + getColor());
    }
}
