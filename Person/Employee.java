package Person;

import java.util.Scanner;

public class Employee extends Person {
    private String ID;
    private double salary;
    private String jobDescription;
    private Scanner sc;

    public Employee() {
        super();
        this.sc = new Scanner(System.in);
    }

    public Employee(String name, Birth dob, String address, String email, String phone, String ID, double salary, String jobDescription) {
        super(name, dob, address, email, phone);
        this.ID = ID;
        this.salary = salary;
        this.jobDescription = jobDescription;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    @Override
    public void enterPerson() {
        boolean tiepTuc;
        do {
            super.enterPerson();

            System.out.println("├───────────────────────────────────────────┤");
            System.out.print("│ Nhap ID nhan vien: ");
            ID = sc.nextLine();

            double salaryInput = 0;
            boolean isValidSalary = false;
            do {
                try {
                    System.out.print("│ Nhap luong nhan vien: ");
                    salaryInput = Double.parseDouble(sc.nextLine());
                    isValidSalary = true;
                } catch (NumberFormatException e) {
                    System.out.println("├───────────────────────────────────────────┤");
                    System.out.println("│ Loi: Vui long nhap so hop le cho luong!   │");
                    System.out.println("├───────────────────────────────────────────┤");
                }
            } while (!isValidSalary);
            salary = salaryInput;

            System.out.print("│ Nhap mo ta cong viec cua nhan vien: ");
            jobDescription = sc.nextLine();

            Employee e = new Employee(getName(), getDob(), getAddress(), getPhone(), getEmail(), ID, salary, jobDescription);
            Employees.addEmployee(e);

            System.out.println("├───────────────────────────────────────────┤");
            System.out.print("│ Ban co muon nhap them nhan vien? (y/n): ");
            String answer = sc.nextLine();
            tiepTuc = answer.equalsIgnoreCase("y");
        } while (tiepTuc);
        System.out.println("└───────────────────────────────────────────┘");
    }
    @Override
    public void displayPerson() {
        super.displayPerson();
        System.out.printf("│ ID nhan vien   : %-24s │\n", ID);
        System.out.printf("│ Luong nhan vien  : $%-22.2f│\n", salary);
        System.out.printf("│ Mo ta cong viec  : %-22s │\n", jobDescription);
        System.out.println("└───────────────────────────────────────────┘");

    }
}
