package edu.cuit.fs.domain;

import com.sun.xml.internal.ws.developer.Serialization;

@Serialization
public class userInfo {
    public String username;
    public String password;
    public String ID;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public userInfo(String username, String password, String ID) {
        this.username = username;
        this.password = password;
        this.ID = ID;
    }

    public userInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public userInfo() {
    }
}
