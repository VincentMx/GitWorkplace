package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.Xt_js;
import com.lix.entity.vo.XtJsVO;
import com.lix.service.XtJsService;
import com.lix.util.Page;
import com.lix.util.PageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : lix
 * @desc :
 * @time : 23:072017/11/26
 * @modify by :
 */
@Controller
@RequestMapping("/xtjs")
public class XtJsController extends BaseController{

    @Resource
    private XtJsService xtJsService;

    /**
      *@method: saveInfo
      *@author: lix
      *@desc： 保存角色操作
      *@Date: 23:24 2017/11/26
      *@param: xt_js
      *@param: request
      *@return: result
      *
      */
    @RequestMapping("/save")
    public String saveInfo(Xt_js xt_js, HttpServletRequest request){
        String result = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】添加角色信息 开始  ####################################################");
        try{
            if (xt_js != null){
                xtJsService.saveJs(xt_js,request,getYh(request));
            }
            result = "{success:true}";
        }catch (Exception e){
            result = "{success:false}";
            e.getMessage();
            System.out.println("--------系统在保存角色时出现："+e.getMessage());
        }
         logger.debug(result);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】添加角色信息 结束  ####################################################");

        return result;
    }


    /**
     *@method: 获取资源列表
     *@author: lix
     *@desc：
     *@Date: 16:01 2017/11/27
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/findAll.html")
    @ResponseBody
    public String getXtZyInfo(XtJsVO xtJsVO, HttpServletRequest request, Integer start, Integer limit){
        String results = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】根据角色获取资源列表信息 开始  ####################################################");
        try{
            Page page = new Page(start,0,limit,null);
            page = xtJsService.findAllJs(xtJsVO,page);
            results = PageUtils.getExtjsPageJsonData(page);
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("----------系统在获取角色列表时出现错误："+e.getMessage());
        }
        logger.debug(results);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】根据角色获取资源列表信息 结束  ####################################################");
        return results;
    }


    /**
      *@method: 删除角色信息
      *@author: lix
      *@desc： 
      *@Date: 19:46 2018/1/28
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/deleteXtJs.html")
    @ResponseBody
    public String deleteXtJs(Xt_js xt_js,HttpServletRequest request){
        String results = "";
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除角色信息 开始  ####################################################");
        try{
            xtJsService.updateJs(xt_js,request,getYh(request));
            results = "{\"success\":\"true\"}";
        }catch (Exception e){
            e.printStackTrace();
            results = "{\"success\":\"false\",\"msg\":"+e.getMessage()+"}";
        }
        logger.debug(results);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除角色信息 结束  ####################################################");
        return  results;
    }
}
