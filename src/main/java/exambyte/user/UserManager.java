package exambyte.user;

import exambyte.Database.DatabaseManager;

import java.util.ArrayList;
import java.util.Optional;

public class UserManager {

    DatabaseManager manager = new DatabaseManager();

    public boolean userExists(String username) {
        return manager.exists(username);
    }

    public User getUser(String username) {
        return manager.getUser(username);
    }

    public Optional<Boolean> addUser(User user) {
//        Pruefen ob User berits existiert
//        userExists(user);
//        return Optional.of(false); //oder so
        manager.addUser(user);
        return Optional.of(true);
    }
}
