package com.lix.service.impl;


import cn.lix.constants.Constants;
import com.lix.dao.XtZyCzDao;
import com.lix.entity.Xt_zy_cz;
import com.lix.service.XtZyCzService;
import com.lix.util.BeanUtils;
import com.lix.util.UuidUtils;
import com.lix.util.operateUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 23:212017/12/6
 * @modify by :
 */
@Service("xtZyCzService")
public class XtZyCzServiceImpl implements XtZyCzService {

    @Resource
    private XtZyCzDao xtZyCzDao;

    @Override
    public void saveZyCzInfo(Xt_zy_cz xt_zy_cz,HttpServletRequest request,String sfzh) throws Exception {
        if (StringUtils.isEmpty(xt_zy_cz.getSkey())){
            xt_zy_cz.setSkey(UuidUtils.get32UUID());
            xtZyCzDao.saveZyCzInfo(xt_zy_cz);
             operateUtils.addUserOperateLog(sfzh, Constants.OPERATORLOGADD,Constants.OPERATE_SUCCESS,"","添加资源操作","saveZyCzInfo,主键："+xt_zy_cz.getSkey(),request);
        }else {
            Xt_zy_cz xt_zy_cz1 = xtZyCzDao.findById(xt_zy_cz.getSkey());
            BeanUtils.copyPropertityIgnoreNull(xt_zy_cz,xt_zy_cz1);
            xtZyCzDao.updateXtZyCz(xt_zy_cz1);
            operateUtils.addUserOperateLog(sfzh, Constants.OPERATORLOGUPDATE,Constants.OPERATE_SUCCESS,"","修改资源操作","updateZyCzInfo,主键："+xt_zy_cz.getSkey(),request);
        }
    }

    @Override
    public void deleteXtZyCz(Xt_zy_cz xt_zy_cz,HttpServletRequest request,String sfzh) throws Exception {
      if(StringUtils.isEmpty(xt_zy_cz.getSkey())){
          throw new Exception("skey is not allow null");
      }
      try{
          Xt_zy_cz xt_zy_cz1 = xtZyCzDao.findById(xt_zy_cz.getSkey());
          if(!StringUtils.isEmpty(xt_zy_cz1)){
              xtZyCzDao.deleteXtZyCz(xt_zy_cz1);
              operateUtils.addUserOperateLog(sfzh, Constants.OPERATORLOGDELETE,Constants.OPERATE_SUCCESS,"","删除资源操作","deleteXtZyCz,主键："+xt_zy_cz.getSkey(),request);
          }else {
              throw  new Exception(" 不存在该操作！ ");
          }
      }catch (Exception e){
          e.printStackTrace();
      }
    }

    @Override
    public void updateXtZyCz(Xt_zy_cz xt_zy_cz) throws Exception {

        if(!StringUtils.isEmpty(xt_zy_cz.getSkey())){
            try{
                Xt_zy_cz xt_zy_cz1 = xtZyCzDao.findById(xt_zy_cz.getSkey());
                BeanUtils.copyPropertityIgnoreNull(xt_zy_cz,xt_zy_cz1);
                xtZyCzDao.updateXtZyCz(xt_zy_cz1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            throw  new Exception(" skey is not allow null ");
        }
    }

    @Override
    public List<Xt_zy_cz> findAllXtZyCz(Xt_zy_cz xt_zy_cz) {
        List<Xt_zy_cz> list = new ArrayList<Xt_zy_cz>();
        try {
           list = xtZyCzDao.findAllXtZyCz(xt_zy_cz);
       }catch (Exception e){
           e.printStackTrace();
       }
       return list;
    }

    @Override
    public Xt_zy_cz findById(String id) {
        if (id != null && id != "" && id != "undefined" ){
            return xtZyCzDao.findById(id);
        }else {
            return null;
        }
    }

    @Override
    public List<Xt_zy_cz> findXtZyCzByResourcesId(Xt_zy_cz xt_zy_cz) {
       if(!StringUtils.isEmpty(xt_zy_cz.getParentkey())){
          return  xtZyCzDao.findXtZyCzByResourcesId(xt_zy_cz.getParentkey());
       }else {
        return null;
       }
    }
}
