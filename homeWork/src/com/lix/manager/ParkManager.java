package com.lix.manager;

import cn.lix.controller.base.BaseController;
import com.lix.service.XtYhDspService;
import com.lix.service.XtYhService;
import com.lix.service.YhParkService;
import com.lix.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 18:372018/7/16
 * @modify by :
 */
@Component
public class ParkManager extends BaseController {


    private static Logger logger = Logger.getLogger(ParkManager.class);


    @Autowired
    private XtYhDspService xtYhDspService;


    @Autowired
    private XtYhService xtYhService;


    @Autowired
    private YhParkService parkService;


    //分页获取车位列表
    public Map<String , Object> getParkList(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取车位详情
    public Map<String , Object> getParkDetail(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取停车价格计划
    public Map<String , Object> getParkPriceDetail(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取可用停车位数量
    public Map<String , Object> getParkNum(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //生成停车位预定订单
    public Map<String , Object> getParkOrder(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取停车位图片列表
    public Map<String , Object> getParkPicture(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取停车订单列表
    public Map<String , Object> getParkOrderList(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取停车订单详情
    public Map<String , Object> getParkOrderDetail(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //取消订单
    public Map<String , Object> getParkRefundOrder(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取取消订单列表
    public Map<String , Object> getParkRefoundOrderList(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }
    //获取取消订单详情
    public Map<String , Object> getParkRefoundOrderDetail(Map<String,Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        return retMap;
    }




}
