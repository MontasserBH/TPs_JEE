package friendsofmine.repositories;

import friendsofmine.domain.Utilisateur;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * Created by SoF on 02/04/2017.
 */
public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Long>, QueryByExampleExecutor<Utilisateur> {
}
