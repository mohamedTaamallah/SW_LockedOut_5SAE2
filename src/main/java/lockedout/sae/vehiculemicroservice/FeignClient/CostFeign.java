package lockedout.sae.vehiculemicroservice.FeignClient;

import lockedout.sae.vehiculemicroservice.entities.DAO.Cost;
import lockedout.sae.vehiculemicroservice.entities.DAO.Document;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "COSTMICROSERVICE")
public interface CostFeign {

    @GetMapping("/costs")
    List<Cost> getAllCosts();

    @GetMapping("/costs/{id}")
    Cost getCostById(@PathVariable("id") Long id);

    @PostMapping("/costs")
    Cost addCost(@RequestBody Cost cost);

    @PutMapping("/costs/{id}")
    Cost updateCost(@PathVariable("id") Long id, @RequestBody Cost cost);

    @DeleteMapping("/costs/{id}")
    void deleteCost(@PathVariable("id") Long id);

    @GetMapping("/costs/vehicle/{vehicleId}")
    List<Cost> getCostsByVehicleId(@PathVariable("vehicleId") Long vehicleId);
}
