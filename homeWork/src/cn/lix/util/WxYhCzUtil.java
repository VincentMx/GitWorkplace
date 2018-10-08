package cn.lix.util;

import com.lix.entity.XtYhWx;
import com.lix.service.XtYhWxService;
import com.lix.service.impl.XtYhWxServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : lix
 * @desc : 操作微信用户的方法  描述： 在微信用户请求的过程中、获取openid并记录下来、存进数据库
 *   然后想办法和用户信息挂钩、首先是实现统计微信用户的操作、其次、实现给用户发消息的时候、微信接收通知。包括各种操作。
 *   在这里可以实现多线程的运行
 * @time : 0:242018/9/7
 * @modify by :
 */
@Component
public class WxYhCzUtil {

    private  Logger logger = Logger.getLogger(WxYhCzUtil.class);



    @Autowired
    private XtYhWxService xtYhWxService;

    /**
      *@method: 把微信用户添加至数据库
      *@author: lix
      *@desc： 
      *@Date: 17:51 2018/9/10
      *@param: 
      *@return:   
      *
      */
    public  void addWxYh(String openId){

        logger.info("--------------- WxYhCzUtil：addWxYh  将微信用户添加进数据库开始");
        logger.info("--------------- openId:" + openId);
        XtYhWx xtYhWx = new XtYhWx();
        xtYhWx.setOpenid(openId);
        Thread thread = new Thread(){

            public void run(){

                try {
                  addWxYh(xtYhWx);

                } catch (Exception e) {
                    logger.error("++++++++++++++++++++++ 保存出错"+ e.getMessage());
                    e.printStackTrace();
                }
            }

        };

        logger.info("-------------- 开始调运线程  " + thread.getId());
        thread.start();

        logger.info("--------------- 将 【"  + openId+  "】添加至数据库成功");

    }



    public void addWxYh(XtYhWx xtYhWx) throws Exception {
        if(xtYhWxService == null){
            xtYhWxService = new XtYhWxServiceImpl();
        }
        xtYhWxService.save(xtYhWx);
    }


}
