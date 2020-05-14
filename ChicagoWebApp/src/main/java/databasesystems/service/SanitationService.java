/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.service;

import databasesystems.domain.Sanitation_code_complaints;
import databasesystems.repository.SanitationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kc
 */
@Service
public class SanitationService {

    @Autowired
    SanitationRepo incRep;

    public Sanitation_code_complaints addIncident(Sanitation_code_complaints newInc) {
        incRep.save(newInc);
        return newInc;
    }    
}
