package exambyte.web;

import exambyte.user.UserManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    //Datenbank Zugriff auf die Users soll das darstellen, hab aber keine Ahnung
    // wie sowas funktioniert.
    UserManager users = new UserManager();
    LoginManager loginManager = new LoginManager();

    @GetMapping("/")
    public String index(){
        return "redirect:wellcome";
    }
    @GetMapping("/wellcome")
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
        if (users.userExists(benutzer)) {
            if (loginManager.isValidLogin(benutzer,passwort)){
                return "redirect:/Startseite";
            }
            //Ansonsten Falsches passwort melden
        }
//        else {} Benutzer nicht vorhanden melden

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
