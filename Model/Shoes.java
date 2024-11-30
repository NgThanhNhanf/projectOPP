package Model;

import java.util.InputMismatchException;

public class Shoes extends Product {
    private int size;
    private String color;

    public Shoes() {}

    public Shoes(int size, String color) {
        super();
        this.size = size;
        this.color = color;
    }

    public Shoes(int productID, String productName, double price, int size, String color) {
        super(productID, productName, size);
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
        sc.nextLine();
        System.out.print("mau giay: ");
        setColor(sc.nextLine());
        System.out.print("gia tien: ");
        setPrice(sc.nextInt());
        sc.nextLine();
    }


    @Override
    public void displayInfor() {
        super.displayInfor();
        System.out.println("size giay: " + getSize() + "\nMau giay: " + getColor());
    }

    public void editSizeG(){
        System.out.print("new size: ");
        int newSizeG;
        do {
            try {
                newSizeG = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
            }
        } while (true);
        System.out.println("thay doi thanh cong");
    }

    public void editColor(){
        System.out.print("new color: ");
        String newColor = sc.nextLine();
        System.out.println("thay doi thanh cong");
    }

    @Override
    public void editALLAttributeProduct(){
        Product newShoes = new Shoes();
        newShoes.inp();
        setProductID(newShoes.getProductID());
        setProductName(newShoes.getProductName());
        editSizeG();
        editColor();
        setPrice(newShoes.getPrice());
    }

    @Override
    public void editProduct(){
        boolean isShoes = false;
        while(!isShoes){
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│         Chon thong tin can sua            │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Ma san pham                            │");
            System.out.println("│ 2. Ten san pham                           │");
            System.out.println("│ 3. Gia tien                               │");
            System.out.println("│ 4. Size giay                              │");
            System.out.println("│ 5. Mau giay                               │");
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
                    editSizeG();
                    break;
                case 5:
                    editColor();
                    break;
                case 6:
                    editALLAttributeProduct();
                    break;
                case 7:
                    System.out.println("thoat");
                    isShoes = true;
                    break;
                default:
                    break;
            }
        }
    }

}
