package friendsofmine.controllers;

import friendsofmine.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by SoF on 02/04/2017.
 */
@Controller
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/utilisateurs")
    public String list(Model model){
        model.addAttribute("utilisateur", utilisateurService.findAllUtilisateurs());
        return "utilisateurs";
    }
}
