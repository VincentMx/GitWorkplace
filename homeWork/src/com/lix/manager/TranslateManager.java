package com.lix.manager;

import cn.lix.constants.BasicConfig;
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
          queryStr = (String)bodyMap.get("queryStr");

        try {

          resStr =   api.getTransResult(queryStr, "auto", "fra");
          baiduTrans = JSON.parseObject(resStr,BaiduTrans.class);
          if(baiduTrans.getError_code() == null){
              retMap.put("results",baiduTrans.getTrans_result());
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
        YoudaoBasicData youdaoBasicData = new YoudaoBasicData();
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 有道 翻译 END ****************************************");

        String query = (String)bodyMap.get("queryStr");
        try{

            String resMsg = sendMsg(query);
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


    public static String sendMsg(String query) throws Exception {
        String appKey = BasicConfig.YOUDAO_APP_ID;
        String url = "http://openapi.youdao.com/api";
        String salt = String.valueOf(System.currentTimeMillis());
        String from = "zh-CHS";
        String to = "EN";
        String sign = md5(appKey + query + salt+ BasicConfig.YOUDAO_SECURE_KEY);
        Map params = new HashMap();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
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
