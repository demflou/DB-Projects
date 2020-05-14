/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.repository;

import databasesystems.domain.Sanitation_code_complaints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author kc
 */
@Repository
public interface SanitationRepo extends CrudRepository<Sanitation_code_complaints, Long> {

}

