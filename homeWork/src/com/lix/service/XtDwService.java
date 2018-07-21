package com.lix.service;

import com.lix.entity.XtDw;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtDwVO;
import com.lix.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 14:412018/1/25
 * @modify by :
 */
public interface XtDwService {
    
    /**
     * @method: 分页查询系统单位出错
     * @author: lix
     * @desc： 
     * @Date: 14:46 2018/1/25
     * @param: 
     * @return:
     * @param page
     * @param xtDwVO
     * @param request
     * @param sfzh
     * @return
     */
    Page getXtDwWithPage(Page page, XtDwVO xtDwVO, HttpServletRequest request,String sfzh);
    
    /**
      *@method: 获取系统单位
      *@author: lix
      *@desc： 
      *@Date: 14:47 2018/1/25
      *@param: 
      *@return:   
      *
      */
    List<XtDwVO> getAllXtDw(XtDwVO xtDwVO,HttpServletRequest request);
    
    /**
      *@method: 获取系统单位
      *@author: lix
      *@desc： 
      *@Date: 14:47 2018/1/25
      *@param: 
      *@return:   
      *
      */
    XtDw getXtDwByParam(XtDwVO xtDwVO) throws Exception;
    
    /**
      *@method: 获取系统单位信息
      *@author: lix
      *@desc： 
      *@Date: 14:48 2018/1/25
      *@param: 
      *@return:   
      *
      */
    XtDwVO getXtDwVoByParam(XtDwVO xtDwVO) throws Exception;
    
    /**
      *@method: 保存系统单位信息或修改单位信息
      *@author: lix
      *@desc： 
      *@Date: 14:48 2018/1/25
      *@param: 
      *@return:   
      *
      */
    void saveOrUpdate(XtDw xtDw,HttpServletRequest request, Xt_yh xt_yh) throws Exception;
    
    /**
      *@method: 删除系统单位信息
      *@author: lix
      *@desc： 
      *@Date: 14:49 2018/1/25
      *@param: 
      *@return:   
      *
      */
    void deleteXtDwINFO(String skey,HttpServletRequest request,Xt_yh xt_yh) throws Exception;
    
    
    /**
      *@method: 获取单位树
      *@author: lix
      *@desc： 
      *@Date: 16:08 2018/3/6
      *@param: 
      *@return:   
      *
      */
    List<XtDw> getXtDwList(String parentKey);

    /**
      *@method: 获取单位树
      *@author: lix
      *@desc： 
      *@Date: 16:15 2018/3/6
      *@param: 
      *@return:   
      *
      */
    List<XtDw> getXtDwList(String parentKey,String unit);

}
