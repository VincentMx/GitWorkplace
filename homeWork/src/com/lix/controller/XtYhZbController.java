package com.lix.controller;


import cn.lix.controller.base.BaseController;
import com.lix.entity.XtYhZb;
import com.lix.entity.XtZy;
import com.lix.entity.vo.XtYhZbVO;
import com.lix.service.XtYhZbService;
import com.lix.util.Page;
import com.lix.util.PageUtils;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 14:562017/11/27
 * @modify by :
 */
@Controller
@RequestMapping("/xtyhzb")
public class XtYhZbController extends BaseController{

    @Resource
    private XtYhZbService xtYhZbService;


    /**
      *@method: 获取账本信息列表
      *@author: lix
      *@desc：
      *@Date: 16:01 2017/11/27
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/findAll.html")
    @ResponseBody
    public String getXtZyInfo(XtYhZbVO xtYhZb, HttpServletRequest request){
        String result = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取系统账本列表信息 开始  ####################################################");
        try{
            List<XtYhZbVO> list = xtYhZbService.findXtYhZb(xtYhZb);
            JSONArray jsonArray = JSONArray.fromObject(list);
            result = "{\"success\":\"true\",\"result\":"+jsonArray+"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("-----------获取系统账本列表信息失败," + e.getMessage());
        }
        logger.debug(result);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取系统账本列表信息 结束  ####################################################");

        return result;
    }

    /**
      *@method: 分页查询账本数据
      *@author: lix
      *@desc： 
      *@Date: 12:56 2017/12/27
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getXtZdPageList.html")
    @ResponseBody
    public String getXtzyPageList(XtYhZbVO xtYhZbVO,XtZy xtZy,HttpServletRequest request,Integer start,Integer limit){
        String results = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取系统账本分页列表信息 开始  ####################################################");

        try{
            Page page = new Page(start,0,limit,null);
            page = xtYhZbService.findXtYhZbWithPage(page , xtYhZbVO);
            results = PageUtils.getExtjsPageJsonData(page);
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("----------获取系统账本分页列表信息失败," + e.getMessage());
        }
        logger.debug(results);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取系统账本分页列表信息 结束  ####################################################");

        return  results;
    }



    /**
      *@method: 保存系统账本的方法
      *@author: lix
      *@desc： 保存系统账本
      *@Date: 22:06 2017/11/29
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/saveXtZy.html")
    @ResponseBody
    public String addXtZy(XtYhZb xtYhZb,HttpServletRequest request){
        String result = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】添加系统账本信息 开始  ####################################################");
        try{
            if (xtYhZb != null){
                xtYhZbService.saveOrUpdate(xtYhZb);
                result = "{\"success\":\"true\"}";
            }else{
                result = "{\"success\":\"false\",\"msg\":\"保存账本为空！\"}";
            }
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("-------------添加系统账本信息失败 " + e.getMessage());
        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】添加系统账本信息 结束  ####################################################");
        return result;
    }


    /**
      *@method: 删除账本信息
      *@author: lix
      *@desc：
      *@Date: 15:17 2017/12/5
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/delete.html")
    @ResponseBody
    public String deleteInfo(String skey,HttpServletRequest request){
        String result = "";
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除系统账本信息 开始  ####################################################");
         try{
            if(!StringUtils.isEmpty(skey)){
                XtYhZbVO xtYhZbVO = new XtYhZbVO();
                xtYhZbVO.setSkey(skey);
                 xtYhZbService.deleteXtYhZb(xtYhZbVO);
                 result  = "{\"success\":\"true\"}";
            }else{
                result = "{\"success\":\"false\",\"msg\":\"主键为空！\"}";
            }

        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("----------删除账本失败"+e.getMessage());
        }
        logger.debug(result);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除系统账本信息 结束  ####################################################");
        return  result;
    }


    /**
      *@method: 根据编号获取账本信息
      *@author: lix
      *@desc： 
      *@Date: 14:04 2017/12/29
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getZbxxById.html")
    @ResponseBody
    public String getZyInfo(String skey,HttpServletRequest request){
        String result = "";
        try{
            XtYhZb xtYhZb = new XtYhZb();
             if(!StringUtils.isEmpty(skey)){
                 xtYhZb.setSkey(skey);
                 XtYhZb xtYhZb1 = xtYhZbService.findXtYhZb(xtYhZb);
                JSONArray jsonArray = JSONArray.fromObject(xtYhZb1);
                result  = "{\"success\":\"true\",\"results\":"+jsonArray+"}";
            }else{
                result = "{\"success\":\"false\",\"msg\":\"主键为空！\"}";
            }
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("获取账本失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }








}
