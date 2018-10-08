package com.lix.service.impl;

import com.lix.dao.SequenceDao;
import com.lix.entity.Sequence;
import com.lix.service.SequenceService;
import com.lix.util.BeanUtils;
import com.lix.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : lix
 * @desc :
 * @time : 16:192018/9/20
 * @modify by :
 */
@Service("sequenceService")
public class SequenceServiceImpl implements SequenceService {

   @Resource
   private SequenceDao sequenceDao;


    @Override
    public void saveOrUpdate(Sequence sequence) {
        Sequence sequence1 = sequenceDao.findByParam(sequence);
        if( sequence1.getName() == null && sequence1.getCurrentValue() == 0){
            sequenceDao.save(sequence);
        }else {
            BeanUtils.copyPropertityIgnoreNull(sequence1 , sequence);
            sequenceDao.update(sequence);
        }
    }

    @Override
    public void deleteSequence(String name) throws Exception {
        Sequence sequence = new Sequence();
        sequence.setName(name);
        Sequence sequence1 = sequenceDao.findByParam(sequence);
       if(sequence1 != null){
           sequenceDao.delete(sequence1);
       }else {
           throw new Exception("未获取到该序列参数");
       }
    }

    @Override
    public Page findAllWithPage(Page page, Sequence sequence) {
        return sequenceDao.findAllWithPage(page , sequence);
    }


    @Override
    public Sequence findByParam(Sequence sequence) throws Exception {
        if(sequence == null){
            throw  new Exception("请输入查询条件");
        }
        return sequenceDao.findByParam(sequence);
    }
}
