package com.lix.service;

import com.lix.entity.Sequence;
import com.lix.util.Page;

/**
 * @author : lix
 * @desc : 序列化 --业务操作
 * @time : 16:172018/9/20
 * @modify by :
 */
public interface SequenceService {

    /**
     *@method: 新增序列数
     *@author: lix
     *@desc：
     *@Date: 16:09 2018/9/20
     *@param:
     *@return:
     *
     */
    void saveOrUpdate(Sequence sequence);

    /**
     *@method: 删除序列数
     *@author: lix
     *@desc：
     *@Date: 16:09 2018/9/20
     *@param:
     *@return:
     *
     */
    void deleteSequence(String name) throws Exception;

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
    Sequence findByParam(Sequence sequence) throws Exception;
}
