package com.lix.dao;

import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtYhVO;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 23:242017/11/29
 * @modify by :
 */
public interface XtYhDao {

    /**
      *@method: 保存用户
      *@author: lix
      *@desc：
      *@Date: 23:26 2017/11/29
      *@param:
      *@return:
      *
      */
    void saveYhInfo(Xt_yh xt_yh);

    /**
      *@method: 获取所有系统用户信息
      *@author: lix
      *@desc：
      *@Date: 23:27 2017/11/29
      *@param:
      *@return:
      *
      */
    List<Xt_yh> findAllXtYh(Xt_yh xt_yh);


    /**
      *@method: 修改系统用户信息
      *@author: lix
      *@desc：
      *@Date: 23:28 2017/11/29
      *@param:
      *@return:
      *
      */
    void updateXtYhInfo(Xt_yh xt_yh);


    /**
      *@method: 根据编号获取用户信息
      *@author: lix
      *@desc：
      *@Date: 23:29 2017/11/29
      *@param:
      *@return:
      *
      */
    Xt_yh findYhInfoById(String skey);
    
    
    /**
      *@method: 根据信息获取用户信息
      *@author: lix
      *@desc： 
      *@Date: 0:14 2017/11/30
      *@param: 
      *@return:   
      *
      */
    Xt_yh findXtYhByPara(Xt_yh xt_yh);
    
    /**
      *@method: 删除系统用户操作
      *@author: lix
      *@desc： 
      *@Date: 15:37 2018/1/18
      *@param: 
      *@return:   
      *
      */
    void deleteXtYh(Xt_yh xt_yh);

    /**
      *@method: 分页查询系统用户信息
      *@author: lix
      *@desc： 
      *@Date: 15:56 2018/1/18
      *@param: 
      *@return:   
      *
      */
    Page getAllXtYh(Page page, XtYhVO xtYhVO);


    /**
      *@method: 根据编号获取用户信息
      *@author: lix
      *@desc： 
      *@Date: 15:49 2018/7/29
      *@param: 
      *@return:   
      *
      */
     Xt_yh findById(String id , String unit);




}
