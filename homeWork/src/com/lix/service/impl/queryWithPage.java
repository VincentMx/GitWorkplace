package com.lix.service.impl;

import com.lix.util.Page;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 11:412017/12/26
 * @modify by :
 */
public class queryWithPage {


  //  private static Session session;
   // private static Transaction transaction;

    private  SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public  Page queryWithPage(String Hql, Page page) {
        List<Object> list = new ArrayList<Object>();

        Hql += "  limit " + page.getStart() + "," + page.getPageSize() + " ";
        try {
            Query query = getSession().createQuery(Hql);
            list = query.list();
            page.setStart(page.getStart());
            page.setTotalCount(list.size());
            page.setList(list);
            getSession().beginTransaction().commit();
            // session.flush();
        } catch (Exception e) {
            e.getMessage();
            getSession().beginTransaction().rollback();
        } finally {
            getSession().close();
        }

        return page;

    }
}