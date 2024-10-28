package Model;

//Shoes: giày
//class này bonus thêm
public class Shoes extends Product{
    private  int size;
    private String color;

    public Shoes() {}
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
    public void inp(){
        System.out.println("nhap thong tin san pham:");
        System.out.print("ma san pham: ");
        setProductID(sc.nextInt());
        sc.nextLine(); // loại bỏ dấu /n sau khi nhập int
        System.out.print("ten san pham: ");
        setProductName(sc.nextLine());
        System.out.print("size: ");
        setSize(sc.nextInt());
        System.out.print("mau giay: ");
        setColor(sc.nextLine());
        System.out.print("gia tien: ");
        setPrice(sc.nextDouble());
        System.out.print("ton kho: ");
        setStock(sc.nextInt());
    }


    @Override
    public void displayInfor() {
        super.displayInfor();
        System.out.println("size giày: " + getSize() + "\nMàu giày: " + getColor());
    }
}
