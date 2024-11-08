package Person;

import java.util.*;
import File.fileWork;
import java.io.*;

public class Employees implements fileWork {
    private static List<Employee> listEmployee = new ArrayList<>();
    public static void addEmployee(Employee e) {
        listEmployee.add(e);
    }
    @Override
    public void readFile() throws FileNotFoundException {
        // File myFile = new File("D:\\Study\\OOP\\projectOPP\\Person\\employeesData.txt");              
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
                System.out.printf("│ STT            : %02d │\n", index++);
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
}
