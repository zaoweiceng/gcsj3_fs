package edu.cuit.fs.service;

import edu.cuit.fs.domain.data;
import edu.cuit.fs.utils.userFiles;

public class userFileSystemOperation {

    private userFiles usf;

    public userFileSystemOperation(String username){
        usf = new userFiles(username);
    }

    public data getUserFIleInfoList(){
        data res = new data();
        try {
            usf.init();
            res.code = 0;
            res.data.add(usf.getFiles());
        }catch (Exception e){
            res.code = -1;
            res.description = "获取文件信息失败";
        }
        return res;
    }
}
