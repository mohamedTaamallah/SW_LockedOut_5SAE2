package lockedout.sae.vehiculemicroservice.FeignClient;

import lockedout.sae.vehiculemicroservice.entities.DAO.Document;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "DOCUMENTMICROSERVICE")
public interface DocumentFeign {


    @GetMapping("/documents")
    List<Document> getAllDocuments();

    @GetMapping("/documents/{id}")
    Document getDocumentById(@PathVariable("id") Long id);

    @PostMapping("/documents/addDocument")
    Document addDocument(@RequestBody Document document);

    @PutMapping("/documents/{id}")
    Document updateDocument(@PathVariable("id") Long id, @RequestBody Document document);

    @DeleteMapping("/documents/{id}")
    void deleteDocument(@PathVariable("id") Long id);

    @GetMapping("/documents/vehicle/{vehicleId}")
    List<Document> getDocumentsByVehicleId(@PathVariable("vehicleId") Long vehicleId);

}
