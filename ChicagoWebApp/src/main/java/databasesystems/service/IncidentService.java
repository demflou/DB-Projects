/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.service;

import databasesystems.domain.Incident;
import databasesystems.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kc
 */
@Service
public class IncidentService {

    @Autowired
    IncidentRepository incRep;

    public Incident addIncident(Incident newInc) {
        incRep.save(newInc);
        return newInc;
    }    
}
