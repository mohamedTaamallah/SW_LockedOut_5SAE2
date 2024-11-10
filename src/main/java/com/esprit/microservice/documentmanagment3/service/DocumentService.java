package com.esprit.microservice.documentmanagment3.service;

import com.esprit.microservice.documentmanagment3.entity.Document;
import com.esprit.microservice.documentmanagment3.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Document getDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    public Document addDocument(Document document) {
        return documentRepository.save(document);
    }

    public Document updateDocument(Long id, Document documentDetails) {
        Document document = documentRepository.findById(id).orElse(null);

        if (document != null) {
            document.setDocumentType(documentDetails.getDocumentType());
            document.setExpirationDate(documentDetails.getExpirationDate());
            document.setRenewalDate(documentDetails.getRenewalDate());
            document.setDocumentFile(documentDetails.getDocumentFile());
            document.setIssuingOrganization(documentDetails.getIssuingOrganization());

            return documentRepository.save(document);
        }

        return null;
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    public List<Document> getDocumentsByVehicleId(Long vehicleId) {
        return documentRepository.findByVehicleId(vehicleId);
    }
}
