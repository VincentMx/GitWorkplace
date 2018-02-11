package com.lix.service.impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtjsDao;
import com.lix.entity.Xt_js;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtJsVO;
import com.lix.service.XtJsService;
import com.lix.util.BeanUtils;
import com.lix.util.Page;
import com.lix.util.UuidUtils;
import com.lix.util.operateUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 22:522017/11/26
 * @modify by :
 */
@Service("xtJsService")
public class XtJsServiceImpl implements XtJsService {

    @Resource
    private XtjsDao xtjsDao;

    @Override
    public void saveJs(Xt_js xt_js, HttpServletRequest request, Xt_yh xt_yh) throws Exception {
        if (StringUtils.isEmpty(xt_js.getSkey())){
            xt_js.setSkey(UuidUtils.get32UUID());
            xt_js.setFlag(Constants.XtJsYxzt_YX);
            xtjsDao.saveJs(xt_js);
            operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGADD,Constants.OPERATE_SUCCESS,"","添加角色信息","saveJs,主键："+xt_js.getSkey(),request);
        }else {
            Xt_js xt_js1 = xtjsDao.findByPara(xt_js);
            BeanUtils.copyPropertityIgnoreNull(xt_js,xt_js1);
            xtjsDao.updateJs(xt_js1);
            operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","修改角色信息","updateJs,主键："+xt_js.getSkey(),request);
        }
    }

    @Override
    public Page findAllJs(XtJsVO xtJsVO,Page page) {
        return xtjsDao.findAllJs(xtJsVO,page);
    }

    @Override
    public void updateJs(Xt_js xt_js,HttpServletRequest request,Xt_yh xt_yh) throws Exception {
        if (!StringUtils.isEmpty(xt_js.getSkey())) {
            Xt_js xt_js1 =  xtjsDao.findByPara(xt_js);
            xt_js1.setFlag(Constants.XtJsYxzt_WX);
            xtjsDao.updateJs(xt_js);
            operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","修改角色信息","updateJs,主键："+xt_js.getSkey(),request);
        }
    }
}
