package com.lwj.pms.pojo;
/**
 * 评论类
 * @author lwj
 */
public class Comment {
        private String PLAYER_NAME;
        private String NAME;
        private String COMMENT;

    public Comment() {
    }

    public Comment(String PLAYER_NAME, String NAME, String COMMENT) {
        this.PLAYER_NAME = PLAYER_NAME;
        this.NAME = NAME;
        this.COMMENT = COMMENT;
    }

    public String getPLAYER_NAME() {
        return PLAYER_NAME;
    }

    public void setPLAYER_NAME(String PLAYER_NAME) {
        this.PLAYER_NAME = PLAYER_NAME;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getCOMMENT() {
        return COMMENT;
    }

    public void setCOMMENT(String COMMENT) {
        this.COMMENT = COMMENT;
    }
}
