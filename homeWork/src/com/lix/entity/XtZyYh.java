package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 10:532018/1/8
 * @modify by :
 */
@Entity
@Table(name = "xt_zy_yh", schema = "xxxt", catalog = "")
public class XtZyYh implements java.io.Serializable{

    private static final long serialVersionUID = 1L;


    private String skey;
    private String resoucekey;
    private String roleKey;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "resoucekey")
    public String getResoucekey() {
        return resoucekey;
    }

    public void setResoucekey(String resoucekey) {
        this.resoucekey = resoucekey;
    }

    @Basic
    @Column(name = "role_key")
    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XtZyYh xtZyYh = (XtZyYh) o;

        if (skey != null ? !skey.equals(xtZyYh.skey) : xtZyYh.skey != null) return false;
        if (resoucekey != null ? !resoucekey.equals(xtZyYh.resoucekey) : xtZyYh.resoucekey != null) return false;
        if (roleKey != null ? !roleKey.equals(xtZyYh.roleKey) : xtZyYh.roleKey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (resoucekey != null ? resoucekey.hashCode() : 0);
        result = 31 * result + (roleKey != null ? roleKey.hashCode() : 0);
        return result;
    }
}
