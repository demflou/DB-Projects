/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasesystems.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author kc
 */
@Entity
@Table(name="queries", schema = "public")
@Embeddable
public class UserQueries {
    @EmbeddedId
    private UserQPK id;

    public UserQPK getId() {
        return id;
    }

    public void setId(UserQPK id) {
        this.id = id;
    }
    
    public static class UserQPK implements Serializable {

        //@EmbeddedId
        private String user_id;
        //@EmbeddedId
        private int query_id;
        //@EmbeddedId
        private Date date_time;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public int getQuery_id() {
            return query_id;
        }

        public void setQuery_id(int query_id) {
            this.query_id = query_id;
        }

        public Date getDate_time() {
            return date_time;
        }

        public void setDate_time(Date date_time) {
            this.date_time = date_time;
        }
    
    }
}
