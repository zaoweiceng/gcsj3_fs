package edu.cuit.fs.service.login;

import edu.cuit.fs.domain.data;
import edu.cuit.fs.domain.userInfo;
import edu.cuit.fs.utils.user;

import java.util.HashMap;

public class Login {
    private user u;
    private userInfo uf;

    public Login(userInfo uf) {
        this.uf = uf;
        u = new user(this.uf);
    }

    public data canLogin(){
        data res = new data();
        if (u.isPwdTrue()){
            res.code = 0;
            res.description = "login success";
            HashMap<String, String> map = new HashMap<>();
            map.put("token", "test");
            res.data.add(map);
        }else {
            res.code = -1;
            res.description = "login fail";
        }
        return res;
    }
}
