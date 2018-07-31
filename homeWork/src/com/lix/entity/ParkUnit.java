package com.lix.entity;

import javax.persistence.*;

/**
 * @author : lix
 * @desc :
 * @time : 23:282018/7/30
 * @modify by :
 */
@Entity
@Table(name = "park_unit", schema = "xxxt", catalog = "")
public class ParkUnit {
    private String skey;
    private String unitSkey;
    private String pcSkey;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "unit_skey")
    public String getUnitSkey() {
        return unitSkey;
    }

    public void setUnitSkey(String unitSkey) {
        this.unitSkey = unitSkey;
    }

    @Basic
    @Column(name = "pc_skey")
    public String getPcSkey() {
        return pcSkey;
    }

    public void setPcSkey(String pcSkey) {
        this.pcSkey = pcSkey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkUnit parkUnit = (ParkUnit) o;

        if (skey != null ? !skey.equals(parkUnit.skey) : parkUnit.skey != null) return false;
        if (unitSkey != null ? !unitSkey.equals(parkUnit.unitSkey) : parkUnit.unitSkey != null) return false;
        if (pcSkey != null ? !pcSkey.equals(parkUnit.pcSkey) : parkUnit.pcSkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (unitSkey != null ? unitSkey.hashCode() : 0);
        result = 31 * result + (pcSkey != null ? pcSkey.hashCode() : 0);
        return result;
    }
}
