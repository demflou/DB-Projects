/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.service;

import databasesystems.domain.Pot_holes_reported;
import databasesystems.repository.PotHolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kc
 */
@Service
public class PotHolesService {

    @Autowired
    PotHolesRepo incRep;

    public Pot_holes_reported addIncident(Pot_holes_reported newInc) {
        incRep.save(newInc);
        return newInc;
    }    
}
