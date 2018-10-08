package com.lix.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author : lix
 * @desc :
 * @time : 10:152018/3/8
 * @modify by :
 */
@WebService(targetNamespace = "com.lix.webService.YhInfoService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface YhInfoService {


    /***
     * @Title: YhInfoService.java
     * @Description: 获取用户信息
     * @param yhId
     * @param yhName
     * @return
     * @see :com.lix.webService.YhInfoService.getYhInfo
     * @创建人：lixian
     * @创建时间： 2018-03-08
     *
     */
    @WebMethod
    @WebResult(name = "result") String getYhInfo(
            @WebParam(name = "yhId") String yhId,
            @WebParam(name = "yhName") String yhName,
            @WebParam(name = "yhPass") String yhPass
    );


    /**
      *@method: 注册用户信息
      *@author: lix
      *@desc： 
      *@Date: 12:16 2018/7/7
      *@param: 
      *@return:   
      *
      */
    @WebMethod
    @WebResult( name =  "result") String addYh(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") String  name,
            @WebParam(name = "sex") String sex,
            @WebParam(name = "unit") String unit,
            @WebParam(name = "password") String password,
            @WebParam(name = "mobile") String mobile,
            @WebParam(name = "address") String address,
            @WebParam(name = "email") String email


            );
    
    
    /**
      *@method: 通过手机号码注册用户
      *@author: lix
      *@desc： 
      *@Date: 12:16 2018/7/7
      *@param: 
      *@return:   
      *
      */
    @WebResult (name = "result") String addYhByMobile(
            @WebParam(name = "mobile") String mobile
    );
    

    /**
      *@method: 添加用户信息
      *@author: lix
      *@desc： 
      *@Date: 12:32 2018/7/7
      *@param: 
      *@return:   
      *
      */
    public String addXtYhDspInfo(@WebParam(name = "jsonStr") String jsonStr);
    
    
    /**
      *@method: 系统用户登录
      *@author: lix
      *@desc： 
      *@Date: 12:33 2018/7/7
      *@param: 
      *@return:   
      *
      */
    public String xtYhLogin(@WebParam(name = "jsonStr") String jsonStr);
    
    
    /**
      *@method: 删除系统用户
      *@author: lix
      *@desc： 
      *@Date: 12:33 2018/7/7
      *@param: 
      *@return:   
      *
      */
    public String deleteXtYhInfo(@WebParam(name = "jsonStr") String jsonStr);
    
    /**
      *@method: 修改用户信息
      *@author: lix
      *@desc： 
      *@Date: 12:35 2018/7/7
      *@param: 
      *@return:   
      *
      */
    public String updateXtYhInfo(@WebParam(name = "jsonStr") String jsonStr);
    
    /**
      *@method: 对待审批用户进行审批
      *@author: lix
      *@desc： 
      *@Date: 12:36 2018/7/7
      *@param: 
      *@return:   
      *
      */
    public String  spXtYhForDsp(@WebParam(name = "jsonStr") String jsonStr);
    
    /**
      *@method: 根据用户主键获取用户信息
      *@author: lix
      *@desc： 
      *@Date: 12:36 2018/7/7
      *@param: 
      *@return:   
      *
      */
    public String queryXtYhInfo(@WebParam(name = "jsonStr") String jsonStr);






    

}
