package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.XtGg;
import com.lix.service.XtGgService;
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
 * @desc :系统公告
 * @time : 15:492018/9/27
 * @modify by :
 */
@Controller
@RequestMapping("/xtgg")
public class XtGgController extends BaseController {

    @Resource
    private XtGgService xtGgService;


    /**
      *@method: 获取所有
      *@author: lix
      *@desc： 
      *@Date: 15:52 2018/9/27
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/findAll.html")
    @ResponseBody
    public String getXtGgInfo(XtGg xtGg, HttpServletRequest request){
        String result = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取公告列表信息 开始  ####################################################");
        try{
            List<XtGg> list = xtGgService.findAllXtGg(xtGg);
            JSONArray jsonArray = JSONArray.fromObject(list);
            result = "{\"success\":\"true\",\"result\":"+jsonArray+"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.getMessage();
        }
        logger.debug(result);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取公告列表信息 结束 ####################################################");

        return result;
    }

    /**
     *@method: 分页查询
     *@author: lix
     *@desc：
     *@Date: 12:56 2017/12/27
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/getXtGgPageList.html")
    @ResponseBody
    public String getXtGgPageList(XtGg xtGg, HttpServletRequest request, Integer start, Integer limit){
        String results = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取公告分页列表信息 开始  ####################################################");
        try{
            Page page = new Page(start,0,limit,null);
            page =  xtGgService.findXtGgWithPage(page , xtGg);
            results = PageUtils.getExtjsPageJsonData(page);
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.printStackTrace();
        }
        logger.debug(request);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】获取公告分页列表信息 结束  ####################################################");
        return  results;
    }



    /**
     *@method: 保存
     *@author: lix
     *@desc： 保存
     *@Date: 22:06 2017/11/29
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/saveXtGg.html")
    @ResponseBody
    public String addXtGg(XtGg xtGg,HttpServletRequest request){
        String result = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】添加公告信息 开始  ####################################################");

        try{
            if (xtGg != null){
                 xtGgService.saveOrUpdate(xtGg,getYh(request),request);
                result = "{\"success\":\"true\"}";
                logger.info("----------------  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】  添加公告【" + xtGg.getGgbt() + "】 成功");

            }else{
                result = "{\"success\":\"false\",\"msg\":\"保存资源为空！\"}";
                logger.info("----------------  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】  添加公告  失败 ，原因【公告信息为空】");

            }
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.info("----------------  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】  添加公告【" + xtGg.getGgbt() + "】 失败 ， 原因【" + e.getMessage() + "】");

        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】添加公告信息 结束  ####################################################");

        return result;
    }


    /**
      *@method: 检测用户信息
      *@author: lix
      *@desc： 
      *@Date: 18:53 2018/9/27
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/checkuser.html")
    @ResponseBody
    public String CheckUserInfo(String token,HttpServletRequest request){
        String result = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】发布公告前检测用户信息信息 开始  ####################################################");

        try{
            if (token != null){
                 boolean flag = xtGgService.checkUserInfo(getYh(request),token , request);
                 result = "{\"success\":\""+ flag +"\"}";
                logger.info("----------------  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】 检测身份信息  成功 ");

            }else{
                result = "{\"success\":\"false\",\"msg\":\"用户口令为空！\"}";
                logger.info("----------------  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】 检测身份信息  失败 ，原因 【用户口令为空】 ");

            }
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.info("----------------  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】 检测身份信息  失败 ，原因 【" + e.getMessage() + "】 ");


        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】发布公告前检测用户信息 结束  ####################################################");

        return result;
    }


    /**
      *@method: 审批公告信息
      *@author: lix
      *@desc： 
      *@Date: 18:55 2018/9/27
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/SpGgXX.html")
    @ResponseBody
    public String SpGgxx(String skey,HttpServletRequest request){
        String result = null;
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】发布公告信息 开始  ####################################################");

        try{
            if (skey != null){
                boolean flag =  xtGgService.SpGgxx(skey,getYh(request) , request);
                result = "{\"success\":\""+ flag +"\"}";
                logger.info("----------------  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】 发布公告【" + skey +"】成功 ");
            }else{
                result = "{\"success\":\"false\",\"msg\":\"主键为空！\"}";
                logger.info("----------------  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】 发布公告【" + skey +"】失败，原因：【主键为空】 ");

            }
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.info("----------------  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】 发布公告【" + skey +"】失败，原因：【" + e.getMessage() + "】 ");


        }
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】发布公告信息 结束  ####################################################");

        return result;
    }



    /**
     *@method: 删除
     *@author: lix
     *@desc：
     *@Date: 15:17 2017/12/5
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/deleteGg.html")
    @ResponseBody
    public String deleteInfo(String skey,HttpServletRequest request){
        String result = "";
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除公告信息 开始  ####################################################");

        try{
            if(!StringUtils.isEmpty(skey)){
                XtGg xtGg = new XtGg();
                xtGg.setSkey(skey);
                xtGgService.delete(xtGg , getYh(request),request );
                result  = "{\"success\":\"true\"}";
                logger.info("----------------  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】 删除公告【" + skey + "】信息  成功");

            }else{
                result = "{\"success\":\"false\",\"msg\":\"主键为空！\"}";
                logger.info("----------------  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】 删除公告【" + skey + "】信息  失败，原因 【 主键为空 】");
            }
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.info("----------------  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】 删除公告【" + skey + "】信息  失败，原因 【 " + e.getMessage() + " 】");
        }
        logger.debug(result);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】删除公告信息 结束  ####################################################");

        return  result;
    }


    /**
     *@method: 根据编号获取信息
     *@author: lix
     *@desc：
     *@Date: 14:04 2017/12/29
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/getXtGgById.html")
    @ResponseBody
    public String getXtGgInfo(String skey,HttpServletRequest request){
        String result = "";
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】根据编号获取公告信息 开始  ####################################################");

        try{

            XtGg xtGg1 =  xtGgService.findById(skey);
            JSONArray jsonArray = JSONArray.fromObject(xtGg1);
            result  = "{\"success\":\"true\",\"results\":"+jsonArray+"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("获取资源失败"+e.getMessage());
        }
        logger.debug(result);
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】根据编号获取公告信息 结束  ####################################################");

        return  result;
    }

    











}
