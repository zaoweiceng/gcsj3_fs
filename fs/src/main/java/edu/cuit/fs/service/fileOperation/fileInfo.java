package edu.cuit.fs.service.fileOperation;

import edu.cuit.fs.utils.userFiles;

public class fileInfo {
    private String Id;
    private userFiles usf;

    public fileInfo(String id) {
        Id = id;
        usf = new userFiles(id);
    }



    public void insertFile(String fileName, String location, String hash){
       usf.insertFiles(false, fileName, location, hash);
    }

    public void insertDirectory(String fileName, String location){
        usf.insertFiles(true, fileName, location, 0);
    }

    private boolean isFileExist(String hash){
        //////////////////////////////////////
        return false;
    }
}
