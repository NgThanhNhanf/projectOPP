package Accounts;
import java.util.*;
import File.fileWork;
import Person.Employee;

import java.io.*;

public class Users implements fileWork {
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
        Scanner scf = new Scanner(myFile);
        while (scf.hasNextLine()) {
            String line = scf.nextLine();
            String [] arrstr = line.split("\\|");
            User newUser = new User(arrstr[0], arrstr[1], arrstr[2]);
            users.add(newUser);
        }
        scf.close();
    }
    @Override
    public void writeFile() throws IOException {
        FileWriter myFile = new FileWriter("D:\\Study\\OOP\\projectOPP\\Accounts\\accountsData.txt");
        for (User cur : users) {
            myFile.write(cur.getUserName() + '|' + cur.getPassword() + '|' + cur.getUserId() + '\n');
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
        for (User cur : users) {
            cur.displayUser();
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
    public static boolean checkUser(User user) {
        for (User cur : users) {
            if (cur.getUserName().equals(user.getUserName()) && cur.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
