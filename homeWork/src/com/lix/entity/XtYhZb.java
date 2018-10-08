package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 14:552018/10/3
 * @modify by :
 */
@Entity
@Table(name = "xt_yh_zb", schema = "xxxt", catalog = "")
public class XtYhZb {
    private String skey;
    private String yhskey;
    private Double xfje;
    private String xfdd;
    private String xfsj;

    @Basic
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Id
    @Column(name = "yhskey")
    public String getYhskey() {
        return yhskey;
    }

    public void setYhskey(String yhskey) {
        this.yhskey = yhskey;
    }

    @Basic
    @Column(name = "xfje")
    public Double getXfje() {
        return xfje;
    }

    public void setXfje(Double xfje) {
        this.xfje = xfje;
    }

    @Basic
    @Column(name = "xfdd")
    public String getXfdd() {
        return xfdd;
    }

    public void setXfdd(String xfdd) {
        this.xfdd = xfdd;
    }

    @Basic
    @Column(name = "xfsj")
    public String getXfsj() {
        return xfsj;
    }

    public void setXfsj(String xfsj) {
        this.xfsj = xfsj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XtYhZb xtYhZb = (XtYhZb) o;

        if (skey != null ? !skey.equals(xtYhZb.skey) : xtYhZb.skey != null) return false;
        if (yhskey != null ? !yhskey.equals(xtYhZb.yhskey) : xtYhZb.yhskey != null) return false;
        if (xfje != null ? !xfje.equals(xtYhZb.xfje) : xtYhZb.xfje != null) return false;
        if (xfdd != null ? !xfdd.equals(xtYhZb.xfdd) : xtYhZb.xfdd != null) return false;
        if (xfsj != null ? !xfsj.equals(xtYhZb.xfsj) : xtYhZb.xfsj != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (yhskey != null ? yhskey.hashCode() : 0);
        result = 31 * result + (xfje != null ? xfje.hashCode() : 0);
        result = 31 * result + (xfdd != null ? xfdd.hashCode() : 0);
        result = 31 * result + (xfsj != null ? xfsj.hashCode() : 0);
        return result;
    }
}
