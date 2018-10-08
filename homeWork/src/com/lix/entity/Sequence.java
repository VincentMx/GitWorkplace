package com.lix.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : lix
 * @desc :
 * @time : 16:062018/9/20
 * @modify by :
 */
@Entity
public class Sequence {
    private String name;
    private int currentValue;
    private int increment;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "current_value")
    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    @Basic
    @Column(name = "increment")
    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sequence sequence = (Sequence) o;

        if (currentValue != sequence.currentValue) return false;
        if (increment != sequence.increment) return false;
        if (name != null ? !name.equals(sequence.name) : sequence.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + currentValue;
        result = 31 * result + increment;
        return result;
    }
}
