package com.lix.dao;

import com.lix.entity.XtJk;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc : 系统接口数据操作类
 * @time : 11:472018/9/20
 * @modify by :
 */
public interface XtJkDao {

    /**
      *@method: 新增系统接口类
      *@author: lix
      *@desc： 
      *@Date: 11:51 2018/9/20
      *@param: 
      *@return:   
      *
      */
   void save(XtJk xtJk);


   /**
     *@method: 修改系统接口类
     *@author: lix
     *@desc： 
     *@Date: 11:51 2018/9/20
     *@param: 
     *@return:   
     *
     */
   void update(XtJk xtJk);


   /**
     *@method: 删除系统接口类
     *@author: lix
     *@desc： 
     *@Date: 11:51 2018/9/20
     *@param: 
     *@return:   
     *
     */
   void delete(XtJk xtJk);


   /**
     *@method: 获取所有系统接口类
     *@author: lix
     *@desc： 
     *@Date: 11:51 2018/9/20
     *@param: 
     *@return:   
     *
     */
   List<XtJk> findAll(XtJk xtJk);

   /**
     *@method: 分页获取系统接口
     *@author: lix
     *@desc： 
     *@Date: 11:51 2018/9/20
     *@param: 
     *@return:   
     *
     */
   Page findAllXtjkWithPage(Page page , XtJk xtJk);

   /**
     *@method: 根据主键获取系统接口
     *@author: lix
     *@desc： 
     *@Date: 11:52 2018/9/20
     *@param: 
     *@return:   
     *
     */
   XtJk findById(String skey);
   
   

   /**
     *@method: 根据参数获取系统接口
     *@author: lix
     *@desc： 
     *@Date: 11:52 2018/9/20
     *@param: 
     *@return:   
     *
     */
   XtJk findByParam(XtJk xtJk);

   


}
