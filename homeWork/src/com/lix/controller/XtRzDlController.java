package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.XtRzDl;
import com.lix.entity.vo.XtDlRzVO;
import com.lix.service.XtRzDlService;
import com.lix.util.Page;
import com.lix.util.PageUtils;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 9:042017/12/14
 * @modify by :
 */
@RequestMapping("/xtRzDl")
@Controller
public class XtRzDlController extends BaseController {

    @Resource
    private XtRzDlService xtRzDlService;

    /**
    *@method: 保存用户登录日志
    *@author: lix
    *@desc： 保存登录日志
    *@Date: 9:08 2017/12/14
    *@param:
    *@return:
    *
    */
    @RequestMapping(value = "/add.html")
    @ResponseBody
    public String saveXtRzDl(XtRzDl xtRzDl, HttpServletRequest request){
        String result = null;
        try{
            xtRzDlService.addYhDlRz(xtRzDl);
            result = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.debug(result);
        return result;
    }


    /**
     *@method: 获取系统登录日志信息
     *@author: lix
     *@desc：
     *@Date: 16:01 2017/11/27
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/findAll.html")
    @ResponseBody
    public String getXtDlRzInfo(XtDlRzVO xtDlRzVO, HttpServletRequest request,Integer start,Integer limit){
        String result = null;
        try{
            List<XtDlRzVO> list = xtRzDlService.getAllYhDlRz(xtDlRzVO);
            JSONArray jsonArray = JSONArray.fromObject(list);
            result = "{\"success\":\"true\",\"result\":"+jsonArray+"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.debug(result);
        return result;
    }


    /**
     *@method: 删除日志信息
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
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除系统登录日志信息 开始  ####################################################");
        XtRzDl xtRzDl = new XtRzDl();
        try{
            xtRzDl.setSkey(skey);
            xtRzDlService.deleteYhDlRz(xtRzDl);
            result  = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("删除资源失败"+e.getMessage());
        }
        logger.debug(result);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除系统登录日志信息 开始  ####################################################");
        return  result;
    }
    
    /**
      *@method: 分页查询登录日志信息
      *@author: lix
      *@desc： 
      *@Date: 9:10 2017/12/26
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/queryAllDataByPage.html")
    @ResponseBody
    public String queryDataWithPage(Integer start,Integer limit,XtDlRzVO xtDlRzVO,HttpServletRequest request ){
        String result = null;
        try{
           // start = 0; limit = 10;
            xtDlRzVO.setUnitKey((String)request.getSession().getAttribute("yhUnitKey"));
            Page page = new Page(start,0,limit,null);
            page = xtRzDlService.getAllXtRzDlByParam(xtDlRzVO,page);
            result = PageUtils.getExtjsPageJsonData(page);
            //result = "{\"success\":\"true\",\"result\":"+jsonArray+"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.debug(result);
        return result;
    }

}
