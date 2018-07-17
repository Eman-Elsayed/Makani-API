/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.makanyapi.daoservicesinterfaces;

import com.mycompany.makanyapi.models.Space;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public interface SpaceDaoServiceInt {

    List<Space> getSpaceByName(String name);

//    ArrayList<Space> getSpaceByGovernment(String government);
//
//    ArrayList<Space> getSpaceByAddress(String address);
//
//    ArrayList<Space> getSpaceByOverview(String keyword);

    List<Space> getTopRatedSpaces(String government);
}
