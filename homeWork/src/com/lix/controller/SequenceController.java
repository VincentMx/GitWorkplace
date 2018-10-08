package com.lix.controller;

import cn.lix.controller.base.BaseController;
import com.lix.entity.Sequence;
import com.lix.service.SequenceService;
import com.lix.util.Page;
import com.lix.util.PageUtils;
import net.sf.json.util.JSONUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : lix
 * @desc :  序列化操作窗口
 * @time : 16:312018/9/20
 * @modify by :
 */
@Controller
@RequestMapping("/sequence")
public class SequenceController extends BaseController {


    @Resource
    private SequenceService sequenceService;




    /**
     *@method: 分页查询序列数据
     *@author: lix
     *@desc：
     *@Date: 12:56 2017/12/27
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/getSequencePageList.html")
    @ResponseBody
    public String getXtSequencePageList(Sequence sequence,  HttpServletRequest request, Integer start, Integer limit){
        String results = null;
        try{
            Page page = new Page(start,0,limit,null);
            page = sequenceService.findAllWithPage(page , sequence);
            results = PageUtils.getExtjsPageJsonData(page);
        }catch (Exception e){
            results = "{\"success\":\"false\",\"message\":"+e.getMessage()+"}";
            e.printStackTrace();
        }
        logger.debug(request);
        return  results;
    }



    /**
     *@method: 保存系统序列化的方法
     *@author: lix
     *@desc：
     *@Date: 22:06 2017/11/29
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/saveXtSequence.html")
    @ResponseBody
    public String addOrUpdateXtSequence(Sequence sequence,HttpServletRequest request){
        String result = null;
        String sfzh = (String)request.getSession().getAttribute("yhId");
        logger.info("用户【'" + sfzh + "'】,开始添加或修改序列化资源 ， 内容为：'"+ JSONUtils.valueToString(sequence) +"'");
        try{
            if (sequence != null){
                sequenceService.saveOrUpdate(sequence);
                result = "{\"success\":\"true\"}";
            }else{
                result = "{\"success\":\"false\",\"msg\":\"保存序列化资源为空！\"}";
            }
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";

        }
        logger.info("用户【'" + sfzh + "'】, 添加或修改序列化资源完成");
        return result;
    }


    /**
     *@method: 删除资源信息
     *@author: lix
     *@desc：
     *@Date: 15:17 2017/12/5
     *@param:
     *@return:
     *
     */
    @RequestMapping(value = "/delete.html")
    @ResponseBody
    public String deleteSequenceInfo(String name,HttpServletRequest request){
        String result = "";
        String sfzh = (String)request.getSession().getAttribute("yhId");
        logger.info("用户【'" + sfzh + "'】删除 name = 【'" + name + "'】 的序列化参数 start ");
        try{
            if(!StringUtils.isEmpty(name)){
                sequenceService.deleteSequence(name);
                result  = "{\"success\":\"true\"}";
            }else{
                logger.info("用户【'" + sfzh + "'】删除 name = 【'" + name + "'】 的序列化参数 ， name 为空 ");
                result = "{\"success\":\"false\",\"msg\":\"名称为空！\"}";
            }

        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
            logger.error("删除序列化资源失败"+e.getMessage());
        }
        logger.info("用户【'" + sfzh + "'】删除 name = 【'" + name + "'】 的序列化参数 end ");
        logger.debug(result);
        return  result;
    }





}
