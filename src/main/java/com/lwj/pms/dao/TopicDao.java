package com.lwj.pms.dao;

import com.lwj.pms.pojo.Comment;
import com.lwj.pms.pojo.Players_Message;
import com.lwj.pms.pojo.Topic;
import com.lwj.pms.utils.DBUtils;

import java.util.List;

public class TopicDao {
    public List<Topic> getTopics(){
        String sql = "select * from topic";
        return DBUtils.getList(Topic.class,sql,null);
    }
    public Integer selectTopic(String topicname) {
        System.out.println("开始查找");
        String sql = "select count(*) from topic where TOPIC_NAME = ?";
        return DBUtils.getCount(sql,topicname);
    }
    public Topic getTopic(String topicname){
        String sql="select * from topic where TOPIC_NAME = ?";
        return DBUtils.getSingleObj(Topic.class,sql,topicname);
    }
    public boolean updateTopic(Topic topic){
        String sql = "update topic set TOPIC_MESSAGE = ?,IS_TOP= ?,IS_BRIGHT=? where TOPIC_NAME = ?";
        return DBUtils.update(sql,topic.getTOPIC_MESSAGE(),topic.getIS_TOP(),topic.getIS_BRIGHT(),topic.getTOPIC_NAME());
    }
}
