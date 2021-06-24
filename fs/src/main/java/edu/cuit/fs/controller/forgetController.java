package edu.cuit.fs.controller;

import com.google.gson.Gson;
import edu.cuit.fs.domain.userInfo;
import edu.cuit.fs.service.login.Forget;
import edu.cuit.fs.service.login.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@Controller
public class forgetController {
    @Autowired
    private Gson gson;

    @RequestMapping(value = "/forget",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody String forget(@RequestBody Map<String, Object> msg){
        String username = (String) msg.get("id");
        String check = (String) msg.get("sign");
        userInfo u = new userInfo();
        u.setUsername(username);
        System.out.println(username);
        System.out.println(check);
        Forget forget = new Forget();
        return gson.toJson(forget.canResetPwd(check));
    }

    @RequestMapping(value = "/reset",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody String reset(@RequestBody Map<String, Object> msg){
        String username = (String) msg.get("username");
        String password = (String) msg.get("password");
        userInfo u = new userInfo();
        u.setUsername(username);
        System.out.println(username);
        System.out.println(password);
        Forget forget = new Forget();
        return gson.toJson(forget.resetPwd(username,password));
    }
}
