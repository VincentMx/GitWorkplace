package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.XtRzDl;
import com.lix.entity.vo.XtYhVO;
import com.lix.service.*;
import com.lix.util.Page;
import com.lix.util.PageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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



}
