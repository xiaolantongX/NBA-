package com.lwj.pms.pojo;
/**
 * 话题类
 * @author lwj
 */
public class Topic implements Comparable<Topic>{
    private  String TOPIC_NAME;
    private  String TOPIC_MESSAGE;
    private Integer IS_TOP;
    private Integer IS_BRIGHT;

    public Topic() {
    }

    public Topic(String TOPIC_NAME, String TOPIC_MESSAGE, Integer IS_TOP, Integer IS_BRIGHT) {
        this.TOPIC_NAME = TOPIC_NAME;
        this.TOPIC_MESSAGE = TOPIC_MESSAGE;
        this.IS_TOP = IS_TOP;
        this.IS_BRIGHT = IS_BRIGHT;
    }



    public String getTOPIC_NAME() {
        return TOPIC_NAME;
    }

    public void setTOPIC_NAME(String TOPIC_NAME) {
        this.TOPIC_NAME = TOPIC_NAME;
    }

    public String getTOPIC_MESSAGE() {
        return TOPIC_MESSAGE;
    }

    public void setTOPIC_MESSAGE(String TOPIC_MESSAGE) {
        this.TOPIC_MESSAGE = TOPIC_MESSAGE;
    }

    public Integer getIS_TOP() {
        return IS_TOP;
    }

    public void setIS_TOP(Integer IS_TOP) {
        this.IS_TOP = IS_TOP;
    }

    public Integer getIS_BRIGHT() {
        return IS_BRIGHT;
    }

    public void setIS_BRIGHT(Integer IS_BRIGHT) {
        this.IS_BRIGHT = IS_BRIGHT;
    }

    @Override
    public int compareTo(Topic o) {
        int num = o.IS_TOP -  this.IS_TOP;
        return num;
        }

    @Override
    public String toString() {
        return "Topic{" +
                "TOPIC_NAME='" + TOPIC_NAME + '\'' +
                ", TOPIC_MESSAGE='" + TOPIC_MESSAGE + '\'' +
                ", IS_TOP=" + IS_TOP +
                ", IS_BRIGHT=" + IS_BRIGHT +
                '}';
    }
        }
