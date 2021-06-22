package edu.cuit.fs.domain;

import com.sun.xml.internal.ws.developer.Serialization;

import java.util.List;

@Serialization
public class file {
    private String filename;
    private String hash;
    private String location;
    private boolean isDir;
    private List<file> children;

    public file() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean dir) {
        isDir = dir;
    }

    public List<file> getList() {
        return children;
    }

    public void setList(List<file> list) {
        this.children = list;
    }

    @Override
    public String toString() {
        return "file{" +
                "filename='" + filename + '\'' +
                ", hash='" + hash + '\'' +
                ", location='" + location + '\'' +
                ", isDir=" + isDir +
                ", list=" + children +
                '}';
    }
}
