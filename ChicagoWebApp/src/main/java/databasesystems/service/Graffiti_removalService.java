package databasesystems.service;

import databasesystems.domain.Graffiti_removal;
import databasesystems.repository.Gaffiti_removalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gunner
 */
@Service
public class Graffiti_removalService {
    @Autowired
    Gaffiti_removalRepository grafRep;
    
    public Graffiti_removal addGraffiti (Graffiti_removal newGraf) {
        grafRep.save(newGraf);
        return newGraf;
    }
}
