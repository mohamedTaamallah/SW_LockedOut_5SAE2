package lockedout.sae.vehiculemicroservice.FeignClient;

import lockedout.sae.vehiculemicroservice.entities.DAO.Trip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "TRIPMICROSERVICE")
public interface TripFeign {

    @GetMapping("/trips")
    List<Trip> getAllTrips();

    @GetMapping("/trips/{id}")
    Trip getTripById(@PathVariable("id") Long id);

    @PostMapping("/trips")
    Trip addTrip(@RequestBody Trip trip);

    @PutMapping("/trips/{id}")
    Trip updateTrip(@PathVariable("id") Long id, @RequestBody Trip trip);

    @DeleteMapping("/trips/{id}")
    void deleteTrip(@PathVariable("id") Long id);

    @GetMapping("/trips/vehicle/{vehicleId}")
    List<Trip> getTripsByVehicleId(@PathVariable("vehicleId") Long vehicleId);
}
