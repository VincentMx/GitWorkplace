package com.lix.service.impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtYhWxDao;
import com.lix.entity.XtYhWx;
import com.lix.service.XtYhWxService;
import com.lix.util.BeanUtils;
import com.lix.util.UuidUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : lix
 * @desc : 系统用户微信的业务层
 * @time : 8:242018/9/7
 * @modify by :
 */
@Service("xtYhWxService")
public class XtYhWxServiceImpl implements XtYhWxService {

    @Resource
    private XtYhWxDao xtYhWxDao;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(XtYhWx xtYhWx) throws Exception {
       if(xtYhWx.getOpenid() == null){
           throw new Exception("微信openId为空");
       }
       XtYhWx xtYhWx1 = xtYhWxDao.findByOpenId(xtYhWx);
       if(xtYhWx1 == null){
           xtYhWx.setSkey(UuidUtils.get32UUID());
           xtYhWx.setBz1(Constants.XT_YH_WX_YX);
           xtYhWxDao.save(xtYhWx);
       }
    }

    @Override
    public void update(XtYhWx xtYhWx) throws Exception {
        if(xtYhWx.getOpenid() == null){
            throw new Exception("微信openId为空");
        }
        XtYhWx xtYhWx1 = xtYhWxDao.findByOpenId(xtYhWx);
        if(xtYhWx1 == null){
            BeanUtils.copyPropertityIgnoreNull(xtYhWx , xtYhWx1);
            xtYhWxDao.update(xtYhWx1);
        }
    }

    @Override
    public void delete(XtYhWx xtYhWx) throws Exception {
        if(xtYhWx.getOpenid() == null){
            throw new Exception("微信openId为空");
        }
        XtYhWx xtYhWx1 = xtYhWxDao.findByOpenId(xtYhWx);
        if(xtYhWx1 == null){
            xtYhWxDao.delete(xtYhWx1);
        }
    }

    @Override
    public XtYhWx findById(XtYhWx xtYhWx) throws Exception {
        if(xtYhWx.getSkey() == null){
            throw new Exception("主键为空");
        }

        return xtYhWxDao.findById(xtYhWx);
    }

    @Override
    public List<XtYhWx> findAll(XtYhWx xtYhWx) {
        return xtYhWxDao.findAll(xtYhWx);
    }

    @Override
    public XtYhWx findByOpenId(XtYhWx xtYhWx) throws Exception {
        if (xtYhWx.getOpenid() == null){
            throw new Exception("微信openId为空");
        }
        return xtYhWxDao.findByOpenId(xtYhWx);
    }
}
