package exambyte;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String wellcome(){
        return "wellcome";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


}
