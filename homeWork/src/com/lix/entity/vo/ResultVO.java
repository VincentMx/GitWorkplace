package com.lix.entity.vo;

/**
 * @author : lix
 * @desc :
 * @time : 10:382018/3/8
 * @modify by :
 */
public class ResultVO {


    private boolean status;
    private String message;
    private String result;
    private String yhinfo_id;


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getYhinfo_id() {
        return yhinfo_id;
    }

    public void setYhinfo_id(String yhinfo_id) {
        this.yhinfo_id = yhinfo_id;
    }
}
