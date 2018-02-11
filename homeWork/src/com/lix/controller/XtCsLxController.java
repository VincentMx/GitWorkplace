package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.XtCsLx;
import com.lix.entity.vo.XtCsLxVO;
import com.lix.service.XtCsLxService;
import com.lix.util.Page;
import com.lix.util.PageUtils;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 10:032018/1/22
 * @modify by :
 */

@RequestMapping("xtCsLx")
@Controller
public class XtCsLxController extends BaseController {


    @Resource
    private XtCsLxService xtCsLxService;



    /**
     *@method: 分页获取系统资源
     *@author: lix
     *@desc：
     *@Date: 15:17 2017/12/27
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/getXtCsLxWithPage.html")
    @ResponseBody
    public String getXtCsWithPage(XtCsLxVO xtCsLxVO, HttpServletRequest request, Integer start, Integer limit){
        String results = null;
        try{
            Page page = new Page(start,0,limit,null);
            page = xtCsLxService.getAllXtCsWithPage(xtCsLxVO,page);
            results = PageUtils.getExtjsPageJsonData(page);
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数查询时出现错误："+e.getMessage());
        }
        return  results;
    }


    /**
      *@method: 查找所有参数类型
      *@author: lix
      *@desc：
      *@Date: 11:11 2018/1/22
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/getAllXtCsLx.html")
    @ResponseBody
    public String getAllXtCslX(XtCsLxVO xtCsLxVO, HttpServletRequest request){
        String results = null;
        List<XtCsLx> list = new ArrayList<XtCsLx>();
        try{
            list = xtCsLxService.findAllXtCsLx(xtCsLxVO);
            JSONArray jsonArray = JSONArray.fromObject(list);
            results = "{\"success\":\"true\",\"results\":"+jsonArray+"}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数查询时出现错误："+e.getMessage());
        }
        return  results;
    }


    /**
      *@method: 保存或修改参数类型信息
      *@author: lix
      *@desc：
      *@Date: 11:14 2018/1/22
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/saveXtCsLx.html")
    @ResponseBody
    public  String saveXtCslX(XtCsLx xtCsLx, HttpServletRequest request){
        String results = null;
        try{
           xtCsLxService.saveXtCsLx(xtCsLx,request,getYh(request));
            results = "{\"success\":\"true\"}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数查询时出现错误："+e.getMessage());
        }
        return  results;
    }

    /**
      *@method: 删除系统参数类型信息
      *@author: lix
      *@desc： 
      *@Date: 11:43 2018/1/22
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/deleteXtCsLx.html")
    @ResponseBody
    public  String saveXtCslX(String skey, HttpServletRequest request){
        String results = null;
        try{
            xtCsLxService.deleteXtCsLx(skey,request,getYh(request));
            results = "{\"success\":\"true\"}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数查询时出现错误："+e.getMessage());
        }
        return  results;
    }


    /**
      *@method: 根据参数信息查询参数类型
      *@author: lix
      *@desc：
      *@Date: 11:22 2018/1/22
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/getXtCsLxByPara.html")
    @ResponseBody
    public  String saveXtCslX(XtCsLxVO xtCsLxVO, HttpServletRequest request){
        String results = null;
        XtCsLx xtCsLx = new XtCsLx();
        try{
           xtCsLx =  xtCsLxService.getXtCsLxByPara(xtCsLxVO);
           JSONArray j = JSONArray.fromObject(xtCsLx);
            results = "{\"success\":\"true\",\"results\":" + j+ "}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数查询时出现错误："+e.getMessage());
        }
        return  results;
    }










}
