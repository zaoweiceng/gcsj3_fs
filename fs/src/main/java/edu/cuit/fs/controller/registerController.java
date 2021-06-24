package edu.cuit.fs.controller;

import com.google.gson.Gson;
import edu.cuit.fs.domain.userInfo;
import edu.cuit.fs.service.login.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@Controller
public class registerController {
    @Autowired
    private  Gson gson;

    @RequestMapping(value = "/register",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody String register(@RequestBody Map<String , Object> msg){
        String username = (String) msg.get("username");
        String sign = (String) msg.get("sign");
        String password = (String) msg.get("password");
        userInfo u = new userInfo();
        u.setUsername(username);
        u.setPassword(password);
        System.out.println(u.getPassword());
        System.out.println(u.getUsername());
        Register register = new Register(username,password);
        return gson.toJson(register.regist(sign));
    }
}
