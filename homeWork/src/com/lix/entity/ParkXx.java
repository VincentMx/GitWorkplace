package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 23:142018/5/2
 * @modify by :
 */
@Entity
@Table(name = "park_xx", schema = "xxxt", catalog = "")
public class ParkXx {
    private String skey;
    private String bdjd;
    private String bdwd;
    private String paCd;
    private String paKd;
    private String paMc;
    private String paFlag;
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
    @Column(name = "bdjd")
    public String getBdjd() {
        return bdjd;
    }

    public void setBdjd(String bdjd) {
        this.bdjd = bdjd;
    }

    @Basic
    @Column(name = "bdwd")
    public String getBdwd() {
        return bdwd;
    }

    public void setBdwd(String bdwd) {
        this.bdwd = bdwd;
    }

    @Basic
    @Column(name = "pa_cd")
    public String getPaCd() {
        return paCd;
    }

    public void setPaCd(String paCd) {
        this.paCd = paCd;
    }

    @Basic
    @Column(name = "pa_kd")
    public String getPaKd() {
        return paKd;
    }

    public void setPaKd(String paKd) {
        this.paKd = paKd;
    }

    @Basic
    @Column(name = "pa_mc")
    public String getPaMc() {
        return paMc;
    }

    public void setPaMc(String paMc) {
        this.paMc = paMc;
    }

    @Basic
    @Column(name = "pa_flag")
    public String getPaFlag() {
        return paFlag;
    }

    public void setPaFlag(String paFlag) {
        this.paFlag = paFlag;
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

        ParkXx parkXx = (ParkXx) o;

        if (skey != null ? !skey.equals(parkXx.skey) : parkXx.skey != null) return false;
        if (bdjd != null ? !bdjd.equals(parkXx.bdjd) : parkXx.bdjd != null) return false;
        if (bdwd != null ? !bdwd.equals(parkXx.bdwd) : parkXx.bdwd != null) return false;
        if (paCd != null ? !paCd.equals(parkXx.paCd) : parkXx.paCd != null) return false;
        if (paKd != null ? !paKd.equals(parkXx.paKd) : parkXx.paKd != null) return false;
        if (paMc != null ? !paMc.equals(parkXx.paMc) : parkXx.paMc != null) return false;
        if (paFlag != null ? !paFlag.equals(parkXx.paFlag) : parkXx.paFlag != null) return false;
        if (bz != null ? !bz.equals(parkXx.bz) : parkXx.bz != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (bdjd != null ? bdjd.hashCode() : 0);
        result = 31 * result + (bdwd != null ? bdwd.hashCode() : 0);
        result = 31 * result + (paCd != null ? paCd.hashCode() : 0);
        result = 31 * result + (paKd != null ? paKd.hashCode() : 0);
        result = 31 * result + (paMc != null ? paMc.hashCode() : 0);
        result = 31 * result + (paFlag != null ? paFlag.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        return result;
    }
}
