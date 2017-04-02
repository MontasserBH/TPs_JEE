package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import friendsofmine.repositories.ActiviteRepository;
import friendsofmine.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SoF on 02/04/2017.
 */
@Service
@Transactional
public class InitialisationService {

    @Autowired
    private ActiviteRepository activiteRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    private Utilisateur thom, mary;
    private Activite taekwondo, randonnee, lindyhop;

    public void initDonnees(){
        initUtilisateurs();
        initActivites();
    }

    public void initUtilisateurs(){
        initThom();
        initMary();
    }
    public void initActivites(){
        initTaekwondo();
        initLindyHop();
        initRandonnee();
    }

    private void initThom() {
        thom = new Utilisateur("Thom", "Thom", "thom@thom.com", "M");
        utilisateurRepository.save(thom);
    }

    private void initMary() {
        mary = new Utilisateur("Mary", "Mary", "mary@mary.com", "F");
        utilisateurRepository.save(mary);
    }

    private void initTaekwondo() {
        taekwondo = new Activite("Taekwondo", "le dimanche soir", thom);
        activiteRepository.save(taekwondo);
    }

    private void initLindyHop() {
        lindyhop = new Activite("Lindy Hop", "le jeudi soir", thom);
        activiteRepository.save(lindyhop);
    }

    private void initRandonnee() {
        randonnee = new Activite("Randonnee", "le lundi matin", mary);
        activiteRepository.save(randonnee);
    }

    public ActiviteRepository getActiviteRepository() {
        return activiteRepository;
    }

    public UtilisateurRepository getUtilisateurRepository() {
        return utilisateurRepository;
    }

    public Utilisateur getThom() {
        return thom;
    }

    public Utilisateur getMary() {
        return mary;
    }

    public Activite getTaekwondo() {
        return taekwondo;
    }

    public Activite getRandonnee() {
        return randonnee;
    }

    public Activite getLindyhop() {
        return lindyhop;
    }
}
