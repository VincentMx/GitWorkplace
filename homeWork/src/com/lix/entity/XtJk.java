package com.lix.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author : lix
 * @desc :
 * @time : 16:452018/9/19
 * @modify by :
 */
@Entity
@Table(name = "xt_jk", schema = "xxxt", catalog = "")
public class XtJk {
    private String skey;
    private String jkdz;
    private String jktgf;
    private String jkms;
    private String jkjym;
    private String jkyxbs;
    private Date jkqysj;
    private String jklb;
    private Date czsj;
    private String czry;
    private String czryunit;
    private String qqmb;
    private String ydmb;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "jkdz")
    public String getJkdz() {
        return jkdz;
    }

    public void setJkdz(String jkdz) {
        this.jkdz = jkdz;
    }

    @Basic
    @Column(name = "jktgf")
    public String getJktgf() {
        return jktgf;
    }

    public void setJktgf(String jktgf) {
        this.jktgf = jktgf;
    }

    @Basic
    @Column(name = "jkms")
    public String getJkms() {
        return jkms;
    }

    public void setJkms(String jkms) {
        this.jkms = jkms;
    }

    @Basic
    @Column(name = "jkjym")
    public String getJkjym() {
        return jkjym;
    }

    public void setJkjym(String jkjym) {
        this.jkjym = jkjym;
    }

    @Basic
    @Column(name = "jkyxbs")
    public String getJkyxbs() {
        return jkyxbs;
    }

    public void setJkyxbs(String jkyxbs) {
        this.jkyxbs = jkyxbs;
    }

    @Basic
    @Column(name = "jkqysj")
    public Date getJkqysj() {
        return jkqysj;
    }

    public void setJkqysj(Date jkqysj) {
        this.jkqysj = jkqysj;
    }

    @Basic
    @Column(name = "jklb")
    public String getJklb() {
        return jklb;
    }

    public void setJklb(String jklb) {
        this.jklb = jklb;
    }

    @Basic
    @Column(name = "czsj")
    public Date getCzsj() {
        return czsj;
    }

    public void setCzsj(Date czsj) {
        this.czsj = czsj;
    }

    @Basic
    @Column(name = "czry")
    public String getCzry() {
        return czry;
    }

    public void setCzry(String czry) {
        this.czry = czry;
    }

    @Basic
    @Column(name = "czryunit")
    public String getCzryunit() {
        return czryunit;
    }

    public void setCzryunit(String czryunit) {
        this.czryunit = czryunit;
    }

    @Basic
    @Column(name = "qqmb")
    public String getQqmb() {
        return qqmb;
    }

    public void setQqmb(String qqmb) {
        this.qqmb = qqmb;
    }

    @Basic
    @Column(name = "ydmb")
    public String getYdmb() {
        return ydmb;
    }

    public void setYdmb(String ydmb) {
        this.ydmb = ydmb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XtJk xtJk = (XtJk) o;

        if (skey != null ? !skey.equals(xtJk.skey) : xtJk.skey != null) return false;
        if (jkdz != null ? !jkdz.equals(xtJk.jkdz) : xtJk.jkdz != null) return false;
        if (jktgf != null ? !jktgf.equals(xtJk.jktgf) : xtJk.jktgf != null) return false;
        if (jkms != null ? !jkms.equals(xtJk.jkms) : xtJk.jkms != null) return false;
        if (jkjym != null ? !jkjym.equals(xtJk.jkjym) : xtJk.jkjym != null) return false;
        if (jkyxbs != null ? !jkyxbs.equals(xtJk.jkyxbs) : xtJk.jkyxbs != null) return false;
        if (jkqysj != null ? !jkqysj.equals(xtJk.jkqysj) : xtJk.jkqysj != null) return false;
        if (jklb != null ? !jklb.equals(xtJk.jklb) : xtJk.jklb != null) return false;
        if (czsj != null ? !czsj.equals(xtJk.czsj) : xtJk.czsj != null) return false;
        if (czry != null ? !czry.equals(xtJk.czry) : xtJk.czry != null) return false;
        if (czryunit != null ? !czryunit.equals(xtJk.czryunit) : xtJk.czryunit != null) return false;
        if (qqmb != null ? !qqmb.equals(xtJk.qqmb) : xtJk.qqmb != null) return false;
        if (ydmb != null ? !ydmb.equals(xtJk.ydmb) : xtJk.ydmb != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (jkdz != null ? jkdz.hashCode() : 0);
        result = 31 * result + (jktgf != null ? jktgf.hashCode() : 0);
        result = 31 * result + (jkms != null ? jkms.hashCode() : 0);
        result = 31 * result + (jkjym != null ? jkjym.hashCode() : 0);
        result = 31 * result + (jkyxbs != null ? jkyxbs.hashCode() : 0);
        result = 31 * result + (jkqysj != null ? jkqysj.hashCode() : 0);
        result = 31 * result + (jklb != null ? jklb.hashCode() : 0);
        result = 31 * result + (czsj != null ? czsj.hashCode() : 0);
        result = 31 * result + (czry != null ? czry.hashCode() : 0);
        result = 31 * result + (czryunit != null ? czryunit.hashCode() : 0);
        result = 31 * result + (qqmb != null ? qqmb.hashCode() : 0);
        result = 31 * result + (ydmb != null ? ydmb.hashCode() : 0);
        return result;
    }
}
