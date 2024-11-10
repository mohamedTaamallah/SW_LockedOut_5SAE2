package com.esprit.tripmangement.restcontrollers;

import com.esprit.tripmangement.entities.Trip;
import com.esprit.tripmangement.services.TripServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private TripServiceImp tripService;

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        Trip trip = tripService.getTripById(id);
        return trip != null ? ResponseEntity.ok(trip) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip) {
        Trip createdTrip = tripService.addTrip(trip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip tripDetails) {
        Trip updatedTrip = tripService.updateTrip(id, tripDetails);
        return updatedTrip != null ? ResponseEntity.ok(updatedTrip) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<Trip>> getTripsByVehicleId(@PathVariable Long vehicleId) {
        List<Trip> trips = tripService.getTripsByVehicleId(vehicleId);
        return ResponseEntity.ok(trips);
    }
}
