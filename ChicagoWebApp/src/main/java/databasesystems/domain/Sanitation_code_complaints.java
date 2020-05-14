/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gunner
 */
@Entity
@Table(name="sanitation_code_complaints", schema = "public")
public class Sanitation_code_complaints {
    @Id
    int id;
    
    String what_is_the_nature_of_this_code_violations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWhat_is_the_nature_of_this_code_violations() {
        return what_is_the_nature_of_this_code_violations;
    }

    public void setWhat_is_the_nature_of_this_code_violations(String what_is_the_nature_of_this_code_violations) {
        this.what_is_the_nature_of_this_code_violations = what_is_the_nature_of_this_code_violations;
    }
}
