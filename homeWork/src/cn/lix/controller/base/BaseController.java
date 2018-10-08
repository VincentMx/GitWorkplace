package cn.lix.controller.base;

import com.lix.entity.Xt_yh;
import com.lix.service.XtYhService;
import com.lix.util.Logger;
import com.lix.util.Page;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.ArrayList;
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


    @Resource
    private XtYhService xtYhService;

    /**
     *@method:  @Resource(name = "org.apache.cxf.jaxws.context.WebServiceContextImpl")
     *@author: lix
     *@desc：
     *@Date: 10:34 2018/8/2
     *@param:
     *@return:
     *
     */
    private WebServiceContext context = new
            org.apache.cxf.jaxws.context.WebServiceContextImpl();


    public WebServiceContext getContext() {
        return context;
    }
    public void setContext(WebServiceContext context) {
        this.context = context;
    }


    /**
     *@method: 获取IP地址
     *@author: lix
     *@desc：
     *@Date: 10:47 2018/8/2
     *@param:
     *@return:
     *
     */
    public String getIp(){
        String ipAddress = null ;
        MessageContext ctx = context.getMessageContext();
        if(null==ctx){
            logger.error("********ctx====null**********");
        }
        HttpServletRequest request = (HttpServletRequest)ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
        ipAddress=request.getRemoteAddr();
        return  ipAddress;
    }


    /**
      *@method: 获取request的方法
      *@author: lix
      *@desc： 
      *@Date: 10:49 2018/8/2
      *@param: 
      *@return:   
      *
      */
    public HttpServletRequest getRequest2(){
        String ipAddress = null ;
        MessageContext ctx = context.getMessageContext();
        if(null==ctx){
            logger.error("********ctx====null**********");
        }
        HttpServletRequest request = (HttpServletRequest)ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
        
        return  request;
    }





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
      *@method: 添加在线人数
      *@author: lix
      *@desc： 
      *@Date: 18:15 2018/7/24
      *@param: 
      *@return:   
      *
      */
    protected  void saddRedisCatch(String skey , String valus){
        jedis.sadd(skey,valus);
    }


    /**
      *@method: 将用户信息以list 方式存储进入redis
      *@author: lix
      *@desc： 
      *@Date: 14:54 2018/7/27
      *@param: 
      *@return:   
      *
      */
    protected void lpushRedisCatch(String key ,  String value){
        jedis.lpush(key , value);
        

    }

    
    /**
      *@method: 
      *@author: lix
      *@desc： 
      *@Date: 8:40 2018/8/3
      *@param: 
      *@return:   
      *
      */
    protected void lremRedisCatch(){
        
    }
    
    /**
      *@method: 按分页的方式获取在线用户数
      *@author: lix
      *@desc： 
      *@Date: 14:57 2018/7/27
      *@param: 
      *@return:   
      *
      */
    protected Page lrangeRedisCatch(Page page, String key , String unit){
        List<Xt_yh> xtYhList = new ArrayList<Xt_yh>();
        List<String> skeyList = jedis.lrange(key , page.getStart() , page.getStart() + page.getPageSize() );
        if(skeyList != null){
            for (String skey : skeyList){
                Xt_yh xt_yh = new Xt_yh();
                xt_yh = xtYhService.fingById(skey , unit);
                xtYhList.add(xt_yh);
            }
        }else{
            xtYhList = null;
        }
       page.setTotalCount(jedis.llen(key));
       page.setData(xtYhList);
        return page;
    }


    protected void lremRedisCatch(String key , String value){
        jedis.lrem(key , -1 , value);
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
