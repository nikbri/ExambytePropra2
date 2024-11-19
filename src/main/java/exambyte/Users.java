package exambyte;

import java.util.ArrayList;

public class Users {

    ArrayList<User> users = new ArrayList<>();

    //Konstruktor ist nur provisorisch, um einen default User zum testen zu haben...

    /*Wusste es nicht anders zu lösen, auch wenn das natürlich nicht gut programmiert ist
    wenn der arrange Schritt im produktiv code ist.
    Bei Ideen gerne refactorn und melden (Niklas)*/
    public Users() {
        User defaultUser = new User("default", "default", "default");
        users.add(defaultUser);
    }


    public boolean userExists(String username, String password) {
        for (User user : users) {
            if(user.benutzername().equals(username) && user.passwort().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String username){
        for (User user : users) {
            if(user.benutzername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(String username,String email, String password) {
        User user = new User(username, email, password);
        users.add(user);
        return;
    }
    public void addUser(User user) {
        users.add(user);
    }
}
