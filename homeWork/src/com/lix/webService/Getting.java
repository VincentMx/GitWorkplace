package com.lix.webService;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author : lix
 * @desc :
 * @time : 19:552018/5/29
 * @modify by :
 */
@WebService(targetNamespace = "com.lix.webService.Getting")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Getting {

    /**
      *@method: 测试
      *@author: lix
      *@desc： 
      *@Date: 7:52 2018/7/5
      *@param: 
      *@return:   
      *
      */
    public String getting(@WebParam(name = "username") String username);


    /**
      *@method: 翻译软件
      *@author: lix
      *@desc： 
      *@Date: 7:52 2018/7/5
      *@param: 
      *@return:   
      *
      */

    public String transLate(@WebParam(name = "jsonStr") String jsonStr);


    /**
     * 用户登录
     * @param jsonStr
     * @return
     */
    public String userLogin(@WebParam(name = "jsonStr") String jsonStr);




    /**
      *@method: 公告查询服务
      *@author: lix
      *@desc： 
      *@Date: 14:48 2018/9/28
      *@param: 
      *@return:   
      *
      */
    public String queryService(@WebParam(name = "jsonStr") String jsonStr);


}
