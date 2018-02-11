package com.lix.service;

import com.lix.entity.Xt_js;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtJsVO;
import com.lix.util.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 22:512017/11/26
 * @modify by :
 */
public interface XtJsService {

    /**
     *@method: saveJs
     *@author: lix
     *@desc： 保存角色方法
     *@Date: 22:25 2017/11/26
     *@param: xt_js
     *@return:
     *
     */
    void saveJs(Xt_js xt_js, HttpServletRequest request, Xt_yh xt_yh) throws Exception;
    /**
     *@method: findAllJs
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
     *@return:
     *
     */
    void updateJs(Xt_js xt_js,HttpServletRequest request,Xt_yh xt_yh) throws Exception;
}
