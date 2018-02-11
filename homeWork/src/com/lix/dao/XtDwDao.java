package com.lix.dao;

import cn.lix.dao.AbstractDao;
import com.lix.entity.XtDw;
import com.lix.entity.vo.XtDwVO;
import com.lix.util.Page;

import java.util.List;

/**
 * @author : lix
 * @desc : ex
 * @time : 10:552017/12/21
 * @modify by :
 */
public interface XtDwDao  extends AbstractDao{

    /**
      *@method: 分页查询单位信息
      *@author: lix
      *@desc： 
      *@Date: 12:37 2018/1/25
      *@param: 
      *@return:   
      *
      */
    Page getXtDwWithPage(XtDwVO xtDwVO ,Page page);
    
    

    /**
      *@method: 查询所有单位信息
      *@author: lix
      *@desc： 
      *@Date: 12:38 2018/1/25
      *@param: 
      *@return:   
      *
      */
    List<XtDwVO> getAllXtDwByPara(XtDwVO xtDwVO);

    /**
      *@method: 获取单位信息
      *@author: lix
      *@desc： 
      *@Date: 12:38 2018/1/25
      *@param: 
      *@return:   
      *
      */
    XtDw getXtDwBySkey(XtDwVO xtDwVO);

    /**
      *@method: 获取单位信息
      *@author: lix
      *@desc： 
      *@Date: 12:38 2018/1/25
      *@param: 
      *@return:   
      *
      */
    XtDwVO getXtDwByPara(XtDwVO xtDwVO);

    /**
      *@method: 新增单位
      *@author: lix
      *@desc： 
      *@Date: 12:38 2018/1/25
      *@param: 
      *@return:   
      *
      */
    void saveXtDw(XtDw xtDw);

    /**
      *@method: 修改单位
      *@author: lix
      *@desc： 
      *@Date: 12:38 2018/1/25
      *@param: 
      *@return:   
      *
      */
    void updateXtDw(XtDw xtDw);

    /**
      *@method: 删除单位信息
      *@author: lix
      *@desc： 
      *@Date: 15:18 2018/1/25
      *@param: 
      *@return:   
      *
      */
    void deleteXtDw(XtDw xtDw);
    
}
