/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.repository;

import databasesystems.domain.Graffiti_removal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gunner
 */
@Repository
public interface Gaffiti_removalRepository extends CrudRepository<Graffiti_removal, Long> {
    
}
