package com.lix.service;

import com.lix.entity.XtYhRzm;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc :用户认证接口
 * @time : 17:472018/8/30
 * @modify by :
 */
public interface XtYhRzService {

    /**
     *@method: 添加系统认证码信息
     *@author: lix
     *@desc：
     *@Date: 17:30 2018/8/30
     *@param:
     *@return:
     *
     */
    void addXtYhRzxx(XtYhRzm xtYhRzm) throws Exception;

    /**
     *@method: 删除系统认证码信息
     *@author: lix
     *@desc：
     *@Date: 17:31 2018/8/30
     *@param:
     *@return:
     *
     */
    void delete(XtYhRzm xtYhRzm);

    /**
     *@method: 修改系统认证码信息
     *@author: lix
     *@desc：
     *@Date: 17:31 2018/8/30
     *@param:
     *@return:
     *
     */
    void update(XtYhRzm xtYhRzm);

    /**
     *@method: 根据条件查询系统认证码信息
     *@author: lix
     *@desc：
     *@Date: 17:31 2018/8/30
     *@param:
     *@return:
     *
     */
    List<XtYhRzm> getAllXtYhRzm(XtYhRzm xtYhRzm);

    /**
     *@method: 根据id查询认证码信息
     *@author: lix
     *@desc：
     *@Date: 17:31 2018/8/30
     *@param:
     *@return:
     *
     */
    XtYhRzm findById(String skey);


    /**
     *@method: 根据用户获取认证码信息
     *@author: lix
     *@desc：
     *@Date: 17:32 2018/8/30
     *@param:
     *@return:
     *
     */
    XtYhRzm findByYhId(String yhskey);


    /**
     *@method: 分页查询认证码信息
     *@author: lix
     *@desc：
     *@Date: 17:32 2018/8/30
     *@param:
     *@return:
     *
     */
    Page fingXtYhRzmByPage(Page page , XtYhRzm xtYhRzm);


}
