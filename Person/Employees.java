package Person;

import File.fileWork;
import Search.SearchList;
import java.io.*;
import java.util.*;

public class Employees implements fileWork, SearchList{
    private static List<Employee> listEmployee = new ArrayList<>();
    public static void addEmployee(Employee e) {
        listEmployee.add(e);
    }
    @Override
    public void readFile() throws FileNotFoundException {
        // File myFile = new File("D:\\Study\\OOP\\projectOPP\\Person\\employeesData.txt");      
        // File myFile = new File("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Person\\employeesData.txt");        
        // File myFile = new File("D:\\Workspace\\Test\\temp\\projectOPP\\Person\\employeesData.txt");        
        File myFile = new File("C:\\OOP\\projectOPP\\Person\\employeesData.txt");        
        Scanner scf = new Scanner(myFile);
        while(scf.hasNextLine()) {
            String line = scf.nextLine();
            if(line == "") return;
            String [] arrstr = line.split("\\|");
            String [] arrdob = arrstr[1].split("\\/");
            Birth birth = new Birth(Integer.parseInt(arrdob[0]), Integer.parseInt(arrdob[1]), Integer.parseInt(arrdob[2]));
            Employee newEmployee = new Employee(arrstr[0], birth, arrstr[2], arrstr[3], arrstr[4], Double.parseDouble(arrstr[5]), arrstr[6]);
            Employees.addEmployee(newEmployee);
        }
        scf.close();
    }
    @Override
    public void writeFile() throws IOException {
        // FileWriter myFile = new FileWriter("D:\\Study\\OOP\\projectOPP\\Person\\employeesData.txt");
        // FileWriter myFile = new FileWriter("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Person\\employeesData.txt");
        // FileWriter myFile = new FileWriter("D:\\Workspace\\Test\\temp\\projectOPP\\Person\\employeesData.txt");
        FileWriter myFile = new FileWriter("C:\\OOP\\projectOPP\\Person\\employeesData.txt");
        for (Employee cur : listEmployee) {
            myFile.write(cur.getName() + '|' + cur.getDob().getDay() + '/' + cur.getDob().getMonth() + '/' + cur.getDob().getYear() + '|' + cur.getAddress() + '|' + cur.getPhone() + '|' + cur.getID() + '|' + cur.getSalary() + '|' + cur.getJobDescription() + '\n');
        }
        myFile.close();
    }
    public static void fileInit() throws FileNotFoundException {
        Employees employees = new Employees();
        employees.readFile();
    }
    public static void fileClose() throws IOException {
        Employees employees = new Employees();
        employees.writeFile();
    }
    public static void viewEmployee() {
        if (listEmployee.isEmpty()) {
            System.out.println("│ Danh sach nhan vien rong.");
        } else {
            System.out.println("├───────────────────────────────────────────┤");
            int index = 1;
            for (Employee e : listEmployee) {
                System.out.printf("│ STT            : %02d                       │\n", index++);
                EmployeeUI.phoneInList.add(e.getPhone());
                e.displayPerson();
            }
        }
    }
    public static boolean checkId(String userid) {
        for (Employee cur : listEmployee) {
            if (cur.getID().equals(userid)) return true;
        }
        return false;
    }
    public static Employee findEmployee(String phone) { 
        for (Employee cur : listEmployee) {
            if (cur.getPhone().equals(phone)) {
                return cur;
            }
        }
        return null;
    }
    public static void deleteEmployee(String Id) {
        for (int i = 0; i < listEmployee.size(); ++i) {
            if (listEmployee.get(i).getID().equals(Id)) {
                listEmployee.remove(i);
                return;
            }
        }
    }
    public static Employee getEmployee(String id) {
        for (Employee cur : listEmployee) {
            if (cur.getID().equals(id)) return cur;
        }
        return null;
    }
    @Override
    public List<String> searching(String id) {
        List<String> arr = new ArrayList<>();
        for (Employee cur : listEmployee) {
            if (cur.getID().contains(id) || cur.getName().contains(id)) arr.add(cur.getID());
        }
        return arr;
    }
}