package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.XtRzDl;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtYhVO;
import com.lix.service.*;
import com.lix.util.ObjectUtils;
import com.lix.util.Page;
import com.lix.util.PageUtils;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static net.sf.json.JSONArray.fromObject;

/**
 * @author : lix
 * @desc :
 * @time : 0:042017/12/31
 * @modify by :
 */
@RequestMapping("tjCount")
@Controller
public class TjCountController extends BaseController {

    @Resource
    private XtZyService xtZyService;

    @Resource
    private XtRzDlService xtRzDlService;

    @Resource
    private XtYhService xtYhService;


    @Resource
    private XtRzCzService xtRzCzService;





    @RequestMapping(value = "/getAllCount.html")
    @ResponseBody
    public String getAllCount(HttpSession session){
        String results = null;
        String UserCount = null;
        XtYhVO xtYhVO = (XtYhVO) session.getAttribute("xt_yh");

        try{
            String a = "";
            // 获取人员数量
            //UserCount = userService.getUserCount(xtYhVO);
            // xtCsService.getAllXtCsWithPage(xtCsVO,page);
            results = null;
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数查询时出现错误："+e.getMessage());
        }
        return  results;
    }


    /**
      *@method: 获取数据统计信息
      *@author: lix
      *@desc： 
      *@Date: 10:39 2018/3/6
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getXtYhCount.html")
    @ResponseBody
    public String getXtYhCount(HttpSession session, HttpServletRequest request){
        String results = null;
        String UserCount = null;
        String dlRzCount = "";
        String czCount = "";
        String yhSelfDlCount = "";
        String nowXtYhCount = "";
        XtYhVO xtYhVO = (XtYhVO) session.getAttribute("xt_yh");
        Xt_yh xt_yh = getYh(request);

        try{
            // 获取人员数量
            UserCount = xtYhService.getXtYhCount(xt_yh);
            dlRzCount = xtYhService.getXtYhDlCount(xt_yh);
            czCount = xtYhService.getXtYhCzCount(xt_yh);
            yhSelfDlCount = xtYhService.getYhSelfDlCount(xt_yh);

            JSONArray jsonArray = JSONArray.fromObject(Integer.parseInt(UserCount));
            JSONArray dlArray = JSONArray.fromObject(Integer.parseInt(dlRzCount));
            JSONArray czArray = JSONArray.fromObject(Integer.parseInt(czCount));
            JSONArray yhSelfDlCountArray = JSONArray.fromObject(Integer.parseInt(yhSelfDlCount));
            results = "{\"success\":\"true\",\"xtYhCount\":"+jsonArray.get(0)+",\"dlCount\":"+dlArray.get(0)+",\"czCount\":"+czArray.get(0)+",\"yhSelfDlCount\":"+ yhSelfDlCountArray.get(0) +"}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数查询时出现错误："+e.getMessage());
        }
        return  results;
    }

    /**
      *@method: 获取用户信息
      *@author: lix
      *@desc：
      *@Date: 10:44 2018/3/6
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/getYhInfo.html")
    @ResponseBody
    public String getAllCount(HttpServletRequest request){
        String results = null;
        String UserCount = null;
        Map<String,Object> objectMap = new HashMap<String, Object>();
        Xt_yh xt_yh = getYh(request);
        try{
            objectMap = ObjectUtils.objectToMap(xt_yh);
            JSONArray jsonArray = JSONArray.fromObject(objectMap);
            results = "{\"success\":\"true\",\"results\":"+jsonArray.get(0)+"}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行参数查询时出现错误："+e.getMessage());
        }
        return  results;
    }


}
