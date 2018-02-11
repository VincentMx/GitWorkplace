package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 10:532018/1/8
 * @modify by :
 */
@Entity
@Table(name = "xt_yh_js", schema = "xxxt", catalog = "")
public class XtYhJs implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    private String rolekey;
    private String userkey;
    private String skey;

    @Basic
    @Column(name = "rolekey")
    public String getRolekey() {
        return rolekey;
    }

    public void setRolekey(String rolekey) {
        this.rolekey = rolekey;
    }

    @Basic
    @Column(name = "userkey")
    public String getUserkey() {
        return userkey;
    }

    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XtYhJs xtYhJs = (XtYhJs) o;

        if (rolekey != null ? !rolekey.equals(xtYhJs.rolekey) : xtYhJs.rolekey != null) return false;
        if (userkey != null ? !userkey.equals(xtYhJs.userkey) : xtYhJs.userkey != null) return false;
        if (skey != null ? !skey.equals(xtYhJs.skey) : xtYhJs.skey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rolekey != null ? rolekey.hashCode() : 0;
        result = 31 * result + (userkey != null ? userkey.hashCode() : 0);
        result = 31 * result + (skey != null ? skey.hashCode() : 0);
        return result;
    }
}
