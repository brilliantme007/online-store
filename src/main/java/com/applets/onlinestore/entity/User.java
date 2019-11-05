package com.applets.onlinestore.entity;

/**
 * @author WHLiang
 * @date 2019/11/5 10:30
 */
public class User {

    private String fid;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "Test{" +
                "fid='" + fid + '\'' +
                '}';
    }
}
