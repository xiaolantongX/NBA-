package com.lwj.pms.pojo;
/**
 * 球员信息类
 * @author lwj
 */
public class Players_Message {
    private String PLAYER_NAME;
    private String TEAM_NAME;
    private String BIRTH_DAY;
    private Float HEIGHT;
    private Float WEIGHT;
    private String POSITION;
    private Integer COUNT;

    public Players_Message() {
    }
    public Players_Message(String PLAYER_NAME, String TEAM_NAME, String BIRTH_DAY, Float HEIGHT, Float WEIGHT, String POSITION, Integer COUNT) {
        this.PLAYER_NAME = PLAYER_NAME;
        this.TEAM_NAME = TEAM_NAME;
        this.BIRTH_DAY = BIRTH_DAY;
        this.HEIGHT = HEIGHT;
        this.WEIGHT = WEIGHT;
        this.POSITION = POSITION;
        this.COUNT = COUNT;
    }

    public String getPLAYER_NAME() {
        return PLAYER_NAME;
    }

    public void setPLAYER_NAME(String PLAYER_NAME) {
        this.PLAYER_NAME = PLAYER_NAME;
    }

    public String getTEAM_NAME() {
        return TEAM_NAME;
    }

    public void setTEAM_NAME(String TEAM_NAME) {
        this.TEAM_NAME = TEAM_NAME;
    }

    public String getBIRTH_DAY() {
        return BIRTH_DAY;
    }

    public void setBIRTH_DAY(String BIRTH_DAY) {
        this.BIRTH_DAY = BIRTH_DAY;
    }

    public Float getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(Float HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public Float getWEIGHT() {
        return WEIGHT;
    }

    public void setWEIGHT(Float WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    public String getPOSITION() {
        return POSITION;
    }

    public void setPOSITION(String POSITION) {
        this.POSITION = POSITION;
    }

    public Integer getCOUNT() {
        return COUNT;
    }

    public void setCOUNT(Integer COUNT) {
        this.COUNT = COUNT;
    }
    @Override
    public String toString() {
        return "Players_Message{" +
                "PLAYER_NAME='" + PLAYER_NAME + '\'' +
                ", TEAM_NAME='" + TEAM_NAME + '\'' +
                ", BIRTH_DAY='" + BIRTH_DAY + '\'' +
                ", HEIGHT=" + HEIGHT +
                ", WEIGHT=" + WEIGHT +
                ", POSITION='" + POSITION + '\'' +
                ", COUNT=" + COUNT +
                '}';
    }
}
