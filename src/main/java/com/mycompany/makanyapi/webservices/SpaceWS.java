package com.mycompany.makanyapi.webservices;

import com.mycompany.makanyapi.daointerfaces.SpaceDaoInt;
import com.mycompany.makanyapi.helper.Message;
import com.mycompany.makanyapi.models.Space;
import com.mycompany.makanyapi.services.SpaceServices;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/space")
public class SpaceWS {

    @Autowired
    private SpaceServices spaceServices;
    @Autowired
    private SpaceDaoInt spaceDao;  
//    @Autowired
//    private ApplicationContext appContext;
//    @Autowired
//    private ImageUpload imageUpload;

//    @RequestMapping(value = "/imageUploade.json", headers = ("content-type=multipart/*"), method = RequestMethod.POST)
//    public UserImageUploadeDto imageUpload(
//            @RequestParam(value = "userImage") MultipartFile inputFile,
//            @RequestParam(value = "email") String email,
//            @RequestParam(value = "extension") String imgExtension) {
//
//        UserDataRegisterDao userDataRegDao = appContext.getBean(UserDataRegisterDao.class);
//        UserImageUploadeDto userImageUploadeDto = (UserImageUploadeDto) appContext.getBean("userImageUploadeDto");
//
//        String[] extensionSplits = imgExtension.split("/");
//        String imageUrl = imageUpload.imageUploading(inputFile, email, "users_images", extensionSplits[1]);
//
//        if (!imageUrl.equals(ImageUpload.FILE_CAN_NOT_BE_SAVED) && !imageUrl.equals(ImageUpload.FILE_IS_EMAPTY)) {
//            userDataRegDao.updateUserImageUrl(imageUrl, email);
//            Users userData = userDataRegDao.findByEmail(email);
//
//            userImageUploadeDto.setStatus("SUCCESS");
//            userImageUploadeDto.setUser(userData);
//            return userImageUploadeDto;
//        }
//        userImageUploadeDto.setStatus("FAILED");
//
//        return userImageUploadeDto;
//    }   

    @RequestMapping(value = "/getSpace", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)    
    public @ResponseBody Space getSpace(@RequestParam("id")Integer id){        
        return spaceDao.getSpaceById(id);        
    }
    
    @RequestMapping(value = {"/getTopSpaces"}, produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
    public @ResponseBody
    List<Space> getTopSpace(@RequestParam("government") String government) {
        return spaceServices.getTopRatedSpaces(government);
    }
    
    @RequestMapping(value = {"/searchspace"}, produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
    public @ResponseBody
    List<Space> searchSpace(@RequestParam("name") String name) {
        return spaceServices.getSpaceByName(name);
    }

    @RequestMapping(value = {"/registerspace"}, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody
    Message registerSpace(@RequestBody Space space,@RequestParam("ownerId") Integer ownerId) {        
        return spaceServices.register(space,ownerId);
    }

    
    @RequestMapping(value = {"/editspace"}, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
    public @ResponseBody
    Message editUser(@RequestBody Space space) {
        return spaceServices.edit(space);
    }
    
//     public ApplicationContext getAppContext() {
//        return appContext;
//    }
//
//    public void setAppContext(ApplicationContext appContext) {
//        this.appContext = appContext;
//    }
//
//    public ImageUpload getImageUpload() {
//        return imageUpload;
//    }
//
//    public void setImageUpload(ImageUpload imageUpload) {
//        this.imageUpload = imageUpload;
//    }

}
