package edu.cuit.fs.service.login;

import edu.cuit.fs.domain.data;
import edu.cuit.fs.utils.user;

import java.util.HashMap;

public class Register {
    private String sign = "000000";
    private user Userinfo;
    public Register(String usrername, String password){
        Userinfo = new user();
        Userinfo.setUsername(usrername);
        Userinfo.setPassword(password);
    }

    public data regist(String sign){
        data res = new data();
        res.code = 0;
        if (sign.equals(sign)){
            Userinfo.initUser().saveUser();
            HashMap<String, String> map = new HashMap<>();
            map.put("ID", Userinfo.getId());
            res.data.add(map);
        }else {
           res.code = -1;
           res.description = "sign error";
        }
        return res;
    }
}
