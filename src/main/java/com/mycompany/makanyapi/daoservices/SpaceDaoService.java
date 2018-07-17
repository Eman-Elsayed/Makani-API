/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.daoservices;

import com.mycompany.makanyapi.models.Space;
import com.mycompany.makanyapi.daoservicesinterfaces.SpaceDaoServiceInt;
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
public class SpaceDaoService implements SpaceDaoServiceInt {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Space> getSpaceByName(String name) {
        String string = "SELECT s FROM Space s WHERE s.name = :name";
        Query q = entityManager.createQuery(string).setParameter("name", name);
        return q.getResultList();
    }

    @Override
    public List<Space> getTopRatedSpaces(String government) {
        String string = "select s from Space s,SpaceLocation l where l.government = :government";        
        Query q = entityManager.createQuery(string).setParameter("government", government);
        q.setFirstResult(0);
        q.setMaxResults(5); 
        return q.getResultList();
    }

}
