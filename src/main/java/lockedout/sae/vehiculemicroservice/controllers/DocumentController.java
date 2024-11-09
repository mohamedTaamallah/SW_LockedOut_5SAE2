package lockedout.sae.vehiculemicroservice.controllers;

import lockedout.sae.vehiculemicroservice.entities.DAO.Document;
import lockedout.sae.vehiculemicroservice.implementation.services.VehicleImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles/{vehicleId}/documents")
public class DocumentController {

    @Autowired
    private VehicleImp documentService;

    @PostMapping
    public ResponseEntity<Document> addDocumentToVehicle(@PathVariable Long vehicleId, @RequestBody Document document) {
        Document createdDocument = documentService.addDocumentToVehicle(vehicleId, document);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
    }

    @GetMapping("/{documentId}")
    public ResponseEntity<Document> getDocumentByIdForVehicle(@PathVariable Long vehicleId, @PathVariable Long documentId, @RequestBody Document document) {
        return ResponseEntity.ok(documentService.updateDocumentForVehicle(vehicleId, documentId,document));
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocumentsForVehicle(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(documentService.getAllDocuments());
    }

    @PutMapping("/{documentId}")
    public ResponseEntity<Document> updateDocumentForVehicle(@PathVariable Long vehicleId, @PathVariable Long documentId, @RequestBody Document document) {
        return ResponseEntity.ok(documentService.updateDocumentForVehicle(vehicleId, documentId, document));
    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<Void> deleteDocumentForVehicle(@PathVariable Long vehicleId, @PathVariable Long documentId) {
        documentService.deleteDocumentForVehicle(vehicleId, documentId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/by-vehicle")
    public ResponseEntity<List<Document>> getDocumentsByVehicleId(@PathVariable Long vehicleId) {
        List<Document> documents = documentService.getDocumentsForVehicle(vehicleId);
        return ResponseEntity.ok(documents);
    }
}
