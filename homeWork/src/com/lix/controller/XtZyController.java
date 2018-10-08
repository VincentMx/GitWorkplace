package com.lix.controller;


import cn.lix.controller.base.BaseController;
import com.lix.entity.XtZy;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtZyVO;
import com.lix.service.XtZyService;
import com.lix.util.Page;
import com.lix.util.PageUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 14:562017/11/27
 * @modify by :
 */
@Controller
@RequestMapping("/xtzy")
public class XtZyController extends BaseController{

    @Resource
    private XtZyService xtZyService;


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
    public String getXtZyInfo(XtZy xt_zy, HttpServletRequest request,Integer start,Integer limit){
        String result = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取系统资源列表信息 开始  ####################################################");
        try{
            List<XtZy> list = xtZyService.findAllXtZy(xt_zy);
            JSONArray jsonArray = JSONArray.fromObject(list);
   //         Page page = new Page(start + 1, 0 , limit, null);
            result = "{\"success\":\"true\",\"result\":"+jsonArray+"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("-----------获取系统资源列表信息失败," + e.getMessage());
        }
        logger.debug(result);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取系统资源列表信息 结束  ####################################################");

        return result;
    }

    /**
      *@method: 分页查询资源数据
      *@author: lix
      *@desc： 
      *@Date: 12:56 2017/12/27
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getXtZyPageList.html")
    @ResponseBody
    public String getXtzyPageList(XtZyVO xtZyVO,XtZy xtZy,HttpServletRequest request,Integer start,Integer limit){
        String results = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取系统资源分页列表信息 开始  ####################################################");

        try{
            Page page = new Page(start,0,limit,null);
            page = xtZyService.findXtZyByParam(page,xtZyVO);
            results = PageUtils.getExtjsPageJsonData(page);
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("----------获取系统资源分页列表信息失败," + e.getMessage());
        }
        logger.debug(request);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取系统资源分页列表信息 结束  ####################################################");

        return  results;
    }



    /**
      *@method: 保存系统资源的方法
      *@author: lix
      *@desc： 保存系统资源
      *@Date: 22:06 2017/11/29
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/saveXtZy.html")
    @ResponseBody
    public String addXtZy(XtZy xtZy,HttpServletRequest request){
        String result = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】添加系统资源信息 开始  ####################################################");
        String sfzh = (String)request.getSession().getAttribute("yhId");
        try{
            if (xtZy != null){
                xtZyService.saveXtZy(xtZy,request,sfzh);
                result = "{\"success\":\"true\"}";
            }else{
                result = "{\"success\":\"false\",\"msg\":\"保存资源为空！\"}";
            }
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("-------------添加系统资源信息失败 " + e.getMessage());
        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】添加系统资源信息 结束  ####################################################");
        return result;
    }


    /**
      *@method: 删除资源信息
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
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除系统资源信息 开始  ####################################################");
        String sfzh = (String)request.getSession().getAttribute("yhId");
        try{
            if(!StringUtils.isEmpty(skey)){
                xtZyService.deleteXtZyInfo(skey,request,sfzh);
                result  = "{\"success\":\"true\"}";
            }else{
                result = "{\"success\":\"false\",\"msg\":\"主键为空！\"}";
            }

        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("----------删除资源失败"+e.getMessage());
        }
        logger.debug(result);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除系统资源信息 结束  ####################################################");
        return  result;
    }


    /**
      *@method: 根据编号获取资源信息
      *@author: lix
      *@desc： 
      *@Date: 14:04 2017/12/29
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getZyXxById.html")
    @ResponseBody
    public String getZyInfo(String skey,HttpServletRequest request){
        String result = "";
        try{
            XtZy xtZy = new XtZy();
            if(!StringUtils.isEmpty(skey)){
                xtZy.setSkey(skey);
                XtZy xtZy1 =  xtZyService.findById(xtZy);
                JSONArray jsonArray = JSONArray.fromObject(xtZy1);
                result  = "{\"success\":\"true\",\"results\":"+jsonArray+"}";
            }else{
                result = "{\"success\":\"false\",\"msg\":\"主键为空！\"}";
            }
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("获取资源失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }


    /***
     * 加载资源树的操作
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/getZyTree.html")
    @ResponseBody
    public String tree(String id,HttpServletRequest request){
        List<Map<String,Object>> list = xtZyService.getTree(id);
        JSONArray jsonArray2 = new JSONArray();
        if(list.size() >= 1){
            for(Map<String,Object> str : list){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id",str.get("skey").toString());
                jsonObject.put("text",str.get("name").toString());

                if(str.get("parentkey").toString() != null && str.get("isparent").toString() != "1" ){
                    jsonObject.put("children",true);
                }else{
                    jsonObject.put("icon","fa fa-file greyicon");
                }
                jsonArray2.add(jsonObject);
            }
        }
        return  jsonArray2.toString();
    }


    /**
     *@method: 获取用户单位树
     *@author: lix
     *@desc：
     *@Date: 16:21 2018/3/6
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/findXtZyTree.html")
    @ResponseBody
    public String getXtZyTreeParnet(@RequestParam(value = "parentKey") String parentKey,@RequestParam(value = "type") String type,HttpServletRequest request){
        Xt_yh xt_yh = getYh(request);
        List<XtZy> list = null;
        if(type.equals("addTreeNodes")){
            list = xtZyService.getXtZyList(parentKey);
        }else {
            if(xt_yh != null && com.boyang.core.util.StringUtils.hasText(xt_yh.getUnit())){
                list = xtZyService.getXtZyList(parentKey,xt_yh.getUnit());
            }else{
                list = xtZyService.getXtZyList(parentKey,"620000000000");
            }
        }

        JSONArray jsonArray = JSONArray.fromObject(list);
        String  results = "{\"success\":\"true\",\"data\":" + jsonArray+ "}";
        return  results;
    }








}
