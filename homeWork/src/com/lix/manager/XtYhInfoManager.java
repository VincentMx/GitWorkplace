package com.lix.manager;

import cn.lix.config.BasicConfig;
import cn.lix.constants.Constants;
import cn.lix.constants.SystemErrorCode;
import cn.lix.controller.base.BaseController;
import com.alibaba.fastjson.JSON;
import com.lix.entity.XtRzDl;
import com.lix.entity.XtYhDsp;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.youdao.YoudaoBasicData;
import com.lix.service.XtRzDlService;
import com.lix.service.XtYhDspService;
import com.lix.service.XtYhService;
import com.lix.service.XtYhWxService;
import com.lix.util.DESCryptUtil;
import com.lix.util.DateUtils;
import com.lix.util.Logger;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : lix
 * @desc : 系统用户操作类
 * @time : 17:352018/7/7
 * @modify by :
 */
@Component
public class XtYhInfoManager extends BaseController{

    private static Logger logger = Logger.getLogger(XtYhInfoManager.class);



    @Autowired
    private XtYhDspService xtYhDspService;


    @Autowired
    private XtYhService xtYhService;


    @Autowired
    private XtRzDlService xtRzDlService;


    @Autowired
    private XtYhWxService xtYhWxService;



    /**
      *@method: 用户注册接口
      *@author: lix
      *@desc： 
      *@Date: 20:31 2018/7/7
      *@param: 
      *@return:   
      *
      */
    public Map<String , Object> addXtYh(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        XtYhDsp xtYhDsp = new XtYhDsp();

        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始注册待审批用户请求  START ****************************************");

        xtYhDsp.setId((String)bodyMap.get("id"));
        xtYhDsp.setMobile((String)bodyMap.get("mobile"));
        xtYhDsp.setPassword((String)bodyMap.get("password"));
        xtYhDsp.setName((String)bodyMap.get("id"));
        xtYhDsp.setUnit((String)bodyMap.get("unit"));
        xtYhDsp.setEmail((String)bodyMap.get("email"));

        Assert.hasText(xtYhDsp.getMobile(), "用户手机号不能为空！");
 //       Assert.hasText(xtYhDsp.getUnit(), "系统单位不能为空！");
        Assert.hasText(xtYhDsp.getId(),"用户id不能为空！");



        try{
            xtYhDspService.addXtYhDspInfo(xtYhDsp , getRequest2() , getYh(getRequest2()));

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
      *@method: 用户登录
      *@author: lix
      *@desc： 
      *@Date: 19:47 2018/8/1
      *@param: 
      *@return:   
      *
      */
    public Map<String , Object> XtYhLogin(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        Xt_yh xt_yh = new Xt_yh();

        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始登录请求  START ****************************************");




        Message message = PhaseInterceptorChain.getCurrentMessage();
        HttpServletRequest request2 = (HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);



        xt_yh.setId((String)bodyMap.get("id"));
        xt_yh.setPassword((String)bodyMap.get("password"));

        Assert.hasText(xt_yh.getPassword(), "密码不能为空！");
        Assert.hasText(xt_yh.getId(),"用户id不能为空！");



        try{
            logger.info("*********************************根据用户名和密码获取用户信息开始**********************");
            Xt_yh xt_yh1 =   xtYhService.findXtYhByPara(xt_yh);
            logger.info("*********************************根据用户名和密码获取用户信息结束**********************");

            if(xt_yh1 != null){
                logger.info("*********************************成功获取到用户信息**********************");

                //getRequest();
               // putLoginInfoToSession(xt_yh1);
                //暂存登录用户信息
                Constants.xtYhInfo.put(xt_yh1.getId(),xt_yh1);
                //将已登录用户信息存储至redis
                //将用户信息添加进
                 lpushRedisCatch("online_users" , xt_yh.getId());
                 setRedisCatch(Constants.ZXYH + xt_yh.getId() , xt_yh.getId());
                 putLoginUserToRedis(xt_yh);

                //修改用户信息
                xt_yh1.setLastip(request2.getRemoteAddr());
                xt_yh1.setLasttime(DateUtils.getCurrDateTime());
                xtYhService.updateXtYhInfo(xt_yh1);
                //记录用户登录日志
                addLoginLog(xt_yh1);

                String signStr =   DESCryptUtil.encrypt(JSON.toJSONString(xt_yh1), BasicConfig.DESKEY);

                retMap.put("token",signStr);
                retMap.put(SystemErrorCode.retcode, Constants.success);
                retMap.put(SystemErrorCode.retshow, Constants.success_msg);

            }else{
                logger.info("*********************************获取用户信息失败、用户名或密码错误**********************");

                retMap.put(SystemErrorCode.retcode, Constants.error);
                retMap.put(SystemErrorCode.retshow, "用户名或密码错误！");
            }

        }catch (Exception e){
            e.printStackTrace();
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, Constants.error_msg);

            logger.error("用户 " + (String)bodyMap.get("id") + " 在请求登录过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始登录请求 用户登录 END ****************************************");
        return retMap;

    }



    /**
     *@method: 登录保存session
     *@author: lix
     *@desc： 保存session信息
     *@Date: 9:29 2017/12/13
     *@param: xt_yh
     *@return:
     *
     */
    private void putLoginInfoToSession( Xt_yh xt_yh)throws Exception{

        logger.info("用户信息进行Session缓存");
        HttpSession session = getRequest().getSession();
        session.setAttribute("yhId" + xt_yh.getId(),xt_yh.getId());
        session.setAttribute("yhSkey",xt_yh.getSkey());
        logger.info("用户信息Session存储成功");

        //将用户信息添加进
        //  lpushRedisCatch("online_users" , xt_yh.getId());

        //  putLoginUserToRedis(xt_yh);

    }


    /***
     * 将用户信息存储至redis
     * @param xt_yh
     */
    public void putLoginUserToRedis(Xt_yh xt_yh){
        logger.info("将用户【"+ xt_yh.getId() +"】暂存至redis，操作开始");
        logger.info("判断【"+ xt_yh.getId() +"】是否已暂存至redis");
        if(getRedisCatch(Constants.ZXYH + xt_yh.getId()) == null){
            logger.info("用户【" + Constants.ZXYH + xt_yh.getId() +"】未暂存至redis，开始暂存");
            lpushRedisCatch("online_users",xt_yh.getId());
        }else{
            logger.info("用户【"+ xt_yh.getId() +"】已经暂存至redis，不在重新存储。");
        }
        logger.info("用户【"+ xt_yh.getId() +"】暂存至redis，操作结束");
    }


    /**
     *@method: 添加登录日志
     *@author: lix
     *@desc： 登录日志操作
     *@Date: 12:58 2017/12/13
     *@param:
     *@return:
     *
     */
    private void addLoginLog(Xt_yh xt_yh)throws Exception{

        Message message = PhaseInterceptorChain.getCurrentMessage();
        HttpServletRequest request2 = (HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);

        XtRzDl xtRzDl = new XtRzDl();
        xtRzDl.setIpAddress(request2.getRemoteAddr());
        xtRzDl.setLoginTime(DateUtils.getCurrDateTime());
        xtRzDl.setUnitKey(xt_yh.getUnit());
        xtRzDl.setUserId(xt_yh.getId());
        xtRzDl.setUserName(xt_yh.getName());
        xtRzDl.setSysType(Constants.XTLX_BXT);
        xtRzDlService.addYhDlRz(xtRzDl);
    }







    /**
      *@method: 审批系统用户信息
      *@author: lix
      *@desc： 
      *@Date: 20:32 2018/7/7
      *@param: 
      *@return:   
      *
      */
    public Map<String , Object> SpXtYhInfo(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 审批 待审批用户 START ****************************************");

        String skey = (String)bodyMap.get("skey");
        String flag = (String)bodyMap.get("flag");
        String bz   = (String)bodyMap.get("bz");

        Assert.hasText(skey,"用户主键为空！");
        Assert.hasText(flag, "审批状态为空！");


        try{
            xtYhService.SpYhInfo(skey,flag,bz , getRequest2(),getYh(getRequest2()));

            retMap.put(SystemErrorCode.retcode, Constants.success);
            retMap.put(SystemErrorCode.retshow, Constants.success_msg);
        }catch (Exception e){
            e.printStackTrace();
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, Constants.error_msg);
            logger.error("用户 " + (String)bodyMap.get("id") + " 在请求审批待审批用户过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 审批待审批用户 END ****************************************");
        return retMap;

    }

    /**
      *@method: 修改系统用户信息
      *@author: lix
      *@desc：
      *@Date: 20:32 2018/7/7
      *@param:
      *@return:
      *
      */
    public Map<String , Object> updateXtYh(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        YoudaoBasicData youdaoBasicData = new YoudaoBasicData();
        Xt_yh xtyh = new Xt_yh();
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 修改用户信息 START ****************************************");

        xtyh.setSkey((String)bodyMap.get("skey"));
        xtyh.setId((String)bodyMap.get("id"));
        xtyh.setName((String)bodyMap.get("name"));
        xtyh.setSex((String)bodyMap.get("sex"));
        xtyh.setUnit((String)bodyMap.get("unit"));
        xtyh.setPassword((String)bodyMap.get("password"));
        xtyh.setPhone((String)bodyMap.get("phone"));
        xtyh.setAddress((String)bodyMap.get("address"));
        xtyh.setEmail((String)bodyMap.get("email"));
        xtyh.setFlag((String)bodyMap.get("flag"));
        xtyh.setBz((String)bodyMap.get("bz"));
        xtyh.setMobile((String)bodyMap.get("mobile"));
        try{

            xtYhService.updateXtYhInfo(xtyh);
            retMap.put(SystemErrorCode.retcode, Constants.success);
            retMap.put(SystemErrorCode.retshow, Constants.success_msg);


        }catch (Exception e){
            e.printStackTrace();
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, Constants.error_msg);
            logger.error("用户 " + (String)bodyMap.get("id") + " 在请求修改用户信息过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 修改用户信息 END ****************************************");
        return retMap;

    }

    /**
      *@method: 删除系统用户信息
      *@author: lix
      *@desc：
      *@Date: 20:32 2018/7/7
      *@param:
      *@return:
      *
      */
    public Map<String , Object> deleteXtYh(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        Xt_yh xtYh = new Xt_yh();
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 删除系统用户信息 START ****************************************");

        String skey = (String)bodyMap.get("skey");
        try{

            xtYhService.deleteXtYh(skey , getRequest(),getYh(getRequest()));
            retMap.put(SystemErrorCode.retcode, Constants.success);
            retMap.put(SystemErrorCode.retshow, Constants.success_msg);


        }catch (Exception e){
            e.printStackTrace();
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, Constants.error_msg);
            logger.error("用户 " + (String)bodyMap.get("id") + " 在请求删除系统用户过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 删除系统用户信息 END ****************************************");
        return retMap;

    }

    /**
      *@method: 修改待审批系统用户信息
      *@author: lix
      *@desc： 
      *@Date: 20:07 2018/7/9
      *@param: 
      *@return:   
      *
      */
    public Map<String , Object> deleteDspXtYh(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        Xt_yh xtYh = new Xt_yh();
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 删除待审批系统用户信息 START ****************************************");

        String skey = (String)bodyMap.get("skey");
        String id = (String)bodyMap.get("id");

        Assert.hasText(skey,"用户主键为空！");
        Assert.hasText(id,"用户id为空！");
        try{

            xtYhDspService.deleteXtYhDspInfoById(skey,id,getRequest2());
            retMap.put(SystemErrorCode.retcode, Constants.success);
            retMap.put(SystemErrorCode.retshow, Constants.success_msg);


        }catch (Exception e){
            e.printStackTrace();
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, Constants.error_msg);
            logger.error("用户 " + (String)bodyMap.get("id") + " 在请求删除待审批系统用户过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 删除待审批系统用户信息 END ****************************************");
        return retMap;

    }


    /**
      *@method: 根据主键获取系统用户信息
      *@author: lix
      *@desc： 
      *@Date: 20:02 2018/7/9
      *@param: 
      *@return:   
      *
      */
    public Map<String , Object> getXtYhInfoBySkey(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        Xt_yh xtYh = new Xt_yh();
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 huo获取系统用户信息 START *************************************");

        String skey = (String)bodyMap.get("skey");
        Assert.hasText(skey,"用户主键不能为空");
        try{

            xtYh = xtYhService.findYhInfoById(skey);
            retMap.put("result",xtYh);
            retMap.put(SystemErrorCode.retcode, Constants.success);
            retMap.put(SystemErrorCode.retshow, Constants.success_msg);


        }catch (Exception e){
            e.printStackTrace();
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, Constants.error_msg);
            logger.error("用户 " + (String)bodyMap.get("id") + " 在请求获取系统用户过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 获取系统用户信息 END ****************************************");
        return retMap;

    }

    /**
      *@method: 获取待审批系统信息
      *@author: lix
      *@desc： 
      *@Date: 20:05 2018/7/9
      *@param: 
      *@return:   
      *
      */
    public Map<String , Object> getDspXtYhInfoBySkey(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
       XtYhDsp xtyhDsp = new XtYhDsp();
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 huo获取系统用户信息 START *************************************");

        String skey = (String)bodyMap.get("skey");
        Assert.hasText(skey,"用户主键不能为空");
        try{

            xtyhDsp = xtYhDspService.getXtYhDspInfoById(skey);
            retMap.put("result",xtyhDsp);
            retMap.put(SystemErrorCode.retcode, Constants.success);
            retMap.put(SystemErrorCode.retshow, Constants.success_msg);


        }catch (Exception e){
            e.printStackTrace();
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, Constants.error_msg);
            logger.error("用户 " + (String)bodyMap.get("id") + " 在请求获取系统用户过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 获取系统用户信息 END ****************************************");
        return retMap;

    }



    /**
      *@method: 查找系统用户信息
      *@author: lix
      *@desc：
      *@Date: 20:33 2018/7/7
      *@param:
      *@return:
      *
      */
    public Map<String , Object> getAllXtYh(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        YoudaoBasicData youdaoBasicData = new YoudaoBasicData();
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 有道 翻译 END ****************************************");

        String query = (String)bodyMap.get("queryStr");
        String skey = (String)bodyMap.get("skey");
        String id = (String)bodyMap.get("id");


        try{


            retMap.put(SystemErrorCode.retcode, Constants.success);
            retMap.put(SystemErrorCode.retshow, Constants.success_msg);

        }catch (Exception e){
            e.printStackTrace();
            retMap.put(SystemErrorCode.retcode, Constants.error);
            retMap.put(SystemErrorCode.retshow, Constants.error_msg);
            logger.error("用户 " + (String)bodyMap.get("id") + " 在请求有道翻译过程中出现异常 ：" + e.getMessage());
        }
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 有道 翻译 END ****************************************");
        return retMap;

    }

    /**
      *@method: 获取单个系统用户
      *@author: lix
      *@desc：
      *@Date: 20:33 2018/7/7
      *@param:
      *@return:
      *
      */
    public Map<String , Object> getXtYh(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        YoudaoBasicData youdaoBasicData = new YoudaoBasicData();
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 有道 翻译 END ****************************************");

        String query = (String)bodyMap.get("queryStr");
        try{

            String resMsg = null;
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

    /**
      *@method: 注销系统用户
      *@author: lix
      *@desc： 
      *@Date: 20:34 2018/7/7
      *@param: 
      *@return:   
      *
      */
    public Map<String , Object> removeXtYh(Map<String , Object> bodyMap){
        Map<String , Object> retMap = new HashMap<String, Object>();
        YoudaoBasicData youdaoBasicData = new YoudaoBasicData();
        logger.info("****************************************用户" + (String)bodyMap.get("id")+ " 开始请求 有道 翻译 END ****************************************");

        String query = (String)bodyMap.get("queryStr");
        try{

            String resMsg = null;
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




}
