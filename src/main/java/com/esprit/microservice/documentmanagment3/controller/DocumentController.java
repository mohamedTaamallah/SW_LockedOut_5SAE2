package com.esprit.microservice.documentmanagment3.controller;

import com.esprit.microservice.documentmanagment3.entity.Document;
import com.esprit.microservice.documentmanagment3.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public Document getDocumentById(@PathVariable Long id) {
        return documentService.getDocumentById(id);
    }


    @PostMapping("/addDocument")
    public ResponseEntity<Document> addDocument(@RequestBody Document document) {
        Document createdDocument = documentService.addDocument(document);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
    }
    @PutMapping("/{id}")
    public Document updateDocument(@PathVariable Long id, @RequestBody Document documentDetails) {
        return documentService.updateDocument(id, documentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
    }
    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<Document>> getDocumentsByVehicleId(@PathVariable Long vehicleId) {
        List<Document> documents = documentService.getDocumentsByVehicleId(vehicleId);
        return ResponseEntity.ok(documents);
    }
}
