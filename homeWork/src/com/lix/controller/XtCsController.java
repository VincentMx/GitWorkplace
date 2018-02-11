package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.XtCs;
import com.lix.entity.XtCsLx;
import com.lix.entity.vo.XtCsLxVO;
import com.lix.entity.vo.XtCsVO;
import com.lix.service.XtCsService;
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
 * @time : 15:092017/12/27
 * @modify by :
 */
@RequestMapping("/xtCs")
@Controller
public class XtCsController extends BaseController {

    @Resource
    private XtCsService xtCsService;

    
    /**
      *@method: 分页获取系统资源
      *@author: lix
      *@desc： 
      *@Date: 15:17 2017/12/27
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getXtCsWithPage.html")
    @ResponseBody
    public String getXtCsWithPage(XtCsVO xtCsVO, HttpServletRequest request,Integer start,Integer limit){
        String results = null;
        try{
            Page page = new Page(start,0,limit,null);
            page = xtCsService.getAllXtCsWithPage(xtCsVO,page);
            results = PageUtils.getExtjsPageJsonData(page);
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数查询时出现错误："+e.getMessage());
        }
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
    @RequestMapping(value = "/saveOrUpdateXtCs.html")
    @ResponseBody
    public String saveXtCs(XtCs xtCs, HttpServletRequest request){
        String results = null;
        try{
            xtCsService.saveOrUpdateXtCs(xtCs,request,getYh(request));
            results = "{\"success\":\"true\"}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数保存时出现错误："+e.getMessage());
        }
        return  results;
    }


    /**
      *@method: 删除系统参数操作
      *@author: lix
      *@desc： 
      *@Date: 15:48 2018/1/23
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/deleteXtCs.html")
    @ResponseBody
    public String deleteXtCs(String skey, HttpServletRequest request){
        String results = null;
        try{
            xtCsService.deleteXtCs(skey,request,getYh(request));
            results = "{\"success\":\"true\"}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行删除系统参数时出现错误："+e.getMessage());
        }
        return  results;
    }

    
    /**
      *@method: 获取所有系统参数
      *@author: lix
      *@desc： 
      *@Date: 16:09 2018/1/23
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/findAllXtCs.html")
    @ResponseBody
    public String getAllXtCs(XtCsVO xtCsVO, HttpServletRequest request){
        String results = null;
        try{
            List<XtCsVO> list = xtCsService.findAllXtCsByPara(xtCsVO);
            JSONArray j = JSONArray.fromObject(list);
            results = "{\"success\":\"true\",\"results\":"+ j  +"}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数查询时出现错误："+e.getMessage());
        }
        return  results;
    }


    /**
     *@method: 根据参数信息查询参数
     *@author: lix
     *@desc：
     *@Date: 11:22 2018/1/22
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/getXtCsByPara.html")
    @ResponseBody
    public  String saveXtCslX(XtCsVO xtCsVO, HttpServletRequest request){
        String results = null;
        XtCs xtCs = new XtCs();
        try{
            xtCs = xtCsService.getXtCsBySkey(xtCsVO.getSkey());
            JSONArray j = JSONArray.fromObject(xtCs);
            results = "{\"success\":\"true\",\"results\":" + j+ "}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数查询时出现错误："+e.getMessage());
        }
        return  results;
    }


}
