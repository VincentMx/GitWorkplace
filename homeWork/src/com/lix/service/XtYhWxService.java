package com.lix.service;

import com.lix.entity.XtYhWx;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 8:202018/9/7
 * @modify by :
 */
public interface XtYhWxService {

    /**
     *@method: 添加微信信息
     *@author: lix
     *@desc：
     *@Date: 0:02 2018/9/7
     *@param:
     *@return:
     *
     */
    void save(XtYhWx xtYhWx) throws Exception;

    /**
     *@method: 修改微信信息
     *@author: lix
     *@desc：
     *@Date: 0:02 2018/9/7
     *@param:
     *@return:
     *
     */
    void update(XtYhWx xtYhWx) throws Exception;

    /**
     *@method: 删除微信信息
     *@author: lix
     *@desc：
     *@Date: 0:03 2018/9/7
     *@param:
     *@return:
     *
     */
    void delete(XtYhWx xtYhWx) throws Exception;

    /**
     *@method: 根据主键查找
     *@author: lix
     *@desc：
     *@Date: 0:03 2018/9/7
     *@param:
     *@return:
     *
     */
    XtYhWx findById(XtYhWx xtYhWx) throws Exception;

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
    XtYhWx findByOpenId(XtYhWx xtYhWx) throws Exception;


}
