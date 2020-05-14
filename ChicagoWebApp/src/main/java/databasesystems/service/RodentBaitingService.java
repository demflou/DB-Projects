/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.service;

import databasesystems.domain.Rodent_baiting;
import databasesystems.repository.RodentBaitingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kc
 */
@Service
public class RodentBaitingService {

    @Autowired
    RodentBaitingRepo incRep;

    public Rodent_baiting addIncident(Rodent_baiting newInc) {
        incRep.save(newInc);
        return newInc;
    }    
}
