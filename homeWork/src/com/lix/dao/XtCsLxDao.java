package com.lix.dao;

import cn.lix.dao.AbstractDao;
import com.lix.entity.XtCsLx;
import com.lix.entity.vo.XtCsLxVO;
import com.lix.entity.vo.XtCsVO;
import com.lix.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 14:502017/12/27
 * @modify by :
 */
public interface XtCsLxDao {
    
    /**
      *@method: 根据分页获取参数
      *@author: lix
      *@desc： 
      *@Date: 15:07 2017/12/27
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
    List<XtCsLx> findAllXtCsLx(XtCsLxVO xtCsLxVO);


    /**
     *@method: 根据id查找参数类型
     *@author: lix
     *@desc：
     *@Date: 10:31 2018/1/22
     *@param:
     *@return:
     *
     */
    XtCsLx  getXtCsLxBySkey(String skey);

    /**
     *@method: 删除参数类型
     *@author: lix
     *@desc：
     *@Date: 10:33 2018/1/22
     *@param:
     *@return:
     *
     */
    void deleteXtCsLx(XtCsLx xtCsLx);


    /**
     *@method: 保存参数分类信息
     *@author: lix
     *@desc：
     *@Date: 10:34 2018/1/22
     *@param:
     *@return:
     *
     */
    void saveXtCsLx(XtCsLx xtCsLx);
    
    /**
      *@method: 修改参数类型
      *@author: lix
      *@desc： 
      *@Date: 10:43 2018/1/22
      *@param: 
      *@return:   
      *
      */
    void updateXtCsLx(XtCsLx xtCsLx);
    
    /**
      *@method: 根据参数获取系统参数类型
      *@author: lix
      *@desc： 
      *@Date: 11:19 2018/1/22
      *@param: 
      *@return:   
      *
      */
    XtCsLx getXtCsLxByPara(XtCsLxVO xtCsLxVO);

}
