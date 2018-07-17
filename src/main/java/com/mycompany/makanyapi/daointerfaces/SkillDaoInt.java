/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.daointerfaces;

import com.mycompany.makanyapi.models.*;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public interface SkillDaoInt {
    
    Boolean addSkill(Skill skill);

    List<Skill> getAllSkills();
    
}
