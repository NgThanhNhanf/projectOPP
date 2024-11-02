package Model;

//Clothing: quần áo,...
public class Clothing extends Product{
    private String size;
    private String material; // material : chất liệu

    public Clothing() {}
    public Clothing(String size,String material){
       this.size = size;
       this.material = material;
    }
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
    public void inp(){
        System.out.println("nhap thong tin san pham:");
        System.out.print("ma san pham: ");
        setProductID(sc.nextInt());
        sc.nextLine(); // loại bỏ dấu /n sau khi nhập int
        System.out.print("ten san pham: ");
        setProductName(sc.nextLine());
        System.out.print("size: ");
        setSize(sc.nextLine());
        System.out.print("chat lieu: ");
        setMaterial(sc.nextLine());
        System.out.print("gia tien: ");
        setPrice(sc.nextDouble());
        sc.nextLine();
    }


    @Override
    public void displayInfor() {
        super.displayInfor();
        System.out.println("size: " + getSize() + "\nchat lieu: " + getMaterial());
    }
}
