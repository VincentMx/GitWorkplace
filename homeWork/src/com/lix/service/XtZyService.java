package com.lix.service;

import com.lix.entity.XtZy;
import com.lix.entity.vo.XtZyVO;
import com.lix.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author : lix
 * @desc :
 * @time : 14:312017/11/27
 * @modify by :
 */
public interface XtZyService {

    /**
     *@method: 保存资源
     *@author: lix
     *@desc：
     *@Date: 13:54 2017/11/27
     *@param:
     *@return:
     *
     */
    void saveXtZy(XtZy xt_zy, HttpServletRequest request,String sfzh) throws Exception;
    /**
     *@method: 获取所有资源
     *@author: lix
     *@desc：
     *@Date: 13:54 2017/11/27
     *@param:
     *@return:
     *
     */
    List<XtZy> findAllXtZy(XtZy xt_zy);

    /**
     *@method: 修改资源
     *@author: lix
     *@desc：
     *@Date: 13:55 2017/11/27
     *@param:
     *@return:
     *
     */
    void updateXtZy(XtZy xt_zy);
    
    /**
      *@method: 根据编号获取信息
      *@author: lix
      *@desc： 
      *@Date: 14:47 2017/11/27
      *@param: 
      *@return:   
      *
      */
    XtZy findById(XtZy xt_zy)throws Exception;



    /**
     *@method: 根据用户权限获取数据库资源
     *@author: lix
     *@desc：
     *@Date: 8:21 2017/11/30
     *@param:
     *@return:
     *
     */
    List<XtZy> findByUserKey(String userKey);


    /**
      *@method: 删除系统资源方法
      *@author: lix
      *@desc：
      *@Date: 15:07 2017/12/5
      *@param: skey
      *@return:
      *
      */
    void deleteXtZyInfo(String skey,HttpServletRequest request,String sfzh);


    /**
     *@method: 分页查询系统资源信息
     *@author: lix
     *@desc：
     *@Date: 12:00 2017/12/27
     *@param:
     *@return:
     *
     */
    Page findXtZyByParam(Page page, XtZyVO xtZyVO);


    /**
      *@method: 获取资源树
      *@author: lix
      *@desc： 
      *@Date: 17:32 2018/2/1
      *@param: 
      *@return:   
      *
      */
    List<Map<String,Object>> getTree(String skey);
    
    /**
      *@method: 获取资源树
      *@author: lix
      *@desc： 
      *@Date: 16:55 2018/3/8
      *@param: 
      *@return:   
      *
      */
    List<XtZy> getXtZyList(String parentKey);
    
    /**
      *@method: 获取资源树
      *@author: lix
      *@desc： 
      *@Date: 17:18 2018/3/8
      *@param: 
      *@return:   
      *
      */
    List<XtZy> getXtZyList(String parentKey,String unit);
}
