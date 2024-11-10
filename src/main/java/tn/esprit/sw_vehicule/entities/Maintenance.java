package tn.esprit.sw_vehicule.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Maintenance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintenanceId;

    private Long vehicleId; // associate maintenance with a specific vehicle

    private LocalDate maintenanceDate;

    @Enumerated(EnumType.STRING)
    private MaintenanceType maintenanceType;

    private Float mileageAtMaintenance;
    private Float cost;
    private String garage;

    @Enumerated(EnumType.STRING)
    private Status status;
}
