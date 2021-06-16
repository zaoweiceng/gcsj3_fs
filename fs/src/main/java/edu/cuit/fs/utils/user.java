package edu.cuit.fs.utils;

import java.io.IOException;
import java.util.Random;

public class user {
    private String username;
    private String password;
    private String id;

    public user initUser(String username, String password) {
        Random random = new Random();
        while (true) {
            Integer ID = (int) (random.nextDouble() * 10e6);
            this.username = username;
            this.password = password;
            this.id = ID.toString().substring(0, 6);
            if (!idIsUsed(this.id)) {
                break;
            }
            System.out.println(this.id + "is used!!!!!!!!!!");
        }
        return this;
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
