package Person;

import java.util.Scanner;

public class Birth {
    private int day;
    private int month;
    private int year;
    Scanner sc = new Scanner(System.in);
    public Birth () {}
    public Birth(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public boolean validBirth() {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                if (day >= 1 && day <= 31) return true;
                else return false;
            case 4, 6, 9, 11: 
                if (day >= 1 && day <= 30) return true;
                else return false;
            case 2:
                int tmp = 28;
                if ((year%4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    tmp = 29;
                }
                if (day >= 1 && day <= tmp) return true;
                else return false;
            default:
                return false;
        }
    }
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    public void displayBirth() {
        System.out.println(day + "/" + month + "/" + year);
    }
    public void enterBirth() {
        boolean complete = false;
        while (!complete) {
            System.out.print("│ Ngay         : ");
            day = sc.nextInt();
            System.out.print("│ Thang         : ");
            month = sc.nextInt();
            System.out.print("│ Nam         : ");
            year = sc.nextInt();
            complete = validBirth();
            if (!complete) {
                System.out.println("├───────────────────────────────────────────┤");
                System.out.println("│ Ngày tháng năm sinh không hợp lệ.         │");
                System.out.println("│ Vui lòng nhập lại.                        │");
                System.out.println("├───────────────────────────────────────────┤");
            }
        }

    }
}
