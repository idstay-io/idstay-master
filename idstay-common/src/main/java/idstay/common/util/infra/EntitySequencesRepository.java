package idstay.common.util.infra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by minsoo.kim@jkglobe.com on 16. 10. 8.
 */
public interface EntitySequencesRepository extends JpaRepository<EntitySequences, Long>{
    Optional<EntitySequences> findByEntityName(EntityName entityName);
}
