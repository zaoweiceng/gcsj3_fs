package edu.cuit.fs.domain;

import com.sun.xml.internal.ws.developer.Serialization;

import java.util.LinkedList;
import java.util.List;

@Serialization
public class userFileInfo {
    public String ID;
    public List<file> files;

    public userFileInfo() {
        files = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "userFileInfo{" +
                "ID='" + ID + '\'' +
                ", files=" + files +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<file> getFiles() {
        return files;
    }

    public void setFiles(List<file> files) {
        this.files = files;
    }

    public userFileInfo(String ID, List<file> files) {
        this.ID = ID;
        this.files = files;
    }
}
