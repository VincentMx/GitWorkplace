package com.lix.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : lix
 * @desc :
 * @time : 2018/11/2 14:53
 * @modify by :
 * @modify Time:
 */
@Entity
public class Test {
    private String skey;
    private String name;

    @Id
    @Column(name = "skey")
    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (skey != null ? !skey.equals(test.skey) : test.skey != null) return false;
        if (name != null ? !name.equals(test.name) : test.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skey != null ? skey.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
