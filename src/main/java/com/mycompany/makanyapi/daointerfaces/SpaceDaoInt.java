/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.daointerfaces;

import com.mycompany.makanyapi.models.Space;

/**
 *
 * @author Ahmed
 */
public interface SpaceDaoInt {    
    
    Boolean addSpace(Space space, Integer ownerId);

    Boolean updateSapce(Space space);
    
//    Space getSpaceByEmailAndPassword(String email, String password);
    
    Space getSpaceById(Integer id);
    
}
