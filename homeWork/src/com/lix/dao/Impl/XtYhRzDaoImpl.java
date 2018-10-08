package com.lix.dao.Impl;

import com.lix.dao.XtYhRzDao;
import com.lix.entity.XtYhRzm;
import com.lix.util.Page;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lix
 * @desc :  系统认证码操作
 * @time : 17:332018/8/30
 * @modify by :
 */
@Component("xtYhRzDao")
public class XtYhRzDaoImpl implements XtYhRzDao {


    private Session session;
    private Transaction transaction;

    @Resource
    private SessionFactory sessionFactory;

    @Autowired
    private JdbcTemplate jdbcTemplate;




    @Override
    public void addXtYhRzxx(XtYhRzm xtYhRzm) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(xtYhRzm);
            transaction.commit();
            //session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(XtYhRzm xtYhRzm) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(xtYhRzm);
            transaction.commit();
            //session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void update(XtYhRzm xtYhRzm) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(xtYhRzm);
            transaction.commit();
            //session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public List<XtYhRzm> getAllXtYhRzm(XtYhRzm xtYhRzm) {
        List<XtYhRzm> list = new ArrayList<XtYhRzm>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from XtYhRzm t where 1 = 1";
        if(xtYhRzm.getYhskey() != null){
            Hql += " and t.yhskey = '" + xtYhRzm.getYhskey() + "' ";
        }


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
    public XtYhRzm findById(String skey) {
        XtYhRzm xtYhRzm = new XtYhRzm();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            String Hql = "   from XtYhRzm where skey = '"+ skey +"'";
            Query query = session.createQuery(Hql);
            xtYhRzm = (XtYhRzm) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return xtYhRzm;
    }

    @Override
    public XtYhRzm findByYhId(String yhskey) {
        XtYhRzm xtYhRzm = new XtYhRzm();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            String Hql = "   from XtYhRzm where yhskey = '"+ yhskey +"'";
            Query query = session.createQuery(Hql);
            xtYhRzm = (XtYhRzm) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return xtYhRzm;
    }

    @Override
    public Page fingXtYhRzmByPage(Page page, XtYhRzm xtYhRzm) {
        List<XtYhRzm> list = new ArrayList<XtYhRzm>();
        List<XtYhRzm> countList = new ArrayList<XtYhRzm>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from XtYhRzm t where 1 = 1 ";
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
}
