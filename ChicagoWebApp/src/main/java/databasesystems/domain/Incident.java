/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author kc
 */
@Entity
@Table(name="incidents", schema = "public")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "incidents_id_seq", allocationSize=1)
    private long id;
    
    private Date creation_date;
    private Date completion_date;

    private String status;
    private String service_request_number;
    private String type_of_service_requested;
    private String current_activity;
    private String most_recent_action;
    private String street_address;
    private String location;

    private int zip_code;
    private int ward;
    private int ssa;
    private int community_area;
    private int police_district;

    private BigDecimal x_coord;
    private BigDecimal y_coord;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getCompletion_date() {
        return completion_date;
    }

    public void setCompletion_date(Date completion_date) {
        this.completion_date = completion_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getService_request_number() {
        return service_request_number;
    }

    public void setService_request_number(String service_request_number) {
        this.service_request_number = service_request_number;
    }

    public String getType_of_service_requested() {
        return type_of_service_requested;
    }

    public void setType_of_service_requested(String type_of_service_requested) {
        this.type_of_service_requested = type_of_service_requested;
    }

    public String getCurrent_activity() {
        return current_activity;
    }

    public void setCurrent_activity(String current_activity) {
        this.current_activity = current_activity;
    }

    public String getMost_recent_action() {
        return most_recent_action;
    }

    public void setMost_recent_action(String most_recent_action) {
        this.most_recent_action = most_recent_action;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public int getSsa() {
        return ssa;
    }

    public void setSsa(int ssa) {
        this.ssa = ssa;
    }

    public int getCommunity_area() {
        return community_area;
    }

    public void setCommunity_area(int community_area) {
        this.community_area = community_area;
    }

    public int getPolice_district() {
        return police_district;
    }

    public void setPolice_district(int police_district) {
        this.police_district = police_district;
    }

    public BigDecimal getX_coord() {
        return x_coord;
    }

    public void setX_coord(BigDecimal x_coord) {
        this.x_coord = x_coord;
    }

    public BigDecimal getY_coord() {
        return y_coord;
    }

    public void setY_coord(BigDecimal y_coord) {
        this.y_coord = y_coord;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
    
    
}
