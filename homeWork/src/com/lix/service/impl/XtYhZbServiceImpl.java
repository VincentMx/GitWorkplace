package com.lix.service.impl;

import com.lix.dao.XtYhZbDao;
import com.lix.entity.XtYhZb;
import com.lix.entity.vo.XtYhZbVO;
import com.lix.service.XtYhZbService;
import com.lix.util.BeanUtils;
import com.lix.util.Page;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 15:502018/10/3
 * @modify by :
 */
@Service("xtYhZbService")
public class XtYhZbServiceImpl implements XtYhZbService {

    @Resource
    private XtYhZbDao xtYhZbDao;

    @Override
    public void saveOrUpdate(XtYhZb xtYhZb) throws Exception {
        if(xtYhZb.getSkey() != null){
           XtYhZb xtYhZb1 = xtYhZbDao.findById(xtYhZb);
           if(xtYhZb1 == null){
               throw  new Exception(" 账本信息不能为空 ");
           }else {
               BeanUtils.copyPropertityIgnoreNull(xtYhZb1 , xtYhZb);
               xtYhZbDao.update(xtYhZb);
           }

        }else {
            xtYhZb.setXfsj(DateFormatUtils.format(new Date() , "yyyy-MM-dd HH:mm:ss"));
            xtYhZbDao.save(xtYhZb);

        }
    }

    @Override
    public void deleteXtYhZb(XtYhZb xtYhZb) throws Exception {
      if(StringUtils.isEmpty(xtYhZb.getSkey())){
          throw new Exception(" 账本主键不能为空 ");
      }

      XtYhZb xtYhZb1 = xtYhZbDao.findById(xtYhZb);

      if(xtYhZb1 == null){
          throw new Exception(" 账本信息不能为空 ");
      }else {
          xtYhZbDao.delete(xtYhZb1);
      }

    }

    @Override
    public List<XtYhZbVO> findXtYhZb(XtYhZbVO xtYhZbVO) {
        return xtYhZbDao.findByParam(xtYhZbVO);
    }

    @Override
    public Page findXtYhZbWithPage(Page page, XtYhZbVO xtYhZbVO) {
        return xtYhZbDao.findYhZbWithPage(page , xtYhZbVO);
    }

    @Override
    public XtYhZb findXtYhZb(XtYhZb xtYhZb) {
        return xtYhZbDao.findById(xtYhZb);
    }
}
