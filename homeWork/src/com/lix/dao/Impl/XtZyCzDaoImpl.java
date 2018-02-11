package com.lix.dao.Impl;

import com.lix.dao.XtZyCzDao;
import com.lix.entity.Xt_zy_cz;
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
 * @time : 15:182017/12/6
 * @modify by :
 */
@Component("xtZyCzDao")
public class XtZyCzDaoImpl implements XtZyCzDao {


    private Session session;
    private Transaction transaction;

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void saveZyCzInfo(Xt_zy_cz xt_zy_cz) {

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(xt_zy_cz);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteXtZyCz(Xt_zy_cz xt_zy_cz) {

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(xt_zy_cz);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateXtZyCz(Xt_zy_cz xt_zy_cz) {

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(xt_zy_cz);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Xt_zy_cz> findAllXtZyCz(Xt_zy_cz xt_zy_cz) {
        List<Xt_zy_cz> list = new ArrayList<Xt_zy_cz>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = " from Xt_zy_cz where parentkey = '"+xt_zy_cz.getParentkey()+"' ";
        try{
            Query query = session.createQuery(Hql);
            list = query.list();
            transaction.commit();
            session.flush();
        }catch (Exception e){
            transaction.rollback();
        } finally{
            session.close();
        };

        return list;
    }

    @Override
    public Xt_zy_cz findById(String id) {
        Xt_zy_cz xt_zy_cz = new Xt_zy_cz();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = " from Xt_zy_cz where skey = '"+ id +"' ";
        try{
            Query query = session.createQuery(Hql);
            xt_zy_cz = (Xt_zy_cz) query.getSingleResult();
            transaction.commit();
            session.flush();
        }catch (Exception e){
            transaction.rollback();
        } finally{
            session.close();
        }

        return xt_zy_cz;
    }

    @Override
    public List<Xt_zy_cz> findXtZyCzByResourcesId(String Skey) {
        List<Xt_zy_cz> list = new ArrayList<Xt_zy_cz>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = " from Xt_zy_cz where parentkey = '"+Skey+"' order by seq asc ";
        try{
            Query query = session.createQuery(Hql);
            list = query.list();
            transaction.commit();
            //session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        } finally{
            session.close();
        };

        return list;
    }
}
