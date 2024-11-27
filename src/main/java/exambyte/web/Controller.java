package exambyte.web;

import exambyte.user.UserManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String login() {
        return "studentHomepage";
    }

    @GetMapping("/adminHomepage")
    public String adminLoginGET(){
        return "adminHomepage";
    }




}
