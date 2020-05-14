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
@Table(name="vehicles", schema = "public")
public class Vehicles {
    @Id
    long id;
    
    String license_plate;
    String vehicle_mademodel;
    String vehicle_color;
    long how_many_days_is_the_vehicle_parked;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getVehicle_mademodel() {
        return vehicle_mademodel;
    }

    public void setVehicle_mademodel(String vehicle_mademodel) {
        this.vehicle_mademodel = vehicle_mademodel;
    }

    public String getVehicle_color() {
        return vehicle_color;
    }

    public void setVehicle_color(String vehicle_color) {
        this.vehicle_color = vehicle_color;
    }

    public long getHow_many_days_is_the_vehicle_parked() {
        return how_many_days_is_the_vehicle_parked;
    }

    public void setHow_many_days_is_the_vehicle_parked(long how_many_days_is_the_vehicle_parked) {
        this.how_many_days_is_the_vehicle_parked = how_many_days_is_the_vehicle_parked;
    }
    
    
}
