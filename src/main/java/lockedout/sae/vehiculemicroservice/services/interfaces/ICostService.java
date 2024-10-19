package lockedout.sae.vehiculemicroservice.services.interfaces;

import lockedout.sae.vehiculemicroservice.entities.Cost;

import java.util.List;

public interface ICostService {
    Cost addCost(Cost cost);
    List<Cost> getAllCosts();
    Cost getCostById(int costId);
    Cost updateCost(Long costId,Cost cost);
    void deleteCostById(int costId);

}
