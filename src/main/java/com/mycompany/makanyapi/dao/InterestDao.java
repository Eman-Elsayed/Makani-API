/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.dao;

import com.mycompany.makanyapi.daointerfaces.InterestDaoInt;
import com.mycompany.makanyapi.models.Interest;
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
public class InterestDao implements InterestDaoInt{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Boolean addInterest(Interest interest) {
         entityManager.persist(interest);
        return true;
    }

    @Override
    public List<Interest> getAllInterests() {
        String string = "SELECT i FROM Interest i";
        Query q = entityManager.createQuery(string);        
        return q.getResultList();
    }
    
}
