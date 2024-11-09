package lockedout.sae.vehiculemicroservice.FeignClient;

import lockedout.sae.vehiculemicroservice.entities.DAO.Maintenance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "MAINTENANCEMICROSERVICE")
public interface MaintenanceFeign {

    @PostMapping("/maintenances")
    Maintenance addMaintenance(@RequestBody Maintenance maintenance);

    @PutMapping("/maintenances/{maintenanceId}")
    Maintenance updateMaintenance(@PathVariable("maintenanceId") Long maintenanceId, @RequestBody Maintenance maintenance);

    @GetMapping("/maintenances/{maintenanceId}")
    Maintenance getMaintenanceById(@PathVariable("maintenanceId") Long maintenanceId);

    @GetMapping("/maintenances/vehicle/{vehicleId}")
    List<Maintenance> getAllMaintenanceForVehicle(@PathVariable("vehicleId") Long vehicleId);

    @DeleteMapping("/maintenances/{maintenanceId}")
    void deleteMaintenance(@PathVariable("maintenanceId") Long maintenanceId);
}
