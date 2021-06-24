package edu.cuit.fs.service.login;

import edu.cuit.fs.domain.data;
import edu.cuit.fs.utils.user;

public class Forget {
    private String sign = "000000";
    private user Userinfo;

    public Forget(){
        Userinfo = new user();
    }

    public data canResetPwd(String code){
        data res = new data();
        if (sign.equals(code)){
            res.code = 0;
        }else {
            res.code = -1;
            res.description = "sign error";
        }
        return res;
    }

    public data resetPwd(String id, String password){
        data res = new data();
        try {
            Userinfo.save("password", id, password);
            res.code = 0;
            return res;
        }catch (Exception e){

        }finally {
            res.code=-2;
        }
        return res;
    }
}
