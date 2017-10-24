package com.example.slam24.retrofitjwt.models;

/**
 * Created by SLAM24 on 10/17/2017.
 */

public class Auth {
    private String token;
    private Integer uid;
    private String username;
    private String email;
    private String path;
    private String fn;
    private String sn;
    private String fln;
    private String sln;
    private Integer state;
    private String ced;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getFln() {
        return fln;
    }

    public void setFln(String fln) {
        this.fln = fln;
    }

    public String getSln() {
        return sln;
    }

    public void setSln(String sln) {
        this.sln = sln;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCed() {
        return ced;
    }

    public void setCed(String ced) {
        this.ced = ced;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
