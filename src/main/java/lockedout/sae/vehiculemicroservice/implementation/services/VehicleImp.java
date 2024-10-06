package lockedout.sae.vehiculemicroservice.implementation.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import lockedout.sae.vehiculemicroservice.entities.Vehicle;
import lockedout.sae.vehiculemicroservice.implementation.interfaces.IVehicleImp;
import lockedout.sae.vehiculemicroservice.repositories.VehicleRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VehicleImp implements IVehicleImp{

    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return this.vehicleRepository.findByRegistrationNumber(vehicle.getRegistrationNumber()) != null ? null : this.vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {
        return this.vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new NoSuchElementException("Vehicle not found"));
    }

    @Override
    public Vehicle updateVehicle(Long vehicleId,Vehicle vehicle) {
        Vehicle existingVehicle = this.getVehicleById(vehicleId);
        existingVehicle.setRegistrationNumber(vehicle.getRegistrationNumber());
        existingVehicle.setMileage(vehicle.getMileage());
        existingVehicle.setBrand(vehicle.getBrand());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setYear(vehicle.getYear());
        existingVehicle.setType(vehicle.getType());
        existingVehicle.setFuelCapacity(vehicle.getFuelCapacity());
        existingVehicle.setAverageConsumption(vehicle.getAverageConsumption());
        return this.vehicleRepository.save(existingVehicle); 
    }

    @Override
    public Vehicle deleteVehicle(Long vehicleId) {
        Vehicle existingVehicle = this.getVehicleById(vehicleId);
        this.vehicleRepository.delete(existingVehicle);
        return existingVehicle;

    }

    @Override
    public Vehicle findByRegistrationNumber(String registrationNumber) {
        return this.vehicleRepository.findByRegistrationNumber(registrationNumber);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

}
