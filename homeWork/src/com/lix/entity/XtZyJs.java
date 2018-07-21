package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 17:422018/3/8
 * @modify by :
 */
@Entity
@Table(name = "xt_zy_js", schema = "xxxt", catalog = "")
public class XtZyJs {
    private String jsskey;
    private String zyskey;
    private String srdKey;
    private String skey;

    @Basic
    @Column(name = "jsskey")
    public String getJsskey() {
        return jsskey;
    }

    public void setJsskey(String jsskey) {
        this.jsskey = jsskey;
    }

    @Basic
    @Column(name = "zyskey")
    public String getZyskey() {
        return zyskey;
    }

    public void setZyskey(String zyskey) {
        this.zyskey = zyskey;
    }

    @Basic
    @Column(name = "srd_key")
    public String getSrdKey() {
        return srdKey;
    }

    public void setSrdKey(String srdKey) {
        this.srdKey = srdKey;
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

        XtZyJs xtZyJs = (XtZyJs) o;

        if (jsskey != null ? !jsskey.equals(xtZyJs.jsskey) : xtZyJs.jsskey != null) return false;
        if (zyskey != null ? !zyskey.equals(xtZyJs.zyskey) : xtZyJs.zyskey != null) return false;
        if (srdKey != null ? !srdKey.equals(xtZyJs.srdKey) : xtZyJs.srdKey != null) return false;
        if (skey != null ? !skey.equals(xtZyJs.skey) : xtZyJs.skey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jsskey != null ? jsskey.hashCode() : 0;
        result = 31 * result + (zyskey != null ? zyskey.hashCode() : 0);
        result = 31 * result + (srdKey != null ? srdKey.hashCode() : 0);
        result = 31 * result + (skey != null ? skey.hashCode() : 0);
        return result;
    }
}
