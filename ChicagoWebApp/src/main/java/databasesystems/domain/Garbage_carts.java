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
@Table(name="garbage_carts", schema = "public")
public class Garbage_carts {
    @Id
    int id;
    
    int number_of_black_carts_delivered;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber_of_black_carts_delivered() {
        return number_of_black_carts_delivered;
    }

    public void setNumber_of_black_carts_delivered(int number_of_black_carts_delivered) {
        this.number_of_black_carts_delivered = number_of_black_carts_delivered;
    }
    
}
