package com.lix.webService;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author : lix
 * @desc :停车 -- 接口嘞
 * @time : 17:522018/7/16
 * @modify by :
 */
@WebService(targetNamespace = "com.lix.webService.Getting")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface parkService {

    /**
      *@method: 查询停车场类接口
      *@author: lix
      *@desc： 
      *@Date: 17:54 2018/7/16
      *@param: 
      *@return:   
      *
      */
    public String queryParkService(@WebParam(name = "jsonStr") String jsonStr);


    /**
      *@method: 生成订单接口
      *@author: lix
      *@desc： 
      *@Date: 17:55 2018/7/16
      *@param: 
      *@return:   
      *
      */
    public String getOrderNo(@WebParam(name = "jsonStr") String jsonStr);







}
