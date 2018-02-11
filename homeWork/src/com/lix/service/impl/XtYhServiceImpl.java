package com.lix.service.impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtYhDao;
import com.lix.entity.XtZy;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtYhVO;
import com.lix.service.XtYhService;
import com.lix.service.XtZyService;
import com.lix.util.BeanUtils;
import com.lix.util.Page;
import com.lix.util.UuidUtils;
import com.lix.util.operateUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * @author : lix
 * @desc :
 * @time : 23:472017/11/29
 * @modify by :
 */
@Service("xtYhService")
public class XtYhServiceImpl implements XtYhService {

    @Resource
    private XtYhDao xtYhDao;



    @Override
    public void saveYhInfo(Xt_yh xt_yh,HttpServletRequest request,Xt_yh xt_yh2) throws Exception {
        if (StringUtils.isEmpty(xt_yh.getSkey())){
            xt_yh.setSkey(UuidUtils.get32UUID());
            xt_yh.setFlag(Constants.XtYhYxzt_YX);
            xtYhDao.saveYhInfo(xt_yh);
            operateUtils.addUserOperateLog(xt_yh2.getId(), Constants.OPERATORLOGADD,Constants.OPERATE_SUCCESS,"","添加用户信息","saveXtYh,主键："+xt_yh.getSkey(),request);
        }else {
            Xt_yh xt_yh1 = xtYhDao.findYhInfoById(xt_yh.getSkey());
            BeanUtils.copyPropertityIgnoreNull(xt_yh,xt_yh1);
            xtYhDao.updateXtYhInfo(xt_yh1);
            operateUtils.addUserOperateLog(xt_yh2.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","修改用户信息","updateXtYh,主键："+xt_yh.getSkey(),request);
        }
    }

    @Override
    public List<Xt_yh> findAllXtYh(Xt_yh xt_yh) {
        return xtYhDao.findAllXtYh(xt_yh);
    }

    @Override
    public void updateXtYhInfo(Xt_yh xt_yh) {
        Xt_yh xt_yh1 = xtYhDao.findYhInfoById(xt_yh.getSkey());
        BeanUtils.copyPropertityIgnoreNull(xt_yh,xt_yh1);
        xtYhDao.updateXtYhInfo(xt_yh1);
    }

    @Override
    public Xt_yh findYhInfoById(String skey) {
        return xtYhDao.findYhInfoById(skey);
    }

    @Override
    public Xt_yh findXtYhByPara(Xt_yh xt_yh) {
        if (xt_yh == null){
            return  null;
        }else {
            return xtYhDao.findXtYhByPara(xt_yh);
        }
    }

    @Override
    public void deleteXtYh(String skey,HttpServletRequest request,Xt_yh xt_yh1) throws Exception {
        if(!StringUtils.isEmpty(skey)){
            Xt_yh xt_yh = xtYhDao.findYhInfoById(skey);
            if(xt_yh != null){
                xtYhDao.deleteXtYh(xt_yh);
                operateUtils.addUserOperateLog(xt_yh1.getId(), Constants.OPERATORLOGDELETE,Constants.OPERATE_SUCCESS,"","删除用户信息","deleteXtYh,主键："+xt_yh.getSkey(),request);
            }else{
                operateUtils.addUserOperateLog(xt_yh1.getId(), Constants.OPERATORLOGDELETE,Constants.OPERATE_FAIL,"","删除用户信息","deleteXtYh,主键："+xt_yh.getSkey(),request);
                throw new Exception("未找到该条记录");
            }
        }else{
            throw new Exception(" skey 不能为空  ");
        }
    }

    @Override
    public Page getAllXtYh(Page page, XtYhVO xtYhVO, HttpServletRequest request) {
        return xtYhDao.getAllXtYh(page,xtYhVO);
    }

    @Override
    public void removeXtYh(String skey, HttpServletRequest request,Xt_yh xt_yh1) throws Exception {
        if(!StringUtils.isEmpty(skey)){
            Xt_yh xt_yh = xtYhDao.findYhInfoById(skey);
            if(xt_yh != null){
                 xt_yh.setFlag(Constants.XtYh_ZX);
                 xtYhDao.updateXtYhInfo(xt_yh);
                operateUtils.addUserOperateLog(xt_yh1.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","注销用户信息","removeXtYh,主键："+xt_yh.getSkey(),request);
            }else{
                operateUtils.addUserOperateLog(xt_yh1.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_FAIL,"","注销用户信息","removeXtYh,主键："+xt_yh.getSkey(),request);
                throw new Exception("未找到该条记录");
            }
        }else{
            throw new Exception(" skey 不能为空  ");
        }
    }
}
