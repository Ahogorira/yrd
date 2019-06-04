package com.zking.model;

import java.io.Serializable;

public class Yq implements Serializable {

    private static final long serialVersionUID = -9070081973431532868L;

    private Integer yqid;//逾期id
    private Integer uid;//用户id
    private String yqtime;//逾期日期
    private String yqover;//逾期截止日期
    private Double yqmoney;//逾期金额
    private Double yqlx;//逾期利息
    private Integer yqfq;//逾期是第几期
    private Integer yqzt;//逾期状态

    public Integer getYqid() {
        return yqid;
    }

    public void setYqid(Integer yqid) {
        this.yqid = yqid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getYqtime() {
        return yqtime;
    }

    public void setYqtime(String yqtime) {
        this.yqtime = yqtime;
    }

    public String getYqover() {
        return yqover;
    }

    public void setYqover(String yqover) {
        this.yqover = yqover;
    }

    public Double getYqmoney() {
        return yqmoney;
    }

    public void setYqmoney(Double yqmoney) {
        this.yqmoney = yqmoney;
    }

    public Double getYqlx() {
        return yqlx;
    }

    public void setYqlx(Double yqlx) {
        this.yqlx = yqlx;
    }

    public Integer getYqfq() {
        return yqfq;
    }

    public void setYqfq(Integer yqfq) {
        this.yqfq = yqfq;
    }

    public Integer getYqzt() {
        return yqzt;
    }

    public void setYqzt(Integer yqzt) {
        this.yqzt = yqzt;
    }

    @Override
    public String toString() {
        return "Yq{" +
                "yqid=" + yqid +
                ", uid=" + uid +
                ", yqtime='" + yqtime + '\'' +
                ", yqover='" + yqover + '\'' +
                ", yqmoney=" + yqmoney +
                ", yqlx=" + yqlx +
                ", yqfq=" + yqfq +
                ", yqzt=" + yqzt +
                '}';
    }
}
