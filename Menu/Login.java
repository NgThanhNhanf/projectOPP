package Menu;

import Accounts.User;

public class Login {
    private User loginUser;
    Login(){}
    public void login() {
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("│                 Dang nhap                 │");
        System.out.println("├───────────────────────────────────────────┤");
        loginUser.enterUser();
        
    }
    public void register() {
        
    }
}
