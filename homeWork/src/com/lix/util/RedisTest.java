package com.lix.util;

import redis.clients.jedis.Jedis;

/**
 * @author : lix
 * @desc :
 * @time : 23:272018/4/4
 * @modify by :
 */
public class RedisTest {


    public static void main(String[] args){
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("1="+ jedis.get("yhId"));

    }
}
