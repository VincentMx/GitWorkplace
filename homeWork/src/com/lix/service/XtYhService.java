package com.lix.service;

import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtYhVO;
import com.lix.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 23:462017/11/29
 * @modify by :
 */
public interface XtYhService {


        /**
         *@method: 保存用户
         *@author: lix
         *@desc：
         *@Date: 23:26 2017/11/29
         *@param:
         *@return:
         *
         */
        void saveYhInfo(Xt_yh xt_yh,HttpServletRequest request,Xt_yh xt_yh1) throws Exception;

        /**
         *@method: 获取所有系统用户信息
         *@author: lix
         *@desc：
         *@Date: 23:27 2017/11/29
         *@param:
         *@return:
         *
         */
        List<Xt_yh> findAllXtYh(Xt_yh xt_yh);


        /**
         *@method: 修改系统用户信息
         *@author: lix
         *@desc：
         *@Date: 23:28 2017/11/29
         *@param:
         *@return:
         *
         */
        void updateXtYhInfo(Xt_yh xt_yh);


        /**
         *@method: 根据编号获取用户信息
         *@author: lix
         *@desc：
         *@Date: 23:29 2017/11/29
         *@param:
         *@return:
         *
         */
        Xt_yh findYhInfoById(String skey);


    /**
     *@method: 根据信息获取用户信息
     *@author: lix
     *@desc：
     *@Date: 0:14 2017/11/30
     *@param:
     *@return:
     *
     */
    Xt_yh findXtYhByPara(Xt_yh xt_yh);
    
    
    /**
      *@method: 删除数据库中用户信息
      *@author: lix
      *@desc： 
      *@Date: 15:49 2018/1/18
      *@param: 
      *@return:   
      *
      */
    void deleteXtYh(String skey,HttpServletRequest request,Xt_yh xt_yh) throws Exception;

    /**
      *@method: 分页查询用户信息
      *@author: lix
      *@desc：
      *@Date: 15:53 2018/1/18
      *@param:
      *@return:
      *
      */
    Page getAllXtYh(Page page, XtYhVO xtYhVO,HttpServletRequest request );
    
    
    /**
      *@method: 注销系统用户信息
      *@author: lix
      *@desc： 
      *@Date: 10:24 2018/1/19
      *@param: 
      *@return:   
      *
      */
    void removeXtYh(String skey,HttpServletRequest request,Xt_yh xt_yh) throws Exception;
    
    
    /**
      *@method: 获取系统用户数量
      *@author: lix
      *@desc： 
      *@Date: 9:03 2018/3/6
      *@param: 
      *@return:   
      *
      */
    String getXtYhCount(Xt_yh xt_yh);

    /**
      *@method: 用户登录日志数量
      *@author: lix
      *@desc： 
      *@Date: 9:47 2018/3/6
      *@param: 
      *@return:   
      *
      */
    String getXtYhDlCount(Xt_yh xt_yh);

    /**
      *@method: 用户操作日志数量
      *@author: lix
      *@desc： 
      *@Date: 9:47 2018/3/6
      *@param: 
      *@return:   
      *
      */
    String getXtYhCzCount(Xt_yh xt_yh);
    
    
    /**
      *@method: 获取用户自己登录的次数统计
      *@author: lix
      *@desc： 
      *@Date: 17:01 2018/3/7
      *@param: 
      *@return:   
      *
      */
    String getYhSelfDlCount(Xt_yh xt_yh);



    /**
      *@method: 审批用户信息
      *@author: lix
      *@desc： 
      *@Date: 23:33 2018/6/27
      *@param: 
      *@return:   
      *
      */
    void SpYhInfo(String Skey, String flag , String bz) throws Exception;


  /***
      *@method: 获取所有用户信息
      *@author: lix
      *@desc：
      *@Date: 19:26 2018/7/9
      *@param:
      *@return:
      *
      */
    List<Map<String , Object>> getAllXtYh(String skey , String id ) throws Exception;
}
