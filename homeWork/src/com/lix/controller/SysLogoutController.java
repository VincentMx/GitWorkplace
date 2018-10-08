package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.Xt_yh;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : lix
 * @desc :
 * @time : 9:572018/1/25
 * @modify by :
 */

@RequestMapping(value = "/logout")
@Controller
public class SysLogoutController extends BaseController{


    
    /**
      *@method: 用户退出
      *@author: lix
      *@desc： 
      *@Date: 11:05 2018/1/25
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/logout.html")
    @ResponseBody
    public ModelAndView logout(HttpServletRequest request){
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】请求退出系统 开始  ####################################################");

        Xt_yh xt_yh = getYh(request);
        ModelAndView mv = new ModelAndView();

        removeSessionAttribute(xt_yh.getId());
        removeSessionAttribute(xt_yh.getName());


        //清除redis 缓存
        deleteRedisCatch(xt_yh.getId());

        //返回首页
        mv.addObject("hello");
        logger.info("############################################  用户【 "+ request.getRemoteAddr() +"：" + getYhId(request) + "】请求退出系统 结束  ####################################################");

        return mv;
    }






}
