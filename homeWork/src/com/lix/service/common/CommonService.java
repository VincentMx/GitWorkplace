package com.lix.service.common;

/**
 * @author : lix
 * @desc :
 * @time : 16:252018/9/20
 * @modify by :
 */
public interface CommonService {

    /**
     *@method: 获取下一个随机数
     *@author: lix
     *@desc：
     *@Date: 15:42 2018/9/20
     *@param: name 名称
     *@return:
     *
     */
    String getNextVal(String name);

    /**
     *@method: 获取当前随机数
     *@author: lix
     *@desc：
     *@Date: 15:42 2018/9/20
     *@param: name 名称
     *@return:
     *
     */
    String getCurrVal(String name);

    /**
     *@method: 设置指定随机数
     *@author: lix
     *@desc：
     *@Date: 15:42 2018/9/20
     *@param: name 名称 ，num 初始值
     *@return:
     *
     */
    String setVal(String name , int num);
}
