/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.repository;

import databasesystems.domain.Garbage_carts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gunner
 */
@Repository
public interface Garbage_cartsRepository extends CrudRepository<Garbage_carts, Long>{
    
}
