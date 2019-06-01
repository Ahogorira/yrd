package com.zking.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class LcShop implements Serializable {

    private static final long serialVersionUID = 8800649389724258911L;
    private Integer lsid;//理财购买记录id
    private Double lsMoney;//购买金额
    private Double lssy;//理财收益
    private User user;//用户id
    private Lccp lccp;//理财产品id

    public Integer getLsid() {
        return lsid;
    }

    public void setLsid(Integer lsid) {
        this.lsid = lsid;
    }

    public Double getLsMoney() {
        return lsMoney;
    }

    public void setLsMoney(Double lsMoney) {
        this.lsMoney = lsMoney;
    }

    public Double getLssy() {
        return lssy;
    }

    public void setLssy(Double lssy) {
        this.lssy = lssy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lccp getLccp() {
        return lccp;
    }

    public void setLccp(Lccp lccp) {
        this.lccp = lccp;
    }

    @Override
    public String toString() {
        return "LcShop{" +
                "lsid=" + lsid +
                ", lsMoney=" + lsMoney +
                ", lssy=" + lssy +
                ", user=" + user +
                ", lccp=" + lccp +
                '}';
    }
}
