package Person;

import java.util.Scanner;
import java.util.regex.*;

public class Person {
    private String name;
    private Birth dob = new Birth();
    private String address;
    private String phone;
    private String email;
    Scanner sc = new Scanner(System.in);
    public Person() {}
    public Person(String name, Birth dob, String address, String phone, String email) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    public boolean validName() {
        return name.length() > 0;
    }
    public boolean validEmail() {
        Pattern patternEmail = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+\\.[a-zA-Z0-9._%+-]{2,}");
        Matcher matcher = patternEmail.matcher(email);
        return matcher.matches();
    }
    public boolean validPhone() {
        Pattern patternPhone = Pattern.compile("0\\d{9}");
        Matcher matcher = patternPhone.matcher(phone);
        return matcher.matches();
    }
    public void enterPerson() {
        boolean valid = false;
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│               Nhap thong tin              │");
        System.out.println("├───────────────────────────────────────────┤");
        while(!valid) {
            System.out.print("│ Ten         : ");
            name = sc.nextLine();
            valid = validName();
            if (!valid) { 
                System.out.println("Khong de trong ten.");
            }
        }
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("│ Ngay sinh                                 │");
        System.out.println("├───────────────────────────────────────────┤");
        dob.enterBirth();
        System.out.print("│ Dia chi         : ");
        address = sc.nextLine();
        valid = false;
        while(!valid) {
            System.out.print("│ So dien thoai         : ");
            phone = sc.nextLine();
            valid = validPhone();
            if (!valid) {
                System.out.println("So dien thoai khong hop le, vui long thu lai.");
            }
        }
        valid = false;
        while(!valid) {
            System.out.print("│ Email         : ");
            email = sc.nextLine();
            valid = validPhone();
            if (!valid) {
                System.out.println("Email khong hop le, vui long thu lai.");
            }
        }
    }
    public void displayPerson() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│             Thông tin cá nhân             │");
        System.out.println("├───────────────────────────────────────────┤");
        System.out.printf("│ Tên            : %-24s │\n", name);
        System.out.printf("│ Ngày sinh      : %02d/%02d/%04d               │\n", dob.getDay(), dob.getMonth(), dob.getYear());
        System.out.printf("│ Địa chỉ        : %-24s │\n", address);
        System.out.printf("│ SĐT            : %-24s │\n", phone);
        System.out.printf("│ Email          : %-24s │\n", email);
    }
    public String getName() {
        return name;
    }
    public Birth getDob() {
        return dob;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
}
