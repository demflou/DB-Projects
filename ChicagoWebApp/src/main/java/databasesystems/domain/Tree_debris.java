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
@Table(name="tree_debris", schema = "public")
public class Tree_debris {
    @Id
    int id;
            
    String if_yes_where_is_the_debris_located;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIf_yes_where_is_the_debris_located() {
        return if_yes_where_is_the_debris_located;
    }

    public void setIf_yes_where_is_the_debris_located(String if_yes_where_is_the_debris_located) {
        this.if_yes_where_is_the_debris_located = if_yes_where_is_the_debris_located;
    }
}
