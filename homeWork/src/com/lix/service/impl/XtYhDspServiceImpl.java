package com.lix.service.impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtYhDspDao;
import com.lix.entity.XtYhDsp;
import com.lix.service.XtYhDspService;
import com.lix.util.BeanUtils;
import com.lix.util.DateUtils;
import com.lix.util.Page;
import com.lix.util.UuidUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public void addXtYhDspInfo(XtYhDsp xtYhDsp) {

        if(StringUtils.isEmpty(xtYhDsp.getSkey())){
            xtYhDsp.setFlag(Constants.XtYhDsp_SPZ);
            xtYhDsp.setLasttime(DateUtils.getCurrDateTime());
            xtYhDsp.setRegtime(DateUtils.getCurrDate());
            xtYhDsp.setSkey(UuidUtils.get32UUID());
            xtYhDspDao.addXtYhDspInfo(xtYhDsp);
        }else{
            XtYhDsp xtYhDsp1 = xtYhDspDao.getXtYhDspInfoByParam(xtYhDsp);
            BeanUtils.copyPropertityIgnoreNull(xtYhDsp,xtYhDsp1);
            xtYhDspDao.updateXtYhDspInfo(xtYhDsp1);
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
    public void deleteXtYhDspInfoById(String id, String sfzh) throws Exception {
        if(StringUtils.isEmpty(id)){
            throw  new Exception(" id 不能为空！  ");
        }

        XtYhDsp xtYhDsp1 = new XtYhDsp();
        xtYhDsp1.setSkey(id);
        xtYhDspDao.deleteXtYhDspInfoById(xtYhDspDao.getXtYhDspInfoByParam(xtYhDsp1));

    }

    @Override
    public Page getAllXtYhDspWithPage(Page page, XtYhDsp xtYhDsp,String unit) {
        return xtYhDspDao.getXtYhDspByParam(xtYhDsp,page,unit);
    }

}
