package com.lix.service.impl.common;

import com.lix.dao.common.CommonDao;
import com.lix.service.common.CommonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : lix
 * @desc :
 * @time : 16:272018/9/20
 * @modify by :
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Resource
    private CommonDao commonDao;

//    String a = commonDao.getCurrVal("orderNoSequence");
//    String b = commonDao.getNextVal("orderNoSequence");
//    String c =  commonDao.setVal("orderNoSequence", 10);

    @Override
    public String getNextVal(String name) {
        return commonDao.getNextVal(name);
    }

    @Override
    public String getCurrVal(String name) {
        return commonDao.getCurrVal(name);
    }

    @Override
    public String setVal(String name, int num) {
        return commonDao.setVal(name , num);
    }
}
