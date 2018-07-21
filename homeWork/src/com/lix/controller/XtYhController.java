package com.lix.controller;

import cn.lix.constants.Constants;
import cn.lix.controller.base.BaseController;
import com.boyang.core.util.StringUtils;
import com.lix.entity.XtRzCz;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtDlRzVO;
import com.lix.entity.vo.XtYhVO;
import com.lix.service.XtYhService;
import com.lix.util.Page;
import com.lix.util.PageUtils;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : lix
 * @desc :
 * @time : 23:552017/11/29
 * @modify by :
 */
@Controller
@RequestMapping("/xt/user")
public class XtYhController extends BaseController {

    @Resource
    private XtYhService xtYhService;





    /**
      *@method: 根据编号获取用户信息
      *@author: lix
      *@desc： 
      *@Date: 0:03 2017/11/30
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public String getUserInfo(Xt_yh xt_yh,HttpServletRequest request){
        String result = null;
        Xt_yh xt_yh1 = new Xt_yh();
        try {
            xt_yh1 = xtYhService.findYhInfoById(xt_yh.getSkey());
            JSONArray jsonArray = JSONArray.fromObject(xt_yh1);
            result = "{\"success\":\"true\",\"results\":"+jsonArray+"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
        }
        return result;
    }



    /**
      *@method: 分页查询系统用户信息
      *@author: lix
      *@desc：
      *@Date: 16:13 2018/1/18
      *@param:
      *@return:
      *
      */
    @RequestMapping(value = "/queryAllXtYhByPage.html")
    @ResponseBody
    public String queryDataWithPage(Integer start, Integer limit, XtYhVO xtYhVO, HttpServletRequest request ){
        String result = null;
        try{
            // start = 0; limit = 10;
            xtYhVO.setUnit((String)request.getSession().getAttribute("yhUnitKey"));
            Page page = new Page(start,0,limit,null);
            page = xtYhService.getAllXtYh(page,xtYhVO,request);
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
     *@method: 新增系统用户信息
     *@author: lix
     *@desc：
     *@Date: 13:51 2017/12/19
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/addXtYh.html")
    @ResponseBody
    public String saveYhInfo(Xt_yh xt_yh, HttpServletRequest request){
        String result = null;
        try{
            xtYhService.saveYhInfo(xt_yh,request,getYh(request));
            result = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.debug(result);
        return result;
    }


    /**
     *@method: 删除系统用户信息
     *@author: lix
     *@desc： 删除
     *@Date: 13:52 2017/12/19
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/deleteXtYh.html")
    @ResponseBody
    public String deleteInfo(String skey,HttpServletRequest request){
        String result = "";
        try{
            xtYhService.deleteXtYh(skey,request,getYh(request));
            result  = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("删除用户失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }



    /**
     *@method: 删除系统用户信息
     *@author: lix
     *@desc： 删除
     *@Date: 13:52 2017/12/19
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/removeXtYh.html")
    @ResponseBody
    public String removeInfo(String skey,HttpServletRequest request){
        String result = "";
        XtRzCz xtRzCz = new XtRzCz();
        try{
            xtYhService.removeXtYh(skey,request,getYh(request));
            result  = "{\"success\":\"true\"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\"注销用户信息失败"+e.getMessage()+"\"}";
            logger.error("注销用户信息失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }

    /**
      *@method: 审批用户信息
      *@author: lix
      *@desc： 
      *@Date: 0:11 2018/6/28
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/SpXtYh.html")
    @ResponseBody
    public String SpYhInfo(String skey, String flag , String bz, HttpServletRequest request){
        String result = "";
        try{
            if(StringUtils.hasText(skey)){

                 if("001".equals(flag)){
                     xtYhService.SpYhInfo(skey, Constants.XtYhDsp_SPTG,bz);
                 }else if("002".equals(flag)){
                     xtYhService.SpYhInfo(skey,Constants.XtYhDsp_SPWTG,bz);
                 }
                result  = "{\"success\":\"true\"}";

            }else{
                result  = "{\"success\":\"false\",\"msg\":\"审批失败、主键不能为空\"}";
            }
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\"审批用户信息失败"+e.getMessage()+"\"}";
            logger.error("审批用户信息失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }



}
