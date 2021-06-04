package edu.cuit.fs.utilTest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import edu.cuit.fs.domain.file;
import edu.cuit.fs.domain.userFileInfo;
import edu.cuit.fs.utils.DbUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class dbTest {

    @Test
    public void test(){
//        System.setProperty("hadoop.home.dir", "D:\\MAVEN\\org\\apache\\hadoop\\hadoop-common\\2.7.7");
        DbUtil.init();
        try {
//            DbUtil.createTable("userinfo", new String[]{"user", "file"});
//            DbUtil.insertData("userinfo", "zaoweiceng", "user", "username", "silence");
            DbUtil.insertData("userinfo", "zaoweiceng", "user", "password", "99999999");
//            DbUtil.insertData("userinfo", "zaoweiceng", "file", "asc13asc5d1s2ds2d12s", "1234560213201201212156132");
//            DbUtil.insertData("userinfo", "zaoweiceng", "file", "aasc54654874865s4a4c", "1232156132");
//            DbUtil.insertData("userinfo", "zaoweiceng", "file", "aasc54aa452121as84d6c", "123215zx545z112102.02156132");
            DbUtil.getData("userinfo", "zaoweiceng", "user", "username");
            DbUtil.getData("userinfo", "zaoweiceng", "user", "password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        DbUtil.close();
    }

    @Test
    public void jsonTEst(){
        userFileInfo usf = new userFileInfo();
        usf.setID("001122");
        file f = new file();
        f.setFilename("a.txt");
        f.setHash("asdasdasdadad");
        f.setLocation("/a/v/c/d/a/s/");
        usf.files.add(f);
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(usf);
        System.out.println(jsonElement);
        userFileInfo info = gson.fromJson(jsonElement, userFileInfo.class);
        System.out.println(info);
    }
}
