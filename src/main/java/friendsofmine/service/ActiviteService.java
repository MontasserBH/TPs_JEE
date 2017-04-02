package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import friendsofmine.repositories.ActiviteRepository;
import friendsofmine.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by SoF on 02/04/2017.
 */
@Service
public class ActiviteService {

    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public void saveActivite(Activite activite){
        if(activite == null){
            throw new IllegalArgumentException();
        }
        Utilisateur res = activite.getResponsable();
        if(res != null){
            utilisateurRepository.save(res);
            res.addActivite(activite);
        }
        this.activiteRepository.save(activite);
    }

    public Activite findOneActivite(Long id){
        return activiteRepository.findOne(id);
    }

    public ArrayList<Activite> findAllActivites(){
        Iterable<Activite> iterable = activiteRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "titre")));
        ArrayList<Activite> activites = new ArrayList<>();
        iterable.forEach(activites::add);
        return activites;
    }

    public long countActivite(){
        return activiteRepository.count();
    }

    public ActiviteRepository getActiviteRepository() {
        return activiteRepository;
    }

    public void setActiviteRepository(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

    public UtilisateurRepository getUtilisateurRepository() {
        return utilisateurRepository;
    }

    public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
}
