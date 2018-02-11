package com.lix.service.impl;

import com.boyang.core.util.StringUtils;
import cn.lix.constants.Constants;
import com.lix.dao.XtRzCzDao;
import com.lix.entity.XtRzCz;
import com.lix.entity.vo.XtRzCzVO;
import com.lix.service.XtRzCzService;
import com.lix.util.DateUtils;
import com.lix.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 13:302017/12/19
 * @modify by :
 */

@Service("xtRzCzService")
public class XtRzCzServiceImpl implements XtRzCzService {


    @Resource
    private XtRzCzDao xtRzCzDao;



    @Override
    public void addXtCzRz(XtRzCz xtRzCz) throws Exception {
        if(xtRzCz != null){
            xtRzCz.setOperateTime(DateUtils.getCurrDateTime());
            xtRzCz.setYxzt(Constants.XtRzCz_YX);
            xtRzCzDao.addXtCzRz(xtRzCz);
        }else{
            throw new Exception(" xtRzCz is not allow null ");
        }
    }

    @Override
    public void DeleteXtRzCz(XtRzCz xtRzCz) throws Exception {
        if (!StringUtils.isEmpty(xtRzCz.getSkey())){
            XtRzCz xtRzCz1 = xtRzCzDao.getXtRzCzByPara(xtRzCz);
            if(xtRzCz1 == null ){
             throw  new Exception(" 未能获取到操作日志信息  ");
            }else{
                xtRzCzDao.DeleteXtRzCz(xtRzCz1);
            }
        }
    }

    @Override
    public List<XtRzCzVO> findAllXtRzCz(XtRzCzVO xtRzCzVO) {
        return xtRzCzDao.findAllXtRzCz(xtRzCzVO);
    }

    @Override
    public XtRzCz getXtRzCzByPara(XtRzCzVO xtRzCzVO) throws Exception {
       XtRzCz xtRzCz = new XtRzCz();
        if(StringUtils.isEmpty(xtRzCzVO.getSkey())){
           throw  new Exception(" skey is not all null ");
       }else{
           xtRzCz = xtRzCzDao.getXtRzCzByPara(xtRzCzVO);
       }
        return xtRzCz;
    }

    @Override
    public Page getAllRzCzByPage(XtRzCzVO xtRzCzVO, Page page) {
        return xtRzCzDao.getAllXtCzRzByParam(xtRzCzVO,page);
    }
}
