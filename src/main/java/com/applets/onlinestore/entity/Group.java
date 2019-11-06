package com.applets.onlinestore.entity;

import java.util.List;

/**
 * @author WHLiang
 * @date 2019/11/6 8:34
 */
public class Group {

    private String fid;
    private String fgroupname;

    private List<GroupPermission> groupPermissions;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFgroupname() {
        return fgroupname;
    }

    public void setFgroupname(String fgroupname) {
        this.fgroupname = fgroupname;
    }

    public List<GroupPermission> getGroupPermissions() {
        return groupPermissions;
    }

    public void setGroupPermissions(List<GroupPermission> groupPermissions) {
        this.groupPermissions = groupPermissions;
    }
}
