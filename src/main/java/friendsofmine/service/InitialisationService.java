package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by SoF on 02/04/2017.
 */
@Service
public class InitialisationService {

    private ArrayList<Activite> activites = new ArrayList<>();
    private ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

    public void initDonnees(){
        initThom();
        initMary();
        initTaekwondo();
        initLindyHop();
        initRandonnee();
    }

    private void initThom() {
        utilisateurs.add(new Utilisateur("Thom", "Thom", "thom@thom.com", "M"));
    }

    private void initMary() {
        utilisateurs.add(new Utilisateur("Mary", "Mary", "mary@mary.com", "F"));
    }

    private void initTaekwondo() {
        activites.add(new Activite("Taekwondo", "le dimanche soir"));

    }

    private void initLindyHop() {
        activites.add(new Activite("Lindy Hop", "le jeudi soir"));
    }

    private void initRandonnee() {
        activites.add(new Activite("Randonnee", "le lundi matin"));
    }

    public ArrayList<Activite> getActivites() {
        return activites;
    }

    public ArrayList<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setActivites(ArrayList<Activite> activites) {
        this.activites = activites;
    }

    public void setUtilisateurs(ArrayList<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
