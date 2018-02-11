package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.XtRzCz;
import com.lix.entity.vo.XtDlRzVO;
import com.lix.entity.vo.XtRzCzVO;
import com.lix.service.XtRzCzService;
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
 * @time : 13:462017/12/19
 * @modify by :
 */
@Controller
@RequestMapping("xtRzCz")
public class XtRzCzController extends BaseController {

    @Resource
    private XtRzCzService xtRzCzService;


    /**
      *@method: 新增操作日志
      *@author: lix
      *@desc：
      *@Date: 13:51 2017/12/19
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/addXtRzCz.html")
    @ResponseBody
    public String saveRzInfo(XtRzCz xtRzCz, HttpServletRequest request){
        String result = null;
        try{
            xtRzCzService.addXtCzRz(xtRzCz);
            result = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.debug(result);
        return result;
    }


    /**
      *@method: 获取全部日志操作
      *@author: lix
      *@desc： 获取全部的操作日志
      *@Date: 13:52 2017/12/19
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/findAllRzCz.html")
    @ResponseBody
    public String getXtDlRzInfo(XtRzCzVO xtRzCzVO, HttpServletRequest request, Integer start, Integer limit){
        String result = null;
        try{
            List<XtRzCzVO> list = xtRzCzService.findAllXtRzCz(xtRzCzVO);
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
      *@method: 删除操作日志信息
      *@author: lix
      *@desc： 删除操作日志
      *@Date: 13:52 2017/12/19
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/deleteRzCz.html")
    @ResponseBody
    public String deleteInfo(String skey,HttpServletRequest request){
        String result = "";
        XtRzCz xtRzCz = new XtRzCz();
        try{
            xtRzCz.setSkey(skey);
            xtRzCzService.DeleteXtRzCz(xtRzCz);
            result  = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("删除日志失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }



    /**
     *@method: 分页查询操作日志信息
     *@author: lix
     *@desc：
     *@Date: 9:10 2017/12/26
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/queryAllByPage.html")
    @ResponseBody
    public String queryDataWithPage(Integer start, Integer limit, XtRzCzVO xtRzCzVO, HttpServletRequest request ){
        String result = null;
        String unitKey = "";
        try{
            xtRzCzVO.setUnitKey((String)request.getSession().getAttribute("yhUnitKey"));
            // start = 0; limit = 10;
            Page page = new Page(start,0,limit,null);
            page = xtRzCzService.getAllRzCzByPage(xtRzCzVO,page);
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
