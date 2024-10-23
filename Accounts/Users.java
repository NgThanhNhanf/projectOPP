package Accounts;
import java.util.*;

public class Users {
    private List<User> users = new ArrayList<>();
    public Users(){}
    public Users(List<User> users) {
        this.users = users;
    }
    public void enterUsers() {
        
    }
    public void displayUsers() {
        for (User cur : users) {
            cur.displayUser();
        }
    }
    public void addUser(User newUser) {
        users.add(newUser);
    }
    public void removeUser(String userid) { 
        for (int i = 0; i < users.size(); ++i) {
            User cur = users.get(i);
            if(cur.getUserId().equals(userid)) {
                users.remove(i);
                i--;
            }
        }
    }
}
