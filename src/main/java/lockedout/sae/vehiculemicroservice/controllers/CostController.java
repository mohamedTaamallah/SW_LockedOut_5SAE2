package lockedout.sae.vehiculemicroservice.controllers;

import lockedout.sae.vehiculemicroservice.entities.Cost;
import lockedout.sae.vehiculemicroservice.services.implementations.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costs")
public class CostController {

    @Autowired
    private CostService costService;

    // Create a new Cost
    @PostMapping
    public ResponseEntity<Cost> addCost(@RequestBody Cost cost) {
        Cost savedCost = costService.addCost(cost);
        return new ResponseEntity<>(savedCost, HttpStatus.CREATED);
    }

    // Get all Costs
    @GetMapping
    public ResponseEntity<List<Cost>> getAllCosts() {
        List<Cost> costs = costService.getAllCosts();
        return new ResponseEntity<>(costs, HttpStatus.OK);
    }

    // Get a specific Cost by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cost> getCostById(@PathVariable int id) {
        Cost cost = costService.getCostById(id);
        if (cost != null) {
            return new ResponseEntity<>(cost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update an existing Cost
    @PutMapping("/{id}")
    public ResponseEntity<Cost> updateCost(@PathVariable Long id, @RequestBody Cost cost) {
        Cost updatedCost = costService.updateCost(id, cost);
        if (updatedCost != null) {
            return new ResponseEntity<>(updatedCost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a Cost by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCostById(@PathVariable int id) {
        costService.deleteCostById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
