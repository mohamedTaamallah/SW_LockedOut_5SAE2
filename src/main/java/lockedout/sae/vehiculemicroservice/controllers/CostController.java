package lockedout.sae.vehiculemicroservice.controllers;

import lockedout.sae.vehiculemicroservice.entities.DAO.Cost;
import lockedout.sae.vehiculemicroservice.implementation.services.VehicleImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles/{vehicleId}/costs")
public class CostController {

    @Autowired
    private VehicleImp vehicleService;

    @PostMapping
    public ResponseEntity<Cost> addCostToVehicle(@PathVariable Long vehicleId, @RequestBody Cost cost) {
        Cost createdCost = vehicleService.addCostToVehicle(vehicleId, cost);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCost);
    }

    @GetMapping("/{costId}")
    public ResponseEntity<Cost> getCostByIdForVehicle(@PathVariable Long vehicleId, @PathVariable Long costId) {
        try {
            Cost cost = vehicleService.getCostByIdForVehicle(vehicleId, costId);
            return ResponseEntity.ok(cost);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Cost>> getAllCostsForVehicle(@PathVariable Long vehicleId) {
        List<Cost> costs = vehicleService.getAllCostsForVehicle(vehicleId);
        return ResponseEntity.ok(costs);
    }

    @PutMapping("/{costId}")
    public ResponseEntity<Cost> updateCostForVehicle(@PathVariable Long vehicleId, @PathVariable Long costId, @RequestBody Cost cost) {
        try {
            Cost updatedCost = vehicleService.updateCostForVehicle(vehicleId, costId, cost);
            return ResponseEntity.ok(updatedCost);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{costId}")
    public ResponseEntity<Void> deleteCostForVehicle(@PathVariable Long vehicleId, @PathVariable Long costId) {
        try {
            vehicleService.deleteCostForVehicle(vehicleId, costId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
