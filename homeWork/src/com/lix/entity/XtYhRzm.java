package com.lix.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author : lix
 * @desc :
 * @time : 17:262018/8/30
 * @modify by :
 */
@Entity
@Table(name = "xt_yh_rzm", schema = "xxxt", catalog = "")
public class XtYhRzm {
    private String skey;
    private String yhskey;
    private String code;
    private String codetime;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "yhskey")
    public String getYhskey() {
        return yhskey;
    }

    public void setYhskey(String yhskey) {
        this.yhskey = yhskey;
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
    @Column(name = "codetime")
    public String getCodetime() {
        return codetime;
    }

    public void setCodetime(String codetime) {
        this.codetime = codetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XtYhRzm xtYhRzm = (XtYhRzm) o;

        if (skey != null ? !skey.equals(xtYhRzm.skey) : xtYhRzm.skey != null) return false;
        if (yhskey != null ? !yhskey.equals(xtYhRzm.yhskey) : xtYhRzm.yhskey != null) return false;
        if (code != null ? !code.equals(xtYhRzm.code) : xtYhRzm.code != null) return false;
        if (codetime != null ? !codetime.equals(xtYhRzm.codetime) : xtYhRzm.codetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (yhskey != null ? yhskey.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (codetime != null ? codetime.hashCode() : 0);
        return result;
    }
}
