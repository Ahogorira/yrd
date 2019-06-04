package com.zking.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -6613236870700929604L;
    private Integer uid;//用户id
    private String phone;//手机号
    private String upwd;//密码
    private Double moneyed;//可借款额度
    private Integer zmf;//芝麻分
    private Integer xyf;//信用分
    private String zctime;//注册时间

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public Double getMoneyed() {
        return moneyed;
    }

    public void setMoneyed(Double moneyed) {
        this.moneyed = moneyed;
    }

    public Integer getZmf() {
        return zmf;
    }

    public void setZmf(Integer zmf) {
        this.zmf = zmf;
    }

    public Integer getXyf() {
        return xyf;
    }

    public void setXyf(Integer xyf) {
        this.xyf = xyf;
    }

    public String getZctime() {
        return zctime;
    }

    public void setZctime(String zctime) {
        this.zctime = zctime;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", phone='" + phone + '\'' +
                ", upwd='" + upwd + '\'' +
                ", moneyed=" + moneyed +
                ", zmf=" + zmf +
                ", xyf=" + xyf +
                ", zctime='" + zctime + '\'' +
                '}';
    }
}
