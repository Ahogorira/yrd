package com.zking.model;

import java.io.Serializable;

/**
 * 借款分期类
 */
public class Jkfq implements Serializable {

    private static final long serialVersionUID = -4801323617106215820L;
    private Integer fqid;//分期id
    private Integer fqkx;//可选分期
    private Double fqlv;//分期利率

    public Integer getFqid() {
        return fqid;
    }

    public void setFqid(Integer fqid) {
        this.fqid = fqid;
    }

    public Integer getFqkx() {
        return fqkx;
    }

    public void setFqkx(Integer fqkx) {
        this.fqkx = fqkx;
    }

    public Double getFqlv() {
        return fqlv;
    }

    public void setFqlv(Double fqlv) {
        this.fqlv = fqlv;
    }

    @Override
    public String toString() {
        return "Jkfq{" +
                "fqid=" + fqid +
                ", fqkx=" + fqkx +
                ", fqlv=" + fqlv +
                '}';
    }
}
