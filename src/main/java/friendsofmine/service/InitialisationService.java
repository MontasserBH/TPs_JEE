package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Inscription;
import friendsofmine.domain.Utilisateur;
import friendsofmine.repositories.ActiviteRepository;
import friendsofmine.repositories.InscriptionRepository;
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
    @Autowired
    private InscriptionRepository inscriptionRepository;

    private Utilisateur thom, mary;
    private Activite taekwondo, randonnee, lindyhop;
    private Inscription maryOnTaekwondo,thomOnRandonnee,thomOnLindyhop;

    public void initDonnees(){
        initThom();
        initMary();
        initTaekwondo();
        initLindyHop();
        initRandonnee();
    }

    public void initInscriptions(){
        initMaryOnTaekwondo();
        initThomOnRandonnee();
        initThomOnLindyhop();
    }

    public void initMaryOnTaekwondo(){
        maryOnTaekwondo = new Inscription();
        maryOnTaekwondo.setParticipant(mary);
        maryOnTaekwondo.setActivite(taekwondo);
        inscriptionRepository.save(maryOnTaekwondo);
    }

    public void initThomOnRandonnee(){
        thomOnRandonnee = new Inscription();
        thomOnRandonnee.setParticipant(thom);
        thomOnRandonnee.setActivite(randonnee);
        inscriptionRepository.save(thomOnRandonnee);
    }

    public void initThomOnLindyhop(){
        thomOnLindyhop = new Inscription();
        thomOnLindyhop.setParticipant(thom);
        thomOnLindyhop.setActivite(lindyhop);
        inscriptionRepository.save(thomOnLindyhop);
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

    public InscriptionRepository getInscriptionRepository() {
        return inscriptionRepository;
    }

    public Inscription getMaryOnTaekwondo() {
        return maryOnTaekwondo;
    }

    public Inscription getThomOnRandonnee() {
        return thomOnRandonnee;
    }

    public Inscription getThomOnLindyhop() {
        return thomOnLindyhop;
    }
}
