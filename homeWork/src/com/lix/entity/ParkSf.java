package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 19:132018/6/26
 * @modify by :
 */
@Entity
@Table(name = "park_sf", schema = "xxxt", catalog = "")
public class ParkSf {
    private String skey;
    private String paKssj;
    private String paJssj;
    private String paSfbz;
    private String bz;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "pa_kssj")
    public String getPaKssj() {
        return paKssj;
    }

    public void setPaKssj(String paKssj) {
        this.paKssj = paKssj;
    }

    @Basic
    @Column(name = "pa_jssj")
    public String getPaJssj() {
        return paJssj;
    }

    public void setPaJssj(String paJssj) {
        this.paJssj = paJssj;
    }

    @Basic
    @Column(name = "pa_sfbz")
    public String getPaSfbz() {
        return paSfbz;
    }

    public void setPaSfbz(String paSfbz) {
        this.paSfbz = paSfbz;
    }

    @Basic
    @Column(name = "bz")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkSf parkSf = (ParkSf) o;

        if (skey != null ? !skey.equals(parkSf.skey) : parkSf.skey != null) return false;
        if (paKssj != null ? !paKssj.equals(parkSf.paKssj) : parkSf.paKssj != null) return false;
        if (paJssj != null ? !paJssj.equals(parkSf.paJssj) : parkSf.paJssj != null) return false;
        if (paSfbz != null ? !paSfbz.equals(parkSf.paSfbz) : parkSf.paSfbz != null) return false;
        if (bz != null ? !bz.equals(parkSf.bz) : parkSf.bz != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (paKssj != null ? paKssj.hashCode() : 0);
        result = 31 * result + (paJssj != null ? paJssj.hashCode() : 0);
        result = 31 * result + (paSfbz != null ? paSfbz.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        return result;
    }
}
