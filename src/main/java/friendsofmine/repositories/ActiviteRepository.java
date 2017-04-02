package friendsofmine.repositories;

import friendsofmine.domain.Activite;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by SoF on 02/04/2017.
 */
public interface ActiviteRepository extends PagingAndSortingRepository<Activite, Long> {
}
