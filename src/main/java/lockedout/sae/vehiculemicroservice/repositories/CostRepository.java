package lockedout.sae.vehiculemicroservice.repositories;

import lockedout.sae.vehiculemicroservice.entities.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends JpaRepository<Cost,Long> {
}
