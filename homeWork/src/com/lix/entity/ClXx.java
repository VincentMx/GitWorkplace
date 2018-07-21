package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 23:142018/5/2
 * @modify by :
 */
@Entity
@Table(name = "cl_xx", schema = "xxxt", catalog = "")
public class ClXx {
    private String skey;
    private String clCph;
    private String clYs;
    private String clPp;
    private String clLx;
    private String clLts;
    private String clCd;
    private String clKd;
    private String bz;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "cl_cph")
    public String getClCph() {
        return clCph;
    }

    public void setClCph(String clCph) {
        this.clCph = clCph;
    }

    @Basic
    @Column(name = "cl_ys")
    public String getClYs() {
        return clYs;
    }

    public void setClYs(String clYs) {
        this.clYs = clYs;
    }

    @Basic
    @Column(name = "cl_pp")
    public String getClPp() {
        return clPp;
    }

    public void setClPp(String clPp) {
        this.clPp = clPp;
    }

    @Basic
    @Column(name = "cl_lx")
    public String getClLx() {
        return clLx;
    }

    public void setClLx(String clLx) {
        this.clLx = clLx;
    }

    @Basic
    @Column(name = "cl_lts")
    public String getClLts() {
        return clLts;
    }

    public void setClLts(String clLts) {
        this.clLts = clLts;
    }

    @Basic
    @Column(name = "cl_cd")
    public String getClCd() {
        return clCd;
    }

    public void setClCd(String clCd) {
        this.clCd = clCd;
    }

    @Basic
    @Column(name = "cl_kd")
    public String getClKd() {
        return clKd;
    }

    public void setClKd(String clKd) {
        this.clKd = clKd;
    }

    @Basic
    @Column(name = "bz")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClXx clXx = (ClXx) o;

        if (skey != null ? !skey.equals(clXx.skey) : clXx.skey != null) return false;
        if (clCph != null ? !clCph.equals(clXx.clCph) : clXx.clCph != null) return false;
        if (clYs != null ? !clYs.equals(clXx.clYs) : clXx.clYs != null) return false;
        if (clPp != null ? !clPp.equals(clXx.clPp) : clXx.clPp != null) return false;
        if (clLx != null ? !clLx.equals(clXx.clLx) : clXx.clLx != null) return false;
        if (clLts != null ? !clLts.equals(clXx.clLts) : clXx.clLts != null) return false;
        if (clCd != null ? !clCd.equals(clXx.clCd) : clXx.clCd != null) return false;
        if (clKd != null ? !clKd.equals(clXx.clKd) : clXx.clKd != null) return false;
        if (bz != null ? !bz.equals(clXx.bz) : clXx.bz != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (clCph != null ? clCph.hashCode() : 0);
        result = 31 * result + (clYs != null ? clYs.hashCode() : 0);
        result = 31 * result + (clPp != null ? clPp.hashCode() : 0);
        result = 31 * result + (clLx != null ? clLx.hashCode() : 0);
        result = 31 * result + (clLts != null ? clLts.hashCode() : 0);
        result = 31 * result + (clCd != null ? clCd.hashCode() : 0);
        result = 31 * result + (clKd != null ? clKd.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        return result;
    }
}
