package com.lix.service;

import com.lix.entity.XtYhZb;
import com.lix.entity.vo.XtYhZbVO;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc : 系统业务操作类
 * @time : 15:442018/10/3
 * @modify by :
 */
public interface XtYhZbService {
    
    /**
      *@method: 添加或修改
      *@author: lix
      *@desc： 
      *@Date: 15:47 2018/10/3
      *@param: 
      *@return:   
      *
      */
    void saveOrUpdate(XtYhZb xtYhZb) throws Exception;
    /**
      *@method: 删除系统用户账本信息
      *@author: lix
      *@desc： 
      *@Date: 15:47 2018/10/3
      *@param: 
      *@return:   
      *
      */
    void deleteXtYhZb(XtYhZb xtYhZb) throws Exception;
    /**
      *@method: 获取所有账本信息
      *@author: lix
      *@desc： 
      *@Date: 15:47 2018/10/3
      *@param: 
      *@return:   
      *
      */
    List<XtYhZbVO> findXtYhZb(XtYhZbVO xtYhZbVO);
    
    /**
      *@method: 获取分页信息
      *@author: lix
      *@desc： 
      *@Date: 15:47 2018/10/3
      *@param: 
      *@return:   
      *
      */
    Page findXtYhZbWithPage(Page page , XtYhZbVO xtYhZbVO);
    
    /**
      *@method: 获取正本信息
      *@author: lix
      *@desc： 
      *@Date: 15:59 2018/10/3
      *@param: 
      *@return:   
      *
      */
    XtYhZb findXtYhZb(XtYhZb xtYhZb);
}
