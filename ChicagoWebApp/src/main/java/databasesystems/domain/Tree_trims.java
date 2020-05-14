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
@Table(name="tree_trims", schema = "public")
public class Tree_trims {
    @Id
    int id;
    
    String location_of_trees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation_of_trees() {
        return location_of_trees;
    }

    public void setLocation_of_trees(String location_of_trees) {
        this.location_of_trees = location_of_trees;
    }
}
