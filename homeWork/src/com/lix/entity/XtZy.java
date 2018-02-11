package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 10:532018/1/8
 * @modify by :
 */
@Entity
@Table(name = "xt_zy", schema = "xxxt", catalog = "")
public class XtZy implements java.io.Serializable {


    private static final long serialVersionUID = 1L;

    private String parentkey;
    private String name;
    private String icon;
    private String url;
    private String isparent;
    private Integer seq;
    private String file1;
    private String skey;

    @Basic
    @Column(name = "parentkey")
    public String getParentkey() {
        return parentkey;
    }

    public void setParentkey(String parentkey) {
        this.parentkey = parentkey;
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
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "isparent")
    public String getIsparent() {
        return isparent;
    }

    public void setIsparent(String isparent) {
        this.isparent = isparent;
    }

    @Basic
    @Column(name = "seq")
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "file1")
    public String getFile1() {
        return file1;
    }

    public void setFile1(String file1) {
        this.file1 = file1;
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

        XtZy xtZy = (XtZy) o;

        if (parentkey != null ? !parentkey.equals(xtZy.parentkey) : xtZy.parentkey != null) return false;
        if (name != null ? !name.equals(xtZy.name) : xtZy.name != null) return false;
        if (icon != null ? !icon.equals(xtZy.icon) : xtZy.icon != null) return false;
        if (url != null ? !url.equals(xtZy.url) : xtZy.url != null) return false;
        if (isparent != null ? !isparent.equals(xtZy.isparent) : xtZy.isparent != null) return false;
        if (seq != null ? !seq.equals(xtZy.seq) : xtZy.seq != null) return false;
        if (file1 != null ? !file1.equals(xtZy.file1) : xtZy.file1 != null) return false;
        if (skey != null ? !skey.equals(xtZy.skey) : xtZy.skey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = parentkey != null ? parentkey.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (isparent != null ? isparent.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        result = 31 * result + (file1 != null ? file1.hashCode() : 0);
        result = 31 * result + (skey != null ? skey.hashCode() : 0);
        return result;
    }
}
