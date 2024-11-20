package exambyte.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
public class WebTests {


    @Autowired
    MockMvc mvc;


    @Test
    @DisplayName("Wellcome Seite erreichbar")
    public void test_welcome() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Login ohne Parameter aufrufen")
    public void test_login() throws Exception {
        mvc.perform(get("/studentLogin"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Login User Exists")
    public void test_login_exists() throws Exception {

        mvc.perform(get("/studentLogin?benutzer=default&passwort=default"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/Startseite"));
    }

    @Test
    @DisplayName("Login User do not Exists")
    public void test_login_dont_exists() throws Exception {

        mvc.perform(get("/studentLogin?benutzer=Name&passwort=default"))
                .andExpect(status().isOk())
                .andExpect(view().name("studentLogin"))
                .andExpect(model().attribute("benutzer", "Name"));
    }

}
