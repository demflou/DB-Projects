/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.domain;

import java.util.Date;
import javax.persistence.Entity;
/**
 *
 * @author kc
 */
//@Entity

public class Query1 {
    private int counter;
    private String type;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}