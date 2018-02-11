package cn.lix.dao;

import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 14:582017/12/16
 * @modify by :
 */
public interface AbstractDao {

    /**
      *@method: 添加方法
      *@author: lix
      *@desc： 共有添加方法
      *@Date: 15:02 2017/12/16
      *@param:
      *@return:
      *
      */
    void add(Object o);

    /**
      *@method: 删除方法
      *@author: lix
      *@desc： 共有删除方法
      *@Date: 15:02 2017/12/16
      *@param:
      *@return:
      *
      */
    void delete(Object o);

    /**
      *@method: 修改方法
      *@author: lix
      *@desc： 共有修改方法
      *@Date: 15:02 2017/12/16
      *@param:
      *@return:
      *
      */
    void update(Object o);

    /**
      *@method: 搜索
      *@author: lix
      *@desc： 共有搜索方法
      *@Date: 15:13 2017/12/16
      *@param:
      *@return:
      *
      */
    Object getById(String id, Object o);

    /**
      *@method: 获取所有列表信息的方法
      *@author: lix
      *@desc： 获取所有
      *@Date: 15:14 2017/12/16
      *@param:
      *@return:
      *
      */
    List<Object> findAll(Object object);

    /**
      *@method: 根据不同的参数获取信息
      *@author: lix
      *@desc： 根据参数获取信息
      *@Date: 15:16 2017/12/16
      *@param:
      *@return:
      *
      */
    List<Object> findAllByPara(String sql, Object object);




}
