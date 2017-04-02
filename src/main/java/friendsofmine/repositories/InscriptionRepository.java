package friendsofmine.repositories;

import friendsofmine.domain.Inscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by SoF on 02/04/2017.
 */
public interface InscriptionRepository extends PagingAndSortingRepository<Inscription, Long> {
    public Page<Inscription> findByParticipantNomOrActiviteTitreAllIgnoreCase(String nom, String titre, Pageable pageable);
}
