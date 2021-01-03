package com.lwj.pms.pojo;

/**
 * 普通管理员类
 * @author lwj
 */
public class Common_Manager {
    private String manager_username;
    private String manager_password;

    public Common_Manager() {
    }
    public String getManager_username() {
        return manager_username;
    }

    public void setManager_username(String manager_username) {
        this.manager_username = manager_username;
    }

    public String getManager_password() {
        return manager_password;
    }

    public void setManager_password(String manager_password) {
        this.manager_password = manager_password;
    }
}
