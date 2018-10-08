package com.lix.dao.order;

import com.lix.entity.XtTcDdXx;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc : 订单信息数据操作类
 * @time : 14:162018/9/20
 * @modify by :
 */
public interface orderDao {

    /**
      *@method: 添加订单信息
      *@author: lix
      *@desc： 
      *@Date: 14:19 2018/9/20
      *@param: 
      *@return:   
      *
      */
    void save(XtTcDdXx xtTcDdXx);

    /**
      *@method: 删除订单信息
      *@author: lix
      *@desc： 
      *@Date: 14:19 2018/9/20
      *@param: 
      *@return:   
      *
      */
    void delete(XtTcDdXx xtTcDdXx);

    /**
      *@method: 修改订单信息
      *@author: lix
      *@desc： 
      *@Date: 14:19 2018/9/20
      *@param: 
      *@return:   
      *
      */
    void update(XtTcDdXx xtTcDdXx);

    /**
      *@method: 获取所有订单信息
      *@author: lix
      *@desc： 
      *@Date: 14:19 2018/9/20
      *@param: 
      *@return:   
      *
      */
    List<XtTcDdXx> findAll(XtTcDdXx xtTcDdXx);

    /**
      *@method: 根据订单号查询订单信息
      *@author: lix
      *@desc： 
      *@Date: 14:20 2018/9/20
      *@param: 
      *@return:   
      *
      */
    XtTcDdXx findById(XtTcDdXx xtTcDdXx);

    /**
      *@method: 查询订单列表信息
      *@author: lix
      *@desc： 
      *@Date: 14:20 2018/9/20
      *@param: 
      *@return:   
      *
      */
    XtTcDdXx findByParam(XtTcDdXx xtTcDdXx);

    /**
      *@method: 分页查询订单信息
      *@author: lix
      *@desc： 
      *@Date: 14:21 2018/9/20
      *@param: 
      *@return:   
      *
      */
    Page findAllWithPage(Page page , XtTcDdXx xtTcDdXx);
}
