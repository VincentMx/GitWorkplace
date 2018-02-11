package com.lix.util;

import com.alibaba.fastjson.JSON;

/**
 * @author : lix
 * @desc :
 * @time : 16:202017/11/28
 * @modify by :
 */
public class Result {
    private int code;
    private String message;
    private Object data;


    public Result(){

    }

    public Result(int code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result setCode(ResultCode resultCode){
        this.code = resultCode.code;
        return this;
    }



    public int getCode() {
        return code;
    }


    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }



    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public String toString(){
        return JSON.toJSONString(this);
    }
}
