package Person;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import File.fileWork;

public class Customers implements fileWork {
    private static List<Customer> listCustomer = new ArrayList<>();
    @Override
    public void readFile() throws FileNotFoundException {
        // File myFile = new File("D:\\Study\\OOP\\projectOPP\\Person\\customersData.txt");
        File myFile = new File("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Person\\customersData.txt");
        Scanner scf = new Scanner(myFile);
        while(scf.hasNextLine()) {
            String line = scf.nextLine();
            if(line == "") return;
            String [] arrstr = line.split("\\|");
            String [] arrdob = arrstr[1].split("\\/");
            Birth birth = new Birth(Integer.parseInt(arrdob[0]), Integer.parseInt(arrdob[1]), Integer.parseInt(arrdob[2]));
            Customer newCustomer = new Customer(arrstr[0], birth, arrstr[2], arrstr[3]);
            Customers.addCustomer(newCustomer);
        }
        scf.close();
    }
    @Override
    public void writeFile() throws IOException {
        // FileWriter myFile = new FileWriter("D:\\Study\\OOP\\projectOPP\\Person\\customersData.txt");
        FileWriter myFile = new FileWriter("C:\\\\OOP\\\\projectOPP\\\\Person\\\\customersData.txt");
        for (Customer cur : listCustomer) {
            myFile.write(cur.getName() + '|' + cur.getDob().getDay() + '/' + cur.getDob().getMonth() + '/' + cur.getDob().getYear() + '|' + cur.getAddress() + '|' + cur.getPhone() + '\n');
        }
        myFile.close();
    }
    public static void fileInit() throws FileNotFoundException {
        Customers customer = new Customers();
        customer.readFile();
    }
    public static void fileClose() throws IOException {
        Customers customers = new Customers();
        customers.writeFile();
    }
    public static void addCustomer(Customer e) {
        if (!isPhoneExist(e.getPhone())) {
            listCustomer.add(e);
        } else {
            System.out.println("So dien thoai da ton tai trong danh sach khach hang. Cap nhat don hang cho khach hang nay.");
            updateOrderCustomer(e.getPhone());
        }
    }
    public static boolean isPhoneExist(String phone) {
        for (Customer c : listCustomer) {
            if (c.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }
    private static void updateOrderCustomer(String phone) {
        for (Customer c : listCustomer) {
            if (c.getPhone().equals(phone)) {
                c.enterPerson();
                break;
            }
        }
    }
    public static void viewCustomer() {
        if (listCustomer.isEmpty()) {
            System.out.println("│ Danh sach khach hang rong.");
        } else {
            System.out.println("├───────────────────────────────────────────┤");
            for (Customer e : listCustomer) {
                e.displayPerson();
            }
        }
    }
}