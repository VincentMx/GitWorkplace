package com.lix.entity.vo;

import com.lix.entity.XtCsLx;

/**
 * @author : lix
 * @desc :
 * @time : 14:502017/12/27
 * @modify by :
 */
public class XtCsLxVO extends XtCsLx {


    private String startTime; //开始时间
    private String endTime; //结束时间


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
}
