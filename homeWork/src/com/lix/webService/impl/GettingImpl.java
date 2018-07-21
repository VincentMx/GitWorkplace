package com.lix.webService.impl;

import cn.lix.constants.BasicConfig;
import cn.lix.constants.Constants;
import com.lix.Query.ServiceQueryUtil;
import com.lix.util.JsonUtils;
import com.lix.util.webServiceCheckUtil;
import com.lix.webService.Getting;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 19:592018/5/29
 * @modify by :
 */
@WebService(targetNamespace="com.lix.webService.Getting",  endpointInterface = "com.lix.webService.Getting")
@Component("Getting")
public class GettingImpl implements Getting {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private webServiceCheckUtil webServiceUtil;

    @Autowired
    private ServiceQueryUtil serviceQueryUtil;

    @Override
    public String getting(String username) {
        logger.info("请求信息：" + username);
        String message = "hello  " + username +  " now :" + new Date();
        logger.info("返回信息：" + message);
        return message;
    }



    public String transLate(@WebParam (name = "jsonStr") String jsonStr){
        logger.info("Method:WebserviceImpl.payResService");
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
        return resStr;
    }
}
