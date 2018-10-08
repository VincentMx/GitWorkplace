package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtYhVO;
import com.lix.service.XtRzCzService;
import com.lix.service.XtRzDlService;
import com.lix.service.XtYhService;
import com.lix.service.XtZyService;
import com.lix.util.ObjectUtils;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
        Map<String , String> systemsMap = new HashMap<String, String>();

        try{
            //获取系统信息
            systemsMap.put("user_model" ,System.getenv("USERDOMAIN_ROAMINGPROFILE"));
            systemsMap.put("processorLevel" ,System.getenv("PROCESSOR_LEVEL")); //处理器级别
            systemsMap.put("address" ,System.getenv("address")); // 地址
            systemsMap.put("processorArchitecture" ,System.getenv("PROCESSOR_ARCHITECTURE")); //处理器的芯片体系结构
            systemsMap.put("username" ,System.getenv("USERNAME")); //用户名
            systemsMap.put("processorIdentifier" ,System.getenv("PROCESSOR_IDENTIFIER")); //处理器说明
            systemsMap.put("userdomain" ,System.getenv("USERDOMAIN")); //用户帐户的域的名称
            systemsMap.put("logonserver" ,System.getenv("LOGONSERVER")); //当前登录会话的域控制器的名称。
            systemsMap.put("fpsBrowserAppProfileString   " ,System.getenv("FPS_BROWSER_APP_PROFILE_STRING"));
            systemsMap.put("os" ,System.getenv("OS")); //操作系统名称
            systemsMap.put("computername" ,System.getenv("COMPUTERNAME")); //计算机的名称
            systemsMap.put("processorRevision" ,System.getenv("PROCESSOR_REVISION")); //处理器修订版本
            systemsMap.put("numberOfProcessors" ,System.getenv("NUMBER_OF_PROCESSORS")); //处理器数量







            // 获取人员数量
            UserCount = xtYhService.getXtYhCount(xt_yh);
            dlRzCount = xtYhService.getXtYhDlCount(xt_yh);
            czCount = xtYhService.getXtYhCzCount(xt_yh);
            yhSelfDlCount = xtYhService.getYhSelfDlCount(xt_yh);

            JSONArray jsonArray = JSONArray.fromObject(Integer.parseInt(UserCount));
            JSONArray dlArray = JSONArray.fromObject(Integer.parseInt(dlRzCount));
            JSONArray czArray = JSONArray.fromObject(Integer.parseInt(czCount));
            JSONArray yhSelfDlCountArray = JSONArray.fromObject(Integer.parseInt(yhSelfDlCount));
            JSONArray systemArr = JSONArray.fromObject(systemsMap);
            results = "{\"success\":\"true\",\"xtYhCount\":"+jsonArray.get(0)+",\"dlCount\":"+dlArray.get(0)+",\"czCount\":"+czArray.get(0)+",\"yhSelfDlCount\":"+ yhSelfDlCountArray.get(0) +",\"systemMap\":"+ systemArr.get(0) +"}";
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
