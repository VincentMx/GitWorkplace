package com.lix.service.impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtCsLxDao;
import com.lix.entity.XtCsLx;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtCsLxVO;
import com.lix.service.XtCsLxService;

import com.lix.util.BeanUtils;
import com.lix.util.Page;
import com.lix.util.UuidUtils;
import com.lix.util.operateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * @author : lix
 * @desc :
 * @time : 10:002018/1/22
 * @modify by :
 *
 */
@Service("xtCsLxService")
public class XtCsLxServiceImpl implements XtCsLxService {


    @Resource
    private XtCsLxDao xtCsLxDao;

    @Override
    public Page getAllXtCsWithPage(XtCsLxVO xtCsLxVO, Page page) {
        return xtCsLxDao.getAllXtCsWithPage(xtCsLxVO,page);
    }

    @Override
    public List<XtCsLx> findAllXtCsLx(XtCsLxVO xtCsLxVO) throws Exception {
        if(xtCsLxVO == null){
            throw   new Exception(" 在查询参数类型时xtCsLxVO不能为空  ");
        }
        return xtCsLxDao.findAllXtCsLx(xtCsLxVO);
    }

    @Override
    public XtCsLx getXtCsLxBySkey(String skey) throws Exception {
        if (skey == null  || skey == "" || skey == "undefined"){
            throw  new Exception(" skey 不能为空  ");
        }
        return xtCsLxDao.getXtCsLxBySkey(skey);
    }

    @Override
    public void deleteXtCsLx(String Skey, HttpServletRequest request, Xt_yh xt_yh) throws Exception {
        if (Skey == null  || Skey == "" || Skey == "undefined"){
            throw  new Exception(" skey 不能为空  ");
        }else{
            try {
                XtCsLx  xtCsLx = getXtCsLxBySkey(Skey);
                if(xtCsLx.getSkey() == null || xtCsLx.getCode()  == null ||  xtCsLx.getName() == null){
                   throw  new Exception(" 未能获取到相关参数类型记录 ");
                }else{
                    xtCsLxDao.deleteXtCsLx(xtCsLx);
                    operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGDELETE,Constants.OPERATE_SUCCESS,"","删除参数类型信息","deleteXtCslX,主键："+xtCsLx.getSkey(),request);

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public void saveXtCsLx(XtCsLx xtCsLx, HttpServletRequest request,Xt_yh xt_yh) throws Exception {

        if (xtCsLx.getSkey() == null || xtCsLx.getSkey() == ""){
            xtCsLx.setSkey(UuidUtils.get32UUID());
            xtCsLx.setYxzt(Constants.XtCsLx_YX);
            xtCsLxDao.saveXtCsLx(xtCsLx);
            operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGADD,Constants.OPERATE_SUCCESS,"","保存参数类型信息","saveXtCslX,主键："+xtCsLx.getSkey(),request);

        }else{
            try {
                XtCsLx  xtCsLx1 = getXtCsLxBySkey(xtCsLx.getSkey());
                BeanUtils.copyPropertityIgnoreNull(xtCsLx,xtCsLx1);
                xtCsLxDao.updateXtCsLx(xtCsLx1);
                operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","修改参数类型信息","updateXtCslX,主键："+xtCsLx.getSkey(),request);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public XtCsLx getXtCsLxByPara(XtCsLxVO xtCsLxVO) throws Exception {
        if (xtCsLxVO == null){
            throw  new Exception(" xtCsLxVO 不能为空  ");
        }
        return xtCsLxDao.getXtCsLxByPara(xtCsLxVO);
    }
}
