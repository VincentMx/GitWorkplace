package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.boyang.core.util.StringUtils;
import com.lix.entity.XtDw;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtDwVO;
import com.lix.service.XtDwService;
import com.lix.util.Page;
import com.lix.util.PageUtils;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 15:122018/1/25
 * @modify by :
 */
@RequestMapping("/xtDw")
@Controller
public class XtDwController extends BaseController {

    @Resource
    private XtDwService xtDwService;



    /**
     *@method: 分页获取系统参数
     *@author: lix
     *@desc：
     *@Date: 15:17 2017/12/27
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/getXtDwWithPage.html")
    @ResponseBody
    public String getXtCsWithPage(XtDwVO xtDwVO, HttpServletRequest request, Integer start, Integer limit){
        String results = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取系统单位分页列表信息 开始  ####################################################");

        try{
            Page page = new Page(start,0,limit,null);
            page = xtDwService.getXtDwWithPage(page,xtDwVO,request,null);
            results = PageUtils.getExtjsPageJsonData(page);
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("---------系统在执行参数查询时出现错误："+e.getMessage());
        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取系统单位分页列表信息 结束  ####################################################");

        return  results;
    }


    /**
     *@method: 保存或者修改操作
     *@author: lix
     *@desc：
     *@Date: 15:46 2018/1/23
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/saveOrUpdateXtDw.html")
    @ResponseBody
    public String saveXtDw(XtDw xtDw, HttpServletRequest request){
        String results = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】保存或修改系统单位信息 开始  ####################################################");

        try{
            xtDwService.saveOrUpdate(xtDw,request,getYh(request));
            results = "{\"success\":\"true\"}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("------------系统在执行参数保存时出现错误："+e.getMessage());
        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】保存或修改系统单位信息 结束  ####################################################");

        return  results;
    }


    /**
     *@method: 删除系统单位操作
     *@author: lix
     *@desc：
     *@Date: 15:48 2018/1/23
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/deleteXtDw.html")
    @ResponseBody
    public String deleteXtCs(String skey, HttpServletRequest request){
        String results = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除系统单位信息 开始  ####################################################");
        try{
            xtDwService.deleteXtDwINFO(skey,request,getYh(request));
            results = "{\"success\":\"true\"}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行删除系统参数时出现错误："+e.getMessage());
        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除系统单位信息 结束  ####################################################");
        return  results;
    }


    /**
     *@method: 获取所有系统单位
     *@author: lix
     *@desc：
     *@Date: 16:09 2018/1/23
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/findAllXtDw.html")
    @ResponseBody
    public String getAllXtCs(XtDwVO xtDwVO, HttpServletRequest request){
        String results = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】查询系统单位列表信息 开始  ####################################################");
        try{
            List<XtDwVO> list = xtDwService.getAllXtDw(xtDwVO,request);
            JSONArray j = JSONArray.fromObject(list);
            results = "{\"success\":\"true\",\"results\":"+ j  +"}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("-------------系统在执行参数查询时出现错误："+e.getMessage());
        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】查询系统单位列表信息 结束  ####################################################");
        return  results;
    }


    /**
     *@method: 根据单位信息查询
     *@author: lix
     *@desc：
     *@Date: 11:22 2018/1/22
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/getXtDwByPara.html")
    @ResponseBody
    public  String saveXtCslX(XtDwVO xtDwVO, HttpServletRequest request){
        String results = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】查询系统单位信息 开始  ####################################################");
        XtDw xtDw1 = new XtDw();
        try{
            xtDw1 = xtDwService.getXtDwByParam(xtDwVO);
            JSONArray j = JSONArray.fromObject(xtDw1);
            results = "{\"success\":\"true\",\"results\":" + j+ "}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数查询时出现错误："+e.getMessage());
        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】查询系统单位信息 结束  ####################################################");
        return  results;
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
    @RequestMapping(value = "/findUnitTree.html")
    @ResponseBody
    public String getUnitTreeParnet(@RequestParam(value = "parentKey") String parentKey,@RequestParam(value = "type") String type,HttpServletRequest request){
        Xt_yh xt_yh = getYh(request);
        List<XtDw> list = null;
        if(type.equals("addTreeNodes")){
            list = xtDwService.getXtDwList(parentKey);
        }else {
            if(xt_yh != null && StringUtils.hasText(xt_yh.getUnit())){
                list = xtDwService.getXtDwList(parentKey,xt_yh.getUnit());
            }else{
                list = xtDwService.getXtDwList(parentKey,"620000000000");
            }
        }

        JSONArray jsonArray = JSONArray.fromObject(list);
        String  results = "{\"success\":\"true\",\"data\":" + jsonArray+ "}";
        return  results;
    }

}
