package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.XtYhDsp;
import com.lix.entity.XtZy;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtZyVO;
import com.lix.service.XtYhDspService;
import com.lix.util.Page;
import com.lix.util.PageUtils;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : lix
 * @desc :
 * @time : 23:142018/2/24
 * @modify by :
 */

@RequestMapping("/XtYhRegister")
@Controller
public class XtYhRegisterController extends BaseController {

    @Resource
    private XtYhDspService xtYhDspService;


    /**
      *@method: 分页获取待审批用户列表
      *@author: lix
      *@desc： 
      *@Date: 23:26 2018/2/24
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getXtYhDspPageList.html")
    @ResponseBody
    public String getXtzyPageList(XtYhDsp xtYhDsp , HttpServletRequest request, Integer start, Integer limit){
        String results = null;
        try{
            Xt_yh xt_yh = getYh(request);
            Page page = new Page(start,0,limit,null);
            page = xtYhDspService.getAllXtYhDspWithPage(page,xtYhDsp,xt_yh.getUnit());
            results = PageUtils.getExtjsPageJsonData(page);
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.printStackTrace();
        }
        logger.debug(request);
        return  results;
    }



    /**
      *@method: 注册用户信息
      *@author: lix
      *@desc： 
      *@Date: 23:29 2018/2/24
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/saveXtYhDsp.html")
    @ResponseBody
    public String addXtYhDsp(XtYhDsp xtYhDsp,HttpServletRequest request){
        String result = null;
        String sfzh = (String)request.getSession().getAttribute("yhId");
        try{
            if (xtYhDsp != null){
                xtYhDspService.addXtYhDspInfo(xtYhDsp); 
                result = "{\"success\":\"true\"}";
            }else{
                result = "{\"success\":\"false\",\"msg\":\"保存用户信息为空！\"}";
            }
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";

        }
        return result;
    }



    /**
      *@method: 删除注册用户信息
      *@author: lix
      *@desc： 
      *@Date: 23:35 2018/2/24
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/delete.html")
    @ResponseBody
    public String deleteInfo(String skey,HttpServletRequest request){
        String result = "";
        String sfzh = (String)request.getSession().getAttribute("yhId");
        try{
            if(!StringUtils.isEmpty(skey)){
                xtYhDspService.deleteXtYhDspInfoById(skey,sfzh);
                result  = "{\"success\":\"true\"}";
            }else{
                result = "{\"success\":\"false\",\"msg\":\"主键为空！\"}";
            }

        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("删除资源失败"+e.getMessage());
        }
        logger.debug(result);
        return  result;
    }


    /**
      *@method: 根据主键获取用户信息
      *@author: lix
      *@desc： 
      *@Date: 22:18 2018/7/2
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/findById.html")
    @ResponseBody
    public String getYhDspInfoInfo(String skey,HttpServletRequest request){
        String result = null;
        XtYhDsp xtYhDsp = new XtYhDsp();
        try {
            xtYhDsp = xtYhDspService.getXtYhDspInfoById(skey);
            JSONArray jsonArray = JSONArray.fromObject(xtYhDsp);
            result = "{\"success\":\"true\",\"results\":"+jsonArray+"}";
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
        }
        return result;
    }



}
