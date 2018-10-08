package com.lix.dao;

import com.lix.entity.XtYhZb;
import com.lix.entity.vo.XtYhZbVO;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc :用户账本操作类
 * @time : 14:572018/10/3
 * @modify by :
 */
public interface XtYhZbDao {
    
    /**
      *@method: 添加账本信息
      *@author: lix
      *@desc： 
      *@Date: 15:00 2018/10/3
      *@param: 
      *@return:   
      *
      */
    void save(XtYhZb xtYhZb);
    /**
      *@method: 修改账本信息
      *@author: lix
      *@desc： 
      *@Date: 15:00 2018/10/3
      *@param: 
      *@return:   
      *
      */
    void update(XtYhZb xtYhZb);
    /**
      *@method: 删除账本信息
      *@author: lix
      *@desc： 
      *@Date: 15:01 2018/10/3
      *@param: 
      *@return:   
      *
      */
    void delete(XtYhZb xtYhZb);
    /**
      *@method: 根据主键获取
      *@author: lix
      *@desc： 
      *@Date: 15:01 2018/10/3
      *@param: 
      *@return:   
      *
      */
    XtYhZb findById(XtYhZb xtYhZb);
    /**
      *@method: 分页获取账本信息
      *@author: lix
      *@desc： 
      *@Date: 15:01 2018/10/3
      *@param: 
      *@return:   
      *
      */
    Page findYhZbWithPage(Page page , XtYhZbVO xtYhZb);
    /**
      *@method: 列表查询
      *@author: lix
      *@desc： 
      *@Date: 15:01 2018/10/3
      *@param: 
      *@return:   
      *
      */
    List<XtYhZbVO> findByParam(XtYhZbVO xtYhZb);
    /**
      *@method: 根据参数获取账本
      *@author: lix
      *@desc： 
      *@Date: 15:07 2018/10/3
      *@param: 
      *@return:   
      *
      */
    XtYhZb findByParams(XtYhZbVO xtYhZb);
}
