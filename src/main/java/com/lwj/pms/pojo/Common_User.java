package com.lwj.pms.pojo;

/**
 * 普通用户类
 * @author lwj
 */
public class Common_User {
    private String user_name;
    private String password;
    private String email;
    private String name;
    private String phone_num;
    private String sex;
    private String birth_day;

    public Common_User() {

    }

    public Common_User(String user_name, String password, String email, String name, String phone_number, String sex, String birth_day) {
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phone_num = phone_number;
        this.sex = sex;
        this.birth_day = birth_day;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(String birth_day) {
        this.birth_day = birth_day;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Common_User{" +
                "user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
