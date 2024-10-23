package Accounts;
import java.util.*;

public class Users {
    private static List<User> users = new ArrayList<>();
    public Users(){}
    public Users(List<User> users) {
        Users.users = users;
    }
    public static void enterUsers() {
        
    }
    public static void displayUsers() {
        for (User cur : users) {
            cur.displayUser();
        }
    }
    public static void addUser(User newUser) {
        users.add(newUser);
    }
    public static int findUser(String userid) {
        for (int i = 0; i < users.size(); ++i) {
            User cur = users.get(i);
            if(cur.getUserId().equals(userid)) {
                return i;
            }
        }
        return -1;
    }
    public static void removeUser(String userid) { 
        int userPosition = findUser(userid);
        users.remove(userPosition);
    }
    public static boolean checkId(User user) {
        for (User cur : users) {
            if (cur.equals(user)) {
                return true;
            }
        }
        return false;
    }
}
