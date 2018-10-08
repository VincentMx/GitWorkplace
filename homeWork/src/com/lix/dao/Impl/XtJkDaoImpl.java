package com.lix.dao.Impl;

import com.lix.dao.XtJkDao;
import com.lix.entity.XtJk;
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
 * @time : 11:522018/9/20
 * @modify by :
 */
@Component("xtJkDao")
public class XtJkDaoImpl implements XtJkDao {

    private Session session;
    private Transaction transaction;

    @Resource
    private SessionFactory sessionFactory;




    @Override
    public void save(XtJk xtJk) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(xtJk);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void update(XtJk xtJk) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(xtJk);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(XtJk xtJk) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(xtJk);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public List<XtJk> findAll(XtJk xtJk) {
        List<XtJk> list = new ArrayList<XtJk>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from XtJk ";
        try{
            Query query = session.createQuery(Hql);
            list = query.list();
            session.flush();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public Page findAllXtjkWithPage(Page page, XtJk xtJk) {
        List<XtJk> list = new ArrayList<XtJk>();
        List<XtJk> countList = new ArrayList<XtJk>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from XtJk where 1 = 1  ";

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
    public XtJk findById(String skey) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        XtJk xtJk = new XtJk();
        try{
            String Hql = "   from XtJk  where skey = '"+ skey +"'";
            Query query = session.createQuery(Hql);
            xtJk = (XtJk) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }

        return xtJk;
    }

    @Override
    public XtJk findByParam(XtJk xtJk) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        XtJk xtJks = new XtJk();
        String Hql = "   from XtJk t where  1 = 1 ";

        if(!StringUtils.isEmpty(xtJk.getJkjym())){
            Hql += " and t.jkjym = '" + xtJk.getJkjym() + "' ";
        }
        if(!StringUtils.isEmpty(xtJk.getSkey())){
            Hql += " and t.skey = '" + xtJk.getSkey() + "' ";
        }

        try{

            Query query = session.createQuery(Hql);
            xtJks = (XtJk) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }

        return xtJks;
    }
}
