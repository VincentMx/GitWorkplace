package com.lix.dao;

import com.lix.entity.XtGg;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc :系统公告
 * @time : 15:032018/9/27
 * @modify by :
 */
public interface XtGgDao {

    /**
      *@method: 新增公告
      *@author: lix
      *@desc：
      *@Date: 15:05 2018/9/27
      *@param:
      *@return:
      *
      */
    void save(XtGg xtGg);
    
    /**
      *@method: 修改公告
      *@author: lix
      *@desc：
      *@Date: 15:05 2018/9/27
      *@param:
      *@return:
      *
      */
    void update(XtGg xtGg);

    /**
      *@method: 删除公告
      *@author: lix
      *@desc： 
      *@Date: 15:05 2018/9/27
      *@param: 
      *@return:   
      *
      */
    void delete(XtGg xtGg);

    /**
      *@method: 获取公告根据主键
      *@author: lix
      *@desc： 
      *@Date: 15:05 2018/9/27
      *@param: 
      *@return:   
      *
      */
    XtGg findById(XtGg xtGg);

    /**
      *@method: 分页获取公告
      *@author: lix
      *@desc： 
      *@Date: 15:06 2018/9/27
      *@param: 
      *@return:   
      *
      */
    Page findWithPage(Page page , XtGg xtGg);

    
    /**
      *@method: 获取所有公告
      *@author: lix
      *@desc： 
      *@Date: 15:06 2018/9/27
      *@param: 
      *@return:   
      *
      */
    List<XtGg> findAllXtGg(XtGg xtGg);


    /**
      *@method: 获取限制数量系统公告
      *@author: lix
      *@desc： 
      *@Date: 14:04 2018/9/28
      *@param: 
      *@return:   
      *
      */
    List<XtGg> fingLimitXtggxx(XtGg xtGg , int size);
    
    
    
}
