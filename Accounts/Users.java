package Accounts;
import java.util.*;
import File.fileWork;
import Person.Customer;
import Person.Employee;
import Person.EmployeeUI;
import Search.SearchList;
import java.io.*;

public class Users implements fileWork, SearchList{
    private static List<User> users = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public Users(){}
    public Users(List<User> users) {
        Users.users = users;
    }
    // đọc file từ file text lên vào Users
    @Override
    public void readFile() throws FileNotFoundException {
        File myFile = new File("D:\\Study\\OOP\\projectOPP\\Accounts\\accountsData.txt");
        // File myFile = new File("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Accounts\\accountsData.txt");
        // File myFile = new File("D:\\Workspace\\Test\\temp\\projectOPP\\Accounts\\accountsData.txt");
        // File myFile = new File("C:\\OOP\\projectOPP\\Accounts\\accountsData.txt");
        Scanner scf = new Scanner(myFile);
        while (scf.hasNextLine()) {
            String line = scf.nextLine();
            String [] arrstr = line.split("\\|");
            User newUser = new User(arrstr[0], arrstr[1], arrstr[2], arrstr[3]);
            users.add(newUser);
        }
        scf.close();
    }
    @Override
    public void writeFile() throws IOException {
        FileWriter myFile = new FileWriter("D:\\Study\\OOP\\projectOPP\\Accounts\\accountsData.txt");
        // FileWriter myFile = new FileWriter("D:\\Java\\Nhom14\\OOP-hanh\\DoAnOOP\\Project\\Accounts\\accountsData.txt");
        // FileWriter myFile = new FileWriter("D:\\Workspace\\Test\\temp\\projectOPP\\Accounts\\accountsData.txt");
        // FileWriter myFile = new FileWriter("C:\\OOP\\projectOPP\\Accounts\\accountsData.txt");
        for (User cur : users) {
            myFile.write(cur.getUserName() + '|' + cur.getPassword() + '|' + cur.getUserId() + '|' + cur.getRole() + '\n');
        }
        myFile.close();
    }
    public static void fileInit() throws FileNotFoundException {
        Users users = new Users();
        users.readFile();
    }
    public static void fileClose() throws IOException {
        Users users = new Users();
        users.writeFile();
    }
    public static void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("Danh sach tai khoan rong.");
        } else {
            System.out.println("┌───────────────────────────────────────────┐");
            System.out.println("│                 Tai khoan                 │");
            int index = 1;
            for (User cur : users) {
                System.out.println("├───────────────────────────────────────────┤");
                System.out.printf("│ STT            : %02d                       │\n", index++);
                UserUI.idUser.add(cur.getUserId());
                cur.displayUser();
            }
        }
    }
    //Thêm User
    public static void addUser(User newUser) {
        users.add(newUser);
    }
    //Tìm User theo userId
    public static int findUser(String userid) {
        for (int i = 0; i < users.size(); ++i) {
            User cur = users.get(i);
            if(cur.getUserId().equals(userid)) {
                return i;
            }
        }
        return -1;
    }
    // Xóa User theo userId dùng boolean để check xem là có xóa được hay không
    // nếu không tìm thấy id thì trong menu ta sẽ cho nhập lại
    public static boolean removeUser(String userid) { 
        int userPosition = findUser(userid);
        if (userPosition == -1) {
            return false;
        } else {
            String choose;
            System.out.println("-Ban co chac chan muon xoa tai khoan " + userid + "?(y/n)");
            choose = sc.next();
            if (choose == "y") {
                users.remove(userPosition);
                System.out.println("-Xoa tai khoan thanh cong!");
            }
            return true;
        }
    }
    //Kiểm tra xem user có tồn tại hay chưa (dùng để đăng nhập)
    public static User checkUser(User user) {
        for (User cur : users) {
            if (cur.getUserName().equals(user.getUserName()) && cur.getPassword().equals(user.getPassword())) {
                return cur;
            }
        }
        return null;
    }
    public static User getUser(String userId) {
        for (User cur : users) {
            if (cur.getUserId().equals(userId)) return cur;
        }
        return null;
    }
    @Override
    public List<String> searching(String id) {
        List<String> arr = new ArrayList<>();
        for (User cur : users) {
            if (cur.getUserName().contains(id) || cur.getUserId().contains(id)) arr.add(cur.getUserId());
        }
        return arr;
    }
}
