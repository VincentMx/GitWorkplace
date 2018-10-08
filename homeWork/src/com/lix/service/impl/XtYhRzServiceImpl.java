package com.lix.service.impl;

import com.lix.dao.XtYhRzDao;
import com.lix.entity.XtYhRzm;
import com.lix.service.XtYhRzService;
import com.lix.util.Page;
import com.lix.util.RandomUtil;
import com.lix.util.UuidUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 18:022018/8/30
 * @modify by :
 */
@Component("xtYhRzService")
public class XtYhRzServiceImpl implements XtYhRzService {


    @Resource
    private XtYhRzDao xtYhRzDao;



    @Override
    public void addXtYhRzxx(XtYhRzm xtYhRzm) throws Exception {

        if(xtYhRzm.getSkey() != null && xtYhRzm.getYhskey() != null && xtYhRzm.getCode() !=null){
            XtYhRzm xtYhRzm1 = xtYhRzDao.findByYhId(xtYhRzm.getYhskey());
            if(xtYhRzm1 != null){
                throw new Exception("认证信息");
            }
            xtYhRzDao.addXtYhRzxx(xtYhRzm);
        }else {
            if(xtYhRzm.getYhskey() != null && !"".equals(xtYhRzm.getYhskey())){
                XtYhRzm xtYhRzm1 = xtYhRzDao.findByYhId(xtYhRzm.getYhskey());
                if(xtYhRzm1 != null){
                    throw new Exception(" 认证信息已存在 ");
                }else {
                   xtYhRzm.setSkey(UuidUtils.get32UUID());
                   xtYhRzm.setCode(RandomUtil.getCharAndNumr(6) + "-" + RandomUtil.getCharAndNumr(4) + "-" + RandomUtil.getCharAndNumr(8));
                   xtYhRzm.setCodetime(DateFormatUtils.format(new Date() , "yyyy-MM-dd HH:mm:ss"));
                   xtYhRzDao.addXtYhRzxx(xtYhRzm);
                }
            }else {
                throw new Exception(" 用户信息不存在 ");

            }

        }
    }

    @Override
    public void delete(XtYhRzm xtYhRzm) {

    }

    @Override
    public void update(XtYhRzm xtYhRzm) {

    }

    @Override
    public List<XtYhRzm> getAllXtYhRzm(XtYhRzm xtYhRzm) {
        return null;
    }

    @Override
    public XtYhRzm findById(String skey) {
        return null;
    }

    @Override
    public XtYhRzm findByYhId(String yhskey) {
        return null;
    }

    @Override
    public Page fingXtYhRzmByPage(Page page, XtYhRzm xtYhRzm) {
        return null;
    }
}
