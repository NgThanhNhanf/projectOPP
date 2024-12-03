package Model;

import java.util.InputMismatchException;
import Order.displayFormat;

public class Clothing extends Product {
    private String size;
    private String material;


    public Clothing() {}

    public Clothing(String size, String material) {
        this.size = size;
        this.material = material;
    }
    public Clothing(int productID, String productName, double price, String size, String material) {
        super(productID, productName, productID);
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
        setPrice(sc.nextInt());
        sc.nextLine();
    }


    @Override
    public void displayInfor() {
        super.displayInfor();
        System.out.printf("Size: %2s│\n│Chat lieu: %-32s│\n", getSize(), getMaterial());
        System.out.printf("│Don gia: %-34s│\n", displayFormat.formatPrice(super.getPrice()).concat(" VND"));
        System.out.println("├───────────────────────────────────────────┤");
    }

    public void editSize(){
        System.out.print("new size: ");
        String newSize = sc.next();
        setSize(newSize);
        System.out.println("thay doi thanh cong");
    }

    public void editMaterial(){
        System.out.print("new material: ");
        String newMaterial = sc.nextLine();
        setMaterial(newMaterial);
        System.out.println("thay doi thanh cong");
    }

    @Override
    public void editALLAttributeProduct(){
        Product newClothing = new Clothing();
        newClothing.inp();
        setProductID(newClothing.getProductID());
        setProductName(newClothing.getProductName());
        editSize();
        editMaterial();
        setPrice(newClothing.getPrice());
    }

    @Override
    public void editProduct(){
        boolean isClothing = false;
        while(!isClothing){
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│         Chon thong tin can sua            │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Ma san pham                            │");
            System.out.println("│ 2. Ten san pham                           │");
            System.out.println("│ 3. Gia tien                               │");
            System.out.println("│ 4. Kich thuoc                             │");
            System.out.println("│ 5. Chat lieu                              │");
            System.out.println("│ 6. Tat ca                                 │");
            System.out.println("│ 7. Thoat                                  │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.println("nhap lua chon: ");
            int choose;
            do {
                try {
                    choose = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                    sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                }
            } while (true);
            
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
                    editSize();
                    break;
                case 5:
                    editMaterial();
                    break;
                case 6:
                    editALLAttributeProduct();
                    break;
                case 7:
                System.out.println("thoat");
                    isClothing = true;
                    break;
                default:
                    System.out.println("lua chon khong hoi le!Vui long nhap lai");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", size: " + getSize() + ", chat lieu: " + getMaterial();
    }
}