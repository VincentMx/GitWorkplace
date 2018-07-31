package cn.lix.controller.redisUser;

import cn.lix.controller.base.BaseController;
import com.lix.service.XtYhService;
import com.lix.util.Page;
import com.lix.util.PageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : lix
 * @desc :
 * @time : 15:032018/7/27
 * @modify by :
 */
@Controller
@RequestMapping("/redisOnlineUser")
public class RedisOnlineUserController extends BaseController {

    @Resource
    private XtYhService xtYhService;

    /**
      *@method: 获取在线用户信息
      *@author: lix
      *@desc： 
      *@Date: 15:09 2018/7/27
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/getUserList")
    @ResponseBody
    public String getUserInfo(Integer start, Integer limit ,  HttpServletRequest request){
        String result = null;
        String key = "online_users";
        try {
            Page page = new Page(start,0,limit,null);
            page = lrangeRedisCatch(page , key ,  getYh(request).getUnit());
            result = PageUtils.getExtjsPageJsonData(page);
        }catch (Exception e){
            result = "{\"success\":\"false\",\"msg\":\""+e.getMessage()+"\"}";
        }
        logger.debug(result);
        return result;
    }

}
