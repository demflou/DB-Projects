/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import databasesystems.domain.Tree_trims;

/**
 *
 * @author kc
 */
@Repository
public interface TreeTrimsRepo extends CrudRepository<Tree_trims, Long> {

}

