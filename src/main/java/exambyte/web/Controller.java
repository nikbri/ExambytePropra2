package exambyte.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String index(){
        return "redirect:wellcome";
    }
    @GetMapping("/wellcome")
    public String wellcome(){
        return "wellcome";
    }

    @GetMapping("/studentHomepage")
    @Secured("ROLE_STUDENT")
    public String studentlogin(OAuth2AuthenticationToken token, Model model) {
        String login = token.getPrincipal().getAttributes().get("login").toString();
        model.addAttribute("name", login);
        return "studentHomepage";
    }

    @GetMapping("/adminHomepage")
    @Secured("ROLE_ADMIN")
    public String adminLoginGET(){
        return "adminHomepage";
    }




}
