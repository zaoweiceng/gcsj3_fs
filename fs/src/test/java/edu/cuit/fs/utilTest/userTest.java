package edu.cuit.fs.utilTest;

import edu.cuit.fs.utils.user;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class userTest {
    @Test
    public void userInitTest(){
        List<String> res = new LinkedList();
        for(int i = 0; i < 10; i++){
            user u = new user();
            res.add(u.initUser("aaa", "asd").toString());
        }
        for (String s : res){
            System.out.println(s);
        }
    }
}
