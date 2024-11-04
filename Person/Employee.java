package Person;

import java.util.Scanner;

public class Employee extends Person {
    private String ID;
    private double salary;
    private String jobDescription;
    Scanner sc = new Scanner(System.in);

    public Employee() {
        super();
    }

    public Employee(String name, Birth dob, String address, String phone, String ID, double salary, String jobDescription) {
        super(name, dob, address, phone);
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

            Employee e = new Employee(getName(), getDob(), getAddress(), getPhone(), ID, salary, jobDescription);
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
    @Override
    public void editAll() {
        Employee newEmployee = new Employee();
        newEmployee.enterPerson();
        setName(newEmployee.getName());
        setBirth(newEmployee.getDob());
        setAddress(newEmployee.getAddress());
        setPhone(newEmployee.getPhone());
        setID(newEmployee.getID());
        setSalary(newEmployee.getSalary());
        setJobDescription(newEmployee.getJobDescription());
    }
    @Override
    public void editPerson() {
        boolean complete = false;
        while(!complete) {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│        Chon thong tin can chinh sua       │");
            System.out.println("├───────────────────────────────────────────┤");
            System.out.println("│ 1. Ten                                    │");
            System.out.println("│ 2. Ngay sinh                              │");
            System.out.println("│ 3. Dia chi                                │");
            System.out.println("│ 4. SDT                                    │");
            System.out.println("│ 5. ID                                     │");
            System.out.println("│ 6. Luong                                  │");
            System.out.println("│ 7. Cong viec                              │");
            System.out.println("│ 8. Tat ca                                 │");
            System.out.println("│ 9. Thoat                                  │");
            System.out.println("└───────────────────────────────────────────┘");
            System.out.println("Nhap lua chon:");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1: 
                    editName();
                    break;
                case 2:
                    editBirth();
                    break;
                case 3:
                    editAddress();
                    break;
                case 4:
                    editPhone();
                    break;
                case 5:
                    editId();
                    break;
                case 6:
                    editSalary();
                    break;
                case 7:
                    editJob();
                    break;
                case 8:
                    editAll();
                    break;
                case 9:
                    System.out.println("Thoat");
                    complete = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le vui long nhap lai");
                    break;
            }
        }
    }
    public void editId() {
        System.out.print("Nhap id moi: ");
        String newId = sc.nextLine();
        setID(newId);
        System.out.println("Cap nhat hoan tat!");
    }
    public void editSalary() {
        System.out.print("Nhap luong moi: ");
        double newSalary = sc.nextDouble();
        setSalary(newSalary);
        System.out.println("Cap nhat hoan tat!");        
    }
    public void editJob() {
        System.out.print("Nhap cong viec moi: ");
        String newJob = sc.nextLine();
        setJobDescription(newJob);
        System.out.println("Cap nhat hoan tat!");
    }
}
