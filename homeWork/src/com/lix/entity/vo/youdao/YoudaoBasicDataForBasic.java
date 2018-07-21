package com.lix.entity.vo.youdao;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 8:322018/7/5
 * @modify by :
 */
public class YoudaoBasicDataForBasic {

    private String phonetic; //拼音
    private List<String> explains; //解释

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public List<String> getExplains() {
        return explains;
    }

    public void setExplains(List<String> explains) {
        this.explains = explains;
    }
}
