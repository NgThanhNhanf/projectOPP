package Model;

import java.util.Scanner;

public class ProductUI {
    Scanner sc = new Scanner(System.in);
    public void rootMenu() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│                 San Pham                  │");
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("│ 1. Danh sach san pham                     │");
        System.out.println("│ 2. Them san pham                          │");
        System.out.println("│ 3. Tim kiem                               │");
        System.out.println("│ 4. Thoat                                  │");
        System.out.println("└───────────────────────────────────────────┘");
        boolean complete = false;
        while (!complete) {
            System.out.print("Nhap lua chon: ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    Inventory.display();
                    break;
                case 2:
                    
                    break;
                case 3:
                    break;
                case 4:
                    complete = true;
                    break;
                default:
                    break;
            }
        }
    }
}
