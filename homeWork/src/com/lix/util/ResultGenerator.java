package com.lix.util;


/**
 * @author : lix
 * @desc :响应结果生成工具
 * @time : 16:222017/11/28
 * @modify by :
 */
public class ResultGenerator {
    private static  final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSucessResult(){
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSucessResult(Object data){
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message){
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

}
