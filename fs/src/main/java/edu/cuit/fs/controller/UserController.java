package edu.cuit.fs.controller;

import com.google.gson.Gson;
import edu.cuit.fs.domain.data;
import edu.cuit.fs.domain.userInfo;
import edu.cuit.fs.service.login.Login;
import edu.cuit.fs.service.userFileSystemOperation;
import edu.cuit.fs.utils.userFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
public class UserController {

    @Autowired
    private  Gson gson;


    @RequestMapping(value = "/login",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody String login(@RequestBody Map<String , Object> msg){
        String username = (String) msg.get("username");
        String password = (String) msg.get("password");
        userInfo u = new userInfo();
        u.setID(username);
        u.setPassword(password);
        System.out.println(u.getPassword());
        System.out.println(u.getID());
        Login login = new Login(u);
        return gson.toJson(login.canLogin());
    }

    @RequestMapping(value = "/fileInfo",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody String getUserFileInfo(@RequestBody Map<String , Object> msg){
        String username = (String) msg.get("username");
        userFileSystemOperation usfso = new userFileSystemOperation(username);
        data res = usfso.getUserFIleInfoList();
        return gson.toJson(res);
    }

}
