package Model;

public class Accessory extends Product {
    private String type;

    public Accessory(){

    }
    

    // public Accessory(int productID, String productName, double price, int stock, String type) {
    //     super(productID, productName, price, stock);
    //     this.type = type;
    // }

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
        setPrice(sc.nextInt());
        sc.nextLine();
    }
    @Override
    public void displayInfor() {
        super.displayInfor();
        System.out.printf("│ Chat lieu  : %-26s │\n", getType());
        System.out.println("──────────────────────────────────────────");
    }

    public void editType(){
        System.out.print("new type: ");
        String newType = sc.nextLine();
        setType(newType);
        System.out.println("thay doi thanh cong");
    }

    @Override
    public void editALLAttributeProduct(){
        Product newAccessory = new Accessory();
        newAccessory.inp();
        setProductID(newAccessory.getProductID());
        setProductName(newAccessory.getProductName());
        editType();
        setPrice(newAccessory.getPrice());
        
    }

    @Override
    public void editProduct(){
        boolean isAccessory = false;
        while(!isAccessory){
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│       Chon thong tin can sua              │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1.Ma san pham                             │");
            System.out.println("│ 2.Ten san pham                            │");
            System.out.println("│ 3.Gia tien                                │");
            System.out.println("│ 4.Loai san pham                           │");
            System.out.println("│ 5.Tat ca                                  │");
            System.out.println("│ 6.Thoat                                   │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.print("Nhap lua chon: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    editProductID();
                    break;
                case 2:
                    editProductName();
                    break;
                case 3:
                    editProductPrice();
                    break;
                case 4:
                    editType();
                    break;
                case 5:
                    editALLAttributeProduct();
                    break;
                case 6:
                    System.out.println("thoat");
                    isAccessory = true;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", looi phu kien: " + getType();
    }
}