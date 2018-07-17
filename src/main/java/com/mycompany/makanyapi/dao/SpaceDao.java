/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.dao;

import com.mycompany.makanyapi.daointerfaces.SpaceDaoInt;
import com.mycompany.makanyapi.models.Freelancer;
import com.mycompany.makanyapi.models.Room;
import com.mycompany.makanyapi.models.Space;
import com.mycompany.makanyapi.models.SpaceContact;
import com.mycompany.makanyapi.models.SpaceLocation;
import com.mycompany.makanyapi.models.SpacePicture;
import com.mycompany.makanyapi.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Ahmed
 */
@Transactional
public class SpaceDao implements SpaceDaoInt {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean addSpace(Space space, Integer ownerId) {
        
        if (!entityManager.contains(space)) {
            space.setOwnerId(entityManager.find(User.class, ownerId));
            System.out.println("Space Facility ID is "+space.getFacility().getId());
            space.getFacility().setSpaceId(space); 
            for (Freelancer freelancer : space.getFreelancers()) {
                freelancer.setSpaceId(space);
            }
            for (SpaceContact spaceContact : space.getSpaceContacts()) {
                spaceContact.setSpaceId(space);
            }
            for (SpacePicture spacePicture : space.getSpacePictures()) {
                spacePicture.setSpaceId(space);
            }
            for (SpaceLocation spaceLocation : space.getSpaceLocations()) {
                spaceLocation.setSpaceId(space);
            }
            for (Room room : space.getRooms()) {
                room.setSpaceId(space);
            }
                       
            entityManager.persist(space);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateSapce(Space space) {
//        if (entityManager.contains(space)) {
            entityManager.merge(space);
            return true;
//        }
//        return false;
    }

//    @Override
//    public Space getSpaceByEmailAndPassword(String email, String password) {
//        String string = "select Space s where s.email = :email and s.password = :password";
//        Query q = entityManager.createQuery(string).setParameter("email", email).setParameter("password", password);
//        return (Space) q.getSingleResult();
//    }

    @Override
    public Space getSpaceById(Integer id) {
        String string = "from Space s where s.id = :id";
        Query q = entityManager.createQuery(string).setParameter("id", id);
        return (Space) q.getSingleResult();
    }

}
