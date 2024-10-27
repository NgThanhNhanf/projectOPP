package Person;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Birth {
    int day;
    int month;
    int year;
}

public class Person {
    Scanner sc = new Scanner(System.in);
    private String name;
    private Birth dob;
    private String address;
    private String phone;
    private String email;

    public String getName() {
        return name;
    }
    public Birth getDob() {
        return dob;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }

    public Person() {
        dob = new Birth();
    }

    // 26/10/2024 Hiền viết thêm hàm khởi tạo 2 tham số 
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Person(String name, Birth dob, String address, String phone, String email){
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    public void nhap() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│            Nhập thông tin cá nhân         │");
        System.out.println("├───────────────────────────────────────────┤");

        // Nhập tên
        System.out.print("│ Nhập tên          : ");
        name = sc.nextLine();

        // Nhập ngày tháng năm sinh
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("│ Nhập ngày tháng năm sinh                  │");
        boolean kt;
        do {
            try {
                System.out.print("│ Ngày (dd)        : ");
                dob.day = sc.nextInt();
                System.out.print("│ Tháng (mm)       : ");
                dob.month = sc.nextInt();
                System.out.print("│ Năm (yyyy)       : ");
                dob.year = sc.nextInt();

                kt = isValidDate(dob.day, dob.month, dob.year);
                if (!kt) {
                    System.out.println("├───────────────────────────────────────────┤");
                    System.out.println("│ Ngày tháng năm sinh không hợp lệ.         │");
                    System.out.println("│ Vui lòng nhập lại.                        │");
                }
            } catch (InputMismatchException e) {
                System.out.println("├───────────────────────────────────────────┤");
                System.out.println("│ Lỗi: Vui lòng nhập số nguyên hợp lệ!      │");
                System.out.println("│ Vui lòng nhập lại.                        │");
                sc.nextLine();
                kt = false;
            }
        } while (!kt);

        sc.nextLine();

        System.out.println("├───────────────────────────────────────────┤");
        System.out.print("│ Nhập địa chỉ     : ");
        address = sc.nextLine();

        // Nhập số điện thoại
        do {
            System.out.println("├───────────────────────────────────────────┤");
            System.out.print("│ Nhập số điện thoại: ");
            phone = sc.nextLine();
            if (!isValidPhone(phone)) {
                System.out.println("├───────────────────────────────────────────┤");
                System.out.println("│ Lỗi : Số điện thoại không hợp lệ.         │\n" +
                                   "│ Vui lòng nhập lại.                        │");
            }
        } while (!isValidPhone(phone));

        // Nhập email
        do {
            System.out.println("├───────────────────────────────────────────┤");
            System.out.print("│ Nhập email       : ");
            email = sc.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("├───────────────────────────────────────────┤");
                System.out.println("│ Lỗi : Email không hợp lệ.                 │\n" +
                                   "│ Vui lòng nhập lại.                        │");
            }
        } while (!isValidEmail(email));

//        System.out.println("└───────────────────────────────────────────┘");
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }
        int[] daysInMonth = { 31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        return day > 0 && day <= daysInMonth[month - 1];
    }

    public static boolean isValidPhone(String phone) {
        String phoneRegex = "^(\\+84|0)\\d{9,10}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        // Biểu thức chính quy kiểm tra email
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public void xuat() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│             Thông tin cá nhân             │");
        System.out.println("├───────────────────────────────────────────┤");
        System.out.printf("│ Tên            : %-24s │\n", this.name);
        System.out.printf("│ Ngày sinh      : %02d/%02d/%04d               │\n", this.dob.day, this.dob.month, this.dob.year);
        System.out.printf("│ Địa chỉ        : %-24s │\n", this.address);
        System.out.printf("│ SĐT            : %-24s │\n", this.phone);
        System.out.printf("│ Email          : %-24s │\n", this.email);

    }


}
