/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ahmed
 */
@Embeddable
public class UserEventPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "event_id")
    private int eventId;

    public UserEventPK() {
    }

    public UserEventPK(int userId, int eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) eventId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEventPK)) {
            return false;
        }
        UserEventPK other = (UserEventPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.eventId != other.eventId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.makanyapi.models.UserEventPK[ userId=" + userId + ", eventId=" + eventId + " ]";
    }
    
}
