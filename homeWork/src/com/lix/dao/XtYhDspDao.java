package com.lix.dao;

import com.lix.entity.XtYhDsp;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 16:062018/2/24
 * @modify by :
 */
public interface XtYhDspDao {


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
    XtYhDsp getXtYhDspInfoByParam(XtYhDsp xtYhDsp);

    /**
     *@method: 查看身份证号是否已存在
     *@author: lix
     *@desc：
     *@Date: 15:53 2018/2/24
     *@param:
     *@return:
     *
     */
    String getXtYhDspById(String Id);


    /**
     *@method: 删除用户注册信息
     *@author: lix
     *@desc：
     *@Date: 15:58 2018/2/24
     *@param:
     *@return:
     *
     */
    void deleteXtYhDspInfoById(XtYhDsp xtYhDsp);
    
    
    /**
      *@method: 分页查询系统用户待审批
      *@author: lix
      *@desc： 
      *@Date: 16:26 2018/2/24
      *@param: 
      *@return:   
      *
      */
    Page getXtYhDspByParam(XtYhDsp xtYhDsp,Page page,String unit);
    
    /**
      *@method: 修改用户审批信息
      *@author: lix
      *@desc： 
      *@Date: 16:48 2018/2/24
      *@param: 
      *@return:   
      *
      */
    void updateXtYhDspInfo(XtYhDsp xtYhDsp);

}
