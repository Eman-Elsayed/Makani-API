/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.services;

import com.mycompany.makanyapi.daointerfaces.UserDaoInt;
import com.mycompany.makanyapi.helper.Message;
import com.mycompany.makanyapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ahmed
 */
public class UserServices {

    @Autowired
    private UserDaoInt userDao;

    public Message register(User user) {
        Message message = new Message();
        if (userDao.addUser(user)) {
            message.setStatusCode(1);
            message.setStatusMessage("user inserted");
            message.setSuccess(true);
        } else {
            message.setStatusCode(2);
            message.setStatusMessage("error");
            message.setSuccess(false);
        }
        return message;
    }

    public Message edit(User user) {
        Message message = new Message();
        if (userDao.updateUser(
                user)) {
            message.setStatusCode(1);
            message.setStatusMessage("user inserted");
            message.setSuccess(true);
        } else {
            message.setStatusCode(2);
            message.setStatusMessage("error");
            message.setSuccess(false);
        }
        return message;
    }
    
    public User login(String email, String password){
        return userDao.getUserByEmailAndPassword(email, password);        
    }
}
