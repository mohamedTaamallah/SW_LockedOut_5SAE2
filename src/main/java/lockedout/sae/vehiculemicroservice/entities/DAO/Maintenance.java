package lockedout.sae.vehiculemicroservice.entities.DAO;

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
    @Column(name = "vehicle_id")
    private Long vehicleId;
    private LocalDate maintenanceDate;
    @Enumerated(EnumType.STRING)
    private MaintenanceType maintenanceType;
    private Float mileageAtMaintenance;
    private Float cost;
    private String garage;
    @Enumerated(EnumType.STRING)
    private Status status;



    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

}
