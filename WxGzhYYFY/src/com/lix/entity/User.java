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
public class User {
    private int id;
    private String iname;
    private String ipassword;
    private Integer iage;
    private String isex;
    private String itel;
    private String iaddr;
    private String iemail;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "iname")
    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    @Basic
    @Column(name = "ipassword")
    public String getIpassword() {
        return ipassword;
    }

    public void setIpassword(String ipassword) {
        this.ipassword = ipassword;
    }

    @Basic
    @Column(name = "iage")
    public Integer getIage() {
        return iage;
    }

    public void setIage(Integer iage) {
        this.iage = iage;
    }

    @Basic
    @Column(name = "isex")
    public String getIsex() {
        return isex;
    }

    public void setIsex(String isex) {
        this.isex = isex;
    }

    @Basic
    @Column(name = "itel")
    public String getItel() {
        return itel;
    }

    public void setItel(String itel) {
        this.itel = itel;
    }

    @Basic
    @Column(name = "iaddr")
    public String getIaddr() {
        return iaddr;
    }

    public void setIaddr(String iaddr) {
        this.iaddr = iaddr;
    }

    @Basic
    @Column(name = "iemail")
    public String getIemail() {
        return iemail;
    }

    public void setIemail(String iemail) {
        this.iemail = iemail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (iname != null ? !iname.equals(user.iname) : user.iname != null) return false;
        if (ipassword != null ? !ipassword.equals(user.ipassword) : user.ipassword != null) return false;
        if (iage != null ? !iage.equals(user.iage) : user.iage != null) return false;
        if (isex != null ? !isex.equals(user.isex) : user.isex != null) return false;
        if (itel != null ? !itel.equals(user.itel) : user.itel != null) return false;
        if (iaddr != null ? !iaddr.equals(user.iaddr) : user.iaddr != null) return false;
        if (iemail != null ? !iemail.equals(user.iemail) : user.iemail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (iname != null ? iname.hashCode() : 0);
        result = 31 * result + (ipassword != null ? ipassword.hashCode() : 0);
        result = 31 * result + (iage != null ? iage.hashCode() : 0);
        result = 31 * result + (isex != null ? isex.hashCode() : 0);
        result = 31 * result + (itel != null ? itel.hashCode() : 0);
        result = 31 * result + (iaddr != null ? iaddr.hashCode() : 0);
        result = 31 * result + (iemail != null ? iemail.hashCode() : 0);
        return result;
    }
}
