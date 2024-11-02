package Model;

//Accessory: phụ kiện
//class này bonus thêm
public class Accessory extends Product{
    private String type;


    public Accessory(){

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
    public void inp(){
        System.out.println("nhap thong tin san pham:");
        System.out.print("ma san pham: ");
        setProductID(sc.nextInt());
        sc.nextLine(); // loại bỏ dấu /n sau khi nhập int
        System.out.print("ten san pham: ");
        setProductName(sc.nextLine());
        System.out.print("loai phu kien: ");
        setType(sc.nextLine());
        System.out.print("gia tien: ");
        setPrice(sc.nextDouble());
        sc.nextLine();
    }
    @Override
    public void displayInfor() {
        super.displayInfor();
        System.out.println("loại phụ kiện: " + getType());
    }
}
