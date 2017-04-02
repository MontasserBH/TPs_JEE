package friendsofmine.repositories;

import friendsofmine.domain.Utilisateur;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by SoF on 02/04/2017.
 */
public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Long> {
}
