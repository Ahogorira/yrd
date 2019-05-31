package com.zking.model;

import java.io.Serializable;

public class permission implements Serializable{

    private static final long serialVersionUID = 4899965418366540979L;
    private Integer pid;
    private String pname;
    private String url;
    private String codes;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    @Override
    public String toString() {
        return "permission{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", url='" + url + '\'' +
                ", codes='" + codes + '\'' +
                '}';
    }
}
