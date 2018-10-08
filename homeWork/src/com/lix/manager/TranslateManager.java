package com.lix.manager;

import cn.lix.config.BasicConfig;
import cn.lix.constants.Constants;
import cn.lix.constants.SystemErrorCode;
import com.alibaba.fastjson.JSON;
import com.lix.entity.vo.baiduTrans.BaiduTrans;
import com.lix.entity.vo.youdao.YoudaoBasicData;
import com.lix.util.Logger;
import com.lix.util.baidu.TransApi;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static com.lix.manager.Demo.md5;

/**
 * @author : lix
 * @desc :
 * @time : 21:162018/7/4
 * @modify by :
 */
@Component
public class TranslateManager {
    private static Logger logger = Logger.getLogger(TranslateManager.class);

    /**
      *@method: 百度翻译的api
      *@author: lix
      *@desc：
      *@Date: 21:20 2018/7/4
      *@param: 
      *@return:   
      *
      */
    public Map<String,Object> queryForBaiduTrans(Map<String , Object> bodyMap){
          Map<String , Object> retMap = new HashMap<String, Object>();
          BaiduTrans baiduTrans = new BaiduTrans();
           TransApi api = new TransApi(BasicConfig.BAIDU_APP_ID, BasicConfig.BAIDU_SECURE_KEY);
          logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 百度 翻译 START ****************************************");
          String queryStr = null;
          String resStr = null;
          String to = null;
          queryStr = (String)bodyMap.get("queryStr");
          if(bodyMap.get("to") != null){
              to = (String)bodyMap.get("to");
          }

        try {
          if(to != null){
              resStr =   api.getTransResult(queryStr, "auto", to);
          }else {
              resStr =   api.getTransResult(queryStr, "auto", "fra");
          }
          logger.info("接口获取到的数据为：" + resStr);
          baiduTrans = JSON.parseObject(resStr,BaiduTrans.class);
          if(baiduTrans.getError_code() == null){
              retMap.put("results",baiduTrans.getTrans_result());
              retMap.put("words",baiduTrans.getTrans_result().get(0).getDst());

              retMap.put(SystemErrorCode.retcode, Constants.success);
              retMap.put(SystemErrorCode.retshow, Constants.success_msg);

          }else {
              retMap.put(SystemErrorCode.retcode, Constants.error);
              retMap.put(SystemErrorCode.retshow, baiduTrans.getError_code());
          }
        } catch (UnsupportedEncodingException e) {
            logger.error("用户 " + (String)bodyMap.get("id") + " 在请求百度翻译过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 百度 翻译 END ****************************************");
        return retMap;

    }



    /**
      *@method: 有道翻译
      *@author: lix
      *@desc： 
      *@Date: 21:20 2018/7/4
      *@param: 
      *@return:   
      *
      */
    public Map<String,Object> queryForYoudaoTrans(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        Map<String , String> queryMap = new HashMap<String , String>();
        YoudaoBasicData youdaoBasicData = new YoudaoBasicData();
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 有道 翻译 START ****************************************");

        String query = (String)bodyMap.get("queryStr");
        String from = "zh-CHS";
        String to = "EN";
        if(bodyMap.get("from") != null){
            from = bodyMap.get("from").toString();
        }

        if(bodyMap.get("to") != null){
            to = bodyMap.get("to").toString();
        }

        //请求体封装
        queryMap.put("query",query);
        queryMap.put("from", from);
        queryMap.put("to", to);


        try{

            String resMsg = sendMsg(queryMap);
            youdaoBasicData = JSON.parseObject(resMsg,YoudaoBasicData.class);
            if("0".equals(youdaoBasicData.getErrorCode()) ){
                retMap.put("result",youdaoBasicData);
                retMap.put(SystemErrorCode.retcode, Constants.success);
                retMap.put(SystemErrorCode.retshow, Constants.success_msg);

            }else {
                retMap.put(SystemErrorCode.retcode, Constants.error);
                retMap.put(SystemErrorCode.retshow, youdaoBasicData.getErrorCode());
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error("用户 " + (String)bodyMap.get("id") + " 在请求有道翻译过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 有道 翻译 END ****************************************");
        return retMap;

    }


    public static String sendMsg(Map<String , String> map) throws Exception {
        String appKey = BasicConfig.YOUDAO_APP_ID;
        String url = "http://openapi.youdao.com/api";
        String salt = String.valueOf(System.currentTimeMillis());

        String sign = md5(appKey + map.get("query") + salt+ BasicConfig.YOUDAO_SECURE_KEY);
        Map params = new HashMap();
        params.put("q", map.get("query"));
        params.put("from", map.get("from"));
        params.put("to", map.get("to"));
        params.put("sign", sign);
        params.put("salt", salt);
        params.put("appKey", appKey);
        StopWatch clock = new StopWatch();
        clock.start();
        Demo demo = new Demo();
        logger.info("请求的json信息为：" + JSON.toJSONString(params));
        String resStr =  demo.requestForHttp(url, params);
        clock.stop();
        logger.info("从接口处获取到数据：\n" + resStr);
        return resStr;

    }


}
