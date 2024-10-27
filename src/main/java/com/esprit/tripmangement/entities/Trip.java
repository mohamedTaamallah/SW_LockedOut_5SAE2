package com.esprit.tripmangement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Trip implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;
    private LocalDate tripDate;
    private Float distance;
    private String startingPoint;
    private String destination;
    private Float duration;
    private Float fuelUsed;
    private String description;
}
