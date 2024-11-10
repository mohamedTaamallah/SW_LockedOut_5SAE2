package tn.esprit.sw_vehicule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.sw_vehicule.entities.Maintenance;
import java.util.List;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    List<Maintenance> findByVehicleId(Long vehicleId);
}
