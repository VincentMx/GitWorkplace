package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 10:532018/1/8
 * @modify by :
 */
@Entity
@Table(name = "xt_js", schema = "xxxt", catalog = "")
public class Xt_js implements  java.io.Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private String flag;
    private String desc;
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
    @Column(name = "flag")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

        Xt_js xtJs = (Xt_js) o;

        if (name != null ? !name.equals(xtJs.name) : xtJs.name != null) return false;
        if (flag != null ? !flag.equals(xtJs.flag) : xtJs.flag != null) return false;
        if (desc != null ? !desc.equals(xtJs.desc) : xtJs.desc != null) return false;
        if (skey != null ? !skey.equals(xtJs.skey) : xtJs.skey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (skey != null ? skey.hashCode() : 0);
        return result;
    }
}
