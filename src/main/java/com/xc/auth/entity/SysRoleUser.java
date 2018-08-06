package com.xc.auth.entity;

public class SysRoleUser {
    private int id;
    private int sysUserId;
    private int roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}

