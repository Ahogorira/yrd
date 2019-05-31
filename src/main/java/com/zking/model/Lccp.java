package com.zking.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 理财产品类
 */
@Component
public class Lccp implements Serializable {

    private static final long serialVersionUID = 7294864045931813326L;

    private Integer lcid;//理财id
    private String lcname;//理财产品名字
    private Double lcv;//理财产品利率
    private String lcTime;//理财时间
    private Double lcMoney;//理财产品价格
    private String lcImg;//理财产品图片

    public Integer getLcid() {
        return lcid;
    }

    public void setLcid(Integer lcid) {
        this.lcid = lcid;
    }

    public String getLcname() {
        return lcname;
    }

    public void setLcname(String lcname) {
        this.lcname = lcname;
    }

    public Double getLcv() {
        return lcv;
    }

    public void setLcv(Double lcv) {
        this.lcv = lcv;
    }

    public String getLcTime() {
        return lcTime;
    }

    public void setLcTime(String lcTime) {
        this.lcTime = lcTime;
    }

    public Double getLcMoney() {
        return lcMoney;
    }

    public void setLcMoney(Double lcMoney) {
        this.lcMoney = lcMoney;
    }

    public String getLcImg() {
        return lcImg;
    }

    public void setLcImg(String lcImg) {
        this.lcImg = lcImg;
    }

    @Override
    public String toString() {
        return "Lccp{" +
                "lcid=" + lcid +
                ", lcname='" + lcname + '\'' +
                ", lcv=" + lcv +
                ", lcTime='" + lcTime + '\'' +
                ", lcMoney=" + lcMoney +
                ", lcImg='" + lcImg + '\'' +
                '}';
    }
}
