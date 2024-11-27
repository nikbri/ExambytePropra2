package exambyte.user;

import exambyte.Database.DatabaseManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@Disabled
public class UserManagerTest {
    @Test
    @DisplayName("DefaultUser existiert")
    void test0(){
        DatabaseManager datenbankmanager = new DatabaseManager();
        assertThat(datenbankmanager.exists("default")).isTrue();
    }

    @Test
    @DisplayName("User hinzufügen")
    void test1(){
        UserManager usermanager = new UserManager();
        User newuser = new User("Testuser","TestEmail", "Testpasswort");
        usermanager.addUser(newuser);
        assertThat(usermanager.userExists("Testuser")).isTrue();
    }

    @Test
    @DisplayName("Bereits vorhandener User hinzufügen")
    void test2(){
        UserManager usermanager = new UserManager();
        User newuser = new User("Testuser","TestEmail", "Testpasswort");
        User newuser2 = new User("Testuser","TestEmail", "Testpasswort");
        usermanager.addUser(newuser);
        Optional<Boolean> result = usermanager.addUser(newuser2);
        assertThat(result.orElse(null)).isFalse();

    }
}
