/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.service;

import databasesystems.domain.Vehicles;
import databasesystems.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kc
 */
@Service
public class VehiclesService {

    @Autowired
    VehicleRepository incRep;

    public Vehicles addVehicle(Vehicles newInc) {
        incRep.save(newInc);
        return newInc;
    }    
}
