package Person;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private static List<Employee> listEmployee = new ArrayList<>();
    public static void addEmployee(Employee e) {
        listEmployee.add(e);
    }
    public static void viewEmployee() {
        if (listEmployee.isEmpty()) {
            System.out.println("│ Danh sách nhân viên: Rỗng.");
        } else {
            System.out.println("├───────────────────────────────────────────┤");
            for (Employee e : listEmployee) {
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
}
