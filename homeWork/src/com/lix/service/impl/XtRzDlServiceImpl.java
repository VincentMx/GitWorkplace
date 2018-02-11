package com.lix.service.impl;

import com.boyang.core.util.StringUtils;
import cn.lix.constants.Constants;
import com.lix.dao.XtRzDlDao;
import com.lix.entity.XtRzDl;
import com.lix.entity.vo.XtDlRzVO;
import com.lix.service.XtRzDlService;
import com.lix.util.Page;
import com.lix.util.UuidUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 8:432017/12/14
 * @modify by :
 */
@Service("xtRzDlService")
public class XtRzDlServiceImpl implements XtRzDlService {

    @Resource
    private XtRzDlDao xtRzDlDao;

    @Override
    public void addYhDlRz(XtRzDl xtRzDl) throws Exception {
        if(xtRzDl != null){
            xtRzDl.setSkey(UuidUtils.get32UUID());
            xtRzDl.setYxzt(Constants.XTRZDL_YX);
            xtRzDlDao.addYhDlRz(xtRzDl);
        }else{
            throw  new Exception(" xtRzDl is not allow null ");
        }
    }

    @Override
    public void deleteYhDlRz(XtRzDl xtRzDl) throws Exception {
       if (!StringUtils.isEmpty(xtRzDl.getSkey())){
           XtRzDl xtRzDl1 = xtRzDlDao.getXtGlRzByParam(xtRzDl);
           xtRzDlDao.deleteYhDlRz(xtRzDl1);
       }else{
            throw  new Exception(" xtRzDl SKEY is not allow null ");
       }
    }

    @Override
    public List<XtDlRzVO> getAllYhDlRz(XtDlRzVO xtDlRzVO) {
        return xtRzDlDao.getAllYhDlRz(xtDlRzVO);
    }

    @Override
    public XtRzDl getXtGlRzByParam(XtRzDl xtRzDl) throws Exception {
        XtRzDl xtRzDl1 = new XtRzDl();
        if (!StringUtils.isEmpty(xtRzDl.getSkey())){
           xtRzDl1 = xtRzDlDao.getXtGlRzByParam(xtRzDl);
        }else{
            throw  new Exception(" xtRzDl SKEY is not allow null ");
        }
        return xtRzDl1;
    }

    @Override
    public Page getAllXtRzDlByParam(XtDlRzVO xtDlRzVO, Page page) {
        return xtRzDlDao.getAllXtRzDlByParam(xtDlRzVO,page);
    }
}
