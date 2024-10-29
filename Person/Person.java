package Person;

import java.util.Scanner;

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
    public boolean validEmail() {
        
        return false;
    }
    public boolean validPhone() {
        return false;
    }
    public void enterPerson() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│               Nhap thong tin              │");
        System.out.println("├───────────────────────────────────────────┤");
        System.out.print("│ Ten         : ");
        name = sc.nextLine();
        System.out.println("├───────────────────────────────────────────┤");
        System.out.println("│ Ngay sinh                                 │");
        System.out.println("├───────────────────────────────────────────┤");
        dob.enterBirth();
        System.out.print("│ Dia chi         : ");
        address = sc.nextLine();
        System.out.print("│ So dien thoai         : ");
        phone = sc.nextLine();
        System.out.print("│ Email         : ");
        email = sc.nextLine();
        System.out.println("└───────────────────────────────────────────┘");
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
