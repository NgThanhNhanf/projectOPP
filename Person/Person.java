package Person;

import java.util.Scanner;
import java.util.regex.*;

public abstract class Person {
    private String phone;
    private String name;
    private Birth dob = new Birth();
    private String address;
    Scanner sc = new Scanner(System.in);
    public Person() {}
    public Person(String name, Birth dob, String address, String phone) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;;
    }
    public boolean validName() {
        return name.length() > 0;
    }
    public boolean validPhone(String phone) {
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
            valid = validPhone(phone);
            if (!valid) {
                System.out.println("So dien thoai khong hop le, vui long thu lai.");
            }
        }
    }
    public void displayPerson() {
        // System.out.println("┌───────────────────────────────────────────┐");
        // System.out.println("│             Thông tin cá nhân             │");
        // System.out.println("├───────────────────────────────────────────┤");
        System.out.printf("│ Ten            : %-24s │\n", name);
        System.out.printf("│ Ngay sinh      : %02d/%02d/%04d               │\n", dob.getDay(), dob.getMonth(), dob.getYear());
        System.out.printf("│ Dia chi        : %-24s │\n", address);
        System.out.printf("│ SDT            : %-24s │\n", phone);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Birth getDob() {
        return dob;
    }
    public void setBirth(Birth dob) {
        this.dob = dob;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void editName() {
        System.out.print("Nhap ten moi: ");
        String in = sc.nextLine();
        setName(in);
        System.out.println("Cap nhat hoan tat!");
    }
    public void editBirth() {
        System.out.println("Nhap ngay sinh:");
        Birth newBirth = new Birth();
        newBirth.enterBirth();
        setBirth(newBirth);
        System.out.println("Cap nhat hoan tat!");
    }
    public void editAddress() {
        System.out.print("Nhap dia chi moi: ");
        String newAddress = sc.nextLine();
        setAddress(newAddress);
        System.out.println("Cap nhat hoan tat!");
    }
    public void editPhone() {
        boolean tmp = false;
        while (!tmp) {
            System.out.print("Nhap SDT moi: ");
            String newPhone = sc.nextLine();
            tmp = validPhone(newPhone);
            if (!tmp) System.out.println("So dien thoai khong hop le, vui long thu lai.");
            else {
                setPhone(newPhone);
                System.out.println("Cap nhat hoan tat!");
            }
        }
    }
    public abstract void editPerson();
    public abstract void editAll();
}