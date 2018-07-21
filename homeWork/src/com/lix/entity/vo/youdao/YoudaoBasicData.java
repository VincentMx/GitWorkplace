package com.lix.entity.vo.youdao;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 8:232018/7/5
 * @modify by :
 */
public class YoudaoBasicData {


    private List<YoudaoBasicDataForWeb> web; //网页答案
    private String tSpeakUrl; //语音入口
    private String query; //查找的字符
    private List<String> translation; //译文
    private String errorCode; //错误码
    private String l; //
    private String speakUrl; //
    private List<YoudaoBasicDataDict> dict; //
    private List<YoudaoBasicDataForWebdict> webdict; //
    private List<YoudaoBasicDataForBasic> basic; //基础数据


    public List<YoudaoBasicDataForWeb> getWeb() {
        return web;
    }

    public void setWeb(List<YoudaoBasicDataForWeb> web) {
        this.web = web;
    }

    public String gettSpeakUrl() {
        return tSpeakUrl;
    }

    public void settSpeakUrl(String tSpeakUrl) {
        this.tSpeakUrl = tSpeakUrl;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getSpeakUrl() {
        return speakUrl;
    }

    public void setSpeakUrl(String speakUrl) {
        this.speakUrl = speakUrl;
    }

    public List<YoudaoBasicDataDict> getDict() {
        return dict;
    }

    public void setDict(List<YoudaoBasicDataDict> dict) {
        this.dict = dict;
    }

    public List<YoudaoBasicDataForWebdict> getWebdict() {
        return webdict;
    }

    public void setWebdict(List<YoudaoBasicDataForWebdict> webdict) {
        this.webdict = webdict;
    }

    public List<YoudaoBasicDataForBasic> getBasic() {
        return basic;
    }

    public void setBasic(List<YoudaoBasicDataForBasic> basic) {
        this.basic = basic;
    }
}
