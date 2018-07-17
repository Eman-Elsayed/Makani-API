/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.dao;

import com.mycompany.makanyapi.daointerfaces.FacilityDaoInt;
import com.mycompany.makanyapi.models.Facility;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


/**
 *
 * @author Ahmed
 */
@Transactional
public class FacilityDao implements FacilityDaoInt{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean addFacility(Facility facility) {
        entityManager.persist(facility);
        return true;
    }

    @Override
    public List<Facility> getAllFacilities() {
        String string = "SELECT f FROM Facility f";
        Query q = entityManager.createQuery(string);        
        return q.getResultList();
    }
 
}
