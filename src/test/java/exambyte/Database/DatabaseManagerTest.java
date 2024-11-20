package exambyte.Database;

import exambyte.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DatabaseManagerTest {
    @Test
    @DisplayName("DatenbankManager holt nur Initialwerte")
    void test01(){
        DatabaseManager datenbankmanager = new DatabaseManager();
        User user = new User("default","default","default");
        User testuser = datenbankmanager.getUser("default");
        assertThat(testuser).isEqualTo(user);
    }

    @Test
    @DisplayName("Benutzer hinzufuegen")
    void test02(){
        DatabaseManager datenbankmanager = new DatabaseManager();
        User user = new User("Testuser","TestEmail", "Testpasswort");
        datenbankmanager.addUser(user);
        User testuser = datenbankmanager.getUser("Testuser");
        assertThat(testuser).isEqualTo(user);
    }

    @Test
    @DisplayName("Benutzer validieren")
    void test03(){
        DatabaseManager datenbankmanager = new DatabaseManager();
        User user = new User("Testuser","TestEmail", "Testpasswort");
        datenbankmanager.addUser(user);
        assertThat(datenbankmanager.isValidUser("Testuser", "Testpasswort")).isTrue();
    }
}
