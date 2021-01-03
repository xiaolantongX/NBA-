package com.lwj.pms.dao;

import com.lwj.pms.pojo.Comment;
import com.lwj.pms.utils.DBUtils;

import java.util.List;

    public class CommentDao {
        public List<Comment> getAllComments(){
            String sql = "select * from comment";
            return DBUtils.getList(Comment.class,sql,null);
        }
        public List<Comment> getComments(String player_name){
            String sql = "select * from comment where PLAYER_NAME = ?";
            return DBUtils.getList(Comment.class,sql,player_name);
        }
        public boolean saveComment(String player_name,String name ,String comment){
            String sql = "insert into comment values(?,?,?,?)";
            return DBUtils.save(sql,null,player_name,name,comment);
        }

}
