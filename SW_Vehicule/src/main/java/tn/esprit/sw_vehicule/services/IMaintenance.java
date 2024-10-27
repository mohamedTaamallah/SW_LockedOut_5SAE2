package tn.esprit.sw_vehicule.services;

import tn.esprit.sw_vehicule.entities.Maintenance;

import java.util.List;

public interface IMaintenance {
    public Maintenance addMaintenance(Maintenance maintenance);
    public Maintenance updateMaintenance (Maintenance maintenance);
    public List<Maintenance> getAllMaintenance();
    public Maintenance getMaintenanceById( long idM);
    public void deleteMaintenance(long idM);

}
