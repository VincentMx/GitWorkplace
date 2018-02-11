package com.lix.entity.vo;

import com.lix.entity.XtCs;

/**
 * @author : lix
 * @desc :
 * @time : 14:422017/12/27
 * @modify by :
 */
public class XtCsVO extends XtCs{

    private String lxmc; //参数类型的名称
    private String startTime; //开始时间
    private String endTime;  //结束时间


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLxmc() {
        return lxmc;
    }

    public void setLxmc(String lxmc) {
        this.lxmc = lxmc;
    }
}
