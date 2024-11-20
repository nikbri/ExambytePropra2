package exambyte.Database;

import exambyte.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DummyDatenbank {
    HashSet<User> users = new HashSet<>();

    DummyDatenbank(){
        User defaultUser = new User("default", "default", "default");
        users.add(defaultUser);
    }
    public User get(String username){
        for (User user : users) {
            if(user.benutzername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    boolean contains(User user){
        return users.contains(user);
    }

    public Boolean userexists(String username) {
        List<String> names = users.stream()
                .map(User::benutzername)
                .toList();
        return names.contains(username);
    }

    public void add(User user) {
        users.add(user);
    }
}
