package com.lwj.pms.dao;

import com.lwj.pms.utils.DBUtils;

public class AjaxDao {
    public Integer selectByUserName(String user_name){
            String sql = "select * from common_user where USER_NAME = ?";
            return DBUtils.getCount(sql,user_name);
    }
}
