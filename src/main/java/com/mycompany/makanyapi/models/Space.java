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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
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
@Table(name = "space")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Space.findAll", query = "SELECT s FROM Space s"),
    @NamedQuery(name = "Space.findById", query = "SELECT s FROM Space s WHERE s.id = :id"),
    @NamedQuery(name = "Space.findByEmail", query = "SELECT s FROM Space s WHERE s.email = :email"),
    @NamedQuery(name = "Space.findByName", query = "SELECT s FROM Space s WHERE s.name = :name"),
    @NamedQuery(name = "Space.findByOpeningDays", query = "SELECT s FROM Space s WHERE s.openingDays = :openingDays"),
    @NamedQuery(name = "Space.findByOpeningTime", query = "SELECT s FROM Space s WHERE s.openingTime = :openingTime"),
    @NamedQuery(name = "Space.findByClosingTime", query = "SELECT s FROM Space s WHERE s.closingTime = :closingTime"),
    @NamedQuery(name = "Space.findByRating", query = "SELECT s FROM Space s WHERE s.rating = :rating"),
    @NamedQuery(name = "Space.findByWebsite", query = "SELECT s FROM Space s WHERE s.website = :website"),
    @NamedQuery(name = "Space.findByFacebook", query = "SELECT s FROM Space s WHERE s.facebook = :facebook")})
public class Space implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "opening_days")
    private String openingDays;
    @Size(max = 45)
    @Column(name = "opening_time")
    private String openingTime;
    @Size(max = 45)
    @Column(name = "closing_time")
    private String closingTime;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "overview")
    private String overview;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating")
    private Float rating;
    @Size(max = 1000)
    @Column(name = "website")
    private String website;
    @Size(max = 1000)
    @Column(name = "facebook")
    private String facebook;
    @OneToMany(mappedBy = "spaceId", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<SpacePicture> spacePictures;
    @OneToMany(mappedBy = "spaceId", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<SpaceLocation> spaceLocations;
    @OneToMany(mappedBy = "spaceId", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Room> rooms;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User ownerId;
    @OneToMany(mappedBy = "spaceId", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<SpaceContact> spaceContacts;
    @OneToOne(mappedBy = "spaceId", cascade = CascadeType.ALL)
    private Facility facility;
    @OneToMany(mappedBy = "spaceId", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Freelancer> freelancers;

    public Space() {
    }

    public Space(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpeningDays() {
        return openingDays;
    }

    public void setOpeningDays(String openingDays) {
        this.openingDays = openingDays;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @XmlTransient
    public Collection<SpacePicture> getSpacePictures() {
        return spacePictures;
    }

    public void setSpacePictures(Collection<SpacePicture> spacePictures) {
        this.spacePictures = spacePictures;
    }

    @XmlTransient
    public Collection<SpaceLocation> getSpaceLocations() {
        return spaceLocations;
    }

    public void setSpaceLocations(Collection<SpaceLocation> spaceLocations) {
        this.spaceLocations = spaceLocations;
    }

    @XmlTransient
    public Collection<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    @XmlTransient
    public Collection<SpaceContact> getSpaceContacts() {
        return spaceContacts;
    }

    public void setSpaceContacts(Collection<SpaceContact> spaceContacts) {
        this.spaceContacts = spaceContacts;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @XmlTransient
    public Collection<Freelancer> getFreelancers() {
        return freelancers;
    }

    public void setFreelancers(Collection<Freelancer> freelancers) {
        this.freelancers = freelancers;
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
        if (!(object instanceof Space)) {
            return false;
        }
        Space other = (Space) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.makanyapi.models.Space[ id=" + id + " ]";
    }
    
}
