package tn.esprit.sw_vehicule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.sw_vehicule.entities.Maintenance;
import tn.esprit.sw_vehicule.repositories.MaintenanceRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MaintenanceServiceImp implements IMaintenance {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance addMaintenance(Maintenance maintenance) {
        // Log the received maintenance object to confirm vehicleId is present
        System.out.println("Saving Maintenance with Vehicle ID: " + maintenance.getVehicleId());
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance updateMaintenance(Long id, Maintenance maintenance) {
        Maintenance existingMaintenance = getMaintenanceById(id);
        existingMaintenance.setMaintenanceDate(maintenance.getMaintenanceDate());
        existingMaintenance.setMaintenanceType(maintenance.getMaintenanceType());
        existingMaintenance.setMileageAtMaintenance(maintenance.getMileageAtMaintenance());
        existingMaintenance.setCost(maintenance.getCost());
        existingMaintenance.setGarage(maintenance.getGarage());
        existingMaintenance.setStatus(maintenance.getStatus());
        existingMaintenance.setVehicleId(maintenance.getVehicleId()); // Ensure vehicleId is maintained
        return maintenanceRepository.save(existingMaintenance);
    }

    @Override
    public Maintenance getMaintenanceById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Maintenance not found"));
    }

    @Override
    public List<Maintenance> getAllMaintenanceForVehicle(Long vehicleId) {
        return maintenanceRepository.findByVehicleId(vehicleId);
    }

    @Override
    public void deleteMaintenance(Long id) {
        maintenanceRepository.deleteById(id);
    }
}
