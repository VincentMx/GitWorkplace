package com.lix.util;

import org.apache.cxf.transport.http.AbstractHTTPDestination;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;


/**
 * Created by Administrator on 2017/10/13.
 */
public class GetCilentInfoUtils {
    private static final Logger log = Logger.getLogger(GetCilentInfoUtils.class.getName());

    public static String getRemoteIp(WebServiceContext wsContext, HttpServletRequest request){
        try{
            if(request == null){
                MessageContext msg = wsContext.getMessageContext();
                request = (HttpServletRequest) msg.get(AbstractHTTPDestination.HTTP_REQUEST);
            }
            String ip = request.getRemoteAddr();
            log.info(" 当前ip " + ip);
            return  ip;
        }catch (Exception e){
            log.error("获取客户端失败："  + e.getMessage() );
        }
        return "";
    }
}
