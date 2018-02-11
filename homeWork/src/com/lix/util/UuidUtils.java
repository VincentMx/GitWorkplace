package com.lix.util;

import java.util.UUID;

/**
 * @author : lix
 * @desc : 获取32位的随机数
 * @time : 8:502017/11/27
 * @modify by :
 */
public class UuidUtils {

    public static String get32UUID(){
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-","");
        return uuid;
    }
    public static void main(String[] args){
        System.out.println(get32UUID());
    }
}
