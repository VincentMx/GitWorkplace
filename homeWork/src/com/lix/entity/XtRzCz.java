package com.lix.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : lix
 * @desc :
 * @time : 10:532018/1/8
 * @modify by :
 */
@Entity
@Table(name = "xt_rz_cz", schema = "xxxt", catalog = "")
public class XtRzCz implements Serializable{

    private static final long serialVersionUID = 1L;

    private String skey;
    private String regId;
    private String userId;
    private String unitName;
    private String unitKey;
    private String userName;
    private String operateTime;
    private String operateType;
    private String operateResult;
    private String errorCode;
    private String operateName;
    private String operateCondition;
    private String yxzt;

    @GenericGenerator(name="generator",strategy = "uuid")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "reg_id")
    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
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
    @Column(name = "unit_name")
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
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
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "operate_time")
    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    @Basic
    @Column(name = "operate_type")
    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    @Basic
    @Column(name = "operate_result")
    public String getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(String operateResult) {
        this.operateResult = operateResult;
    }

    @Basic
    @Column(name = "error_code")
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Basic
    @Column(name = "operate_name")
    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    @Basic
    @Column(name = "operate_condition")
    public String getOperateCondition() {
        return operateCondition;
    }

    public void setOperateCondition(String operateCondition) {
        this.operateCondition = operateCondition;
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

        XtRzCz xtRzCz = (XtRzCz) o;

        if (skey != null ? !skey.equals(xtRzCz.skey) : xtRzCz.skey != null) return false;
        if (regId != null ? !regId.equals(xtRzCz.regId) : xtRzCz.regId != null) return false;
        if (userId != null ? !userId.equals(xtRzCz.userId) : xtRzCz.userId != null) return false;
        if (unitName != null ? !unitName.equals(xtRzCz.unitName) : xtRzCz.unitName != null) return false;
        if (unitKey != null ? !unitKey.equals(xtRzCz.unitKey) : xtRzCz.unitKey != null) return false;
        if (userName != null ? !userName.equals(xtRzCz.userName) : xtRzCz.userName != null) return false;
        if (operateTime != null ? !operateTime.equals(xtRzCz.operateTime) : xtRzCz.operateTime != null) return false;
        if (operateType != null ? !operateType.equals(xtRzCz.operateType) : xtRzCz.operateType != null) return false;
        if (operateResult != null ? !operateResult.equals(xtRzCz.operateResult) : xtRzCz.operateResult != null)
            return false;
        if (errorCode != null ? !errorCode.equals(xtRzCz.errorCode) : xtRzCz.errorCode != null) return false;
        if (operateName != null ? !operateName.equals(xtRzCz.operateName) : xtRzCz.operateName != null) return false;
        if (operateCondition != null ? !operateCondition.equals(xtRzCz.operateCondition) : xtRzCz.operateCondition != null)
            return false;
        if (yxzt != null ? !yxzt.equals(xtRzCz.yxzt) : xtRzCz.yxzt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (regId != null ? regId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        result = 31 * result + (unitKey != null ? unitKey.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (operateType != null ? operateType.hashCode() : 0);
        result = 31 * result + (operateResult != null ? operateResult.hashCode() : 0);
        result = 31 * result + (errorCode != null ? errorCode.hashCode() : 0);
        result = 31 * result + (operateName != null ? operateName.hashCode() : 0);
        result = 31 * result + (operateCondition != null ? operateCondition.hashCode() : 0);
        result = 31 * result + (yxzt != null ? yxzt.hashCode() : 0);
        return result;
    }
}
