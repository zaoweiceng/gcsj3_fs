package edu.cuit.fs.domain;

import com.sun.xml.internal.ws.developer.Serialization;

@Serialization
public class file {
    public String filename;
    public String hash;
    public String location;

    public file() {
    }

    @Override
    public String toString() {
        return "file{" +
                "filename='" + filename + '\'' +
                ", hash='" + hash + '\'' +
                ", location='" + location + '\'' +
                '}';
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

    public file(String filename, String hash, String location) {
        this.filename = filename;
        this.hash = hash;
        this.location = location;
    }
}
