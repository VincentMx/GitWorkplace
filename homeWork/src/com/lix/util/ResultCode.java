package com.lix.util;

/**
 * @author : lix
 * @desc :响应码枚举，参考HTTP协议
 * @time : 16:232017/11/28
 * @modify by :
 */
public enum ResultCode {
    SUCCESS(200), //成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证
    NOTFOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500); //服务器内部错误
    public  int code;
    ResultCode(int code){
        this.code = code;
    }
}
