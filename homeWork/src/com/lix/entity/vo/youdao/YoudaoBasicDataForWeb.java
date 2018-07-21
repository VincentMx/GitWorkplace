package com.lix.entity.vo.youdao;

import java.util.List;

/**
 * @author : lix
 * @desc :有道的接口类
 * @time : 8:232018/7/5
 * @modify by :
 */
public class YoudaoBasicDataForWeb {


    private String key; //key
    private List<String> value; //

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }
}
