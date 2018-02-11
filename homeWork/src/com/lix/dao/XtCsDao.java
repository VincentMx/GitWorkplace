package com.lix.dao;

import cn.lix.dao.AbstractDao;
import com.lix.entity.XtCs;
import com.lix.entity.vo.XtCsVO;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 14:502017/12/27
 * @modify by :
 */
public interface XtCsDao extends AbstractDao {
    
    /**
      *@method: 根据分页获取参数
      *@author: lix
      *@desc： 
      *@Date: 15:07 2017/12/27
      *@param: 
      *@return:   
      *
      */
    Page getAllXtCsWithPage(XtCsVO xtCsVO, Page page);

    /**
      *@method: 查询所有系统参数
      *@author: lix
      *@desc：
      *@Date: 15:17 2018/1/23
      *@param:
      *@return:
      *
      */
    List<XtCsVO> findAllXtCsByPara(XtCsVO xtCsVO);

    /**
      *@method: 根据编号查询系统参数信息
      *@author: lix
      *@desc：
      *@Date: 15:18 2018/1/23
      *@param:
      *@return:
      *
      */
    XtCsVO getXtCsVoBySkey(String skey);

    /**
      *@method: 根据编号获取系统参数信息
      *@author: lix
      *@desc：
      *@Date: 15:18 2018/1/23
      *@param:
      *@return:
      *
      */
    XtCs getXtCsBySkey(String skey);

    /**
      *@method: 添加或修改系统参数信息
      *@author: lix
      *@desc：
      *@Date: 15:21 2018/1/23
      *@param:
      *@return:
      *
      */
    void saveOrUpdateXtCs(XtCs xtCs,String type);

    /**
      *@method: 删除系统参数信息
      *@author: lix
      *@desc：
      *@Date: 15:21 2018/1/23
      *@param:
      *@return:
      *
      */
    void deleteXtCs(XtCs xtCs);





}
