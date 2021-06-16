package edu.cuit.fs.domain;

import com.sun.xml.internal.ws.developer.Serialization;

import java.util.List;

@Serialization
public class directory {
    private String currentDirectory;
    private List<directory> childDirectory;

    public directory(String currentDirectory, List<directory> childDirectory) {
        this.currentDirectory = currentDirectory;
        this.childDirectory = childDirectory;
    }

    @Override
    public String toString() {
        return "directory{" +
                "currentDirectory='" + currentDirectory + '\'' +
                ", childDirectory=" + childDirectory +
                '}';
    }

    public directory(String currentDirectory) {
        this.currentDirectory = currentDirectory;
        this.childDirectory = null;
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(String currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public List<directory> getChildDirectory() {
        return childDirectory;
    }

    public void setChildDirectory(List<directory> childDirectory) {
        this.childDirectory = childDirectory;
    }
}
