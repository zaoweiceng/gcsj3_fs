package edu.cuit.fs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(String username){

        //map.put("loginError", "用户名或密码错误，请重新输入");
        return "login";
    }
}
