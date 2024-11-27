package exambyte.Database;

import exambyte.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DummyDatenbank {
    HashMap<String,User> users = new HashMap();

    DummyDatenbank(){
        User dave = new User("Catchme1fyoucan", "exmaple@hhu.com", "1234", "ROLE_ORGANIZER");
        users.put(dave.benutzername(), dave);
    }
    public User get(String username){
        for (User user : users.values()) {
            if(user.benutzername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    boolean contains(User user){
        return users.containsKey(user.benutzername());
    }

    public Boolean userexists(String username) {
        List<String> names = users.keySet().stream()
                .toList();
        return names.contains(username);
    }

    public void add(User user) {
        users.put(user.benutzername(), user);
    }

    public List<String> getAdmins() {
        return users.keySet().stream()
                .filter(name -> users.get(name).role().equals("ROLE_ADMIN"))
                .toList();
    }

    public String getRole(String name) {
        return users.get(name).role();
    }
}
