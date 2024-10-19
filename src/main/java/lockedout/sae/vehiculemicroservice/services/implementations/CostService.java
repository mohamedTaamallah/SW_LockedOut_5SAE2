package lockedout.sae.vehiculemicroservice.services.implementations;

import lockedout.sae.vehiculemicroservice.entities.Cost;
import lockedout.sae.vehiculemicroservice.repositories.CostRepository;
import lockedout.sae.vehiculemicroservice.services.interfaces.ICostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CostService implements ICostService {

    private final CostRepository costRepository;

    @Override
    public Cost addCost(Cost cost) {
        return costRepository.save(cost);
    }

    @Override
    public List<Cost> getAllCosts() {
        return costRepository.findAll();
    }

    @Override
    public Cost getCostById(int costId) {
        Optional<Cost> cost = costRepository.findById((long) costId);
        return cost.orElse(null);
    }

    @Override
    public Cost updateCost(Long costId, Cost cost) {
        return costRepository.findById(costId)
                .map(existingCost -> {
                    existingCost.setAmount(cost.getAmount());
                    existingCost.setCostType(cost.getCostType());
                    existingCost.setCostDate(cost.getCostDate());
                    existingCost.setDescription(cost.getDescription());
                    existingCost.setVendor(cost.getVendor());
                    existingCost.setPaymentMethod(cost.getPaymentMethod());
                    return costRepository.save(existingCost);
                }).orElse(null);
    }

    @Override
    public void deleteCostById(int costId) {
        costRepository.deleteById((long) costId);
    }
}
