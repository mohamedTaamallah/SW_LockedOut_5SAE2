package tn.esprit.sw_vehicule.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.sw_vehicule.entities.Maintenance;
import tn.esprit.sw_vehicule.repositories.MaintenanceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceServiceImp implements IMaintenance{
    private MaintenanceRepository maintenanceRepository;
    @Override
    public Maintenance addMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance updateMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> getAllMaintenance() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance getMaintenanceById(long idM) {
        return maintenanceRepository.findById(idM).orElse(null);
    }

    @Override
    public void deleteMaintenance(long idM) {
        maintenanceRepository.deleteById(idM);

    }
}
