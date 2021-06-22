package edu.cuit.fs.utils;

import com.google.gson.Gson;
import edu.cuit.fs.domain.file;

import java.util.List;

public class userFiles {
    private List<file> files;
    private String ID;
    private Gson gson;

    public userFiles(String id){
        this.ID = id;
        gson = new Gson();
    }

    public userFiles setFiles(List<file> files){
        this.files = files;
        return this;
    }

    public List<file> getFiles(){

        return files;
    }

    public void insertFiles(){
        String json = gson.toJson(files);
        System.out.println(json);
    }


}
