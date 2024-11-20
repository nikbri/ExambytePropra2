package exambyte.web;

import exambyte.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class LoginManagerTest {
    @Test
    @DisplayName("Login Test defaultUser")
    void test(){
        LoginManager loginManager = new LoginManager();
        assert(loginManager.isValidLogin("default","default"));
    }
}