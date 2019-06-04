package com.zking.model;

import java.io.Serializable;

public class Bank implements Serializable {
    private static final long serialVersionUID = -7991609156262839158L;
    private Integer bid;
    private Integer uid;
    private String bname;
    private String bcardid;
    private String bankname;
    private String bphone;
    private Integer mrxz;
    private String banktype;
    private String bankno;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBcardid() {
        return bcardid;
    }

    public void setBcardid(String bcardid) {
        this.bcardid = bcardid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBphone() {
        return bphone;
    }

    public void setBphone(String bphone) {
        this.bphone = bphone;
    }

    public Integer getMrxz() {
        return mrxz;
    }

    public void setMrxz(Integer mrxz) {
        this.mrxz = mrxz;
    }

    public String getBanktype() {
        return banktype;
    }

    public void setBanktype(String banktype) {
        this.banktype = banktype;
    }

    public String getBankno() {
        return bankno;
    }

    public void setBankno(String bankno) {
        this.bankno = bankno;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bid=" + bid +
                ", uid=" + uid +
                ", bname='" + bname + '\'' +
                ", bcardid='" + bcardid + '\'' +
                ", bankname='" + bankname + '\'' +
                ", bphone='" + bphone + '\'' +
                ", mrxz=" + mrxz +
                ", banktype='" + banktype + '\'' +
                ", bankno='" + bankno + '\'' +
                '}';
    }
}
