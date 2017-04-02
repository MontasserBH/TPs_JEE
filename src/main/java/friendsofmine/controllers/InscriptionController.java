package friendsofmine.controllers;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import friendsofmine.domain.Activite;
import friendsofmine.domain.Inscription;
import friendsofmine.exceptions.InscriptionNotFoundException;
import friendsofmine.repositories.ActiviteRepository;
import friendsofmine.repositories.UtilisateurRepository;
import friendsofmine.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by SoF on 02/04/2017.
 */
@RestController
public class InscriptionController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private ActiviteRepository activiteRepository;
    @Autowired
    private InscriptionService inscriptionService;

    @PostMapping("/api/inscription")
    public ResponseEntity<Inscription> createInscription(@RequestParam(value = "utilisateur_id") Long utilisateurId, @RequestParam(value = "activite_id") Long activiteId){
        Inscription inscription = new Inscription();
        inscription.setParticipant(utilisateurRepository.findOne(utilisateurId));
        inscription.setActivite(activiteRepository.findOne(activiteId));
        inscriptionService.saveInscription(inscription);
        return new  ResponseEntity<Inscription>(inscription, HttpStatus.CREATED);
    }

    @GetMapping("/api/inscription/{id}")
    public Inscription show(@PathVariable Long id){
        Inscription inscription = inscriptionService.findOneInscription(id);
        if(inscription == null){
            new InscriptionNotFoundException(id);
        }
        return inscription;
    }

    @DeleteMapping(value = "/api/inscription/{id}")
    public void delete(@PathVariable(value = "id") Long inscriptionId){
        inscriptionService.deleteInscription(inscriptionId);
    }

    @GetMapping(value = "/api/inscription/search")
    public Page<Inscription> searchInscriptions(@RequestParam(value = "nom_utilisateur",required = false)String nomUtilisateur,
                                                @RequestParam(value = "titre_activite",required = false)String titreActivite,
                                                Pageable pageable) {
        if (nomUtilisateur == null && titreActivite == null)
            return inscriptionService.findAllInscription(pageable);
        return inscriptionService.findAll(nomUtilisateur, titreActivite, pageable);
    }
}
