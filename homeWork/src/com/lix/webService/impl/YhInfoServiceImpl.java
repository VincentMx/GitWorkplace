package com.lix.webService.impl;

import cn.lix.constants.BasicConfig;
import cn.lix.constants.Constants;
import com.lix.Query.ServiceQueryUtil;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.ResultVO;
import com.lix.service.XtYhService;
import com.lix.util.JsonUtils;
import com.lix.util.webServiceCheckUtil;
import com.lix.webService.YhInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Title:
 * @author : lix
 * @desc :
 * @time : 10:162018/3/8
 * @modify by :
 */
@WebService(endpointInterface = "com.lix.webService.YhInfoService",targetNamespace = "http://impl.webService.com.lix/")
public class YhInfoServiceImpl implements YhInfoService {

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
    public String getYhInfo(String yhId, String yhName,String yhPass) {
        logger.info("请求信息为：" +  "yhid :"  + yhId + "  yhName : " + yhName + " yhpass : " + yhPass);

        ResultVO resultVO = new ResultVO();
        String result = "";
        try{
            Xt_yh xt_yh = new Xt_yh();
            xt_yh.setId(yhId);
            xt_yh.setName(yhName);
            xt_yh.setPassword(yhPass);
            Xt_yh xt_yh2 = xtYhService.findXtYhByPara(xt_yh);
            Constants.xtYhInfo.put(xt_yh2.getId(),xt_yh2);
            resultVO.setStatus(true);
            resultVO.setResult(JsonUtils.getJsonData(xt_yh2));

        }catch (Exception e){
            resultVO.setStatus(false);
            resultVO.setMessage(e.getMessage());
            e.printStackTrace();
        }

        result = JsonUtils.getJsonData(resultVO);

        logger.info("返回信息为： "  + result);
        return result;
    }

    @Override
    public String addYh(String id, String name, String sex, String unit, String password, String mobile, String address, String email) {
        return null;
    }

    @Override
    public String addYhByMobile(String mobile) {
        return null;
    }

    @Override
    public String addXtYhDspInfo(String jsonStr) {
        logger.info("Method:YhInfoServiceImpl.addXtYhDspInfo");
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

    @Override
    public String xtYhLogin(String jsonStr) {
        logger.info("Method:YhInfoServiceImpl.xtYhLogin");
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

    @Override
    public String deleteXtYhInfo(String jsonStr) {
        logger.info("Method:YhInfoServiceImpl.deleteXtYhInfo");
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

    @Override
    public String updateXtYhInfo(String jsonStr) {
        logger.info("Method:YhInfoServiceImpl.updateXtYhInfo");
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

    @Override
    public String spXtYhForDsp(String jsonStr) {
        logger.info("Method:YhInfoServiceImpl.spXtYhForDsp");
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

    @Override
    public String queryXtYhInfo(String jsonStr) {
        logger.info("Method:YhInfoServiceImpl.queryXtYhInfo");
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
