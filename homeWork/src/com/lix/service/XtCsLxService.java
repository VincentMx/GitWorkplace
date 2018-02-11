package com.lix.service;

import com.lix.entity.XtCsLx;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtCsLxVO;
import com.lix.entity.vo.XtCsVO;
import com.lix.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 15:072017/12/27
 * @modify by :
 */
public interface XtCsLxService {

    /**
     *@method: 根据分页获取参数
     *@author: lix
     *@desc：
     *@Date: 14:55 2017/12/27
     *@param:
     *@return:
     *
     */
    Page getAllXtCsWithPage(XtCsLxVO xtCsLxVO, Page page);

    /**
      *@method: 查找所有参数类型
      *@author: lix
      *@desc： 获取参数类型
      *@Date: 10:30 2018/1/22
      *@param:
      *@return:
      *
      */
    List<XtCsLx> findAllXtCsLx(XtCsLxVO xtCsLxVO) throws Exception;


    /**
      *@method: 根据id查找参数类型
      *@author: lix
      *@desc：
      *@Date: 10:31 2018/1/22
      *@param:
      *@return:
      *
      */
   XtCsLx  getXtCsLxBySkey(String skey) throws Exception;
   
   /**
     *@method: 删除参数类型
     *@author: lix
     *@desc： 
     *@Date: 10:33 2018/1/22
     *@param: 
     *@return:   
     *
     */
   void deleteXtCsLx(String Skey, HttpServletRequest request, Xt_yh xt_yh) throws Exception;
   
   
   /**
     *@method: 保存参数分类信息
     *@author: lix
     *@desc： 
     *@Date: 10:35 2018/1/22
     *@param: 
     *@return:   
     *
     */
   void saveXtCsLx(XtCsLx xtCsLx, HttpServletRequest request,Xt_yh xt_yh) throws Exception;

    /**
     *@method: 根据参数获取系统参数类型
     *@author: lix
     *@desc：
     *@Date: 11:15 2018/1/22
     *@param:
     *@return:
     *
     */
    XtCsLx getXtCsLxByPara(XtCsLxVO xtCsLxVO) throws Exception;

}
