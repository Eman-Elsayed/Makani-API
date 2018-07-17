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
@Table(name = "space_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpaceLocation.findAll", query = "SELECT s FROM SpaceLocation s"),
    @NamedQuery(name = "SpaceLocation.findById", query = "SELECT s FROM SpaceLocation s WHERE s.id = :id"),
    @NamedQuery(name = "SpaceLocation.findByCountry", query = "SELECT s FROM SpaceLocation s WHERE s.country = :country"),
    @NamedQuery(name = "SpaceLocation.findByGovernment", query = "SELECT s FROM SpaceLocation s WHERE s.government = :government"),
    @NamedQuery(name = "SpaceLocation.findByLongitude", query = "SELECT s FROM SpaceLocation s WHERE s.longitude = :longitude"),
    @NamedQuery(name = "SpaceLocation.findByLatitude", query = "SELECT s FROM SpaceLocation s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "SpaceLocation.findByAtitude", query = "SELECT s FROM SpaceLocation s WHERE s.atitude = :atitude")})
public class SpaceLocation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Size(max = 100)
    @Column(name = "government")
    private String government;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "address")
    private String address;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "atitude")
    private Double atitude;
    @JoinColumn(name = "space_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Space spaceId;

    public SpaceLocation() {
    }

    public SpaceLocation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGovernment() {
        return government;
    }

    public void setGovernment(String government) {
        this.government = government;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getAtitude() {
        return atitude;
    }

    public void setAtitude(Double atitude) {
        this.atitude = atitude;
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
        if (!(object instanceof SpaceLocation)) {
            return false;
        }
        SpaceLocation other = (SpaceLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.makanyapi.models.SpaceLocation[ id=" + id + " ]";
    }
    
}
