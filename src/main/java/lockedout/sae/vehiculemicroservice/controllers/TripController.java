package lockedout.sae.vehiculemicroservice.controllers;

import lockedout.sae.vehiculemicroservice.entities.DAO.Trip;
import lockedout.sae.vehiculemicroservice.implementation.services.VehicleImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles/{vehicleId}/trips")
public class TripController {

    @Autowired
    private VehicleImp vehicleService;

    @PostMapping
    public ResponseEntity<Trip> addTripToVehicle(@PathVariable Long vehicleId, @RequestBody Trip trip) {
        Trip createdTrip = vehicleService.addTripToVehicle(vehicleId, trip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrip);
    }

    @GetMapping("/{tripId}")
    public ResponseEntity<Trip> getTripByIdForVehicle(@PathVariable Long vehicleId, @PathVariable Long tripId) {
        try {
            Trip trip = vehicleService.getTripByIdForVehicle(vehicleId, tripId);
            return ResponseEntity.ok(trip);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAllTripsForVehicle(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(vehicleService.getAllTripsForVehicle(vehicleId));
    }

    @PutMapping("/{tripId}")
    public ResponseEntity<Trip> updateTripForVehicle(@PathVariable Long vehicleId, @PathVariable Long tripId, @RequestBody Trip trip) {
        try {
            Trip updatedTrip = vehicleService.updateTripForVehicle(vehicleId, tripId, trip);
            return ResponseEntity.ok(updatedTrip);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{tripId}")
    public ResponseEntity<Void> deleteTripForVehicle(@PathVariable Long vehicleId, @PathVariable Long tripId) {
        try {
            vehicleService.deleteTripForVehicle(vehicleId, tripId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
