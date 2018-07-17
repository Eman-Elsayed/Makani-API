/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.dao;

import com.mycompany.makanyapi.daointerfaces.UserDaoInt;
import com.mycompany.makanyapi.models.Interest;
import com.mycompany.makanyapi.models.Skill;
import com.mycompany.makanyapi.models.User;
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
//@Service
public class UserDao implements UserDaoInt {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(Integer id) {
        String string = "from User u where u.id = :id";
        Query q = entityManager.createQuery(string).setParameter("id", id);
        return (User) q.getSingleResult();
    }

    @Override
    public List<User> getUserByKeyword(String keyword) {
        String string = "select Space s where s.name = :name";
        Query q = entityManager.createQuery(string).setParameter("name", keyword);
        return q.getResultList();
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        String string = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password";
        Query q = entityManager.createQuery(string).setParameter("email", email).setParameter("password", password);
        return (User) q.getSingleResult();
    }

    @Override
    public Boolean addUser(User user) {
        if (!entityManager.contains(user)) {
            for (Skill skill : user.getSkills()) {
                System.out.println("Skill " + skill.getName());
                entityManager.getReference(Skill.class, skill.getId()).getUsers().add(user);
            }
            for (Interest interest : user.getInterests()) {
                System.out.println("interest " + interest.getName());
                entityManager.getReference(Interest.class, interest.getId()).getUsers().add(user);
            }
            entityManager.persist(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateUser(User user) {
        entityManager.merge(user);
        return true;
    }
}
