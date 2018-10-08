package com.lix.dao;

import com.lix.entity.XtYhWx;

import java.util.List;

/**
 * @author : lix
 * @desc :  操作跟微信相关的方法
 * @time : 23:592018/9/6
 * @modify by :
 */
public interface XtYhWxDao {

    
    /**
      *@method: 添加微信信息
      *@author: lix
      *@desc： 
      *@Date: 0:02 2018/9/7
      *@param: 
      *@return:   
      *
      */
    void save(XtYhWx xtYhWx);

    /**
      *@method: 修改微信信息
      *@author: lix
      *@desc： 
      *@Date: 0:02 2018/9/7
      *@param: 
      *@return:   
      *
      */
    void update(XtYhWx xtYhWx);

    /**
      *@method: 删除微信信息
      *@author: lix
      *@desc： 
      *@Date: 0:03 2018/9/7
      *@param: 
      *@return:   
      *
      */
    void delete(XtYhWx xtYhWx);

    /**
      *@method: 根据主键查找
      *@author: lix
      *@desc： 
      *@Date: 0:03 2018/9/7
      *@param: 
      *@return:   
      *
      */
    XtYhWx findById(XtYhWx xtYhWx);

    /**
      *@method: 获取微信列表
      *@author: lix
      *@desc： 
      *@Date: 0:03 2018/9/7
      *@param: 
      *@return:   
      *
      */
    List<XtYhWx> findAll(XtYhWx xtYhWx);
    
    /**
      *@method: 根据openId查询信息
      *@author: lix
      *@desc： 
      *@Date: 0:04 2018/9/7
      *@param: 
      *@return:   
      *
      */
    XtYhWx findByOpenId(XtYhWx xtYhWx);



}
