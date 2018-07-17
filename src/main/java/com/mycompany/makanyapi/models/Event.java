/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Ahmed
 */
@Entity
@Table(name = "event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findById", query = "SELECT e FROM Event e WHERE e.id = :id"),
    @NamedQuery(name = "Event.findByName", query = "SELECT e FROM Event e WHERE e.name = :name"),
    @NamedQuery(name = "Event.findByDate", query = "SELECT e FROM Event e WHERE e.date = :date"),
    @NamedQuery(name = "Event.findByTime", query = "SELECT e FROM Event e WHERE e.time = :time"),
    @NamedQuery(name = "Event.findByMaxNumbers", query = "SELECT e FROM Event e WHERE e.maxNumbers = :maxNumbers")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "overview")
    private String overview;
    @Size(max = 45)
    @Column(name = "date")
    private String date;
    @Size(max = 45)
    @Column(name = "time")
    private String time;
    @Size(max = 45)
    @Column(name = "max_numbers")
    private String maxNumbers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    @JsonIgnore
    private Collection<UserEvent> userEventCollection;
    @OneToMany(mappedBy = "eventId", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Speaker> speakers;
    @JoinColumn(name = "interest_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Interest interestId;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User ownerId;

    public Event() {
    }

    public Event(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMaxNumbers() {
        return maxNumbers;
    }

    public void setMaxNumbers(String maxNumbers) {
        this.maxNumbers = maxNumbers;
    }

    @XmlTransient
    public Collection<UserEvent> getUserEventCollection() {
        return userEventCollection;
    }

    public void setUserEventCollection(Collection<UserEvent> userEventCollection) {
        this.userEventCollection = userEventCollection;
    }

    @XmlTransient
    public Collection<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Collection<Speaker> speakers) {
        this.speakers = speakers;
    }

    public Interest getInterestId() {
        return interestId;
    }

    public void setInterestId(Interest interestId) {
        this.interestId = interestId;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.makanyapi.models.Event[ id=" + id + " ]";
    }
    
}
