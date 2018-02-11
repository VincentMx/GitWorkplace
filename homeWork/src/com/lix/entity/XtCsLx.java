package com.lix.entity;

import javax.persistence.*;


/**
 * @author : lix
 * @desc :
 * @time : 10:532018/1/8
 * @modify by :
 */
@Entity
@Table(name = "xt_cs_lx", schema = "xxxt")
public class XtCsLx implements java.io.Serializable{


    private static final long serialVersionUID = 1L;


    private String name;
    private String code;
    private String yxzt;
    private String descr;
    private String skey;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "yxzt")
    public String getYxzt() {
        return yxzt;
    }

    public void setYxzt(String yxzt) {
        this.yxzt = yxzt;
    }

    @Basic
    @Column(name = "descr")
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
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

        XtCsLx xtCsLx = (XtCsLx) o;

        if (name != null ? !name.equals(xtCsLx.name) : xtCsLx.name != null) return false;
        if (code != null ? !code.equals(xtCsLx.code) : xtCsLx.code != null) return false;
        if (yxzt != null ? !yxzt.equals(xtCsLx.yxzt) : xtCsLx.yxzt != null) return false;
        if (descr != null ? !descr.equals(xtCsLx.descr) : xtCsLx.descr != null) return false;
        if (skey != null ? !skey.equals(xtCsLx.skey) : xtCsLx.skey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (yxzt != null ? yxzt.hashCode() : 0);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        result = 31 * result + (skey != null ? skey.hashCode() : 0);
        return result;
    }
}
