/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.services;

import com.mycompany.makanyapi.daointerfaces.SpaceDaoInt;
import com.mycompany.makanyapi.daoservicesinterfaces.SpaceDaoServiceInt;
import com.mycompany.makanyapi.helper.Message;
import com.mycompany.makanyapi.models.Space;
import com.mycompany.makanyapi.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ahmed
 */
public class SpaceServices {

    @Autowired
    private SpaceDaoInt spaceDao;
    @Autowired
    private SpaceDaoServiceInt spaceDaoServices;

    public Message register(Space space ,Integer ownerId) {
        Message message = new Message();
        if (spaceDao.addSpace(space ,ownerId)) {
            message.setStatusCode(1);
            message.setStatusMessage("space inserted");
            message.setSuccess(true);
        } else {
            message.setStatusCode(2);
            message.setStatusMessage("error");
            message.setSuccess(false);
        }
        return message;
    }

    public Message edit(Space space) {
        Message message = new Message();
        if (spaceDao.updateSapce(space)) {
            message.setStatusCode(1);
            message.setStatusMessage("space inserted");
            message.setSuccess(true);
        } else {
            message.setStatusCode(2);
            message.setStatusMessage("error");
            message.setSuccess(false);
        }
        return message;
    }
    public List<Space> getTopRatedSpaces(String government){
        return spaceDaoServices.getTopRatedSpaces(government);
    }
    public List<Space> getSpaceByName(String keyword){
        return spaceDaoServices.getSpaceByName(keyword);
    }
}
