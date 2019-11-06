package com.applets.onlinestore.entity;

/**
 * @author WHLiang
 * @date 2019/11/6 8:35
 */
public class Permission {

    private String  fid;
    private String fname;
    private String furl;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFurl() {
        return furl;
    }

    public void setFurl(String furl) {
        this.furl = furl;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "fid='" + fid + '\'' +
                ", fname='" + fname + '\'' +
                ", furl='" + furl + '\'' +
                '}';
    }
}
