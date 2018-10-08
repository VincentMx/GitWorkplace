package com.lix.dao.Impl;

import com.lix.dao.SequenceDao;
import com.lix.entity.Sequence;
import com.lix.util.Page;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 16:112018/9/20
 * @modify by :
 */
@Component("sequenceDao")
public class SequenceDaoImpl implements SequenceDao {

    private Session session;
    private Transaction transaction;

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void save(Sequence sequence) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(sequence);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(Sequence sequence) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(sequence);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void update(Sequence sequence) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(sequence);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public Page findAllWithPage(Page page, Sequence sequence) {
        List<Sequence> list = new ArrayList<Sequence>();
        List<Sequence> countList = new ArrayList<Sequence>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from Sequence t where 1 = 1  ";
        if(!StringUtils.isEmpty(sequence.getName())){
            Hql += " and t.name like '%" + sequence.getName() + "%' ";
        }
        if(sequence.getCurrentValue() != 0){
            Hql += " and t.currentValue = " + sequence.getCurrentValue() + " ";
        }
        if(sequence.getIncrement() != 0){
            Hql += " and t.increment = " + sequence.getIncrement() + " ";
        }

        try{
            Query query = session.createQuery(Hql);
            countList = query.list();
            query.setFirstResult(page.getStart());
            query.setMaxResults(page.getPageSize());
            list = query.list();
            page.setList(list);
            page.setTotalCount(countList.size());
//            session.flush();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return page;
    }

    @Override
    public Sequence findByParam(Sequence sequence) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Sequence sequence1 = new Sequence();
        String Hql = "   from Sequence t where  1 = 1 ";
        if(!StringUtils.isEmpty(sequence.getName())){
            Hql += " and t.name = '" + sequence.getName() + "' ";
        }
        try{
            Query query = session.createQuery(Hql);
            sequence1 = (Sequence) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return sequence1;
    }
}
