package com.lix.controller.park;

import cn.lix.controller.base.BaseController;
import com.lix.entity.ParkCompany;
import com.lix.entity.ParkCompanyDsp;
import com.lix.entity.ParkSf;
import com.lix.entity.ParkXx;
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
 * @desc :
 * @time : 20:122018/8/8
 * @modify by :
 */
@Controller
@RequestMapping("cwGsGl")
public class CwGsController extends BaseController {



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
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】通过公司添加车位信息 开始  ####################################################");
        String result = null;
        try{
            yhParkService.save(parkXx);
            result = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】通过公司添加车位信息 结束  ####################################################");
        logger.debug(result);
        return result;
    }


    /**
      *@method: 添加车位
      *@author: lix
      *@desc： 
      *@Date: 17:54 2018/8/24
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/addGsCw.html")
    @ResponseBody
    public String saveCw(ParkXx parkXx, String pcskey , HttpServletRequest request){
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】通过公司添加车位信息 开始  ####################################################");
        String result = null;
        try{
            yhParkService.save(pcskey , parkXx , getYh(request) , request);
            result = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】通过公司添加车位信息 结束  ####################################################");
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
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】通过公司添加车位收费信息 开始  ####################################################");
        String result = null;
        try{
            yhParkService.save(parkSf);
            result = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】通过公司添加车位收费信息 结束  ####################################################");
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
     *@method: 删除操作停车位公司
     *@author: lix
     *@desc： 删除
     *@Date: 13:52 2017/12/19
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/deleteParkCompanyDsp.html")
    @ResponseBody
    public String deleteCw(String skey,HttpServletRequest request){
        String result = "";
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除待审批车位公司信息 开始  ####################################################");
         try{
            yhParkService.deleteParkCompanyDsp(skey , request , getYh(request));
            result  = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("删除待审批车位公司失败"+e.getMessage());
        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除待审批车位公司信息 结束  ####################################################");
        logger.debug(result);
        return  result;
    }


    /**
     *@method: 分页查询停车位公司
     *@author: lix
     *@desc：
     *@Date: 9:10 2017/12/26
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/queryAllParkCompanyByPage.html")
    @ResponseBody
    public String queryDataWithPage(Integer start, Integer limit, ParkCompany parkCompany, HttpServletRequest request ){
        String result = null;
        String unitKey = "";
        try{
            // start = 0; limit = 10;
            Page page = new Page(start,0,limit,null);
            page = yhParkService.findAllParkCompany(page,parkCompany);
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
   **@method: 分页查询停车位公司待审批
     *@author: lix
     *@desc：
     *@Date: 9:10 2017/12/26
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/queryAllParkCompanyDspByPage.html")
    @ResponseBody
    public String queryDspDataWithPage(Integer start, Integer limit, ParkCompanyDsp parkCompany, HttpServletRequest request ){
        String result = null;
        String unitKey = "";
        try{
            // start = 0; limit = 10;
            Page page = new Page(start,0,limit,null);
            page = yhParkService.findAllParkCompanyDsp(page,parkCompany);
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
