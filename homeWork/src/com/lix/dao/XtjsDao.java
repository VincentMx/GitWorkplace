package com.lix.dao;

import com.lix.entity.Xt_js;
import com.lix.entity.vo.XtJsVO;
import com.lix.util.Page;

import java.util.List;

public interface XtjsDao {


    /**
      *@method: saveJs
      *@author: lix
      *@desc： 保存角色方法
      *@Date: 22:25 2017/11/26
      *@param: xt_js
      *@return:   
      *
      */
    void saveJs(Xt_js xt_js);
    /**
      *@method: 分页查询
      *@author: lix
      *@desc： 获取所有的角色信息
      *@Date: 22:27 2017/11/26
      *@param: xt_js
      *@return:
      *
      */
    Page findAllJs(XtJsVO xtJsVO, Page page);

    /**
      *@method: updateJs
      *@author: lix
      *@desc： 修改角色信息
      *@Date: 22:28 2017/11/26
      *@param: xt_js
      *@return: void
      *
      */
    void updateJs(Xt_js xt_js);

    /**
      *@method: findByPara
      *@author: lix
      *@desc： 根据名称或者编号获取角色信息
      *@Date: 23:00 2017/11/26
      *@param: xt_js
      *@return: void
      *
      */
    Xt_js findByPara(Xt_js xt_js);
}
