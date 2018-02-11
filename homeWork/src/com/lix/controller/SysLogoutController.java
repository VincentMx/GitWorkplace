package com.lix.controller;

import cn.lix.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView logout(){

        ModelAndView mv = new ModelAndView();

        removeSessionAttribute("xtYh");
        removeSessionAttribute("yhId");

        removeSessionAttribute("yhName");
        removeSessionAttribute("yhSex");

        removeSessionAttribute("yhSkey");
        removeSessionAttribute("yhUnitKey");

        mv.addObject("hello");
        return mv;
    }






}
