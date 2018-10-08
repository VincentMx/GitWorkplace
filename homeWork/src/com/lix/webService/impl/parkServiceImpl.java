package com.lix.webService.impl;

import cn.lix.config.BasicConfig;
import cn.lix.constants.Constants;
import com.lix.Query.ServiceQueryUtil;
import com.lix.service.XtYhService;
import com.lix.util.JsonUtils;
import com.lix.util.webServiceCheckUtil;
import com.lix.webService.YhInfoService;
import com.lix.webService.parkService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : lix
 * @desc : 停车场接口服务类
 * @time : 17:562018/7/16
 * @modify by :
 */
@WebService(targetNamespace="com.lix.webService.parkService",  endpointInterface = "com.lix.webService.parkService")
@Component("parkService")
public class parkServiceImpl implements parkService {


    private Logger logger = Logger.getLogger(this.getClass());


    @Resource
    private YhInfoService yhInfoService;



    @Resource
    private XtYhService xtYhService;



    @Autowired
    private webServiceCheckUtil webServiceUtil;

    @Autowired
    private ServiceQueryUtil serviceQueryUtil;




    @Override
    public String queryParkService(String jsonStr) {
        logger.info("Method:parkServiceImpl.queryParkService");
        logger.info("接受到的报文" + jsonStr);

        Map<String, Object> map = JsonUtils.parseJSON2Map(jsonStr);
        Map<String, Object> headMap = JsonUtils.parseJSON2Map(map.get("msghead").toString());
        Map<String, Object> bodyMap = JsonUtils.parseJSON2Map(map.get("msgreq").toString());
        // 作为参数传递使用的map
        Map<String, Object> paramMap = new HashMap<String, Object>();
        Map<String, Object> headermap = new HashMap<String, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();

        paramMap.putAll(bodyMap);
        paramMap.putAll(headMap);

        try{

            String servicename = (String) headMap.get("serviceName");
            String code = (String)headMap.get("sign");

            if(code == null){
                logger.info("---------验证码为空------");
                String resStr = webServiceUtil.rtnBack(code,"验证码为空",headMap);
                return resStr;
            }else if(!code.equals(BasicConfig.sign)){
                logger.info("---------验证码错误------");
                String resStr = webServiceUtil.rtnBack(code,"验证码错误",headMap);
                return resStr;
            }

            if (servicename == null){
                logger.info("---------服务名称为空------");
                String resStr = webServiceUtil.rtnBack(code,"服务名称为空",headMap);
                return resStr;
            }
            bodyMap.put("servicename",servicename);
            headermap.putAll(headMap);
            Map<String,Object> queryMap = new HashMap<String, Object>();
            queryMap = serviceQueryUtil.queryBack(bodyMap);

            rtnMap.put("msghead", headermap);
            rtnMap.put("msgrsp", queryMap);
        } catch (Exception e) {
            String resStr = webServiceUtil.rtnBack(Constants.error_msg, headMap);
            logger.info("---返回报文:" + resStr);
            return resStr;
        }
        String resStr = JsonUtils.map2json(rtnMap);
        logger.info("---返回报文:" + resStr);
        return resStr;
    }


    @Override
    public String getOrderNo(String jsonStr) {
        logger.info("Method:parkServiceImpl.getOrderNo");
        logger.info("接受到的报文" + jsonStr);

        Map<String, Object> map = JsonUtils.parseJSON2Map(jsonStr);
        Map<String, Object> headMap = JsonUtils.parseJSON2Map(map.get("msghead").toString());
        Map<String, Object> bodyMap = JsonUtils.parseJSON2Map(map.get("msgreq").toString());
        // 作为参数传递使用的map
        Map<String, Object> paramMap = new HashMap<String, Object>();
        Map<String, Object> headermap = new HashMap<String, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();

        paramMap.putAll(bodyMap);
        paramMap.putAll(headMap);

        try{

            String servicename = (String) headMap.get("serviceName");
            String code = (String)headMap.get("sign");

            if(code == null){
                logger.info("---------验证码为空------");
                String resStr = webServiceUtil.rtnBack(code,"验证码为空",headMap);
                return resStr;
            }else if(!code.equals(BasicConfig.sign)){
                logger.info("---------验证码错误------");
                String resStr = webServiceUtil.rtnBack(code,"验证码错误",headMap);
                return resStr;
            }

            if (servicename == null){
                logger.info("---------服务名称为空------");
                String resStr = webServiceUtil.rtnBack(code,"服务名称为空",headMap);
                return resStr;
            }
            bodyMap.put("servicename",servicename);
            headermap.putAll(headMap);
            Map<String,Object> queryMap = new HashMap<String, Object>();
            queryMap = serviceQueryUtil.queryBack(bodyMap);

            rtnMap.put("msghead", headermap);
            rtnMap.put("msgrsp", queryMap);
        } catch (Exception e) {
            String resStr = webServiceUtil.rtnBack(Constants.error_msg, headMap);
            logger.info("---返回报文:" + resStr);
            return resStr;
        }
        String resStr = JsonUtils.map2json(rtnMap);
        logger.info("---返回报文:" + resStr);
        return resStr;
    }


}
