package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 10:532018/1/8
 * @modify by :
 */
@Entity
@Table(name = "xt_zy_cz", schema = "xxxt", catalog = "")
public class Xt_zy_cz implements  java.io.Serializable{

    private static final long serialVersionUID = 1L;

    private String skey;
    private String parentkey;
    private String name;
    private String action;
    private String icon;
    private Integer seq;
    private String style;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "action")
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
    @Column(name = "seq")
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Xt_zy_cz xtZycz = (Xt_zy_cz) o;

        if (skey != null ? !skey.equals(xtZycz.skey) : xtZycz.skey != null) return false;
        if (parentkey != null ? !parentkey.equals(xtZycz.parentkey) : xtZycz.parentkey != null) return false;
        if (name != null ? !name.equals(xtZycz.name) : xtZycz.name != null) return false;
        if (action != null ? !action.equals(xtZycz.action) : xtZycz.action != null) return false;
        if (icon != null ? !icon.equals(xtZycz.icon) : xtZycz.icon != null) return false;
        if (seq != null ? !seq.equals(xtZycz.seq) : xtZycz.seq != null) return false;
        if (style != null ? !style.equals(xtZycz.style) : xtZycz.style != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (parentkey != null ? parentkey.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        return result;
    }
}
