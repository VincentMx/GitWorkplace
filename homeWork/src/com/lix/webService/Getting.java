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
    
}
