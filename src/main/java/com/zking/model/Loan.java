package com.zking.model;

import java.io.Serializable;

public class Loan implements Serializable {
    private static final long serialVersionUID = 5242732911641712485L;
    private Integer lid;//借款申请id
    private Double money;//借款金额
    private Integer ifq;//借款分期
    private Integer lzt;//审核状态
    private Integer yid;//审核员工id
    private Integer uid;//用户id
    private String sqtime;//申请时间
    private String shtime;//审核时间

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getIfq() {
        return ifq;
    }

    public void setIfq(Integer ifq) {
        this.ifq = ifq;
    }

    public Integer getLzt() {
        return lzt;
    }

    public void setLzt(Integer lzt) {
        this.lzt = lzt;
    }

    public Integer getYid() {
        return yid;
    }

    public void setYid(Integer yid) {
        this.yid = yid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSqtime() {
        return sqtime;
    }

    public void setSqtime(String sqtime) {
        this.sqtime = sqtime;
    }

    public String getShtime() {
        return shtime;
    }

    public void setShtime(String shtime) {
        this.shtime = shtime;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "lid=" + lid +
                ", money=" + money +
                ", ifq=" + ifq +
                ", lzt=" + lzt +
                ", yid=" + yid +
                ", uid=" + uid +
                ", sqtime='" + sqtime + '\'' +
                ", shtime='" + shtime + '\'' +
                '}';
    }
}
