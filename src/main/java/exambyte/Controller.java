package exambyte;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String wellcome(){
        return "wellcome";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


}
