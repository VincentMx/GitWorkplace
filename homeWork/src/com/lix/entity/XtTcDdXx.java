package com.lix.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author : lix
 * @desc :
 * @time : 14:152018/9/20
 * @modify by :
 */
@Entity
@Table(name = "xt_tc_dd_xx", schema = "xxxt", catalog = "")
public class XtTcDdXx {
    private String orderNo;
    private String jfHh;
    private String jfShbh;
    private String ddzt;
    private Date cssj;
    private Double ddje;
    private Double ddzfje;
    private String bz;
    private String zddbh;
    private String jylsh;
    private String zfqd;
    private String bz2;
    private String jfrbh;

    @Id
    @Column(name = "orderNo")
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Basic
    @Column(name = "jf_hh")
    public String getJfHh() {
        return jfHh;
    }

    public void setJfHh(String jfHh) {
        this.jfHh = jfHh;
    }

    @Basic
    @Column(name = "jf_shbh")
    public String getJfShbh() {
        return jfShbh;
    }

    public void setJfShbh(String jfShbh) {
        this.jfShbh = jfShbh;
    }

    @Basic
    @Column(name = "ddzt")
    public String getDdzt() {
        return ddzt;
    }

    public void setDdzt(String ddzt) {
        this.ddzt = ddzt;
    }

    @Basic
    @Column(name = "cssj")
    public Date getCssj() {
        return cssj;
    }

    public void setCssj(Date cssj) {
        this.cssj = cssj;
    }

    @Basic
    @Column(name = "ddje")
    public Double getDdje() {
        return ddje;
    }

    public void setDdje(Double ddje) {
        this.ddje = ddje;
    }

    @Basic
    @Column(name = "ddzfje")
    public Double getDdzfje() {
        return ddzfje;
    }

    public void setDdzfje(Double ddzfje) {
        this.ddzfje = ddzfje;
    }

    @Basic
    @Column(name = "bz")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Basic
    @Column(name = "zddbh")
    public String getZddbh() {
        return zddbh;
    }

    public void setZddbh(String zddbh) {
        this.zddbh = zddbh;
    }

    @Basic
    @Column(name = "jylsh")
    public String getJylsh() {
        return jylsh;
    }

    public void setJylsh(String jylsh) {
        this.jylsh = jylsh;
    }

    @Basic
    @Column(name = "zfqd")
    public String getZfqd() {
        return zfqd;
    }

    public void setZfqd(String zfqd) {
        this.zfqd = zfqd;
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
    @Column(name = "jfrbh")
    public String getJfrbh() {
        return jfrbh;
    }

    public void setJfrbh(String jfrbh) {
        this.jfrbh = jfrbh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XtTcDdXx xtTcDdXx = (XtTcDdXx) o;

        if (orderNo != null ? !orderNo.equals(xtTcDdXx.orderNo) : xtTcDdXx.orderNo != null) return false;
        if (jfHh != null ? !jfHh.equals(xtTcDdXx.jfHh) : xtTcDdXx.jfHh != null) return false;
        if (jfShbh != null ? !jfShbh.equals(xtTcDdXx.jfShbh) : xtTcDdXx.jfShbh != null) return false;
        if (ddzt != null ? !ddzt.equals(xtTcDdXx.ddzt) : xtTcDdXx.ddzt != null) return false;
        if (cssj != null ? !cssj.equals(xtTcDdXx.cssj) : xtTcDdXx.cssj != null) return false;
        if (ddje != null ? !ddje.equals(xtTcDdXx.ddje) : xtTcDdXx.ddje != null) return false;
        if (ddzfje != null ? !ddzfje.equals(xtTcDdXx.ddzfje) : xtTcDdXx.ddzfje != null) return false;
        if (bz != null ? !bz.equals(xtTcDdXx.bz) : xtTcDdXx.bz != null) return false;
        if (zddbh != null ? !zddbh.equals(xtTcDdXx.zddbh) : xtTcDdXx.zddbh != null) return false;
        if (jylsh != null ? !jylsh.equals(xtTcDdXx.jylsh) : xtTcDdXx.jylsh != null) return false;
        if (zfqd != null ? !zfqd.equals(xtTcDdXx.zfqd) : xtTcDdXx.zfqd != null) return false;
        if (bz2 != null ? !bz2.equals(xtTcDdXx.bz2) : xtTcDdXx.bz2 != null) return false;
        if (jfrbh != null ? !jfrbh.equals(xtTcDdXx.jfrbh) : xtTcDdXx.jfrbh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderNo != null ? orderNo.hashCode() : 0;
        result = 31 * result + (jfHh != null ? jfHh.hashCode() : 0);
        result = 31 * result + (jfShbh != null ? jfShbh.hashCode() : 0);
        result = 31 * result + (ddzt != null ? ddzt.hashCode() : 0);
        result = 31 * result + (cssj != null ? cssj.hashCode() : 0);
        result = 31 * result + (ddje != null ? ddje.hashCode() : 0);
        result = 31 * result + (ddzfje != null ? ddzfje.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        result = 31 * result + (zddbh != null ? zddbh.hashCode() : 0);
        result = 31 * result + (jylsh != null ? jylsh.hashCode() : 0);
        result = 31 * result + (zfqd != null ? zfqd.hashCode() : 0);
        result = 31 * result + (bz2 != null ? bz2.hashCode() : 0);
        result = 31 * result + (jfrbh != null ? jfrbh.hashCode() : 0);
        return result;
    }
}
