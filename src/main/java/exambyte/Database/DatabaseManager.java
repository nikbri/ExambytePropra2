package exambyte.Database;

import exambyte.user.User;
import jakarta.validation.constraints.Null;

public class DatabaseManager {
    DummyDatenbank dummy = new DummyDatenbank();

    public User getUser(String username){
        return dummy.get(username);
    }
    public Boolean exists(String username) {
        return dummy.userexists(username);
    }
    public void addUser(String username,String email, String password) {
        User user = new User(username, email, password);
        dummy.add(user);
    }

    public void addUser(User user) {
        dummy.add(user);
    }
    //Benutzername und password validieren
    //So verlässt das User-objekt nicht die Datenbank
    //Gerne verbessern
    public boolean isValidUser(String username,String password){
        String email = getUser(username).email();
        User login = new User(username,email,password);
        return dummy.contains(login);
    }
}
