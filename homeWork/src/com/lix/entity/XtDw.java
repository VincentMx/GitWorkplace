package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 10:532018/1/8
 * @modify by :
 */
@Entity
@Table(name = "xt_dw", schema = "xxxt", catalog = "")
public class XtDw implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    private String shortname;
    private String parentkey;
    private String yxzt;
    private String unitlevel;
    private String yxdate;
    private Integer seq;
    private String skey;

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "shortname")
    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Basic
    @Column(name = "parentkey")
    public String getParentkey() {
        return parentkey;
    }

    public void setParentkey(String parentkey) {
        this.parentkey = parentkey;
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
    @Column(name = "unitlevel")
    public String getUnitlevel() {
        return unitlevel;
    }

    public void setUnitlevel(String unitlevel) {
        this.unitlevel = unitlevel;
    }

    @Basic
    @Column(name = "yxdate")
    public String getYxdate() {
        return yxdate;
    }

    public void setYxdate(String yxdate) {
        this.yxdate = yxdate;
    }

    @Basic
    @Column(name = "seq")
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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

        XtDw xtDw = (XtDw) o;

        if (code != null ? !code.equals(xtDw.code) : xtDw.code != null) return false;
        if (name != null ? !name.equals(xtDw.name) : xtDw.name != null) return false;
        if (shortname != null ? !shortname.equals(xtDw.shortname) : xtDw.shortname != null) return false;
        if (parentkey != null ? !parentkey.equals(xtDw.parentkey) : xtDw.parentkey != null) return false;
        if (yxzt != null ? !yxzt.equals(xtDw.yxzt) : xtDw.yxzt != null) return false;
        if (unitlevel != null ? !unitlevel.equals(xtDw.unitlevel) : xtDw.unitlevel != null) return false;
        if (yxdate != null ? !yxdate.equals(xtDw.yxdate) : xtDw.yxdate != null) return false;
        if (seq != null ? !seq.equals(xtDw.seq) : xtDw.seq != null) return false;
        if (skey != null ? !skey.equals(xtDw.skey) : xtDw.skey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortname != null ? shortname.hashCode() : 0);
        result = 31 * result + (parentkey != null ? parentkey.hashCode() : 0);
        result = 31 * result + (yxzt != null ? yxzt.hashCode() : 0);
        result = 31 * result + (unitlevel != null ? unitlevel.hashCode() : 0);
        result = 31 * result + (yxdate != null ? yxdate.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        result = 31 * result + (skey != null ? skey.hashCode() : 0);
        return result;
    }
}
