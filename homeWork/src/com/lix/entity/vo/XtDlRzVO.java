package com.lix.entity.vo;

import com.lix.entity.XtRzDl;

/**
 * @author : lix
 * @desc :
 * @time : 13:242017/12/13
 * @modify by :
 */
public class XtDlRzVO extends XtRzDl {

    private String  startTime;

    private String endTime;

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
