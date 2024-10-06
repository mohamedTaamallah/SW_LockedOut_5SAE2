package lockedout.sae.vehiculemicroservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private Long VehicleId;
    private String registrationNumber;
    private float mileage;
    private String brand;
    private String model;
    private int year;
    private VehicleType type;
    private float fuelCapacity;
    private float averageConsumption;

}
