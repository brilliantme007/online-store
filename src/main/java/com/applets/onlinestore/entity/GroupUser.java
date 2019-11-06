package com.applets.onlinestore.entity;

import java.util.List;

/**
 * @author WHLiang
 * @date 2019/11/6 8:49
 */
public class GroupUser {

    private String fid;
    private String rgroupid;
    private String ruserid;

    private Group group;

    private List<User> users;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getRgroupid() {
        return rgroupid;
    }

    public void setRgroupid(String rgroupid) {
        this.rgroupid = rgroupid;
    }

    public String getRuserid() {
        return ruserid;
    }

    public void setRuserid(String ruserid) {
        this.ruserid = ruserid;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
