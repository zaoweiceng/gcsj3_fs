package edu.cuit.fs.utils;

public class fileUtil {
    public String  getPath(String path){
        String res = "";
        for (int i = 0; i < path.length(); i++){
            res = res + '/' + path.charAt(i);
        }
        res = res + '/' + "file";
        return res;
    }
}
