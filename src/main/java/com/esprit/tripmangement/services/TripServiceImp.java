package com.esprit.tripmangement.services;

import com.esprit.tripmangement.entities.Trip;
import com.esprit.tripmangement.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImp {

    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip updateTrip(Long id, Trip tripDetails) {
        Trip trip = tripRepository.findById(id).orElse(null);
        if (trip != null) {
            trip.setTripDate(tripDetails.getTripDate());
            trip.setDistance(tripDetails.getDistance());
            trip.setStartingPoint(tripDetails.getStartingPoint());
            trip.setDestination(tripDetails.getDestination());
            trip.setDuration(tripDetails.getDuration());
            trip.setFuelUsed(tripDetails.getFuelUsed());
            trip.setDescription(tripDetails.getDescription());
            return tripRepository.save(trip);
        }
        return null;
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public List<Trip> getTripsByVehicleId(Long vehicleId) {
        return tripRepository.findByVehicleId(vehicleId);
    }
}
