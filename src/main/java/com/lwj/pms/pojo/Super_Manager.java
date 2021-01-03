package com.lwj.pms.pojo;
/**
 * 超级管理员
 * @author lwj
 */
public class Super_Manager {
    private  String super_username;
    private  String super_password;

    public Super_Manager() {
    }

    public Super_Manager(String super_username, String super_password) {
        this.super_username = super_username;
        this.super_password = super_password;
    }

    public String getSuper_username() {
        return super_username;
    }

    public void setSuper_username(String super_username) {
        this.super_username = super_username;
    }

    public String getSuper_password() {
        return super_password;
    }

    public void setSuper_password(String super_password) {
        this.super_password = super_password;
    }
}
