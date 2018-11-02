package com.lix.dao.impl;

import com.lix.dao.TestDao;
import com.lix.entity.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : lix
 * @desc :
 * @time : 2018/11/2 14:55
 * @modify by :
 * @modify Time:
 */
@Component("testDao")
public class TestDaoImpl implements TestDao {

    private Session session;
    private Transaction transaction;
    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void save(Test test) {
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(test);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }
}
