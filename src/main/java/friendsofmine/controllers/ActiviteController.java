package friendsofmine.controllers;

import friendsofmine.service.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by SoF on 02/04/2017.
 */
@Controller
public class ActiviteController {

    @Autowired
    private ActiviteService activiteService;

    @GetMapping("/activites")
    public String list(Model model){
        model.addAttribute("activite", activiteService.findAllActivites());
        return "activites";
    }
}
