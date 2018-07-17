/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmed
 */
@Entity
@Table(name = "freelancer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Freelancer.findAll", query = "SELECT f FROM Freelancer f"),
    @NamedQuery(name = "Freelancer.findById", query = "SELECT f FROM Freelancer f WHERE f.id = :id"),
    @NamedQuery(name = "Freelancer.findByName", query = "SELECT f FROM Freelancer f WHERE f.name = :name"),
    @NamedQuery(name = "Freelancer.findByJob", query = "SELECT f FROM Freelancer f WHERE f.job = :job"),
    @NamedQuery(name = "Freelancer.findByAvailability", query = "SELECT f FROM Freelancer f WHERE f.availability = :availability"),
    @NamedQuery(name = "Freelancer.findByCostPerHour", query = "SELECT f FROM Freelancer f WHERE f.costPerHour = :costPerHour")})
public class Freelancer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "job")
    private String job;
    @Size(max = 45)
    @Column(name = "availability")
    private String availability;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost_per_hour")
    private Double costPerHour;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "overview")
    private String overview;
    @JoinColumn(name = "space_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Space spaceId;

    public Freelancer() {
    }

    public Freelancer(Integer id) {
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(Double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Space getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Space spaceId) {
        this.spaceId = spaceId;
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
        if (!(object instanceof Freelancer)) {
            return false;
        }
        Freelancer other = (Freelancer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.makanyapi.models.Freelancer[ id=" + id + " ]";
    }
    
}
