/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.service;

import databasesystems.domain.Tree_trims;
import databasesystems.repository.TreeTrimsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kc
 */
@Service
public class TreeTrimsService {

    @Autowired
    TreeTrimsRepo incRep;

    public Tree_trims addIncident(Tree_trims newInc) {
        incRep.save(newInc);
        return newInc;
    }    
}