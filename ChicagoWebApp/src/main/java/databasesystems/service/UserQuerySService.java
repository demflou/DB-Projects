/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.service;

import databasesystems.domain.UserQueries;
import databasesystems.repository.QueryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kc
 */

@Service
public class UserQuerySService {
    @Autowired
    QueryRepo qrepo;
    
    public UserQueries addUserQuery(UserQueries newUQ){
        qrepo.save(newUQ);
        return newUQ;
    }
    
}
