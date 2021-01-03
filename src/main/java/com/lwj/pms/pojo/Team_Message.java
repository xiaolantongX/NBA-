package com.lwj.pms.pojo;

public class Team_Message {
    private String TEAM_ID;
    private String TEAM_NAME;
    private String TEAM_LOCATION;//球队地址
    private String COMPLETITION_AREA; //球队赛区
    private Integer TOTAL_CHAMPIONS;
    private String COACH;
    private Integer WIN_NUM;//胜场数
    private Integer FAILE_NUM;//负场数
    private Float WIN_PRO;//胜率
    private Integer TEAM_RANK;//联盟排名
    private Integer PLAYER_NUM; //球员数
    public Team_Message() {}

    public Team_Message(String TEAMID, String TEAMNAME, String TEAM_LOCATION, String COMPLETITIONAREA, Integer TOTALCHAMPIONS, String COACH, Integer WINNUM, Integer FAILENUM, Float WINPRO, Integer TEAMRANK, Integer PLAYERNUM) {
        TEAM_ID = TEAMID;
        TEAM_NAME = TEAMNAME;
        this.TEAM_LOCATION = TEAM_LOCATION;
        COMPLETITION_AREA = COMPLETITIONAREA;
        TOTAL_CHAMPIONS = TOTALCHAMPIONS;
        this.COACH = COACH;
        WIN_NUM = WINNUM;
        FAILE_NUM = FAILENUM;
        WIN_PRO = WINPRO;
        TEAM_RANK = TEAMRANK;
        PLAYER_NUM = PLAYERNUM;
    }

    public String getTEAM_ID() {
        return TEAM_ID;
    }
    public void setTEAM_ID(String TEAM_ID) {
        this.TEAM_ID = TEAM_ID;
    }
    public String getTEAM_NAME() {
        return TEAM_NAME;
    }
    public void setTEAM_NAME(String TEAM_NAME) {
        this.TEAM_NAME = TEAM_NAME;
    }
    public String getTEAM_LOCATION() {
        return TEAM_LOCATION;
    }
    public void setTEAM_LOCATION(String TEAM_LOCATION) {
        this.TEAM_LOCATION = TEAM_LOCATION;
    }
    public String getCOMPLETITION_AREA() {
        return COMPLETITION_AREA;
    }
    public void setCOMPLETITION_AREA(String COMPLETITION_AREA) {
        this.COMPLETITION_AREA = COMPLETITION_AREA;
    }
    public Integer getTOTAL_CHAMPIONS() {
        return TOTAL_CHAMPIONS;
    }
    public void setTOTAL_CHAMPIONS(Integer TOTAL_CHAMPIONS) {
        this.TOTAL_CHAMPIONS = TOTAL_CHAMPIONS;
    }
    public String getCOACH() {
        return COACH;
    }
    public void setCOACH(String COACH) {
        this.COACH = COACH;
    }
    public Integer getWIN_NUM() {
        return WIN_NUM;
    }
    public void setWIN_NUM(Integer WIN_NUM) {
        this.WIN_NUM = WIN_NUM;
    }
    public Integer getFAILE_NUM() {
        return FAILE_NUM;
    }
    public void setFAILE_NUM(Integer FAILE_NUM) {
        this.FAILE_NUM = FAILE_NUM;
    }
    public Float getWIN_PRO() {
        return WIN_PRO;
    }
    public void setWIN_PRO(Float WIN_PRO) {
        this.WIN_PRO = WIN_PRO;
    }
    public Integer getTEAM_RANK() {
        return TEAM_RANK;
    }
    public void setTEAM_RANK(Integer rank) {
        TEAM_RANK = rank;
    }
    public Integer getPLAYER_NUM() {
        return PLAYER_NUM;
    }
    public void setPLAYER_NUM(Integer PLAYER_NUM) {
        this.PLAYER_NUM = PLAYER_NUM;
    }

}
