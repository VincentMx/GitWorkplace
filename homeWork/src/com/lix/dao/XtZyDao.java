package com.lix.dao;


import com.lix.entity.XtZy;
import com.lix.entity.vo.XtZyVO;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 13:532017/11/27
 * @modify by :
 */
public interface XtZyDao {
    
    /**
      *@method: 保存资源
      *@author: lix
      *@desc： 
      *@Date: 13:54 2017/11/27
      *@param: 
      *@return:   
      *
      */
    void saveXtZy(XtZy xt_zy);
    /**
      *@method: 获取所有资源
      *@author: lix
      *@desc： 
      *@Date: 13:54 2017/11/27
      *@param: 
      *@return:   
      *
      */
    List<XtZy> findAllXtZy(XtZy xt_zy);
    
    /**
      *@method: 修改资源
      *@author: lix
      *@desc： 
      *@Date: 13:55 2017/11/27
      *@param: 
      *@return:   
      *
      */
    void updateXtZy(XtZy xt_zy);
    
    /**
      *@method: 根据编号获取信息
      *@author: lix
      *@desc： 
      *@Date: 15:33 2017/11/27
      *@param: 
      *@return:   
      *
      */
    XtZy findById(XtZy xt_zy);
    
    /**
      *@method: 根据用户权限获取数据库资源
      *@author: lix
      *@desc： 登录时获取资源所用
      *@Date: 8:21 2017/11/30
      *@param: 
      *@return:   
      *
      */
    List<XtZy> findByUserKey(String userKey);
    
    
    /**
      *@method: 删除系统资源方法
      *@author: lix
      *@desc： 
      *@Date: 15:11 2017/12/5
      *@param: 
      *@return:   
      *
      */
    void deleteXtZyInfo(XtZy xtZy);

    /**
      *@method: 分页查询系统资源信息
      *@author: lix
      *@desc： 
      *@Date: 12:00 2017/12/27
      *@param: 
      *@return:   
      *
      */
    Page findXtZyByParam(Page page, XtZyVO xtZyVO);
    
    
    /**
      *@method: 获取系统资源列表
      *@author: lix
      *@desc： 
      *@Date: 17:33 2018/3/8
      *@param: 
      *@return:   
      *
      */
    List<XtZy> getXtZyList(String sql);


}
