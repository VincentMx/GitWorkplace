package com.lix.service.impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtCsDao;
import com.lix.entity.XtCs;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtCsVO;
import com.lix.service.XtCsService;
import com.lix.util.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 15:072017/12/27
 * @modify by :
 */

@Service("xtCsService")
public class XtCsServiceImpl implements XtCsService {

    @Resource
    private XtCsDao xtCsDao;

    @Override
    public Page getAllXtCsWithPage(XtCsVO xtCsVO, Page page) {
        return xtCsDao.getAllXtCsWithPage(xtCsVO,page);
    }

    @Override
    public List<XtCsVO> findAllXtCsByPara(XtCsVO xtCsVO) {
        return xtCsDao.findAllXtCsByPara(xtCsVO);
    }

    @Override
    public XtCsVO getXtCsVoBySkey(String skey) throws Exception {
        if (StringUtils.isEmpty(skey) || "undefined".equals(skey)){
            throw new Exception(" skey 不能为空  ");
        }
        return xtCsDao.getXtCsVoBySkey(skey);
    }

    @Override
    public XtCs getXtCsBySkey(String skey) throws Exception {
        if (StringUtils.isEmpty(skey) || "undefined".equals(skey)){
            throw new Exception(" skey 不能为空  ");
        }
        return xtCsDao.getXtCsBySkey(skey);
    }

    @Override
    public void saveOrUpdateXtCs(XtCs xtCs, HttpServletRequest request, Xt_yh xt_yh) throws Exception {
         String type = null;
         if (xtCs != null){
             if(xtCs.getSkey() == null){
                 type = "save";
                 xtCs.setSkey(UuidUtils.get32UUID());
                 xtCs.setYxzt(Constants.XtCs_YX);
                 xtCs.setCreattime(DateUtils.getCurrDateTime());
                 xtCsDao.saveOrUpdateXtCs(xtCs,type);
                 operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGADD,Constants.OPERATE_SUCCESS,"","添加参数信息","saveXtCs,主键："+xtCs.getSkey(),request);

             }else {
                 type = "update";
                 XtCs xtCs1 = getXtCsBySkey(xtCs.getSkey());
                 BeanUtils.copyPropertityIgnoreNull(xtCs,xtCs1);
                 xtCsDao.saveOrUpdateXtCs(xtCs1,type);
                 operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","修改参数信息","updateXtCs,主键："+xtCs.getSkey(),request);

             }
         }else{
             throw  new Exception(" 执行保存操作时XtCs不能为空  ");
         }
    }

    @Override
    public void deleteXtCs(String skey,HttpServletRequest request,Xt_yh xt_yh) throws Exception {
       if(StringUtils.isEmpty(skey) || "undefined".equals(skey)){
           throw new Exception(" skey 在deleteXtCs时不能为空  ");
       }else{
           XtCs xtCs = getXtCsBySkey(skey);
           if(xtCs == null){
               throw  new Exception("  在deleteXtCs时未能获取到xtcs  ");
           }else{
               xtCsDao.deleteXtCs(xtCs);
               operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGDELETE,Constants.OPERATE_SUCCESS,"","删除参数信息","deleteXtCs,主键："+xtCs.getSkey(),request);
           }
       }
    }
}
