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
@Table(name="rodent_baiting", schema = "public")
public class Rodent_baiting {
    @Id
    long id;
    
    int number_of_premises_baited;
    int number_of_premises_with_garbage;
    int number_of_premises_with_rodent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber_of_premises_baited() {
        return number_of_premises_baited;
    }

    public void setNumber_of_premises_baited(int number_of_premises_baited) {
        this.number_of_premises_baited = number_of_premises_baited;
    }

    public int getNumber_of_premises_with_garbage() {
        return number_of_premises_with_garbage;
    }

    public void setNumber_of_premises_with_garbage(int number_of_premises_with_garbage) {
        this.number_of_premises_with_garbage = number_of_premises_with_garbage;
    }

    public int getNumber_of_premises_with_rodent() {
        return number_of_premises_with_rodent;
    }

    public void setNumber_of_premises_with_rodent(int number_of_premises_with_rodent) {
        this.number_of_premises_with_rodent = number_of_premises_with_rodent;
    }
    
    
}
