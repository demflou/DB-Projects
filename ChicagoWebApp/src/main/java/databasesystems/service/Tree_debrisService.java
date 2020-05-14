/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.service;

import databasesystems.domain.Tree_debris;
import databasesystems.repository.Tree_debrisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gunner
 */
@Service
public class Tree_debrisService {
    @Autowired
    Tree_debrisRepository debRep;
    
    public Tree_debris addTree_debris(Tree_debris newDeb) {
        debRep.save(newDeb);
        return newDeb;
    }
}
