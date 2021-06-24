package edu.cuit.fs.utils;

import com.google.gson.Gson;
import edu.cuit.fs.domain.file;

import java.io.IOException;
import java.util.LinkedList;
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

    public userFiles insertFiles(boolean isDir, String fileName, String location, String hash){
        file f = new file();
        f.setDir(isDir);
        f.setFilename(fileName);
        f.setLocation(location);
        f.setHash(hash);
        List<file> fs =  getFs(location);
        f.setLocation(location);
        fs.add(f);
        return this;
    }

    private List<file> getFs(String location){
        List<file> fs = files;
        if (location.equals("")){
            return files;
        }
        String[] strings = location.split("_");
        int i = 0;
        String loc = strings[i++];
        while (true){
            int f = 0;
            for (file l : fs){
                if (loc.equals(l.getLocation())){
                    fs = l.getList();
                    if (i < strings.length) loc  = loc + "_" + strings[i++];
                    if (loc == location){
                        return fs;
                    }
                    f = 1;
                }
            }
            if (f == 0) break;
        }
        return fs;
    }

    public userFiles insertFiles(boolean isDir, String fileName, String location, Integer childNum){
        file f = new file();
        f.setDir(isDir);
        f.setFilename(fileName);
        f.setLocation(location);
        f.setChildNum(childNum);
        List<file> fs = getFs(location);
        f.setLocation(location);
        fs.add(f);
        return this;
    }

    public userFiles init(){
        DbUtil.init();
        String json = null;
        try {
            json = DbUtil.getData("userinfo", this.ID, "file", "files");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            DbUtil.close();
        }
        files = gson.fromJson(json, List.class);
        return this;
    }

    public void saveFileInfo(){
        DbUtil.init();
        try {
            DbUtil.insertData("userinfo", this.ID, "file", "files", toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            DbUtil.close();
        }
    }

    @Override
    public String toString() {
        String json = gson.toJson(files);
        return json;
    }
}
