package tn.esprit.sw_vehicule.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sw_vehicule.entities.Maintenance;
import tn.esprit.sw_vehicule.services.IMaintenance;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceController {

    @Autowired
    private IMaintenance maintenanceService;

    @PostMapping
    public ResponseEntity<Maintenance> addMaintenance(@RequestBody Maintenance maintenance) {
        return ResponseEntity.ok(maintenanceService.addMaintenance(maintenance));
    }

    @PutMapping("/{maintenanceId}")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable Long maintenanceId, @RequestBody Maintenance maintenance) {
        return ResponseEntity.ok(maintenanceService.updateMaintenance(maintenanceId, maintenance));
    }

    @GetMapping("/{maintenanceId}")
    public ResponseEntity<Maintenance> getMaintenanceById(@PathVariable Long maintenanceId) {
        return ResponseEntity.ok(maintenanceService.getMaintenanceById(maintenanceId));
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<Maintenance>> getAllMaintenanceForVehicle(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(maintenanceService.getAllMaintenanceForVehicle(vehicleId));
    }

    @DeleteMapping("/{maintenanceId}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable Long maintenanceId) {
        maintenanceService.deleteMaintenance(maintenanceId);
        return ResponseEntity.noContent().build();
    }
}
