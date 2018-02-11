package com.lix.service;

import com.lix.entity.XtRzCz;
import com.lix.entity.Xt_zy_cz;
import com.lix.entity.vo.XtRzCzVO;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 13:302017/12/19
 * @modify by :
 */
public interface XtRzCzService {


    /**
     *@method: 添加系统的操作日志
     *@author: lix
     *@desc： 系统操作日志记录
     *@Date: 14:51 2017/12/16
     *@param:
     *@return:
     *
     */
    void addXtCzRz(XtRzCz xtRzCz) throws Exception;

    /**
     *@method: 删除系统操作日志
     *@author: lix
     *@desc： 系统操作日志的删除
     *@Date: 14:51 2017/12/16
     *@param:
     *@return:
     *
     */
    void DeleteXtRzCz(XtRzCz xtRzCz) throws Exception;

    /**
     *@method: 获取所有的系统日志信息
     *@author: lix
     *@desc： 获取所有的系统日志
     *@Date: 14:52 2017/12/16
     *@param:
     *@return:
     *
     */
    List<XtRzCzVO>  findAllXtRzCz(XtRzCzVO xtRzCzVO);

    /**
     *@method: 根据参数获取系统
     *@author: lix
     *@desc：
     *@Date: 14:53 2017/12/16
     *@param:
     *@return:
     *
     */
    XtRzCz getXtRzCzByPara(XtRzCzVO xtRzCzVO) throws Exception;
    
    
    /**
      *@method: 分页查询操作日志
      *@author: lix
      *@desc： 
      *@Date: 16:57 2018/1/16
      *@param: 
      *@return:   
      *
      */
    Page getAllRzCzByPage(XtRzCzVO xtRzCzVO,Page page);

}
