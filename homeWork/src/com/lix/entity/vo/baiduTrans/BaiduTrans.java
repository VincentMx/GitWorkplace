package com.lix.entity.vo.baiduTrans;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 23:122018/7/4
 * @modify by :
 */
public class BaiduTrans {


    private List<BaiduTransForResult> trans_result; //翻译返回结果
    private String from; //带翻译语言种类
    private String to; //翻译成为语言种类
    private String error_code; //错误码
    private String error_msg; //错误信息


    public List<BaiduTransForResult> getTrans_result() {
        return trans_result;
    }

    public void setTrans_result(List<BaiduTransForResult> trans_result) {
        this.trans_result = trans_result;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
}
