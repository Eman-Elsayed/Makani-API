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
public interface UserDaoInt {

    List<User> getUserByKeyword(String keyword);

    User getUserByEmailAndPassword(String email, String password);        

    Boolean addUser(User user);

    Boolean updateUser(User user);
    
    User getUserById(Integer id);
}
