package com.lix.controller;

import  com.lix.util.DateUtils;
import cn.lix.constants.Constants;
import cn.lix.controller.base.BaseController;
import com.lix.entity.XtRzDl;
import com.lix.entity.Xt_yh;
import com.lix.service.XtRzDlService;
import com.lix.service.XtYhService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 0:062017/11/30
 * @modify by :
 */
@Controller
@RequestMapping(value = "/sys/login")
public class SysLoginController extends BaseController {


    @Resource
    private XtYhService xtYhService;

    @Resource
    private XtRzDlService xtRzDlService;


    /**
     * @param request
     * @param response
     * @param xt_yh
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login.html")
    @ResponseBody
    public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response, Xt_yh xt_yh, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView();

        logger.info("对用户进行身份验证");
        if (xt_yh.getId() == null || xt_yh.getId() == "") {
            mv.addObject("errorInfo", "用户名为空！");
            mv.setViewName("hello");
            return mv;
        }

        logger.info("用户【"+xt_yh.getId()+"】进行验证");
        if (xt_yh.getPassword() == null || xt_yh.getPassword() == "") {
            mv.addObject("errorInfo", "密码为空！");
            mv.setViewName("hello");
            return mv;
        }

        Xt_yh xt_yh1 = xtYhService.findXtYhByPara(xt_yh);
        //密码验证
        if (xt_yh1 != null) {
            if (!xt_yh.getId().equals(xt_yh1.getId())) {
                mv.addObject("errorInfo", "用户名或密码错误");
                mv.setViewName("hello");
                return mv;
            }else if (xt_yh.getId().equals(xt_yh1.getId())){
//                session.setAttribute("User", xt_yh1); //用户信息的提取，需要重新设计
                mv.setViewName("console/main");
                mv.addObject("student", xt_yh1);
                mv.addObject("username", xt_yh1.getName());
                mv.addObject("user",xt_yh1);

            }
        }
        //单位验证
        //验证权限
        //保存用户session
        putLoginInfoToSession(request,xt_yh1);
        //暂存登录用户信息
        Constants.xtYhInfo.put(xt_yh1.getId(),xt_yh1);
        //将已登录用户信息存储至redis
       // putLoginUserToRedis(xt_yh);

        //修改用户信息
        xt_yh1.setLastip(request.getRemoteAddr());
        xt_yh1.setLasttime(DateUtils.getCurrDateTime());
        xtYhService.updateXtYhInfo(xt_yh1);
        //记录用户登录日志
        addLoginLog(request,xt_yh1);
        return mv;
    }

    @RequestMapping("/mian")
    public String getUserResources(ModelMap modelMap){

        return "";
    }



    /**
      *@method: 登录保存session
      *@author: lix
      *@desc： 保存session信息
      *@Date: 9:29 2017/12/13
      *@param: xt_yh
      *@return:
      *
      */
    private void putLoginInfoToSession(HttpServletRequest request,Xt_yh xt_yh)throws Exception{

        logger.info("用户信息进行Session缓存");
        HttpSession  session = request.getSession();
        session.setAttribute("xtYh",xt_yh);
        session.setAttribute("yhId",xt_yh.getId());
        session.setAttribute("yhName",xt_yh.getName());
        session.setAttribute("yhSex",xt_yh.getSex());
        session.setAttribute("yhSkey",xt_yh.getSkey());
        session.setAttribute("yhUnitKey",xt_yh.getUnit());
        logger.info("用户信息Session存储成功");

    }


    /***
     * 将用户信息存储至redis
     * @param xt_yh
     */
    public void putLoginUserToRedis(Xt_yh xt_yh){
        logger.info("将用户【"+ xt_yh.getId() +"】暂存至redis，操作开始");
        logger.info("判断【"+ xt_yh.getId() +"】是否已暂存至redis");
        if(getRedisCatch(Constants.ZXYH + xt_yh.getId()) == null){
            logger.info("用户【"+ xt_yh.getId() +"】未暂存至redis，开始暂存");
            setRedisCatch(Constants.ZXYH + xt_yh.getId(),xt_yh.getId());
        }else{
            logger.info("用户【"+ xt_yh.getId() +"】已经暂存至redis，不在重新存储。");
        }
        logger.info("用户【"+ xt_yh.getId() +"】暂存至redis，操作结束");
    }


    /**
      *@method: 添加登录日志
      *@author: lix
      *@desc： 登录日志操作
      *@Date: 12:58 2017/12/13
      *@param:
      *@return:
      *
      */
    private void addLoginLog(HttpServletRequest request,Xt_yh xt_yh)throws Exception{

        XtRzDl xtRzDl = new XtRzDl();
        xtRzDl.setIpAddress(request.getRemoteAddr());
        xtRzDl.setLoginTime(DateUtils.getCurrDateTime());
        xtRzDl.setUnitKey(xt_yh.getUnit());
        xtRzDl.setUserId(xt_yh.getId());
        xtRzDl.setUserName(xt_yh.getName());
        xtRzDl.setSysType(Constants.XTLX_BXT);
        xtRzDlService.addYhDlRz(xtRzDl);
    }


    @RequestMapping(value = "/login")
    public String userLogin(Xt_yh xt_yh, HttpSession session, RedirectAttributes redirectAttributes){
        if(xt_yh.getId() != null && xt_yh.getPassword() != null){
            redirectAttributes.addFlashAttribute("username",xt_yh.getId());
            logger.debug("对用户【"+xt_yh.getId()+"】进行登陆验证，验证开始");
            try{
                UsernamePasswordToken token =  new UsernamePasswordToken(xt_yh.getId(), xt_yh.getPassword(),getRequest().getRemoteAddr());
                SecurityUtils.getSubject().login(token);
                return "redirect:/index/main";
            }catch (UnknownAccountException uae){
                logger.error("对用户【"+xt_yh.getId()+"】进行验证，验证失败-用户名不存在");
                redirectAttributes.addFlashAttribute("msg","用户名不存在");
            }catch (DisabledAccountException ice){
                logger.error("对用户【"+xt_yh.getId()+"】进行厌憎，验证失败-用户无效");
                redirectAttributes.addFlashAttribute("msg","用户无效");
            }catch (AccountException ac){
                logger.error("对用户【"+xt_yh.getId()+"】进行登陆验证，验证失败-密码错误");
                redirectAttributes.addFlashAttribute("msg","账号密码不正确");
            }catch (AuthenticationException ae){
                redirectAttributes.addFlashAttribute("msg","用户无效");
                logger.error(ae.getMessage());
            }
         return "redirect:/portalogin";

        }
        redirectAttributes.addFlashAttribute("msg","用户名和密码不能为空");
        return  "redirect:/portalogin";
    }


    @RequestMapping(value = "/portalogin")
    public ModelAndView portalogin(){
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}


