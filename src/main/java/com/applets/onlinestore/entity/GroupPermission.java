package com.applets.onlinestore.entity;

import java.util.List;

/**
 * @author WHLiang
 * @date 2019/11/6 8:49
 */
public class GroupPermission {

    private String fid;
    private String rgroupid;
    private String rpermissionid;

    private List<Group> groups;
    private Permission permission;

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

    public String getRpermissionid() {
        return rpermissionid;
    }

    public void setRpermissionid(String rpermissionid) {
        this.rpermissionid = rpermissionid;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
