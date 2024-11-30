package Search;

import Model.Clothing;
import Model.Inventory;
import Model.Product;
import Model.Shoes;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchBySize implements SearchMethod {
    Scanner sc = new Scanner(System.in);

    public void search() {
        boolean isSize = false;
        while (!isSize) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│    Tim kiem theo Clothing hoac Shoes      │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1.Size Clothing                           │");
            System.out.println("│ 2.Size Shoes                              │");
            System.out.println("│ 3. Thoat                                  │");
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

            sc.nextLine();
            switch (choose) {
                case 1:
                    boolean isClothing = false;
                    System.out.print("Nhap size ban muon tim kiem: ");
                    String x = sc.nextLine();
                    for (Product product : Inventory.getListInventory().keySet()) {
                        if (product instanceof Clothing) {
                            Clothing clothing = (Clothing) product; // Downcasting
                            if (clothing.getSize().equals(x)) {
                                clothing.displayInfor();
                                isClothing = true;
                            }
                        } else
                            continue;

                    }

                    if (!isClothing) {
                        System.out.println("khong tim thay size nao hop le");
                        System.out.println("ban co muon tim lai ? (y/n)");
                        char it = sc.next().charAt(0);
                        if (it == 'N' || it == 'n') {
                            System.out.println("tim kiem ket thuc");
                            break;
                        }
                    }
                    break;
                case 2:
                    boolean isShoes = false;
                    System.out.print("Nhap size giay ban muon tim kiem: ");
                    int y;
                    do {
                        try {
                            y = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Lua chon chi bao gom chu so. Vui long nhap lai.");
                            sc.nextLine(); // Xóa dữ liệu không hợp lệ trong bộ đệm
                        }
                    } while (true);

                    for (Product product : Inventory.getListInventory().keySet()) {
                        if (product instanceof Shoes) {
                            Shoes shoes = (Shoes) product;
                            if (shoes.getSize() == y) {
                                shoes.displayInfor();
                                isShoes = true;
                            }
                        } else
                            continue;
                    }
                    if (!isShoes) {
                        System.out.println("khong tim thay size nao hop le");
                        System.out.println("ban co muon tim lai ? (y/n)");
                        char v = sc.next().charAt(0);
                        if (v == 'N' || v == 'n') {
                            System.out.println("tim kiem ket thuc");
                            break;
                        }
                    }
                    break;
                case 3:
                    isSize = true;
                    break;
            }
        }
    }
}
