package com.lix.entity.vo;

import com.lix.entity.Xt_yh;

/**
 * @author : lix
 * @desc : 为用户定义的实体
 * @time : 13:152017/12/13
 * @modify by :
 */
public class XtYhVO extends Xt_yh {


    private String startTime;
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
