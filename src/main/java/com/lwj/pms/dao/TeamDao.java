package com.lwj.pms.dao;

import com.lwj.pms.pojo.Team_Message;
import com.lwj.pms.utils.DBUtils;

import java.util.List;

public class TeamDao {
    public List<Team_Message> getTeams(){
        String sql = "select * from team";
        return DBUtils.getList(Team_Message.class,sql,null);
    }

    public Team_Message getTeam(String team_name){
        String sql="select * from team where TEAM_NAME = ?";
        return DBUtils.getSingleObj(Team_Message.class,sql,team_name);
    }
    //保存球员对象
    public boolean saveTeam(Team_Message team) {
        System.out.println("开始加入球队数据");
        String sql = "insert into team(TEAM_ID,TEAM_NAME,TEAM_LOCATION,TOTAL_CHAMPIONS,COMPLETITION_AREA,COACH,WIN_NUM,FAILE_NUM,WIN_PRO,TEAM_RANK,PLAYER_NUM)" +
                "values(?,?,?,?,?,?,?,?,?,?,?)";
        return DBUtils.save(sql,team.getTEAM_ID(),team.getTEAM_NAME(),team.getTEAM_LOCATION(),team.getCOMPLETITION_AREA(),team.getTOTAL_CHAMPIONS(),team.getCOACH(),team.getWIN_NUM(),team.getFAILE_NUM(),team.getWIN_PRO(),team.getTEAM_RANK(),team.getPLAYER_NUM());
    }
    //修改球员对象
    public boolean updateTeam(Team_Message team) {
        System.out.println("开始修改数据");
        String sql = "update team set TEAM_LOCATION = ?,TOTAL_CHAMPIONS = ?,COMPLETITION_AREA = ?,COACH = ?,WIN_NUM = ?,FAILE_NUM = ?,WIN_PRO = ?,TEAM_RANK = ?,PLAYER_NUM = ? where TEAM_NAME = ?";
        return DBUtils.update(sql,team.getTEAM_ID(),team.getTEAM_NAME(),team.getTEAM_LOCATION(),team.getCOMPLETITION_AREA(),team.getTOTAL_CHAMPIONS(),team.getCOACH(),team.getWIN_NUM(),team.getFAILE_NUM(),team.getWIN_PRO(),team.getTEAM_RANK(),team.getPLAYER_NUM());
    }
    //删除球员对象
    public boolean delTeam(String team_name) {
        System.out.println("开始删除数据");
        String sql = "delete from team where TEAM_NAME = ?";
        return DBUtils.update(sql,team_name);
    }
}
