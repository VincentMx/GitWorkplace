package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 10:532018/1/8
 * @modify by :
 */
@Entity
@Table(name = "xt_cs", schema = "xxxt", catalog = "")
public class XtCs implements java.io.Serializable{


    private static final long serialVersionUID = 1L;

    private String name;
    private String typecode;
    private String creattime;
    private String value;
    private String seq;
    private String filed1;
    private String filed2;
    private String filed3;
    private String filed4;
    private String yxzt;
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
    @Column(name = "typecode")
    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    @Basic
    @Column(name = "creattime")
    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "seq")
    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    @Basic
    @Column(name = "filed_1")
    public String getFiled1() {
        return filed1;
    }

    public void setFiled1(String filed1) {
        this.filed1 = filed1;
    }

    @Basic
    @Column(name = "filed_2")
    public String getFiled2() {
        return filed2;
    }

    public void setFiled2(String filed2) {
        this.filed2 = filed2;
    }

    @Basic
    @Column(name = "filed_3")
    public String getFiled3() {
        return filed3;
    }

    public void setFiled3(String filed3) {
        this.filed3 = filed3;
    }

    @Basic
    @Column(name = "filed_4")
    public String getFiled4() {
        return filed4;
    }

    public void setFiled4(String filed4) {
        this.filed4 = filed4;
    }

    @Basic
    @Column(name = "yxzt")
    public String getYxzt() {
        return yxzt;
    }

    public void setYxzt(String yxzt) {
        this.yxzt = yxzt;
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

        XtCs xtCs = (XtCs) o;

        if (name != null ? !name.equals(xtCs.name) : xtCs.name != null) return false;
        if (typecode != null ? !typecode.equals(xtCs.typecode) : xtCs.typecode != null) return false;
        if (creattime != null ? !creattime.equals(xtCs.creattime) : xtCs.creattime != null) return false;
        if (value != null ? !value.equals(xtCs.value) : xtCs.value != null) return false;
        if (seq != null ? !seq.equals(xtCs.seq) : xtCs.seq != null) return false;
        if (filed1 != null ? !filed1.equals(xtCs.filed1) : xtCs.filed1 != null) return false;
        if (filed2 != null ? !filed2.equals(xtCs.filed2) : xtCs.filed2 != null) return false;
        if (filed3 != null ? !filed3.equals(xtCs.filed3) : xtCs.filed3 != null) return false;
        if (filed4 != null ? !filed4.equals(xtCs.filed4) : xtCs.filed4 != null) return false;
        if (yxzt != null ? !yxzt.equals(xtCs.yxzt) : xtCs.yxzt != null) return false;
        if (skey != null ? !skey.equals(xtCs.skey) : xtCs.skey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (typecode != null ? typecode.hashCode() : 0);
        result = 31 * result + (creattime != null ? creattime.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (seq != null ? seq.hashCode() : 0);
        result = 31 * result + (filed1 != null ? filed1.hashCode() : 0);
        result = 31 * result + (filed2 != null ? filed2.hashCode() : 0);
        result = 31 * result + (filed3 != null ? filed3.hashCode() : 0);
        result = 31 * result + (filed4 != null ? filed4.hashCode() : 0);
        result = 31 * result + (yxzt != null ? yxzt.hashCode() : 0);
        result = 31 * result + (skey != null ? skey.hashCode() : 0);
        return result;
    }
}
