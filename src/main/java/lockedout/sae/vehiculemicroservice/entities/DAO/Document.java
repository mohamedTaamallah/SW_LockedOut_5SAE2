package lockedout.sae.vehiculemicroservice.entities.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;
    private Long vehicleId;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    private LocalDate expirationDate;

    private LocalDate renewalDate;

    private String documentFile;

    private String issuingOrganization;

}
