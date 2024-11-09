package lockedout.sae.vehiculemicroservice.implementation.interfaces;

import lockedout.sae.vehiculemicroservice.entities.DAO.Cost;
import lockedout.sae.vehiculemicroservice.entities.DAO.Document;
import lockedout.sae.vehiculemicroservice.entities.DAO.Maintenance;
import lockedout.sae.vehiculemicroservice.entities.DAO.Trip;
import lockedout.sae.vehiculemicroservice.entities.Vehicle;

import java.util.List;

public interface IVehicleImp {
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle getVehicleById(Long vehicleId);
    Vehicle updateVehicle(Long vehicleId, Vehicle vehicle);
    Vehicle deleteVehicle(Long vehicleId);

    Vehicle findByRegistrationNumber(String registrationNumber);

    List<Vehicle> getAllVehicles(Long userId);

    Document addDocumentToVehicle(Long vehicleId, Document document);
    Document updateDocumentForVehicle(Long vehicleId, Long documentId, Document document);
    void deleteDocumentForVehicle(Long vehicleId, Long documentId);
    List<Document> getAllDocuments();
    List<Document> getDocumentsForVehicle(Long vehicleId);

    void deleteTripForVehicle(Long vehicleId, Long tripId);

    List<Trip> getAllTripsForVehicle(Long vehicleId);

    Trip getTripByIdForVehicle(Long vehicleId, Long tripId);

    Cost addCostToVehicle(Long vehicleId, Cost cost);
    Cost updateCostForVehicle(Long vehicleId, Long costId, Cost cost);
    void deleteCostForVehicle(Long vehicleId, Long costId);
    List<Cost> getAllCostsForVehicle(Long vehicleId);
    Cost getCostByIdForVehicle(Long vehicleId, Long costId);


    // Trip Methods
    Trip addTripToVehicle(Long vehicleId, Trip trip);

    Trip updateTripForVehicle(Long vehicleId, Long tripId, Trip trip);



    Maintenance addMaintenanceToVehicle(Long vehicleId, Maintenance maintenance);
    Maintenance updateMaintenanceForVehicle(Long vehicleId, Long maintenanceId, Maintenance maintenance);
    void deleteMaintenanceForVehicle(Long vehicleId, Long maintenanceId);
    List<Maintenance> getAllMaintenanceForVehicle(Long vehicleId);
    Maintenance getMaintenanceByIdForVehicle(Long vehicleId, Long maintenanceId);
}
