package com.esprit.microservice.documentmanagment3.repository;

import com.esprit.microservice.documentmanagment3.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
