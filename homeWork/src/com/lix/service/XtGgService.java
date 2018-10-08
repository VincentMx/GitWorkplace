package com.lix.service;

import com.lix.entity.XtGg;
import com.lix.entity.Xt_yh;
import com.lix.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : lix
 * @desc :系统公告业务层
 * @time : 15:272018/9/27
 * @modify by :
 */
public interface XtGgService {

    /**
      *@method: 添加或修改
      *@author: lix
      *@desc： 
      *@Date: 15:29 2018/9/27
      *@param: 
      *@return:   
      *
      */
    void saveOrUpdate(XtGg xtGg , Xt_yh xt_yh , HttpServletRequest request) throws Exception;
    /**
      *@method: 删除公告
      *@author: lix
      *@desc： 
      *@Date: 15:30 2018/9/27
      *@param: 
      *@return:   
      *
      */
    void delete(XtGg xtGg , Xt_yh xt_yh , HttpServletRequest request) throws Exception;
    /**
      *@method: 查询系统公告
      *@author: lix
      *@desc： 
      *@Date: 15:30 2018/9/27
      *@param: 
      *@return:   
      *
      */
    List<XtGg> findAllXtGg(XtGg xtGg);
    
    /**
      *@method: 获取分页列表
      *@author: lix
      *@desc： 
      *@Date: 15:30 2018/9/27
      *@param: 
      *@return:   
      *
      */
    Page findXtGgWithPage(Page page , XtGg xtGg);

    
    /**
      *@method: 根据主键获取
      *@author: lix
      *@desc： 
      *@Date: 15:58 2018/9/27
      *@param: 
      *@return:   
      *
      */
    XtGg findById(String  Skey) throws Exception;
    
    
    /**
      *@method: 检测审批人员
      *@author: lix
      *@desc： 
      *@Date: 18:31 2018/9/27
      *@param: 
      *@return:   
      *
      */
    boolean checkUserInfo(Xt_yh xt_yh , String token , HttpServletRequest request) throws Exception;
    
    
    /**
      *@method: 发布公告
      *@author: lix
      *@desc： 
      *@Date: 18:35 2018/9/27
      *@param: 
      *@return:   
      *
      */
    boolean SpGgxx(String skey , Xt_yh xt_yh , HttpServletRequest request) throws Exception;




    /**
      *@method: 获取限定数量的系统公告
      *@author: lix
      *@desc： 
      *@Date: 14:06 2018/9/28
      *@param: 
      *@return:   
      *
      */
    List<XtGg> findLimitXtGgxx(XtGg xtGg , int size) throws Exception;

}
