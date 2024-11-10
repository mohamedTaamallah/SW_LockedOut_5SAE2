package tn.esprit.sw_vehicule.services;

import tn.esprit.sw_vehicule.entities.Maintenance;

import java.util.List;

public interface IMaintenance {
    Maintenance addMaintenance(Maintenance maintenance);
    Maintenance getMaintenanceById(Long maintenanceId);
    List<Maintenance> getAllMaintenanceForVehicle(Long vehicleId);
    Maintenance updateMaintenance(Long maintenanceId, Maintenance maintenance);
    void deleteMaintenance(Long maintenanceId);
}
