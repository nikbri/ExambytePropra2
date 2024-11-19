package exambyte;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.boot.web.server.Cookie;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class Controller {

    //Datenbank Zugriff auf die Users soll das darstellen, hab aber keine Ahnung
    // wie sowas funktioniert.
    Users users = new Users();

    @GetMapping("/")
    public String wellcome(){
        return "wellcome";
    }

    @GetMapping("/studentLogin")
    public String login(Model model,
                        @RequestParam(defaultValue = "Benutzername") String benutzer,
                        @RequestParam(defaultValue = "Passwort") String passwort) {
        if(benutzer.equals("Benutzername") || passwort.equals("Passwort")){
            model.addAttribute("benutzer", benutzer);
            model.addAttribute("passwort", passwort);
            return "studentLogin";
        }
        if (users.userExists(benutzer, passwort)) {
            return "redirect:/Startseite";
        }
        model.addAttribute("benutzer", benutzer);
        model.addAttribute("passwort", "Passwort");
        return "studentLogin";
    }
    @GetMapping("/adminLogin")
    public String adminLogin(){
        return "adminLogin";
    }
    @GetMapping("/Startseite")
    public String landingpage(){
        return "Startseite";
    }



}
