package com.esprit.microservice.documentmanagment3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
