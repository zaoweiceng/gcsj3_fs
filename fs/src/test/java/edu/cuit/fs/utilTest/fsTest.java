package edu.cuit.fs.utilTest;

import org.junit.Test;

import java.io.*;

public class fsTest {
    @Test
    public void test(){
        File file = new File("C:\\Users\\zwc\\Desktop\\centos.txt");
        String  hash = file.hashCode() + "";
        System.out.println(file.canRead());
        System.out.println(hash);
        String res = "";
        byte[] read = new byte[1024];
        int byteread = 0;
        try {
            InputStream in = new FileInputStream(file);
            BufferedInputStream buffin = new BufferedInputStream(in);
            while ((byteread = buffin.read()) != -1){
                res += (byte) byteread;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }
}
