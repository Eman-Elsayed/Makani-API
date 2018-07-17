/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.daoservices;

import com.mycompany.makanyapi.models.Event;
import com.mycompany.makanyapi.daoservicesinterfaces.EventDaoServiceInt;
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
public class EventDaoService implements EventDaoServiceInt {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Event> getEventByName(String name) {
        String string = "select Event e where e.name = :name";
        Query q = entityManager.createQuery(string).setParameter("name", name);
        return q.getResultList();
    }

}
