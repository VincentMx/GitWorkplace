package com.lix.entity.vo;

import com.lix.entity.XtYhZb;

/**
 * @author : lix
 * @desc :
 * @time : 15:152018/10/3
 * @modify by :
 */
public class XtYhZbVO  extends XtYhZb {


    private String startTime;
    private String endTime;
    private Double zxje;
    private Double zdje;

    public Double getZxje() {
        return zxje;
    }

    public void setZxje(Double zxje) {
        this.zxje = zxje;
    }

    public Double getZdje() {
        return zdje;
    }

    public void setZdje(Double zdje) {
        this.zdje = zdje;
    }

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
