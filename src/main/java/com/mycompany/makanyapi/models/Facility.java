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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmed
 */
@Entity
@Table(name = "facility")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facility.findAll", query = "SELECT f FROM Facility f"),
    @NamedQuery(name = "Facility.findById", query = "SELECT f FROM Facility f WHERE f.id = :id"),
    @NamedQuery(name = "Facility.findByProjector", query = "SELECT f FROM Facility f WHERE f.projector = :projector"),
    @NamedQuery(name = "Facility.findByLaptops", query = "SELECT f FROM Facility f WHERE f.laptops = :laptops"),
    @NamedQuery(name = "Facility.findByAirConditioner", query = "SELECT f FROM Facility f WHERE f.airConditioner = :airConditioner"),
    @NamedQuery(name = "Facility.findByInternet", query = "SELECT f FROM Facility f WHERE f.internet = :internet"),
    @NamedQuery(name = "Facility.findByInternetSpeed", query = "SELECT f FROM Facility f WHERE f.internetSpeed = :internetSpeed"),
    @NamedQuery(name = "Facility.findByFoodDrinks", query = "SELECT f FROM Facility f WHERE f.foodDrinks = :foodDrinks")})
public class Facility implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "projector")
    private Boolean projector;
    @Column(name = "laptops")
    private Boolean laptops;
    @Column(name = "air_conditioner")
    private Boolean airConditioner;
    @Column(name = "internet")
    private Boolean internet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "internet_speed")
    private Double internetSpeed;
    @Column(name = "food_drinks")
    private Boolean foodDrinks;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "other_facilities")
    private String otherFacilities;
    @JoinColumn(name = "space_id", referencedColumnName = "id")
    @OneToOne
    @JsonIgnore
    private Space spaceId;

    public Facility() {
    }

    public Facility(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getProjector() {
        return projector;
    }

    public void setProjector(Boolean projector) {
        this.projector = projector;
    }

    public Boolean getLaptops() {
        return laptops;
    }

    public void setLaptops(Boolean laptops) {
        this.laptops = laptops;
    }

    public Boolean getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(Boolean airConditioner) {
        this.airConditioner = airConditioner;
    }

    public Boolean getInternet() {
        return internet;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }

    public Double getInternetSpeed() {
        return internetSpeed;
    }

    public void setInternetSpeed(Double internetSpeed) {
        this.internetSpeed = internetSpeed;
    }

    public Boolean getFoodDrinks() {
        return foodDrinks;
    }

    public void setFoodDrinks(Boolean foodDrinks) {
        this.foodDrinks = foodDrinks;
    }

    public String getOtherFacilities() {
        return otherFacilities;
    }

    public void setOtherFacilities(String otherFacilities) {
        this.otherFacilities = otherFacilities;
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
        if (!(object instanceof Facility)) {
            return false;
        }
        Facility other = (Facility) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.makanyapi.models.Facility[ id=" + id + " ]";
    }
    
}
