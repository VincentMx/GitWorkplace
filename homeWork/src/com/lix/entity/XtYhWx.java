package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 23:572018/9/6
 * @modify by :
 */
@Entity
@Table(name = "xt_yh_wx", schema = "xxxt", catalog = "")
public class XtYhWx {
    private String skey;
    private String openid;
    private String yhskey;
    private String yhmobile;
    private String bz1;
    private String bz2;
    private String bz3;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "openid")
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Basic
    @Column(name = "yhskey")
    public String getYhskey() {
        return yhskey;
    }

    public void setYhskey(String yhskey) {
        this.yhskey = yhskey;
    }

    @Basic
    @Column(name = "yhmobile")
    public String getYhmobile() {
        return yhmobile;
    }

    public void setYhmobile(String yhmobile) {
        this.yhmobile = yhmobile;
    }

    @Basic
    @Column(name = "bz1")
    public String getBz1() {
        return bz1;
    }

    public void setBz1(String bz1) {
        this.bz1 = bz1;
    }

    @Basic
    @Column(name = "bz2")
    public String getBz2() {
        return bz2;
    }

    public void setBz2(String bz2) {
        this.bz2 = bz2;
    }

    @Basic
    @Column(name = "bz3")
    public String getBz3() {
        return bz3;
    }

    public void setBz3(String bz3) {
        this.bz3 = bz3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XtYhWx xtYhWx = (XtYhWx) o;

        if (skey != null ? !skey.equals(xtYhWx.skey) : xtYhWx.skey != null) return false;
        if (openid != null ? !openid.equals(xtYhWx.openid) : xtYhWx.openid != null) return false;
        if (yhskey != null ? !yhskey.equals(xtYhWx.yhskey) : xtYhWx.yhskey != null) return false;
        if (yhmobile != null ? !yhmobile.equals(xtYhWx.yhmobile) : xtYhWx.yhmobile != null) return false;
        if (bz1 != null ? !bz1.equals(xtYhWx.bz1) : xtYhWx.bz1 != null) return false;
        if (bz2 != null ? !bz2.equals(xtYhWx.bz2) : xtYhWx.bz2 != null) return false;
        if (bz3 != null ? !bz3.equals(xtYhWx.bz3) : xtYhWx.bz3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (openid != null ? openid.hashCode() : 0);
        result = 31 * result + (yhskey != null ? yhskey.hashCode() : 0);
        result = 31 * result + (yhmobile != null ? yhmobile.hashCode() : 0);
        result = 31 * result + (bz1 != null ? bz1.hashCode() : 0);
        result = 31 * result + (bz2 != null ? bz2.hashCode() : 0);
        result = 31 * result + (bz3 != null ? bz3.hashCode() : 0);
        return result;
    }
}
