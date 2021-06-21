package edu.cuit.fs.controller;

import com.google.gson.Gson;
import edu.cuit.fs.domain.data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
public class UserController {

    private final Gson gson;

    public UserController(Gson gson) {
        this.gson = gson;
    }

    @RequestMapping(value = "/login",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody String login(@RequestBody Map<String , Object> msg){
        String username = (String) msg.get("username");
        String password = (String) msg.get("password");
        data d = new data();
        d.setCode(0);
        d.setDescription("login success");
        HashMap<String, String> map = new HashMap<>();
        map.put("token", "test");
        d.data.add(map);
        String res = gson.toJson(d);
        System.out.println(res);
        return res;
    }
}
