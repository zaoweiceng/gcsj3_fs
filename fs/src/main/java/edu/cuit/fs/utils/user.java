package edu.cuit.fs.utils;

import edu.cuit.fs.domain.userInfo;

import java.io.IOException;
import java.util.Random;

public class user {
    private String username;
    private String password;
    private String id;

    public user() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public user(userInfo u) {
        this.username = u.getUsername();
        this.password = u.getPassword();
        this.id = u.getID();
    }

    public user initUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.initId();
        return this;
    }
    public user initUser(userInfo u) {
        this.username = u.getUsername();
        this.password = u.getPassword();
        this.initId();
        return this;
    }
    public user initUser() {
        this.initId();
        return this;
    }

    private void initId(){
        DbUtil db = new DbUtil();
        this.id = String.format("%06d", db.rowCountByCoprocessor("userinfo"));
    }

    public boolean isPwdTrue(){
        DbUtil.init();
        try {
            String data = DbUtil.getData("userinfo", this.id, "user", "password");
            if (data == null || data == "") {
                DbUtil.close();
                return false;
            }
            if (data.equals(this.password)){
                DbUtil.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close();
        }
        return false;
    }

    public boolean saveUser() {
        DbUtil.init();
        try {
            DbUtil.insertData("userinfo", this.id, "user", "username", this.username);
            DbUtil.insertData("userinfo", this.id, "user", "password", this.password);
            DbUtil.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close();
        }
        return false;
    }

    public void save(String col, String id,  String data){
        DbUtil.init();
        try {
            DbUtil.insertData("userinfo", id, "user", col, data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            DbUtil.close();
        }
    }

    public String getUsername() {
        return username;
    }

    public user setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public user setPassword(String password) {
        this.password = password;
        return this;
    }

    private boolean idIsUsed(String ID) {
        DbUtil.init();
        try {
            String data = DbUtil.getData("userinfo", ID, "user", "username");
            if (data != null || data != "") {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close();
        }
        return false;
    }

    @Override
    public String toString() {
        return "user{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
