package exambyte.web;

import exambyte.Database.DatabaseManager;
import exambyte.user.UserManager;

public class LoginManager {
    DatabaseManager databaseManager = new DatabaseManager();
    boolean isValidLogin(String username, String passwort){
        return databaseManager.isValidUser(username,passwort);
    }
}
