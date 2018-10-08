package com.lix.dao;

import com.lix.entity.Sequence;
import com.lix.util.Page;

/**
 * @author : lix
 * @desc : 序列化参数操作类
 * @time : 16:072018/9/20
 * @modify by :
 */
public interface SequenceDao {

    /**
      *@method: 新增序列数
      *@author: lix
      *@desc： 
      *@Date: 16:09 2018/9/20
      *@param: 
      *@return:   
      *
      */
    void save(Sequence sequence);
    
    /**
      *@method: 删除序列数
      *@author: lix
      *@desc： 
      *@Date: 16:09 2018/9/20
      *@param: 
      *@return:   
      *
      */
    void delete(Sequence sequence);
    
    /**
      *@method: 修改序列数
      *@author: lix
      *@desc： 
      *@Date: 16:10 2018/9/20
      *@param: 
      *@return:   
      *
      */
    void update(Sequence sequence);
    
    /**
      *@method: 分页查询序列数
      *@author: lix
      *@desc： 
      *@Date: 16:10 2018/9/20
      *@param: 
      *@return:   
      *
      */
    Page findAllWithPage(Page page , Sequence sequence);

    /**
      *@method: 查询序列数
      *@author: lix
      *@desc： 
      *@Date: 16:11 2018/9/20
      *@param: 
      *@return:   
      *
      */
    Sequence findByParam(Sequence sequence);
}
