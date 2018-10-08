package com.lix.manager;

import cn.lix.config.BasicConfig;
import com.lix.util.baidu.TransApi;

import java.io.UnsupportedEncodingException;

/**
 * @author : lix
 * @desc :
 * @time : 22:492018/7/4
 * @modify by :
 */
public class test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        TransApi api = new TransApi(BasicConfig.BAIDU_APP_ID, BasicConfig.BAIDU_SECURE_KEY);

        String query = "美女";
        System.out.println(api.getTransResult(query, "auto", "en2"));
    }
}
