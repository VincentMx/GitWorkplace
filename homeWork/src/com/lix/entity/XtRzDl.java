package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 10:532018/1/8
 * @modify by :
 */
@Entity
@Table(name = "xt_rz_dl", schema = "xxxt", catalog = "")
public class XtRzDl implements java.io.Serializable{


    private static final long serialVersionUID = 1L;


    private String skey;
    private String userId;
    private String userName;
    private String ipAddress;
    private String sysType;
    private String loginTime;
    private String logoutTime;
    private String unitKey;
    private String unitName;
    private String yxzt;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "sys_type")
    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType;
    }

    @Basic
    @Column(name = "login_time")
    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "logout_time")
    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }

    @Basic
    @Column(name = "unit_key")
    public String getUnitKey() {
        return unitKey;
    }

    public void setUnitKey(String unitKey) {
        this.unitKey = unitKey;
    }

    @Basic
    @Column(name = "unit_name")
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Basic
    @Column(name = "yxzt")
    public String getYxzt() {
        return yxzt;
    }

    public void setYxzt(String yxzt) {
        this.yxzt = yxzt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XtRzDl xtRzDl = (XtRzDl) o;

        if (skey != null ? !skey.equals(xtRzDl.skey) : xtRzDl.skey != null) return false;
        if (userId != null ? !userId.equals(xtRzDl.userId) : xtRzDl.userId != null) return false;
        if (userName != null ? !userName.equals(xtRzDl.userName) : xtRzDl.userName != null) return false;
        if (ipAddress != null ? !ipAddress.equals(xtRzDl.ipAddress) : xtRzDl.ipAddress != null) return false;
        if (sysType != null ? !sysType.equals(xtRzDl.sysType) : xtRzDl.sysType != null) return false;
        if (loginTime != null ? !loginTime.equals(xtRzDl.loginTime) : xtRzDl.loginTime != null) return false;
        if (logoutTime != null ? !logoutTime.equals(xtRzDl.logoutTime) : xtRzDl.logoutTime != null) return false;
        if (unitKey != null ? !unitKey.equals(xtRzDl.unitKey) : xtRzDl.unitKey != null) return false;
        if (unitName != null ? !unitName.equals(xtRzDl.unitName) : xtRzDl.unitName != null) return false;
        if (yxzt != null ? !yxzt.equals(xtRzDl.yxzt) : xtRzDl.yxzt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        result = 31 * result + (sysType != null ? sysType.hashCode() : 0);
        result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
        result = 31 * result + (logoutTime != null ? logoutTime.hashCode() : 0);
        result = 31 * result + (unitKey != null ? unitKey.hashCode() : 0);
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        result = 31 * result + (yxzt != null ? yxzt.hashCode() : 0);
        return result;
    }
}
