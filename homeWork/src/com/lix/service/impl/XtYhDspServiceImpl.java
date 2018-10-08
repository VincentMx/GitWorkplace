package com.lix.service.impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtYhDspDao;
import com.lix.entity.XtYhDsp;
import com.lix.entity.Xt_yh;
import com.lix.service.XtYhDspService;
import com.lix.util.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 15:582018/2/24
 * @modify by :
 */
@Service("xtYhDspService")
public class XtYhDspServiceImpl implements XtYhDspService {

    @Resource
    private XtYhDspDao xtYhDspDao;

    @Override
    public void addXtYhDspInfo(XtYhDsp xtYhDsp , HttpServletRequest request , Xt_yh xt_yh) throws Exception {

        if(StringUtils.isEmpty(xtYhDsp.getSkey())){
            if(xtYhDsp.getUnit() == null){
                xtYhDsp.setUnit("620000000001");
            }
            xtYhDsp.setFlag(Constants.XtYhDsp_SPZ);
            xtYhDsp.setLasttime(DateFormatUtils.format(new Date() , "yyyy-MM-dd HH:mm:ss"));
            xtYhDsp.setRegtime(DateFormatUtils.format(new Date() , "yyyy-MM-dd HH:mm:ss"));
            xtYhDsp.setSkey(UuidUtils.get32UUID());
            xtYhDspDao.addXtYhDspInfo(xtYhDsp);
           if(xt_yh != null){
               operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGADD,Constants.OPERATE_SUCCESS,"","用户注册","addXtYhDspInfo,主键："+xtYhDsp.getName(),request);
           }

        }else{
            XtYhDsp xtYhDsp1 = xtYhDspDao.getXtYhDspInfoByParam(xtYhDsp);
            BeanUtils.copyPropertityIgnoreNull(xtYhDsp,xtYhDsp1);
            xtYhDspDao.updateXtYhDspInfo(xtYhDsp1);
            if(xt_yh != null){
                operateUtils.addUserOperateLog(xt_yh.getId(), Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","修改用户信息","addXtYhDspInfo,主键："+xtYhDsp.getName(),request);
            }
        }

    }

    @Override
    public List<XtYhDsp> findAllXtYhDsp() {
        return xtYhDspDao.findAllXtYhDsp();
    }

    @Override
    public XtYhDsp getXtYhDspInfoById(String id) throws Exception {
        if(StringUtils.isEmpty(id)){
            throw  new Exception(" id 不能为空！  ");
        }
        XtYhDsp xtYhDsp = new XtYhDsp();
        xtYhDsp.setSkey(id);
        return xtYhDspDao.getXtYhDspInfoByParam(xtYhDsp);
    }

    @Override
    public void SpXtYhDspInfo(String id) {

    }

    @Override
    public String getXtYhDspById(String Id) throws Exception {
        if(StringUtils.isEmpty(Id)){
            throw  new Exception(" id 不能为空！  ");
        }
        if( xtYhDspDao.getXtYhDspById(Id) != null  ){

            return "yes";
        }else{
            return null ;
        }

    }

    @Override
    public void deleteXtYhDspInfoById(String id, String sfzh , HttpServletRequest request) throws Exception {
        if(StringUtils.isEmpty(id)){
            throw  new Exception(" id 不能为空！  ");
        }

        XtYhDsp xtYhDsp1 = new XtYhDsp();
        xtYhDsp1.setSkey(id);
        XtYhDsp xtYhDsp = xtYhDspDao.getXtYhDspInfoByParam(xtYhDsp1);
        xtYhDspDao.deleteXtYhDspInfoById(xtYhDsp);
        operateUtils.addUserOperateLog("", Constants.OPERATORLOGDELETE,Constants.OPERATE_SUCCESS,"","删除待审批用户信息","deleteXtYhDspInfoById,主键："+xtYhDsp.getId(),request);


    }

    @Override
    public Page getAllXtYhDspWithPage(Page page, XtYhDsp xtYhDsp,String unit) {
        return xtYhDspDao.getXtYhDspByParam(xtYhDsp,page,unit);
    }

}
