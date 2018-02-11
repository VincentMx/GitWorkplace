package com.lix.dao;

import com.lix.entity.XtRzDl;
import com.lix.entity.vo.XtDlRzVO;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 13:202017/12/13
 * @modify by :
 */
public interface XtRzDlDao {


    /**
      *@method: 添加登录日志
      *@author: lix
      *@desc： 添加登录日志
      *@Date: 13:26 2017/12/13
      *@param:
      *@return:
      *
      */
    void addYhDlRz(XtRzDl xtRzDl);

    /**
      *@method: 删除登陆日志
      *@author: lix
      *@desc： 删除登录日志
      *@Date: 13:26 2017/12/13
      *@param:
      *@return:
      *
      */
    void deleteYhDlRz(XtRzDl xtRzDl);

    /**
      *@method: 获取所有登录日志
      *@author: lix
      *@desc： 获取所有登录日志
      *@Date: 13:26 2017/12/13
      *@param:
      *@return:
      *
      */
    List<XtDlRzVO> getAllYhDlRz(XtDlRzVO xtDlRzVO);

    /**
      *@method: 根据参数获取登录日志
      *@author: lix
      *@desc： 根据参数获取登录日志
      *@Date: 13:27 2017/12/13
      *@param:
      *@return:
      *
      */
    XtRzDl getXtGlRzByParam(XtRzDl xtRzDl);
    
    
    /**
      *@method: 根据分页处理
      *@author: lix
      *@desc： 
      *@Date: 8:56 2017/12/26
      *@param: 
      *@return:   
      *
      */
    Page getAllXtRzDlByParam(XtDlRzVO xtDlRzVO, Page page);
}
