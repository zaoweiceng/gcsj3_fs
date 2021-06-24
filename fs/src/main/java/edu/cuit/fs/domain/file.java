package edu.cuit.fs.domain;

import com.sun.xml.internal.ws.developer.Serialization;

import java.util.LinkedList;
import java.util.List;

@Serialization
public class file {
    private String filename; //文件名
    private String hash; //文件md5值
    private String location; //文件在用户文件系统中的定位
    private boolean isDir; //该文件是否为文件夹
    private Integer childNum; //文件夹下有几个子文件
    private List<file> children;


    public file(String filename, String location, boolean isDir, Integer childNum, List<file> children) {
        this.filename = filename;
        this.location = location;
        this.isDir = isDir;
        this.childNum = childNum;
        this.children = children;
    }

    public file(String filename, String hash, String location, boolean isDir) {
        this.filename = filename;
        this.hash = hash;
        this.location = location;
        this.isDir = isDir;
    }

    public Integer getChildNum() {
        return childNum;
    }

    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }

    public List<file> getChildren() {
        return children;
    }

    public void setChildren(List<file> children) {
        this.children = children;
    }



    public file() {
        this.children = new LinkedList<>();
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
                ", childNum=" + childNum +
                ", children=" + children +
                '}';
    }
}
