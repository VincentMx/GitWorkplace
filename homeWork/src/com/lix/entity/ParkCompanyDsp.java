package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 18:402018/8/7
 * @modify by :
 */
@Entity
@Table(name = "park_company_dsp", schema = "xxxt", catalog = "")
public class ParkCompanyDsp {
    private String skey;
    private String pcName;
    private String pcPhone;
    private String pcAddr;
    private String pcJd;
    private String pcWd;
    private String pcDesc;
    private String pcBz;
    private String pcLogo;
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
    @Column(name = "pc_name")
    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    @Basic
    @Column(name = "pc_phone")
    public String getPcPhone() {
        return pcPhone;
    }

    public void setPcPhone(String pcPhone) {
        this.pcPhone = pcPhone;
    }

    @Basic
    @Column(name = "pc_addr")
    public String getPcAddr() {
        return pcAddr;
    }

    public void setPcAddr(String pcAddr) {
        this.pcAddr = pcAddr;
    }

    @Basic
    @Column(name = "pc_jd")
    public String getPcJd() {
        return pcJd;
    }

    public void setPcJd(String pcJd) {
        this.pcJd = pcJd;
    }

    @Basic
    @Column(name = "pc_wd")
    public String getPcWd() {
        return pcWd;
    }

    public void setPcWd(String pcWd) {
        this.pcWd = pcWd;
    }

    @Basic
    @Column(name = "pc_desc")
    public String getPcDesc() {
        return pcDesc;
    }

    public void setPcDesc(String pcDesc) {
        this.pcDesc = pcDesc;
    }

    @Basic
    @Column(name = "pc_bz")
    public String getPcBz() {
        return pcBz;
    }

    public void setPcBz(String pcBz) {
        this.pcBz = pcBz;
    }

    @Basic
    @Column(name = "pc_logo")
    public String getPcLogo() {
        return pcLogo;
    }

    public void setPcLogo(String pcLogo) {
        this.pcLogo = pcLogo;
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

        ParkCompanyDsp that = (ParkCompanyDsp) o;

        if (skey != null ? !skey.equals(that.skey) : that.skey != null) return false;
        if (pcName != null ? !pcName.equals(that.pcName) : that.pcName != null) return false;
        if (pcPhone != null ? !pcPhone.equals(that.pcPhone) : that.pcPhone != null) return false;
        if (pcAddr != null ? !pcAddr.equals(that.pcAddr) : that.pcAddr != null) return false;
        if (pcJd != null ? !pcJd.equals(that.pcJd) : that.pcJd != null) return false;
        if (pcWd != null ? !pcWd.equals(that.pcWd) : that.pcWd != null) return false;
        if (pcDesc != null ? !pcDesc.equals(that.pcDesc) : that.pcDesc != null) return false;
        if (pcBz != null ? !pcBz.equals(that.pcBz) : that.pcBz != null) return false;
        if (pcLogo != null ? !pcLogo.equals(that.pcLogo) : that.pcLogo != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (pcName != null ? pcName.hashCode() : 0);
        result = 31 * result + (pcPhone != null ? pcPhone.hashCode() : 0);
        result = 31 * result + (pcAddr != null ? pcAddr.hashCode() : 0);
        result = 31 * result + (pcJd != null ? pcJd.hashCode() : 0);
        result = 31 * result + (pcWd != null ? pcWd.hashCode() : 0);
        result = 31 * result + (pcDesc != null ? pcDesc.hashCode() : 0);
        result = 31 * result + (pcBz != null ? pcBz.hashCode() : 0);
        result = 31 * result + (pcLogo != null ? pcLogo.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }
}
