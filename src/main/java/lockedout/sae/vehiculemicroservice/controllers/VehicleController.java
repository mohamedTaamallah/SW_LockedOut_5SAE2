package lockedout.sae.vehiculemicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lockedout.sae.vehiculemicroservice.entities.Vehicle;
import lockedout.sae.vehiculemicroservice.implementation.interfaces.IVehicleImp;

@RestController
@RequestMapping("/vehicleController")
public class VehicleController {



    @Autowired
    private IVehicleImp vehicleService;

    // Add a new vehicle
    @PostMapping("/addVehicle")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(this.vehicleService.addVehicle(vehicle));
    }

    // Get vehicle by ID
    @GetMapping("/getVehicleById/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(this.vehicleService.getVehicleById(id));
    }

    // Update an existing vehicle
    @PutMapping("/updateVehicle/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(this.vehicleService.updateVehicle(id,vehicle));

    }

    // Delete a vehicle by ID
    @DeleteMapping("/deleteVehicle/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable Long id) {
        return ResponseEntity.ok(this.vehicleService.deleteVehicle(id));

    }

    // Find vehicle by registration number
    @GetMapping("/findByRegistrationNumber/{registrationNumber}")
    public ResponseEntity<Vehicle> findByRegistrationNumber(@PathVariable String registrationNumber) {
        return ResponseEntity.ok(this.vehicleService.findByRegistrationNumber(registrationNumber));

    }
    
    // Optional: Get all vehicles (if you want to list them)
    @GetMapping("/getAllVehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(this.vehicleService.getAllVehicles());

    }
}
