package exambyte;

import java.util.ArrayList;

public class Users {
    ArrayList<User> users;

    public boolean userExists(String username, String password) {
        for (User user : users) {
            if(user.benutzername().equals(username) && user.passwort().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
