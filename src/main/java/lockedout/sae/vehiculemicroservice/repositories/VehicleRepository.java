package lockedout.sae.vehiculemicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lockedout.sae.vehiculemicroservice.entities.Vehicle;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long > {
    
    Vehicle findByRegistrationNumber(String registrationNumber);
    List<Vehicle> findByUserId (Long userId);
}
