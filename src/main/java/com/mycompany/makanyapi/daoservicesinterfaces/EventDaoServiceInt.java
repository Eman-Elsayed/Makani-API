/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.daoservicesinterfaces;

import com.mycompany.makanyapi.models.Event;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public interface EventDaoServiceInt {

    List<Event> getEventByName(String name);

//    ArrayList<Event> getEventByInterest(String interest);
//
//    ArrayList<Event> getEventByOverview(String keyword);
//
//    ArrayList<Event> getEventByGovernment(String government);

//    ArrayList<Event> getEventByAddress(String address);
}
