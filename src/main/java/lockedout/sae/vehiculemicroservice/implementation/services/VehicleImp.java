package lockedout.sae.vehiculemicroservice.implementation.services;

import lockedout.sae.vehiculemicroservice.FeignClient.CostFeign;
import lockedout.sae.vehiculemicroservice.FeignClient.DocumentFeign;
import lockedout.sae.vehiculemicroservice.FeignClient.MaintenanceFeign;
import lockedout.sae.vehiculemicroservice.FeignClient.TripFeign;
import lockedout.sae.vehiculemicroservice.entities.DAO.Cost;
import lockedout.sae.vehiculemicroservice.entities.DAO.Document;
import lockedout.sae.vehiculemicroservice.entities.DAO.Maintenance;
import lockedout.sae.vehiculemicroservice.entities.DAO.Trip;
import lockedout.sae.vehiculemicroservice.entities.Vehicle;
import lockedout.sae.vehiculemicroservice.implementation.interfaces.IVehicleImp;
import lockedout.sae.vehiculemicroservice.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VehicleImp implements IVehicleImp {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private DocumentFeign documentFeign;

    @Autowired
    private CostFeign costFeign;

    @Autowired
    private TripFeign tripFeign;

    @Autowired
    private MaintenanceFeign maintenanceFeign;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        if (vehicle.getRegistrationNumber() == null || vehicle.getRegistrationNumber().isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be null or empty");
        }
        if (vehicleRepository.findByRegistrationNumber(vehicle.getRegistrationNumber()) != null) {
            throw new IllegalArgumentException("Vehicle with this registration number already exists");
        }
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new NoSuchElementException("Vehicle not found"));
    }

    @Override
    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicle) {
        Vehicle existingVehicle = getVehicleById(vehicleId);
        existingVehicle.setRegistrationNumber(vehicle.getRegistrationNumber());
        existingVehicle.setMileage(vehicle.getMileage());
        existingVehicle.setBrand(vehicle.getBrand());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setYear(vehicle.getYear());
        existingVehicle.setType(vehicle.getType());
        existingVehicle.setFuelCapacity(vehicle.getFuelCapacity());
        existingVehicle.setAverageConsumption(vehicle.getAverageConsumption());
        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public Vehicle deleteVehicle(Long vehicleId) {
        Vehicle existingVehicle = getVehicleById(vehicleId);
        vehicleRepository.delete(existingVehicle);
        return existingVehicle;
    }

    @Override
    public Vehicle findByRegistrationNumber(String registrationNumber) {
        return vehicleRepository.findByRegistrationNumber(registrationNumber);
    }

    @Override
    public List<Vehicle> getAllVehicles(Long userId) {
        return vehicleRepository.findByUserId(userId);
    }

    // Document Methods




    @Override
    public void deleteDocumentForVehicle(Long vehicleId, Long documentId) {
        Document existingDocument = documentFeign.getDocumentById(documentId);
        if (existingDocument.getVehicleId().equals(vehicleId)) {
            documentFeign.deleteDocument(documentId);
        } else {
            throw new IllegalArgumentException("Document does not belong to the specified vehicle.");
        }
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentFeign.getAllDocuments();
    }

    @Override
    public List<Document> getDocumentsForVehicle(Long vehicleId) {
        return documentFeign.getDocumentsByVehicleId(vehicleId);
    }

    // Trip Methods
    @Override
    public Document addDocumentToVehicle(Long vehicleId, Document document) {
        document.setVehicleId(vehicleId);
        return documentFeign.addDocument(document);
    }
    @Override
    public Trip addTripToVehicle(Long vehicleId, Trip trip) {
        trip.setVehicleId(vehicleId);
        return tripFeign.addTrip(trip);
    }
    @Override
    public Document updateDocumentForVehicle(Long vehicleId, Long documentId, Document document) {
        Document existingDocument = documentFeign.getDocumentById(documentId);
        if (existingDocument.getVehicleId().equals(vehicleId)) {
            document.setVehicleId(vehicleId);
            return documentFeign.updateDocument(documentId, document);
        } else {
            throw new IllegalArgumentException("Document does not belong to the specified vehicle.");
        }
    }

    @Override
    public Trip updateTripForVehicle(Long vehicleId, Long tripId, Trip trip) {
        Trip existingTrip = tripFeign.getTripById(tripId);
        if (existingTrip.getVehicleId().equals(vehicleId)) {
            trip.setVehicleId(vehicleId);
            return tripFeign.updateTrip(tripId, trip);
        } else {
            throw new IllegalArgumentException("Trip does not belong to the specified vehicle.");
        }
    }

    @Override
    public Maintenance addMaintenanceToVehicle(Long vehicleId, Maintenance maintenance) {
        maintenance.setVehicleId(vehicleId); // Set the vehicle ID on the trip
        return maintenanceFeign.addMaintenance(maintenance);
    }

    @Override
    public void deleteTripForVehicle(Long vehicleId, Long tripId) {
        Trip existingTrip = tripFeign.getTripById(tripId);
        if (existingTrip.getVehicleId().equals(vehicleId)) {
            tripFeign.deleteTrip(tripId);
        } else {
            throw new IllegalArgumentException("Trip does not belong to the specified vehicle.");
        }
    }

    @Override
    public List<Trip> getAllTripsForVehicle(Long vehicleId) {
        return tripFeign.getTripsByVehicleId(vehicleId);
    }

    @Override
    public Trip getTripByIdForVehicle(Long vehicleId, Long tripId) {
        Trip trip = tripFeign.getTripById(tripId);
        if (trip.getVehicleId().equals(vehicleId)) {
            return trip;
        } else {
            throw new IllegalArgumentException("Trip does not belong to the specified vehicle.");
        }
    }

    // Cost Methods
    @Override
    public Cost addCostToVehicle(Long vehicleId, Cost cost) {
        cost.setVehicleId(vehicleId);
        return costFeign.addCost(cost);
    }

    @Override
    public Cost updateCostForVehicle(Long vehicleId, Long costId, Cost cost) {
        Cost existingCost = costFeign.getCostById(costId);
        if (existingCost.getVehicleId().equals(vehicleId)) {
            cost.setVehicleId(vehicleId);
            return costFeign.updateCost(costId, cost);
        } else {
            throw new IllegalArgumentException("Cost does not belong to the specified vehicle.");
        }
    }

    @Override
    public void deleteCostForVehicle(Long vehicleId, Long costId) {
        Cost existingCost = costFeign.getCostById(costId);
        if (existingCost.getVehicleId().equals(vehicleId)) {
            costFeign.deleteCost(costId);
        } else {
            throw new IllegalArgumentException("Cost does not belong to the specified vehicle.");
        }
    }

    @Override
    public List<Cost> getAllCostsForVehicle(Long vehicleId) {
        return costFeign.getCostsByVehicleId(vehicleId);
    }

    @Override
    public Cost getCostByIdForVehicle(Long vehicleId, Long costId) {
        Cost cost = costFeign.getCostById(costId);
        if (cost.getVehicleId().equals(vehicleId)) {
            return cost;
        } else {
            throw new IllegalArgumentException("Cost does not belong to the specified vehicle.");
        }
    }

    // Get all maintenance records for a specific vehicle
    public List<Maintenance> getAllMaintenanceForVehicle(Long vehicleId) {
        return maintenanceFeign.getAllMaintenanceForVehicle(vehicleId);
    }

    // Get a specific maintenance record by ID for a vehicle
    public Maintenance getMaintenanceByIdForVehicle(Long vehicleId, Long maintenanceId) {
        Maintenance maintenance = maintenanceFeign.getMaintenanceById(maintenanceId);
        if (!maintenance.getVehicleId().equals(vehicleId)) {
            throw new IllegalArgumentException("Maintenance record does not belong to the specified vehicle.");
        }
        return maintenance;
    }

    // Update a maintenance record for a specific vehicle
    public Maintenance updateMaintenanceForVehicle(Long vehicleId, Long maintenanceId, Maintenance maintenance) {
        maintenance.setVehicleId(vehicleId);
        return maintenanceFeign.updateMaintenance(maintenanceId, maintenance);
    }

    // Delete a maintenance record for a specific vehicle
    public void deleteMaintenanceForVehicle(Long vehicleId, Long maintenanceId) {
        Maintenance maintenance = getMaintenanceByIdForVehicle(vehicleId, maintenanceId);
        maintenanceFeign.deleteMaintenance(maintenanceId);
    }

}
