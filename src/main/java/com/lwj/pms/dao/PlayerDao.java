package com.lwj.pms.dao;

import com.lwj.pms.pojo.Comment;
import com.lwj.pms.pojo.Common_User;
import com.lwj.pms.pojo.Players_Message;
import com.lwj.pms.utils.DBUtils;

import java.util.ArrayList;
import java.util.List;


public class PlayerDao {
    public List<Players_Message> getPlayers(){
        String sql = "select * from players_message";
        return DBUtils.getList(Players_Message.class,sql,null);
    }

    public Players_Message getPlayer(String player_name){
        String sql="select * from players_message where PLAYER_NAME = ?";
      return DBUtils.getSingleObj(Players_Message.class,sql,player_name);
    }
    //保存球员对象
    public boolean savePlayer(Players_Message player) {
        System.out.println("开始插入球员数据");
        String sql = "insert into players_message values(?,?,?,?,?,?,?)";
        System.out.println(player.getPLAYER_NAME()+player.getTEAM_NAME()+player.getBIRTH_DAY());
        return DBUtils.save(sql,player.getPLAYER_NAME(),player.getTEAM_NAME(),player.getBIRTH_DAY(),player.getHEIGHT(),player.getWEIGHT(),player.getPOSITION(),player.getCOUNT());
    }
    //修改球员对象
    public boolean updatePlayer(Players_Message player) {
        System.out.println("开始修改数据");
        String sql = "update players_message set TEAM_NAME = ?,BIRTH_DAY = ?,HEIGHT= ?,WEIGHT=?,POSITION = ?,COUNT=? where PLAYER_NAME = ?";
        return DBUtils.update(sql,player.getTEAM_NAME(),player.getBIRTH_DAY(),player.getHEIGHT(),player.getWEIGHT(),player.getPOSITION(),player.getCOUNT(),player.getPLAYER_NAME());
    }
    //删除球员对象
    public boolean delPlayer(String player_name) {
        System.out.println("开始删除数据");
        String sql = "delete from players_message where PLAYER_NAME = ?";
        return DBUtils.update(sql,player_name);
    }
    //按球队查找球员
    public List<Players_Message> getPlayersByTeam(String teamname){
        String sql = "select * from players_message where TEAM_NAME = ?";
        return DBUtils.getList(Players_Message.class,sql,teamname);

    }
}
