package com.mycompany.makanyapi.webservices;

import com.mycompany.makanyapi.daointerfaces.UserDaoInt;
import com.mycompany.makanyapi.helper.Message;
import com.mycompany.makanyapi.helper.UserLogin;
import com.mycompany.makanyapi.models.User;
import com.mycompany.makanyapi.services.UserServices;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserWS {

    @Autowired
    private UserServices userServices;
    @Autowired
    private UserDaoInt userDao;

//    @POST
//    @RequestMapping(name = "/sayHello", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
//    public @ResponseBody String sayHello(@RequestBody String name) {
//        String message = "Hello " + name;
//        return message;
//    }
    
    @RequestMapping(value = "/getuser", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody
    User getUser(@RequestParam("id") Integer id) {
        return userDao.getUserById(id);
    }
    
    @POST
    @RequestMapping(value = "/registeruser", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody
    Message registerUser(@RequestBody User user) {
        return userServices.register(user);
    }

    @POST
    @RequestMapping(value = "/edituser", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody
    Message editUser(@RequestBody User user) {
        return userServices.edit(user);
    }

    @POST
    @RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public @ResponseBody
    User loginUser(@RequestBody UserLogin login) {
        return userServices.login(login.getEmail(), login.getPassword());
    }

}
