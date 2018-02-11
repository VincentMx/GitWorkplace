package com.lix.dao;

import com.lix.entity.Xt_zy_cz;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 15:182017/12/6
 * @modify by :
 */
public interface XtZyCzDao {


    /**
      *@method: 保存资源方法
      *@author: lix
      *@desc： 保存资源
      *@Date: 15:21 2017/12/6
      *@param: xt_zy_cz
      *@return:
      *
      */
    void saveZyCzInfo(Xt_zy_cz xt_zy_cz);

    /**
      *@method: 删除资源操作
      *@author: lix
      *@desc： 删除资源操作相关
      *@Date: 15:22 2017/12/6
      *@param:
      *@return:
      *
      */
    void deleteXtZyCz(Xt_zy_cz xt_zy_cz);

    /**
      *@method: 修改操作的方法
      *@author: lix
      *@desc：
      *@Date: 23:18 2017/12/6
      *@param: xt_zy_cz
      *@return:
      *
      */
    void updateXtZyCz(Xt_zy_cz xt_zy_cz);


    /**
      *@method: 查询所有的操作信息
      *@author: lix
      *@desc：
      *@Date: 23:19 2017/12/6
      *@param: xt_zy_cz
      *@return:
      *
      */
    List<Xt_zy_cz> findAllXtZyCz(Xt_zy_cz xt_zy_cz);

    /**
      *@method: 根据编号获取信息
      *@author: lix
      *@desc：
      *@Date: 23:19 2017/12/6
      *@param: id
      *@return:
      *
      */
    Xt_zy_cz findById(String id);


    /**
      *@method: 根据每个jsp的资源主键获取每个页面的按钮
      *@author: lix
      *@desc： 
      *@Date: 17:22 2018/1/8
      *@param: 
      *@return:   
      *
      */
    List<Xt_zy_cz> findXtZyCzByResourcesId(String Skey);
}
