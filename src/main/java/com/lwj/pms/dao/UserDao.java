package com.lwj.pms.dao;

import com.lwj.pms.pojo.Common_User;
import com.lwj.pms.pojo.Players_Message;
import com.lwj.pms.utils.DBUtils;

import java.util.List;

public class UserDao {
   //保存注册对象
    public boolean saveUser(Common_User user) {
        System.out.println("开始插入数据");
        String sql = "insert into common_user(USER_NAME,PASSWORD,EMAIL,NAME,PHONE_NUM,SEX,BIRTH_DAY)" +
                "values(?,?,?,?,?,?,?)";
        return DBUtils.save(sql,user.getUser_name(),user.getPassword(),user.getEmail(),user.getName(),user.getPhone_num(),user.getSex(),user.getBirth_day());
    }
    //查询所有的用户账号
    public List<Common_User> getUsers(){
        String sql = "select USER_NAME user_name,PASSWORD password,EMAIL email,NAME name,PHONE_NUM phone_num,SEX sex,BIRTH_DAY birth_day from common_user";
        return DBUtils.getList(Common_User.class,sql,null);
    }
        //根据账号和密码查询用户

     public Common_User getUserByUserNameAndPwd(String userName, String password) {
            System.out.println("开始匹配数据库");
            String sql = "select USER_NAME user_name,PASSWORD password,EMAIL email,NAME name,PHONE_NUM phone_num,SEX sex,BIRTH_DAY birth_day from common_user where USER_NAME = ? and PASSWORD = ?";
            return DBUtils.getSingleObj(Common_User.class,sql,userName,password);
        }

    public Integer selectUserName(String username) {
        System.out.println("开始查找");
        String sql = "select count(*) from common_user where USER_NAME = ?";
        return DBUtils.getCount(sql,username);
    }
    public boolean delByUserName(String username){
        System.out.println("开始删除数据");
        String sql = "delete from common_user where USER_NAME = ?";
        return DBUtils.update(sql,username);
    }
}
