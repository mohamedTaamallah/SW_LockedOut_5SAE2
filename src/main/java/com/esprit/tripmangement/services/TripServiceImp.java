package com.esprit.tripmangement.services;

import com.esprit.tripmangement.entities.Trip;
import com.esprit.tripmangement.repositories.TripRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TripServiceImp implements ITrip{

    private TripRepository tripRepository;

    @Override
    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public Trip updateTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);

    }
}
