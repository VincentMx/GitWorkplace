package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 10:532018/1/8
 * @modify by :
 */
@Entity
@Table(name = "xt_yh", schema = "xxxt", catalog = "")
public class Xt_yh implements java.io.Serializable{

    private static final long serialVersionUID = 1L;


    private String skey;
    private String id;
    private String name;
    private String sex;
    private String unit;
    private String password;
    private String phone;
    private String address;
    private String email;
    private String flag;
    private String lasttime;
    private String lastip;
    private String bz;
    private String mobile;
    private String regtime;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "lasttime")
    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    @Basic
    @Column(name = "lastip")
    public String getLastip() {
        return lastip;
    }

    public void setLastip(String lastip) {
        this.lastip = lastip;
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
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "regtime")
    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Xt_yh xtYh = (Xt_yh) o;

        if (skey != null ? !skey.equals(xtYh.skey) : xtYh.skey != null) return false;
        if (id != null ? !id.equals(xtYh.id) : xtYh.id != null) return false;
        if (name != null ? !name.equals(xtYh.name) : xtYh.name != null) return false;
        if (sex != null ? !sex.equals(xtYh.sex) : xtYh.sex != null) return false;
        if (unit != null ? !unit.equals(xtYh.unit) : xtYh.unit != null) return false;
        if (password != null ? !password.equals(xtYh.password) : xtYh.password != null) return false;
        if (phone != null ? !phone.equals(xtYh.phone) : xtYh.phone != null) return false;
        if (address != null ? !address.equals(xtYh.address) : xtYh.address != null) return false;
        if (email != null ? !email.equals(xtYh.email) : xtYh.email != null) return false;
        if (flag != null ? !flag.equals(xtYh.flag) : xtYh.flag != null) return false;
        if (lasttime != null ? !lasttime.equals(xtYh.lasttime) : xtYh.lasttime != null) return false;
        if (lastip != null ? !lastip.equals(xtYh.lastip) : xtYh.lastip != null) return false;
        if (bz != null ? !bz.equals(xtYh.bz) : xtYh.bz != null) return false;
        if (mobile != null ? !mobile.equals(xtYh.mobile) : xtYh.mobile != null) return false;
        if (regtime != null ? !regtime.equals(xtYh.regtime) : xtYh.regtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (lasttime != null ? lasttime.hashCode() : 0);
        result = 31 * result + (lastip != null ? lastip.hashCode() : 0);
        result = 31 * result + (bz != null ? bz.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (regtime != null ? regtime.hashCode() : 0);
        return result;
    }
}
