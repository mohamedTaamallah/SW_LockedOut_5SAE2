package com.esprit.tripmangement.services;

import com.esprit.tripmangement.entities.Trip;

import java.util.List;

public interface ITrip {


    Trip addTrip(Trip trip);
    Trip updateTrip(Trip trip);
    List<Trip> getAllTrips();
    Trip getTripById(Long id);
    void deleteTrip(Long id);

}
