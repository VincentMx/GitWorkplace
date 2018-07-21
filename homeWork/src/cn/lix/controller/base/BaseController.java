package cn.lix.controller.base;

import com.lix.entity.Xt_yh;
import com.lix.util.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 15:082017/11/27
 * @modify by :
 */
public class BaseController {

    //加载日志信息
    protected Logger logger = Logger.getLogger(this.getClass());

    //redis缓存设置
    Jedis jedis = new Jedis("localhost");


    /***
     * 得到yh信息
     */
    public static Xt_yh getYh(HttpServletRequest request){
        return (Xt_yh)request.getSession().getAttribute("xtYh");
    }



    /***
     * 得到用户身份证号
     */
    public static String getYhId(HttpServletRequest request){
        return (String) request.getSession().getAttribute("yhId");
    }

    /***
     * 得到Request对象
     */
    public HttpServletRequest getRequest(){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /***
     *
     * 将值放入session
     * @param key
     * @param value
     */
    protected void setSessionAttribute(String key,Object value){
        HttpSession session = this.getRequest().getSession();
        session.setAttribute(key,value);
    }


    /***
     * 获得session对象
     *
     * @param key
     * @return
     */
    protected Object getSessionAttribute(String key){
        HttpSession session = this.getRequest().getSession();
        return session.getAttribute(key)  ;
    }


    /**
     * 清楚session key
     *
     * @param key
     */
    protected void removeSessionAttribute(String key){
        HttpSession session = this.getRequest().getSession();
        session.removeAttribute(key);
    }

    /**
     * redis存放信息
     *
     * @param key
     * @param value
     */
    protected void setRedisCatch(String key,String value){
        jedis.set(key,value);
    }

    /**
     * 获取redis的信息
     *
     * @param key
     * @return
     */
    protected String getRedisCatch(String key){
        return jedis.get(key);
    }


    /***
     * 删除 key 所队形的信息
     * @param key
     */
    protected void deleteRedisCatch(String key){
        jedis.del(key);
    }


    /***
     * list 添加redis
     *
     * @param key
     * @param list
     */
    protected void setListRedis(String key, List<String> list){
        for (int i = 0; i < list.size(); i++) {
            jedis.rpush(key,list.get(i));
        }
    }


}
