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
@Table(name = "space_picture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpacePicture.findAll", query = "SELECT s FROM SpacePicture s"),
    @NamedQuery(name = "SpacePicture.findById", query = "SELECT s FROM SpacePicture s WHERE s.id = :id"),
    @NamedQuery(name = "SpacePicture.findByPicture", query = "SELECT s FROM SpacePicture s WHERE s.picture = :picture")})
public class SpacePicture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "picture")
    private String picture;
    @JoinColumn(name = "space_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Space spaceId;

    public SpacePicture() {
    }

    public SpacePicture(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
        if (!(object instanceof SpacePicture)) {
            return false;
        }
        SpacePicture other = (SpacePicture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.makanyapi.models.SpacePicture[ id=" + id + " ]";
    }
    
}
