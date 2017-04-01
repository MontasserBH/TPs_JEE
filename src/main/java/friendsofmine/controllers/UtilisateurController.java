package friendsofmine.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import friendsofmine.Bootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SoF on 02/04/2017.
 */
@Controller
public class UtilisateurController {

    @Autowired
    private Bootstrap bootstrap;

    @GetMapping("/utilisateurs")
    public String list(Model model){
        model.addAttribute("utilisateur", bootstrap.getInitialisationService().getUtilisateurs());
        return "utilisateurs";
    }
}
