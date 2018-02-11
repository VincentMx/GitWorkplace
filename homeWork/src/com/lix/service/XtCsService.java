package com.lix.service;

import com.lix.entity.XtCs;
import com.lix.entity.Xt_yh;
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
public interface XtCsService {

    /**
     *@method: 根据分页获取参数
     *@author: lix
     *@desc：
     *@Date: 14:55 2017/12/27
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
    XtCsVO getXtCsVoBySkey(String skey) throws Exception;

    /**
     *@method: 根据编号获取系统参数信息
     *@author: lix
     *@desc：
     *@Date: 15:18 2018/1/23
     *@param:
     *@return:
     *
     */
    XtCs getXtCsBySkey(String skey) throws Exception;

    /**
     *@method: 添加或修改系统参数信息
     *@author: lix
     *@desc：
     *@Date: 15:21 2018/1/23
     *@param:
     *@return:
     *
     */
    void saveOrUpdateXtCs(XtCs xtCs, HttpServletRequest request, Xt_yh xt_yh) throws Exception;

    /**
     *@method: 删除系统参数信息
     *@author: lix
     *@desc：
     *@Date: 15:21 2018/1/23
     *@param:
     *@return:
     *
     */
    void deleteXtCs(String skey,HttpServletRequest request,Xt_yh xt_yh) throws Exception;

}
