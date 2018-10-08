package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 15:002018/9/27
 * @modify by :
 */
@Entity
@Table(name = "xt_gg", schema = "xxxt", catalog = "")
public class XtGg {
    private String skey;
    private String ggbt;
    private String ggnr;
    private String fbyh;
    private String fbsj;
    private String flag;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "ggbt")
    public String getGgbt() {
        return ggbt;
    }

    public void setGgbt(String ggbt) {
        this.ggbt = ggbt;
    }

    @Basic
    @Column(name = "ggnr")
    public String getGgnr() {
        return ggnr;
    }

    public void setGgnr(String ggnr) {
        this.ggnr = ggnr;
    }

    @Basic
    @Column(name = "fbyh")
    public String getFbyh() {
        return fbyh;
    }

    public void setFbyh(String fbyh) {
        this.fbyh = fbyh;
    }

    @Basic
    @Column(name = "fbsj")
    public String getFbsj() {
        return fbsj;
    }

    public void setFbsj(String fbsj) {
        this.fbsj = fbsj;
    }

    @Basic
    @Column(name = "flag")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XtGg xtGg = (XtGg) o;

        if (skey != null ? !skey.equals(xtGg.skey) : xtGg.skey != null) return false;
        if (ggbt != null ? !ggbt.equals(xtGg.ggbt) : xtGg.ggbt != null) return false;
        if (ggnr != null ? !ggnr.equals(xtGg.ggnr) : xtGg.ggnr != null) return false;
        if (fbyh != null ? !fbyh.equals(xtGg.fbyh) : xtGg.fbyh != null) return false;
        if (fbsj != null ? !fbsj.equals(xtGg.fbsj) : xtGg.fbsj != null) return false;
        if (flag != null ? !flag.equals(xtGg.flag) : xtGg.flag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (ggbt != null ? ggbt.hashCode() : 0);
        result = 31 * result + (ggnr != null ? ggnr.hashCode() : 0);
        result = 31 * result + (fbyh != null ? fbyh.hashCode() : 0);
        result = 31 * result + (fbsj != null ? fbsj.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }
}
