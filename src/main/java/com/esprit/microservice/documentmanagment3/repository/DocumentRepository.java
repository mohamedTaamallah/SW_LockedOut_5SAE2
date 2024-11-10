package com.esprit.microservice.documentmanagment3.repository;

import com.esprit.microservice.documentmanagment3.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByVehicleId(Long vehicleId);
}
