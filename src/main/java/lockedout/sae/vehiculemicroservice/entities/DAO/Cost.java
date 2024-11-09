package lockedout.sae.vehiculemicroservice.entities.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cost {
    @Id
    @GeneratedValue
private long costId;
    private Long vehicleId;
    private CostType costType;
    private float amount;
    private LocalDate costDate;
    private String description;
    private String vendor;
    private PaymentMethod paymentMethod;
}
