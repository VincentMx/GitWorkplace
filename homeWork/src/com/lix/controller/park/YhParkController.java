package com.lix.controller.park;

import cn.lix.controller.base.BaseController;
import com.lix.entity.*;
import com.lix.entity.vo.CwxxVO;
import com.lix.entity.vo.XtCsVO;
import com.lix.entity.vo.XtRzCzVO;
import com.lix.service.XtRzCzService;
import com.lix.service.YhParkService;
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
 * @desc :用户停车信息表
 * @time : 23:162018/5/2
 * @modify by :
 */
@Controller
@RequestMapping("yhPark")
public class YhParkController extends BaseController{



    @Resource
    private YhParkService yhParkService;



    @Resource
    private XtRzCzService xtRzCzService;


    /**
     *@method: 新增车位
     *@author: lix
     *@desc：
     *@Date: 13:51 2017/12/19
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/addCw.html")
    @ResponseBody
    public String saveCwInfo(ParkXx parkXx, HttpServletRequest request){
        String result = null;
        try{
            yhParkService.save(parkXx);
            result = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.debug(result);
        return result;
    }


    /**
      *@method: 新增收费信息
      *@author: lix
      *@desc： 
      *@Date: 19:07 2018/6/26
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/addSf.html")
    @ResponseBody
    public String saveSfInfo(ParkSf parkSf, HttpServletRequest request){
        String result = null;
        try{
            yhParkService.save(parkSf);
            result = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.debug(result);
        return result;
    }
    
    /**
     *@method: 获取全部日志车位
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
     *@method: 删除操作车位
     *@author: lix
     *@desc： 删除操作日志
     *@Date: 13:52 2017/12/19
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/deleteCw.html")
    @ResponseBody
    public String deleteCw(String skey,HttpServletRequest request){
        String result = "";
        ParkXx parkXx = new ParkXx();
        try{
            parkXx.setSkey(skey);
            yhParkService.delete(parkXx);
            result  = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("删除日志失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }


    /**
      *@method: 修改车位信息
      *@author: lix
      *@desc： 
      *@Date: 20:25 2018/6/6
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/updateCw.html")
    @ResponseBody
    public String updateCw(ParkXx parkXx ,HttpServletRequest request){
        String result = "";
        try{
            yhParkService.update(parkXx);
            result  = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("修改日志失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }

    /**
      *@method: 修改车辆信息
      *@author: lix
      *@desc： 
      *@Date: 20:25 2018/6/6
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/updateCl.html")
    @ResponseBody
    public String updateCw(ClXx clXx ,HttpServletRequest request){
        String result = "";
        try{
            yhParkService.update(clXx);
            result  = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("修改车辆失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }

    /**
      *@method: 修改收费信息
      *@author: lix
      *@desc： 
      *@Date: 20:24 2018/6/6
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/updateSf.html")
    @ResponseBody
    public String updateCw(ParkSf parkSf ,HttpServletRequest request){
        String result = "";
        try{
            yhParkService.update(parkSf);
            result  = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("修改收费信息失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }

    /**
      *@method: 删除收费
      *@author: lix
      *@desc：
      *@Date: 20:20 2018/6/6
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/deleteSf.html")
    @ResponseBody
    public String deleteSf(String skey,HttpServletRequest request){
        String result = "";
        ParkSf parkSf = new ParkSf();
        try{
            parkSf.setSkey(skey);
            yhParkService.delete(parkSf);
            result  = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("删除收费信息失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }


    /**
      *@method: 删除车辆
      *@author: lix
      *@desc：
      *@Date: 20:20 2018/6/6
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/deleteCl.html")
    @ResponseBody
    public String deleteCl(String skey,HttpServletRequest request){
        String result = "";
        ClXx clXx = new ClXx();
        try{
            clXx.setSkey(skey);
            yhParkService.delete(clXx);
            result  = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("删除车辆失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }






    /**
     *@method: 分页查询车位
     *@author: lix
     *@desc：
     *@Date: 9:10 2017/12/26
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/queryAllCwByPage.html")
    @ResponseBody
    public String queryDataWithPage(Integer start, Integer limit, CwxxVO cwxxVO, HttpServletRequest request ){
        String result = null;
        String unitKey = "";
        try{
            // start = 0; limit = 10;
            Page page = new Page(start,0,limit,null);
            page = yhParkService.findAllParkxx(page,cwxxVO);
            result = PageUtils.getExtjsPageJsonData(page);
            //result = "{\"success\":\"true\",\"result\":"+jsonArray+"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.debug(result);
        return result;
    }

    /**
      *@method: 获取收费信息
      *@author: lix
      *@desc：
      *@Date: 22:34 2018/6/5
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/queryAllParkSfByPage.html")
    @ResponseBody
    public String queryClSfDataWithPage(Integer start, Integer limit, ParkSf parkSf, HttpServletRequest request ){
        String result = null;
        String unitKey = "";
        try{
            // start = 0; limit = 10;
            Page page = new Page(start,0,limit,null);
            page = yhParkService.findAllParkSf(page , parkSf);
            result = PageUtils.getExtjsPageJsonData(page);
            //result = "{\"success\":\"true\",\"result\":"+jsonArray+"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.debug(result);
        return result;
    }

    /**
      *@method: 获取交易信息
      *@author: lix
      *@desc：
      *@Date: 22:34 2018/6/5
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/queryAllJyDataByPage.html")
    @ResponseBody
    public String queryJyDataWithPage(Integer start, Integer limit, ParkCl parkCl, HttpServletRequest request ){
        String result = null;
        String unitKey = "";
        try{
            // start = 0; limit = 10;
            Page page = new Page(start,0,limit,null);
            page = yhParkService.findAllParkCl(page , parkCl);
            result = PageUtils.getExtjsPageJsonData(page);
            //result = "{\"success\":\"true\",\"result\":"+jsonArray+"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.debug(result);
        return result;
    }


    /**
      *@method: 车辆停车位查询
      *@author: lix
      *@desc： 
      *@Date: 21:45 2018/6/7
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getParkClBySkey.html")
    @ResponseBody
    public  String findParkClByParam(ParkCl parkCl, HttpServletRequest request){
        String results = null;
        ParkCl parkCl1 = new ParkCl();
        try{
            parkCl1 = yhParkService.findpARKcLByParam(parkCl);
            JSONArray j = JSONArray.fromObject(parkCl1);
            results = "{\"success\":\"true\",\"results\":" + j+ "}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行车位车辆绑定查询时出现错误："+e.getMessage());
        }
        return  results;
    }
    
    /**
      *@method: 停车收费查询
      *@author: lix
      *@desc： 
      *@Date: 21:46 2018/6/7
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getParkSfBySkey.html")
    @ResponseBody
    public  String findParkSfByParam(ParkSf parkSf , HttpServletRequest request){
        String results = null;
       ParkSf parkSf1 = new ParkSf();
        try{
            parkSf1 = yhParkService.findParkSfByParam(parkSf);
            JSONArray j = JSONArray.fromObject(parkSf1);
            results = "{\"success\":\"true\",\"results\":" + j+ "}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行收费信息查询时出现错误："+e.getMessage());
        }
        return  results;
    }
    
    /**
      *@method: 车辆信息查询
      *@author: lix
      *@desc： 
      *@Date: 21:46 2018/6/7
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getClxxBySkey.html")
    @ResponseBody
    public  String findClxxByParam(ClXx clXx, HttpServletRequest request){
        String results = null;
        ClXx clXx1 = new ClXx();
        try{
            clXx1 = yhParkService.findClxxByParam(clXx);
            JSONArray j = JSONArray.fromObject(clXx1);
            results = "{\"success\":\"true\",\"results\":" + j+ "}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行车辆查询时出现错误："+e.getMessage());
        }
        return  results;
    }
    
    /**
      *@method: 车位信息查询
      *@author: lix
      *@desc： 
      *@Date: 21:46 2018/6/7
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getCwxxBySkey.html")
    @ResponseBody
    public  String findCwxxByParam(CwxxVO cwxxVO, HttpServletRequest request){
        String results = null;
       CwxxVO cwxxVO1 = new CwxxVO();
        try{
             cwxxVO1 = yhParkService.findCwByParam(cwxxVO);
            JSONArray j = JSONArray.fromObject(cwxxVO1);
            results = "{\"success\":\"true\",\"results\":" + j+ "}";
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            logger.error("系统在执行车位查询时出现错误："+e.getMessage());
        }
        return  results;
    }

}
