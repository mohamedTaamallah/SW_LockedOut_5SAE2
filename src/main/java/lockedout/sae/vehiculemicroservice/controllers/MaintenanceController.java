package lockedout.sae.vehiculemicroservice.controllers;

import lockedout.sae.vehiculemicroservice.entities.DAO.Maintenance;
import lockedout.sae.vehiculemicroservice.implementation.services.VehicleImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles/{vehicleId}/maintenances")
public class MaintenanceController {

    @Autowired
    private VehicleImp vehicleMaintenanceService;

    // Add maintenance record to a specific vehicle
    @PostMapping
    public ResponseEntity<Maintenance> addMaintenanceToVehicle(
            @PathVariable Long vehicleId,
            @RequestBody Maintenance maintenance) {
        Maintenance createdMaintenance = vehicleMaintenanceService.addMaintenanceToVehicle(vehicleId, maintenance);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMaintenance);
    }

    // Get maintenance record by ID for a specific vehicle
    @GetMapping("/{maintenanceId}")
    public ResponseEntity<Maintenance> getMaintenanceByIdForVehicle(
            @PathVariable Long vehicleId,
            @PathVariable Long maintenanceId) {
        Maintenance maintenance = vehicleMaintenanceService.getMaintenanceByIdForVehicle(vehicleId, maintenanceId);
        return ResponseEntity.ok(maintenance);
    }

    // Get all maintenance records for a specific vehicle
    @GetMapping
    public ResponseEntity<List<Maintenance>> getAllMaintenanceForVehicle(@PathVariable Long vehicleId) {
        List<Maintenance> maintenances = vehicleMaintenanceService.getAllMaintenanceForVehicle(vehicleId);
        return ResponseEntity.ok(maintenances);
    }

    // Update maintenance record for a specific vehicle
    @PutMapping("/{maintenanceId}")
    public ResponseEntity<Maintenance> updateMaintenanceForVehicle(
            @PathVariable Long vehicleId,
            @PathVariable Long maintenanceId,
            @RequestBody Maintenance maintenance) {
        Maintenance updatedMaintenance = vehicleMaintenanceService.updateMaintenanceForVehicle(vehicleId, maintenanceId, maintenance);
        return ResponseEntity.ok(updatedMaintenance);
    }

    // Delete maintenance record for a specific vehicle
    @DeleteMapping("/{maintenanceId}")
    public ResponseEntity<Void> deleteMaintenanceForVehicle(
            @PathVariable Long vehicleId,
            @PathVariable Long maintenanceId) {
        vehicleMaintenanceService.deleteMaintenanceForVehicle(vehicleId, maintenanceId);
        return ResponseEntity.noContent().build();
    }
}
