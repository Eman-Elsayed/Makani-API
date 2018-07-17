/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.dao;

import com.mycompany.makanyapi.daointerfaces.SkillDaoInt;
import com.mycompany.makanyapi.models.Skill;
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
public class SkillDao implements SkillDaoInt {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean addSkill(Skill skill) {
        entityManager.persist(skill);
        return true;
    }

    @Override
    public List<Skill> getAllSkills() {
        String string = "SELECT s FROM Skill s";
        Query q = entityManager.createQuery(string);
        return q.getResultList();
    }

}
