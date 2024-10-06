package lockedout.sae.vehiculemicroservice.implementation.interfaces;

import java.util.List;

import lockedout.sae.vehiculemicroservice.entities.Vehicle;

public interface IVehicleImp {
        // Basic CRUD Operations
    Vehicle addVehicle(Vehicle vehicle);
    
    Vehicle getVehicleById(Long vehicleId);
    
    Vehicle updateVehicle(Long vehicleId,Vehicle vehicle);
    
    Vehicle deleteVehicle(Long vehicleId);
    
    // Query Methods
    Vehicle findByRegistrationNumber(String registrationNumber);

    List<Vehicle> getAllVehicles();

}
