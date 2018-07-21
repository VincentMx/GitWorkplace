package com.lix.service;

import com.lix.entity.XtYhDsp;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 15:432018/2/24
 * @modify by :
 */
public interface XtYhDspService {

    /**
      *@method: 用户注册操作
      *@author: lix
      *@desc：
      *@Date: 15:51 2018/2/24
      *@param:
      *@return:
      *
      */
    void addXtYhDspInfo(XtYhDsp xtYhDsp);

    /**
      *@method: 获取所有用户注册待审批信息
      *@author: lix
      *@desc：
      *@Date: 15:52 2018/2/24
      *@param:
      *@return:
      *
      */
    List<XtYhDsp> findAllXtYhDsp();

    /**
      *@method: 根据用户身份证号码获取用户信息
      *@author: lix
      *@desc：
      *@Date: 15:52 2018/2/24
      *@param:
      *@return:
      *
      */
    XtYhDsp getXtYhDspInfoById(String id) throws Exception;

    /**
      *@method: 审批操作
      *@author: lix
      *@desc：
      *@Date: 15:52 2018/2/24
      *@param:
      *@return:
      *
      */
    void SpXtYhDspInfo(String id);

    /**
      *@method: 查看身份证号是否已存在
      *@author: lix
      *@desc：
      *@Date: 15:53 2018/2/24
      *@param:
      *@return:
      *
      */
    String getXtYhDspById(String Id) throws Exception;


    /**
      *@method: 删除用户注册信息
      *@author: lix
      *@desc： 
      *@Date: 15:58 2018/2/24
      *@param: 
      *@return:   
      *
      */
    void deleteXtYhDspInfoById(String id,String sfzh) throws Exception;
    
    /**
      *@method: 分页获取所有待审批用户
      *@author: lix
      *@desc： 
      *@Date: 23:23 2018/2/24
      *@param: 
      *@return:   
      *
      */
    Page getAllXtYhDspWithPage(Page page,XtYhDsp xtYhDsp,String unit);

}
