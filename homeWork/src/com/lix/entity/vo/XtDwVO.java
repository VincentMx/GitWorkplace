package com.lix.entity.vo;

import com.lix.entity.XtDw;

/**
 * @author : lix
 * @desc :
 * @time : 11:592018/1/25
 * @modify by :
 */
public class XtDwVO extends XtDw {


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
