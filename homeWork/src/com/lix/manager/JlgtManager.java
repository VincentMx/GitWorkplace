package com.lix.manager;

import cn.lix.constants.Constants;
import cn.lix.constants.SystemErrorCode;
import com.alibaba.fastjson.JSON;
import com.lix.entity.XtGg;
import com.lix.service.XtGgService;
import com.lix.util.Logger;
import org.apache.http.util.Asserts;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :交流沟通服务类
 * @time :
 * @modify by :
 */
@Component
public class JlgtManager {
    private static Logger logger = Logger.getLogger(JlgtManager.class);


    @Resource
    private XtGgService xtGgService;

    /**
      *@method:  手机首页获取5公告数据
      *@author: lix
      *@desc：
      *@Date: 21:20 2018/7/4
      *@param: 
      *@return:   
      *
      */
    public Map<String,Object> queryForGgxx(Map<String , Object> bodyMap){
           Map<String , Object> retMap = new HashMap<String, Object>();
           List<XtGg> xtGgList = new ArrayList<XtGg>();
           XtGg xtGg = new XtGg();
           logger.info("****************************************用户" + (String)bodyMap.get("ID")+ " 开始请求 app 首页公告信息 START ****************************************");
           try {
                  xtGgList = xtGgService.findLimitXtGgxx(xtGg , Constants.GG_APP_SY_SL);
                  logger.info("---------接口获取到的数据为：" + JSON.toJSONString(xtGgList));
                   if(xtGgList != null){

                      retMap.put("results",xtGgList);

                      retMap.put(SystemErrorCode.retcode, Constants.success);
                      retMap.put(SystemErrorCode.retshow, Constants.success_msg);

                  }else {
                      logger.error("----------获取app首页公告信息失败");
                      retMap.put(SystemErrorCode.retcode, Constants.error);
                      retMap.put(SystemErrorCode.retshow, Constants.error_msg);
                  }
           } catch (Exception e) {
               logger.error("----------获取app首页公告信息失败，原因：" + e.getMessage());
               e.printStackTrace();
           }
           logger.info("****************************************用户" + (String)bodyMap.get("ID")+ " 请求 app 首页公告信息 END ****************************************");
        return retMap;
    }



    /**
      *@method: 根据主键获取公告详细信息
      *@author: lix
      *@desc： 
      *@Date: 21:20 2018/7/4
      *@param: 
      *@return:   
      *
      */
    public Map<String,Object> queryForGgxxxxById(Map<String , Object> bodyMap){
           Map<String , Object> retMap = new HashMap<String, Object>();
           XtGg xtGg = new XtGg();
           logger.info("****************************************用户" + (String)bodyMap.get("ID")+ " 开始请求 系统公告详细信息 START ****************************************");

           String skey = bodyMap.get("SKEY").toString();
           Asserts.notEmpty(skey , "主键不能为空");

        try{
            xtGg = xtGgService.findById(skey);
            logger.info("---------接口获取到的数据为：" + JSON.toJSONString(xtGg));

            if( xtGg != null){

                retMap.put("result",xtGg);
                retMap.put(SystemErrorCode.retcode, Constants.success);
                retMap.put(SystemErrorCode.retshow, Constants.success_msg);

            }else {
                logger.error("---------获取系统公告信息失败");
                retMap.put(SystemErrorCode.retcode, Constants.error);
                retMap.put(SystemErrorCode.retshow, Constants.error_msg);
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error("用户 " + (String)bodyMap.get("ID") + " 在获取系统公告详情信息过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("ID")+ " 开始请求 系统公告详细信息 END ****************************************");
        return retMap;

    }

}
