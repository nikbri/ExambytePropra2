package exambyte.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
public class WebTests {


    @Autowired
    MockMvc mvc;


    @Test
    @WithMockUser
    @DisplayName("Wellcome Seite erreichbar")
    public void test_welcome() throws Exception {
        mvc.perform(get("/wellcome"))
                .andExpect(status().isOk());
    }



}
