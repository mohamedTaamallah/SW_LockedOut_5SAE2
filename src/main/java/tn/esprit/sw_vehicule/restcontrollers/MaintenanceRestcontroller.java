package tn.esprit.sw_vehicule.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sw_vehicule.entities.Maintenance;

import tn.esprit.sw_vehicule.services.IMaintenance;

import java.util.List;

@RestController
@RequestMapping("/Maintenance")
public class MaintenanceRestcontroller {
    @Autowired
    private IMaintenance iMaintenance;
    @PostMapping("/addMaintenance")
    public Maintenance addMaintenance (@RequestBody Maintenance m)
    {return iMaintenance.addMaintenance(m);};
    @PutMapping("/updateMaintenance")
    public Maintenance updateMaintenance (@RequestBody Maintenance m)
    {return iMaintenance.updateMaintenance(m);};
    @GetMapping("/getAllMaintenance")
    public List<Maintenance> getAllSkieur() {
        return iMaintenance.getAllMaintenance();
    };
    @GetMapping("/getMaintenancebyId/{idM}")
    public Maintenance getMaintenanceById(@PathVariable long idM) {
        return iMaintenance.getMaintenanceById(idM);
    };
    @DeleteMapping("/deleteMaintenancebyId/{idM}")
    public void deleteMaintenance(@PathVariable long idM){
        iMaintenance.deleteMaintenance(idM);
    }

}
