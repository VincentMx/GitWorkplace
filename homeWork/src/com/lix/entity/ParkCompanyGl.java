package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 1:032018/8/24
 * @modify by :
 */
@Entity
@Table(name = "park_company_gl", schema = "xxxt", catalog = "")
public class ParkCompanyGl {
    private String skey;
    private String pcskey;
    private String paskey;
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
    @Column(name = "pcskey")
    public String getPcskey() {
        return pcskey;
    }

    public void setPcskey(String pcskey) {
        this.pcskey = pcskey;
    }

    @Basic
    @Column(name = "paskey")
    public String getPaskey() {
        return paskey;
    }

    public void setPaskey(String paskey) {
        this.paskey = paskey;
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

        ParkCompanyGl that = (ParkCompanyGl) o;

        if (skey != null ? !skey.equals(that.skey) : that.skey != null) return false;
        if (pcskey != null ? !pcskey.equals(that.pcskey) : that.pcskey != null) return false;
        if (paskey != null ? !paskey.equals(that.paskey) : that.paskey != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (pcskey != null ? pcskey.hashCode() : 0);
        result = 31 * result + (paskey != null ? paskey.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }
}
