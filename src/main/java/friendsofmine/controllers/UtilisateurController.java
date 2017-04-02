package friendsofmine.controllers;

import friendsofmine.domain.Utilisateur;
import friendsofmine.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

    @GetMapping("/utilisateur/{id}")
    public String reed(Model model, @PathVariable Long id){
        Utilisateur utilisateur = utilisateurService.findOneUtilisateur(id);
        if(utilisateur == null){
            return "error";
        }
        model.addAttribute("utilisateur", utilisateur);
        return "utilisateurShow";
    }

    @GetMapping("/utilisateur/new")
    public String newUtilisateur(Model model){
        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateurForm";
    }

    @PostMapping("/utilisateur")
    public String saveUtilisateur(@Valid Utilisateur utilisateur, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.print(bindingResult.getAllErrors());
            return "utilisateurForm";
        }
        utilisateurService.saveUtilisateur(utilisateur);
        return "redirect:/utilisateur/" + utilisateur.getId();
    }

    @GetMapping("/utilisateur/edit/{id}")
    public String editUtilisateur(Model model, @PathVariable Long id){
        Utilisateur util = utilisateurService.findOneUtilisateur(id);
        if(util == null){
            return "error";
        }
        model.addAttribute("utilisateur", utilisateurService.findOneUtilisateur(id));
        return "utilisateurForm";
    }

    @RequestMapping("/utilisateur/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (utilisateurService.findOneUtilisateur(id).getActivites().isEmpty()){
            utilisateurService.deleteUtilisateur(id);
            return "redirect:/utilisateurs";
        }
        model.addAttribute("customMessage", "Impossible. L'utilisateur est responsable d'activités");
        return "error";
    }

}
