package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.Xt_yh;
import com.lix.entity.Xt_zy_cz;
import com.lix.service.XtZyCzService;
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
 * @desc : 资源操作的相关控制层
 * @time : 23:352017/12/6
 * @modify by :
 */
@RequestMapping(value = "/xtZyCz")
@Controller
public class XtZyCzController extends BaseController{
    
    @Resource
    private XtZyCzService xtZyCzService;
    
    /**
      *@method: 新增资源操作信息
      *@author: lix
      *@desc： 
      *@Date: 23:49 2017/12/6
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/saveOrUpdateXtZyCzInfo.html")
    @ResponseBody
    public String saveXtZyCzInfo(Xt_zy_cz xt_zy_cz, HttpServletRequest request){
        String result = null;
        String sfzh = (String)request.getSession().getAttribute("yhId");
        try{
            xtZyCzService.saveZyCzInfo(xt_zy_cz,request,sfzh);
            result = "{\"success\":\"true\"}";
        }catch (Exception e){
            logger.error("在saveOrUpdateXtZyCzInfo的方法执行中出现"+e.getMessage());
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
        }
        return  result;
    }
    
    /**
      *@method: 删除资源操作信息
      *@author: lix
      *@desc： 
      *@Date: 23:49 2017/12/6
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/deleteXtZyCzInfo.html")
    @ResponseBody
    public String deleteInfo(@RequestParam("skey") String skey,HttpServletRequest request){
        String result = null;
        Xt_zy_cz xt_zy_cz = new Xt_zy_cz();
        String sfzh = (String)request.getSession().getAttribute("yhId");

        try{
            xt_zy_cz.setSkey(skey);
            xtZyCzService.deleteXtZyCz(xt_zy_cz,request,sfzh);
            result = "{\"success\":\"true\"}";
        }catch (Exception e){
            logger.error("在deleteXtZyCzInfo的方法执行中出现"+e.getMessage());
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
        }
        return  result;
    }

    /**
      *@method: 查看资源详情
      *@author: lix
      *@desc： 
      *@Date: 23:50 2017/12/6
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/findXtZyCzInfo.html")
    @ResponseBody
    public String detailInfo(@RequestParam("skey") String skey,HttpServletRequest request){
        String result = null;
        Xt_zy_cz xt_zy_cz = new Xt_zy_cz();
        try{
           xt_zy_cz =  xtZyCzService.findById(skey);
           JSONArray jsonDate = JSONArray.fromObject(xt_zy_cz);
            result = "{\"success\":\"true\",\"results\":"+jsonDate+"}";
        }catch (Exception e){
            logger.error("在findXtZyCzInfo的方法执行中出现"+e.getMessage());
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
        }
        logger.debug(result);
        return  result;
    }

    /**
      *@method: 获取所有资源信息
      *@author: lix
      *@desc： 
      *@Date: 23:50 2017/12/6
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/findAllXtZyCzInfo.html")
    @ResponseBody
    public String fingAllInfo(Xt_zy_cz xt_zy_cz,HttpServletRequest request){
        String result = null;
        try{
            List<Xt_zy_cz> list =  xtZyCzService.findAllXtZyCz(xt_zy_cz);
            JSONArray jsonDate = JSONArray.fromObject(list);
            result = "{\"success\":\"true\",\"results\":\""+jsonDate+"\"}";
        }catch (Exception e){
            logger.error("在findAllXtZyCzInfo的方法执行中出现"+e.getMessage());
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
        }
        logger.debug(result);
        return  result;
    }


    /**
      *@method: 根据资源主键获取操作权限
      *@author: lix
      *@desc： 
      *@Date: 17:49 2018/1/8
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "getAllXtZyCzByResourcesId.html")
    @ResponseBody
    public String getInfoById(Xt_zy_cz xt_zy_cz ,HttpServletRequest request){
        String result = null;
        try{
            List<Xt_zy_cz> list =  xtZyCzService.findXtZyCzByResourcesId(xt_zy_cz);
            JSONArray jsonDate = JSONArray.fromObject(list);
            result = "{\"success\":\"true\",\"results\":"+jsonDate+"}";
        }catch (Exception e){
            logger.error("在getInfoById的方法执行中出现"+e.getMessage());
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
        }
        logger.debug(result);
        return  result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
