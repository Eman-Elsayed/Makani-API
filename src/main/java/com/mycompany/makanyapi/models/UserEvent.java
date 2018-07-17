/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmed
 */
@Entity
@Table(name = "user_event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserEvent.findAll", query = "SELECT u FROM UserEvent u"),
    @NamedQuery(name = "UserEvent.findByUserId", query = "SELECT u FROM UserEvent u WHERE u.userEventPK.userId = :userId"),
    @NamedQuery(name = "UserEvent.findByEventId", query = "SELECT u FROM UserEvent u WHERE u.userEventPK.eventId = :eventId"),
    @NamedQuery(name = "UserEvent.findByStatus", query = "SELECT u FROM UserEvent u WHERE u.status = :status")})
public class UserEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserEventPK userEventPK;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "event_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Event event;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private User user;

    public UserEvent() {
    }

    public UserEvent(UserEventPK userEventPK) {
        this.userEventPK = userEventPK;
    }

    public UserEvent(int userId, int eventId) {
        this.userEventPK = new UserEventPK(userId, eventId);
    }

    public UserEventPK getUserEventPK() {
        return userEventPK;
    }

    public void setUserEventPK(UserEventPK userEventPK) {
        this.userEventPK = userEventPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userEventPK != null ? userEventPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEvent)) {
            return false;
        }
        UserEvent other = (UserEvent) object;
        if ((this.userEventPK == null && other.userEventPK != null) || (this.userEventPK != null && !this.userEventPK.equals(other.userEventPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.makanyapi.models.UserEvent[ userEventPK=" + userEventPK + " ]";
    }
    
}
