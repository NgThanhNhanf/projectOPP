package Menu;
import java.util.*;
import java.io.*;

public class MainMenu {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();
        boolean complete = false;
        while (!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Welcome!!                 │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Dang nhap.                             │");
            System.out.println("│ 2. Dang ky.                               │");
            System.out.println("│ 3. Thoat.                                 │");
            System.out.println("└───────────────────────────────────────────┘");
            int choose = sc.nextInt();
            sc.nextLine();
            if (choose == 1) {
                System.out.println("-Chon dang nhap.");
                if (login.login()) {
                    System.out.println("vao Menu");
                }
            } else if (choose == 2) {
                System.out.println("-Chon dang ky.");
                if (login.register()) {
                    System.out.println("Vao Menu");
                }
            } else {
                System.out.println("-Chon thoat.");
                complete = true;
            }
        }
        sc.close();
    }
}
