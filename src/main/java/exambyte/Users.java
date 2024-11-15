package exambyte;

import jakarta.validation.constraints.Email;

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

    public void addUser(String username, Email email, String password) {
        User user = new User(username, email, password);
        users.add(user);
        return;
    }
}
