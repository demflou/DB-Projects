/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.Assigned;

/**
 *
 * @author kc
 */
@Entity
@Table(name="users", schema = "public")
public class MyUser {

    @Id
    String username;
    
    String name;
    String address;
    String password;
    String email;

    //private MyUser user;

    public String getUsername() {
        return username;
    }

    public void setUsername(String uname) {
        this.username = uname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address= address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password= password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email= email;
    }




}
