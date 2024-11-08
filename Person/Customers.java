// Customers.java
package Person;

import java.io.*;
import java.util.*;
import File.fileWork;

public class Customers implements fileWork {
    private static List<Customer> listCustomer = new ArrayList<>();
    public static boolean isPhoneExist(String phone) {
        for (Customer c : listCustomer) {
            if (c.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public static void addCustomer(Customer e) {
        if (!isPhoneExist(e.getPhone())) {
            listCustomer.add(e);
        } else {
            System.out.println("So dien thoai da ton tai. Cap nhat thong tin khach hang nay.");
            updateCustomer(e.getPhone());
        }
    }

    private static void updateCustomer(String phone) {
        for (Customer c : listCustomer) {
            if (c.getPhone().equals(phone)) {
                c.editPerson();
                break;
            }
        }
    }
    @Override
    public void readFile() throws FileNotFoundException {
        // File myFile = new File("D:\\Study\\OOP\\projectOPP\\Person\\customersData.txt");
        // File myFile = new File("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Person\\customersData.txt");
        File myFile = new File("C:\\OOP\\projectOPP\\Person\\customersData.txt");
        Scanner scf = new Scanner(myFile);
        while(scf.hasNextLine()) {
            String line = scf.nextLine();
            if(line == "") return;
            String[] arrstr = line.split("\\|");
            String[] arrdob = arrstr[1].split("\\/");
            Birth birth = new Birth(Integer.parseInt(arrdob[0]), Integer.parseInt(arrdob[1]), Integer.parseInt(arrdob[2]));
            Customer newCustomer = new Customer(arrstr[0], birth, arrstr[2], arrstr[3]);
            Customers.addCustomer(newCustomer);
        }
        scf.close();
    }

    @Override
    public void writeFile() throws IOException {
        // FileWriter myFile = new FileWriter("D:\\Study\\OOP\\projectOPP\\Person\\customersData.txt");
        // FileWriter myFile = new FileWriter("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Person\\customersData.txt");
        FileWriter myFile = new FileWriter("C:\\OOP\\projectOPP\\Person\\customersData.txt");
        for (Customer cur : listCustomer) {
            myFile.write(cur.getName() + '|' + cur.getDob().getDay() + '/' + cur.getDob().getMonth() + '/' + cur.getDob().getYear() + '|' + cur.getAddress() + '|' + cur.getPhone() + '\n');
        }
        myFile.close();
    }

    public static void fileInit() throws FileNotFoundException {
        Customers customers = new Customers();
        customers.readFile();
    }

    public static void fileClose() throws IOException {
        Customers customers = new Customers();
        customers.writeFile();
    }

    public static void viewCustomer() {
        if (listCustomer.isEmpty()) {
            System.out.println("│         Danh sach khach hang rong.        │");
        } else {
            System.out.println("├───────────────────────────────────────────┤");
            int index = 1;
            for (Customer e : listCustomer) {
                System.out.printf("│ STT            : %02d                       │\n", index++);
                CustomerUI.phoneInList.add(e.getPhone());
                e.displayPerson();
                System.out.println("├───────────────────────────────────────────┤");
            }
        }
    }

    public static Customer findCustomer(String phone) { 
        for (Customer cur : listCustomer) {
            if (cur.getPhone().equals(phone)) {
                return cur;
            }
        }
        return null;
    }

    public static void deleteCustomer(String phone) {
        listCustomer.removeIf(c -> c.getPhone().equals(phone));
    }
}