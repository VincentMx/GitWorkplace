package com.lix.service.impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtDwDao;
import com.lix.entity.XtDw;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtDwVO;
import com.lix.service.XtDwService;
import com.lix.util.BeanUtils;
import com.lix.util.Page;
import com.lix.util.UuidUtils;
import com.lix.util.operateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 14:492018/1/25
 * @modify by :
 */
@Service("xtDwService")
public class XtDwServiceImpl implements XtDwService {

    @Resource
    private XtDwDao xtDwDao;

    @Override
    public Page getXtDwWithPage(Page page, XtDwVO xtDwVO, HttpServletRequest request, String sfzh) {
        return xtDwDao.getXtDwWithPage(xtDwVO,page);
    }

    @Override
    public List<XtDwVO> getAllXtDw(XtDwVO xtDwVO, HttpServletRequest request) {
        return xtDwDao.getAllXtDwByPara(xtDwVO);
    }

    @Override
    public XtDw getXtDwByParam(XtDwVO xtDwVO) throws Exception {
        if(StringUtils.isEmpty(xtDwVO.getSkey()) || xtDwVO.getSkey() == "undefined"){
            throw  new Exception(" 在查询系统单位信息时skey 不能为空");
        }

        return xtDwDao.getXtDwBySkey(xtDwVO);
    }

    @Override
    public XtDwVO getXtDwVoByParam(XtDwVO xtDwVO) throws Exception {
        if(StringUtils.isEmpty(xtDwVO.getSkey()) || xtDwVO.getSkey() == "undefined"){
            throw  new Exception(" 在查询系统单位信息时skey 不能为空");
        }

        return xtDwDao.getXtDwByPara(xtDwVO);
    }

    @Override
    public void saveOrUpdate(XtDw xtDw, HttpServletRequest request, Xt_yh xt_yh) throws Exception {

        if(xtDw == null){
            throw new Exception(" 在执行保存操作的时候xtdw不能为空  ");
        }else{
            if(xtDw.getSkey() == null){
                xtDw.setYxzt(Constants.XtDw_YX);
                xtDw.setSkey(UuidUtils.get32UUID());
                xtDwDao.saveXtDw(xtDw);
                operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGADD,Constants.OPERATE_SUCCESS,"","添加单位信息","saveDw,主键："+xtDw.getSkey(),request);

            }else{
                XtDwVO xtDwVO = new XtDwVO();
                xtDwVO.setSkey(xtDw.getSkey());
                XtDw xtDw1 = getXtDwByParam(xtDwVO);
                if(xtDw1 == null){
                    throw  new Exception(" 未能获取到该系统单位信息");
                }else {
                    BeanUtils.copyPropertityIgnoreNull(xtDw,xtDw1);
                    xtDwDao.updateXtDw(xtDw1);
                    operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","修改单位信息","saveDw,主键："+xtDw.getSkey(),request);
                }
            }
        }
    }

    @Override
    public void deleteXtDwINFO(String skey,HttpServletRequest request,Xt_yh xt_yh) throws Exception {
        if(StringUtils.isEmpty(skey) || skey == "undefined"){
            throw  new Exception(" 在删除系统单位信息时skey 不能为空");
        }
        XtDwVO xtDwVO = new XtDwVO();
        xtDwVO.setSkey(skey);
        XtDw xtDw1 = getXtDwByParam(xtDwVO);
        if(xtDw1 == null){
            throw  new Exception(" 未能获取到该系统单位信息");
        }else {
            xtDwDao.deleteXtDw(xtDw1);
            operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGDELETE,Constants.OPERATE_SUCCESS,"","删除单位信息","saveDw,主键："+xtDw1.getSkey(),request);

        }
    }
}
