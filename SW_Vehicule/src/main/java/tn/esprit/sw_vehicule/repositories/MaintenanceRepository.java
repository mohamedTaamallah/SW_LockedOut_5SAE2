package tn.esprit.sw_vehicule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.sw_vehicule.entities.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Long> {
}
