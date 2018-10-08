package com.lix.Query;

import cn.lix.constants.Constants;
import com.lix.manager.JlgtManager;
import com.lix.manager.ParkManager;
import com.lix.manager.TranslateManager;
import com.lix.manager.XtYhInfoManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 23:352018/7/4
 * @modify by :
 */
@Component
public class ServiceQueryUtil {

    private static final Log logger = LogFactory.getLog(ServiceQueryUtil.class);


    @Autowired
    private TranslateManager translateManager;

    @Autowired
    private XtYhInfoManager xtYhInfoManager;

    @Autowired
    private ParkManager parkManager;

    @Autowired
    private JlgtManager jlgtManager;


    public Map<String , Object> queryBack(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();

        String code = (String)bodyMap.get("servicename");

        //****************************   翻译类接口  开始  *******************************//

        if(code.equals(Constants.TR001)){
            logger.info("------百度翻译接口开始------");
            retMap = translateManager.queryForBaiduTrans(bodyMap);
            logger.info("------百度翻译接口结束------");
        }
        if(code.equals(Constants.TR002)){
            logger.info("------有道翻译接口开始------");
            retMap = translateManager.queryForYoudaoTrans(bodyMap);
            logger.info("------有道翻译接口结束------");
        }

        //****************************    翻译类接口  结束    *******************************//
        //****************************    用户信息类接口  开始    *******************************//

        if(code.equals(Constants.YH001)){
            logger.info("------注册待审批用户接口开始------");
            retMap = xtYhInfoManager.addXtYh(bodyMap);
            logger.info("------注册待审批接口结束------");
        }
        if(code.equals(Constants.YH002)){
            logger.info("------审批待审批用户接口开始------");
            retMap = xtYhInfoManager.SpXtYhInfo(bodyMap);
            logger.info("------审批待审批用户接口结束------");
        }
        if(code.equals(Constants.YH003)){
            logger.info("------修改用户信息接口开始------");
            retMap = xtYhInfoManager.updateXtYh(bodyMap);
            logger.info("------修改用户信息接口结束------");
        }
        if(code.equals(Constants.YH005)){
            logger.info("------获取所有用户信息接口开始------");
            retMap = xtYhInfoManager.getAllXtYh(bodyMap);
            logger.info("------获取所有用户信息接口结束------");
        }
        if(code.equals(Constants.YH006)){
            logger.info("------获取待审批单个用户信息接口开始------");
            retMap = xtYhInfoManager.getDspXtYhInfoBySkey(bodyMap);
            logger.info("------获取待审批单个用户信息接口结束------");
        }
        if(code.equals(Constants.YH007)){
            logger.info("------获取单个系统用户信息接口开始------");
            retMap = xtYhInfoManager.getXtYhInfoBySkey(bodyMap);
            logger.info("------获取单个系统用户信息接口结束------");
        }
        if(code.equals(Constants.YH008)){
            logger.info("------删除待审批用户信息接口开始------");
            retMap = xtYhInfoManager.deleteDspXtYh(bodyMap);
            logger.info("------删除待审批用户信息接口结束------");
        }
        if(code.equals(Constants.YH004)){
            logger.info("------删除系统用户信息接口开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------删除系统用户信息接口结束------");
        }
        //****************************    用户信息类接口  结束    *******************************//
        //****************************    停车类接口  开始    *******************************//
        if(code.equals(Constants.PK001)){
            logger.info("------分页获取车位列表开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------分页获取车位列表结束------");
        }
        if(code.equals(Constants.PK002)){
            logger.info("------获取车位详情接口开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------获取车位详情接口结束------");
        }
        if(code.equals(Constants.PK003)){
            logger.info("------获取停车价格计划接口开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------获取停车价格计划接口结束------");
        }
        if(code.equals(Constants.PK004)){
            logger.info("------获取可用停车位数量接口开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------获取可用停车位数量接口结束------");
        }
        if(code.equals(Constants.PK005)){
            logger.info("------生成停车位预定订单接口开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------生成停车位预定订单接口结束------");
        }
        if(code.equals(Constants.PK006)){
            logger.info("------获取停车位图片列表接口开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------获取停车位图片列表接口结束------");
        }
        if(code.equals(Constants.PK007)){
            logger.info("------获取停车位图片列表接口开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------获取停车位图片列表接口结束------");
        }
        if(code.equals(Constants.PK008)){
            logger.info("------获取停车位图片列表接口开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------获取停车位图片列表接口结束------");
        }
        if(code.equals(Constants.PK009)){
            logger.info("------获取停车位图片列表接口开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------获取停车位图片列表接口结束------");
        }
        if(code.equals(Constants.PK010)){
            logger.info("------获取停车位图片列表接口开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------获取停车位图片列表接口结束------");
        }
        if(code.equals(Constants.PK011)){
            logger.info("------获取停车位图片列表接口开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------获取停车位图片列表接口结束------");
        }
        if(code.equals(Constants.PK012)){
            logger.info("------获取停车位图片列表接口开始------");
            retMap = xtYhInfoManager.deleteXtYh(bodyMap);
            logger.info("------获取停车位图片列表接口结束------");
        }
        if(code.equals(Constants.PK013)){
            logger.info("------获取停车公司列表接口开始------");
            retMap = parkManager.getParkCompanyList(bodyMap);
            logger.info("------获取停车公司列表接口结束------");
        }
        if(code.equals(Constants.PK014)){
            logger.info("------获取停车公司信息接口开始------");
            retMap = parkManager.getParkCompanyInfo(bodyMap);
            logger.info("------获取停车公司信息接口结束------");
        }
        if(code.equals(Constants.PK015)){
            logger.info("------获取停车公司车位列表接口开始------");
            retMap = parkManager.getParkCompanyCwList(bodyMap);
            logger.info("------获取停车公司车位列表接口结束------");
        }






        //****************************    停车类接口  结束    *******************************//
        //****************************    公共类接口  开始    *******************************//
        if(code.equals(Constants.UL001)){
            logger.info("------用户登录接口开始------");
            retMap = xtYhInfoManager.XtYhLogin(bodyMap);
            logger.info("------用户登录接口结束------");
        }
        if(code.equals(Constants.UL002)){
            logger.info("------用户注册接口开始------");
            retMap = xtYhInfoManager.addXtYh(bodyMap);
            logger.info("------用户注册接口结束------");
        }

        //****************************    公共类接口  结束    *******************************//
        //****************************    交流沟通类接口  开始    *******************************//

        if(code.equals(Constants.JLGT001)){
            logger.info("------用户获取公告信息接口开始------");
            retMap = jlgtManager.queryForGgxx(bodyMap);
            logger.info("------用户获取公告信息接口结束------");
        }
        if(code.equals(Constants.JLGT002)){
            logger.info("------用户获取公告详细信息接口开始------");
            retMap = jlgtManager.queryForGgxxxxById(bodyMap);
            logger.info("------用户获取公告详细信息接口结束------");
        }

        //****************************    交流沟通类接口  结束    *******************************//

        return  retMap;


    }



}
