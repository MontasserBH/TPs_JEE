package friendsofmine.service;

import friendsofmine.domain.Inscription;
import friendsofmine.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by SoF on 02/04/2017.
 */
@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    public void saveInscription(Inscription inscription) {
        inscriptionRepository.save(inscription);
    }

    public Inscription findOneInscription(Long id){
        return inscriptionRepository.findOne(id);
    }

    public long countInscription(){
        return inscriptionRepository.count();
    }

    public void deleteInscription(Long id){
        inscriptionRepository.delete(id);
    }

    public Page<Inscription> findAllInscription(Pageable pageable) {
        return inscriptionRepository.findAll(pageable);
    }

    public Page<Inscription> findAll(String nom, String titre, Pageable pageable) {
        return inscriptionRepository.findByParticipantNomOrActiviteTitreAllIgnoreCase(nom, titre , pageable);
    }

    public InscriptionRepository getInscriptionRepository() {
        return inscriptionRepository;
    }

    public void setInscriptionRepository(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }
}
