package com.lix.manager;

import cn.lix.constants.Constants;
import cn.lix.constants.SystemErrorCode;
import cn.lix.controller.base.BaseController;
import com.lix.entity.XtYhDsp;
import com.lix.service.XtDwService;
import com.lix.util.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 12:242018/8/4
 * @modify by :
 */
@Component
public class UnitManager extends BaseController {


    private static Logger logger = Logger.getLogger(UnitManager.class);

    @Resource
    private XtDwService xtDwService;


    /**
      *@method: 获取市级单位
      *@author: lix
      *@desc： 
      *@Date: 12:31 2018/8/4
      *@param: 
      *@return:   
      *
      */
    public Map<String , Object> getSjDw(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        XtYhDsp xtYhDsp = new XtYhDsp();

        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求  END ****************************************");

        xtYhDsp.setId((String)bodyMap.get("id"));
        xtYhDsp.setMobile((String)bodyMap.get("mobile"));
        xtYhDsp.setPassword((String)bodyMap.get("password"));
        xtYhDsp.setName((String)bodyMap.get("name"));
        xtYhDsp.setUnit((String)bodyMap.get("unit"));
        xtYhDsp.setEmail((String)bodyMap.get("email"));

        try{

            retMap.put(SystemErrorCode.retcode, Constants.success);
            retMap.put(SystemErrorCode.retshow, Constants.success_msg);
        }catch (Exception e){
            e.printStackTrace();
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, Constants.error_msg);

            logger.error("用户 " + (String)bodyMap.get("id") + " 在请求待审批用户注册过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 待审批用户注册 END ****************************************");
        return retMap;

    }

    /**
      *@method: 获取城市数据
      *@author: lix
      *@desc： 
      *@Date: 12:30 2018/8/4
      *@param: 
      *@return:   
      *
      */
    public Map<String , Object> getCityDw(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        XtYhDsp xtYhDsp = new XtYhDsp();

        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求  END ****************************************");

        xtYhDsp.setId((String)bodyMap.get("id"));
        xtYhDsp.setMobile((String)bodyMap.get("mobile"));
        xtYhDsp.setPassword((String)bodyMap.get("password"));
        xtYhDsp.setName((String)bodyMap.get("name"));
        xtYhDsp.setUnit((String)bodyMap.get("unit"));
        xtYhDsp.setEmail((String)bodyMap.get("email"));




        try{

            retMap.put(SystemErrorCode.retcode, Constants.success);
            retMap.put(SystemErrorCode.retshow, Constants.success_msg);
        }catch (Exception e){
            e.printStackTrace();
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, Constants.error_msg);

            logger.error("用户 " + (String)bodyMap.get("id") + " 在请求待审批用户注册过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 待审批用户注册 END ****************************************");
        return retMap;

    }




}
