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
@Table(name="graffiti_removal", schema = "public")
public class Graffiti_removal {
    @Id
    int id;
    
    String what_type_of_surface_is_the_graffiti_on;
    String where_is_the_graffiti_located;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWhat_type_of_surface_is_the_graffiti_on() {
        return what_type_of_surface_is_the_graffiti_on;
    }

    public void setWhat_type_of_surface_is_the_graffiti_on(String what_type_of_surface_is_the_graffiti_on) {
        this.what_type_of_surface_is_the_graffiti_on = what_type_of_surface_is_the_graffiti_on;
    }

    public String getWhere_is_the_graffiti_located() {
        return where_is_the_graffiti_located;
    }

    public void setWhere_is_the_graffiti_located(String where_is_the_graffiti_located) {
        this.where_is_the_graffiti_located = where_is_the_graffiti_located;
    }
}
