package com.applets.onlinestore.entity;

import java.util.List;

/**
 * @author WHLiang
 * @date 2019/11/5 10:30
 */
public class User {

    private String fid;
    private String floginname;
    private String fpassword;
    private List<GroupUser> groupUser;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFloginname() {
        return floginname;
    }

    public void setFloginname(String floginname) {
        this.floginname = floginname;
    }

    public String getFpassword() {
        return fpassword;
    }

    public void setFpassword(String fpassword) {
        this.fpassword = fpassword;
    }

    public List<GroupUser> getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(List<GroupUser> groupUser) {
        this.groupUser = groupUser;
    }
}
