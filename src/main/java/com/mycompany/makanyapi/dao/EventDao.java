/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.dao;

import com.mycompany.makanyapi.daointerfaces.*;
import com.mycompany.makanyapi.models.Event;
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
public class EventDao implements EventDaoInt {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Event> getTopRatedEvents(String government) {
        String string = "select Event e where e.government = :government";
        Query q = entityManager.createQuery(string).setParameter("government", government);
        q.setFirstResult(0);
        q.setMaxResults(5); 
        return q.getResultList();  
    }

    @Override
    public Boolean addEvent(Event event) {
        entityManager.persist(event);
        return true;
    }

    @Override
    public Boolean updateEvent(Event event) {
        entityManager.refresh(event);
        return true;
    }

}
