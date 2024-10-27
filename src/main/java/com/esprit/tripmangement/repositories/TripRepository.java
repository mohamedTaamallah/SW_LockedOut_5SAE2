package com.esprit.tripmangement.repositories;

import com.esprit.tripmangement.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip,Long> {
}
