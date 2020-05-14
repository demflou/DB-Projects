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
@Table(name="pot_holes_reported", schema="public")
public class Pot_holes_reported {

    @Id
    long id;
    int number_of_potholes_filled_on_block;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber_of_potholes_filled_on_block() {
        return number_of_potholes_filled_on_block;
    }

    public void setNumber_of_potholes_filled_on_block(int number_of_potholes_filled_on_block) {
        this.number_of_potholes_filled_on_block = number_of_potholes_filled_on_block;
    }
    
    
}
