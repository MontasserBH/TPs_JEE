package friendsofmine.service;

import friendsofmine.domain.Utilisateur;
import friendsofmine.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by SoF on 02/04/2017.
 */
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public void saveUtilisateur(Utilisateur utilisateur){
        this.utilisateurRepository.save(utilisateur);
    }

    public Utilisateur findOneUtilisateur(Long id){
        return utilisateurRepository.findOne(id);
    }

    public ArrayList<Utilisateur> findAllUtilisateurs(){
        Iterable<Utilisateur> iterable = utilisateurRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "nom")));
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        iterable.forEach(utilisateurs::add);
        return utilisateurs;
    }

    public long countUtilisateur(){
        return utilisateurRepository.count();
    }

    public UtilisateurRepository getUtilisateurRepository() {
        return utilisateurRepository;
    }

    public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
}
