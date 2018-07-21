package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 23:142018/5/2
 * @modify by :
 */
@Entity
@Table(name = "park_cl", schema = "xxxt", catalog = "")
public class ParkCl {
    private String skey;
    private String paSkey;
    private String clSkey;
    private String tcKssj;
    private String tcJssj;
    private String tcZt;
    private String bz;
    private Integer paSf;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "pa_skey")
    public String getPaSkey() {
        return paSkey;
    }

    public void setPaSkey(String paSkey) {
        this.paSkey = paSkey;
    }

    @Basic
    @Column(name = "cl_skey")
    public String getClSkey() {
        return clSkey;
    }

    public void setClSkey(String clSkey) {
        this.clSkey = clSkey;
    }

    @Basic
    @Column(name = "tc_kssj")
    public String getTcKssj() {
        return tcKssj;
    }

    public void setTcKssj(String tcKssj) {
        this.tcKssj = tcKssj;
    }

    @Basic
    @Column(name = "tc_jssj")
    public String getTcJssj() {
        return tcJssj;
    }

    public void setTcJssj(String tcJssj) {
        this.tcJssj = tcJssj;
    }

    @Basic
    @Column(name = "tc_zt")
    public String getTcZt() {
        return tcZt;
    }

    public void setTcZt(String tcZt) {
        this.tcZt = tcZt;
    }

    @Basic
    @Column(name = "bz")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Basic
    @Column(name = "pa_sf")
    public Integer getPaSf() {
        return paSf;
    }

    public void setPaSf(Integer paSf) {
        this.paSf = paSf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkCl parkCl = (ParkCl) o;

        if (skey != null ? !skey.equals(parkCl.skey) : parkCl.skey != null) return false;
        if (paSkey != null ? !paSkey.equals(parkCl.paSkey) : parkCl.paSkey != null) return false;
        if (clSkey != null ? !clSkey.equals(parkCl.clSkey) : parkCl.clSkey != null) return false;
        if (tcKssj != null ? !tcKssj.equals(parkCl.tcKssj) : parkCl.tcKssj != null) return false;
        if (tcJssj != null ? !tcJssj.equals(parkCl.tcJssj) : parkCl.tcJssj != null) return false;
        if (tcZt != null ? !tcZt.equals(parkCl.tcZt) : parkCl.tcZt != null) return false;
        if (bz != null ? !bz.equals(parkCl.bz) : parkCl.bz != null) return false;
        if (paSf != null ? !paSf.equals(parkCl.paSf) : parkCl.paSf != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (paSkey != null ? paSkey.hashCode() : 0);
        result = 31 * result + (clSkey != null ? clSkey.hashCode() : 0);
        result = 31 * result + (tcKssj != null ? tcKssj.hashCode() : 0);
        result = 31 * result + (tcJssj != null ? tcJssj.hashCode() : 0);
        result = 31 * result + (tcZt != null ? tcZt.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        result = 31 * result + (paSf != null ? paSf.hashCode() : 0);
        return result;
    }
}
