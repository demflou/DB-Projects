/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.service;

import databasesystems.domain.Garbage_carts;
import databasesystems.repository.Garbage_cartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gunner
 */
@Service
public class Garbage_cartsService {
    @Autowired
    Garbage_cartsRepository garRep;
    
    public Garbage_carts addGarbage_carts(Garbage_carts newGarbage) {
        garRep.save(newGarbage);
        return newGarbage;
    }
}
