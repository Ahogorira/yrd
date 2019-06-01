package com.zking.model;

import java.io.Serializable;

public class Hk implements Serializable {

    private static final long serialVersionUID = 169983298541035920L;
    private Integer hkid;//还款id
    private Integer uid;//用户id
    private Integer jkfq;//借款的期数
    private Double money;//借款金额
    private Integer hkfq;//当前还款的期数
    private Double hkMoney;//还款金额
    private String hktime;//还款时间

    public Integer getHkid() {
        return hkid;
    }

    public void setHkid(Integer hkid) {
        this.hkid = hkid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getJkfq() {
        return jkfq;
    }

    public void setJkfq(Integer jkfq) {
        this.jkfq = jkfq;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getHkfq() {
        return hkfq;
    }

    public void setHkfq(Integer hkfq) {
        this.hkfq = hkfq;
    }

    public Double getHkMoney() {
        return hkMoney;
    }

    public void setHkMoney(Double hkMoney) {
        this.hkMoney = hkMoney;
    }

    public String getHktime() {
        return hktime;
    }

    public void setHktime(String hktime) {
        this.hktime = hktime;
    }

    @Override
    public String toString() {
        return "Hk{" +
                "hkid=" + hkid +
                ", uid=" + uid +
                ", jkfq=" + jkfq +
                ", money=" + money +
                ", hkfq=" + hkfq +
                ", hkMoney=" + hkMoney +
                ", hktime='" + hktime + '\'' +
                '}';
    }
}
