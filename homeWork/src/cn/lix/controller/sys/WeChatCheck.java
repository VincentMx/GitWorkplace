package cn.lix.controller.sys;

import cn.lix.controller.base.BaseController;
import cn.lix.dispatcher.EventDispatcher;
import cn.lix.dispatcher.MsgDispatcher;
import com.lix.util.WeChat.MessageUtil;
import com.lix.util.WeChat.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author : lix
 * @desc :微信公众号验证
 * @time : 19:422018/7/12
 * @modify by :
 */

@Controller
@RequestMapping(value = "core")
public class WeChatCheck extends BaseController {
    private Logger log = Logger.getLogger(WeChatCheck.class);

    private static String Token = "wslzlgdxlx";

    @RequestMapping(value = "/check.html",method = { RequestMethod.GET })
    public void doget(HttpServletRequest request, HttpServletResponse response, PrintWriter out){

        logger.info("#######################################################      微信验证接口 START         #######################################################################" );

        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");


        logger.info("接收到微信发送消息：signature:  " + signature + " --->  timestamp : " + timestamp + " --- >  nonce :  " + nonce + "--- > echostr :   " + echostr);
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
            logger.info("----------------------------------------微信服务器验证    成功----------------------------------------");
        } else {
            logger.info("----------------------------------------微信服务器验证    失败----------------------------------------");
        }
        out.flush();
        out.close();

        logger.info("#######################################################      微信验证接口  END        #######################################################################" );

    }

    /**
      *@method: 业务处理实体
      *@author: lix
      *@desc： 
      *@Date: 1:06 2018/7/13
      *@param: 
      *@return:   
      *
      */
    @RequestMapping(value = "/check.html", method = RequestMethod.POST)
    public void dopost(HttpServletRequest request,HttpServletResponse response){
        logger.info("#######################################################      微信请求服务 START         #######################################################################" );
        try{ 
            Map<String, String> map=MessageUtil.parseXml(request);
            String msgtype=map.get("MsgType");
            logger.info("------------------------------------请求的信息为： " + map.get("Content"));
            if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)){ 
                EventDispatcher.processEvent(map); //进入事件处理 
                 }else{ 
                MsgDispatcher.processMessage(map); 
                //进入消息处理 
                }
        }catch(Exception e){
            logger.error(e,e); 
        }

        logger.info("#######################################################      微信请求服务 END         #######################################################################" );

    }
}
