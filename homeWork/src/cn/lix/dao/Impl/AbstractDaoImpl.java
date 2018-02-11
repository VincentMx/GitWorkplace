package cn.lix.dao.Impl;

import com.boyang.core.util.StringUtils;
import cn.lix.dao.AbstractDao;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import com.lix.entity.vo.XtDlRzVO;
import com.lix.util.Page;
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
 * @time : 14:572017/12/16
 * @modify by :
 */
@Component("abstractDao")
public class AbstractDaoImpl implements AbstractDao{

    private Session session;
    private Transaction transaction;

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void add(Object o) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(o);
            transaction.commit();
        }catch (Exception e){
            e.getMessage();
            transaction.rollback();
        }finally {
            session.close();
        }

    }

    @Override
    public void delete(Object o) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(o);
            transaction.commit();
            session.flush();
        }catch (Exception e){
            e.getMessage();
            transaction.rollback();
        }finally {
            session.close();
        }

    }

    @Override
    public void update(Object o) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(o);
            transaction.commit();
            session.flush();
        }catch (Exception e){
            e.getMessage();
            transaction.rollback();
        }finally {
            session.close();
        }

    }

    @Override
    public Object getById(String id,Object o) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            String  Hql = " from " + o + " where    = "+ id +" ";

           Query query = session.createQuery(Hql);
            transaction.commit();
        }catch (Exception e){
            e.getMessage();
            transaction.rollback();
        }finally {
            session.close();
        }

        return null;
    }

    @Override
    public List<Object> findAll( Object object) {

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Object> list = new ArrayList<Object>();
        try{
            String Hql = " from "+object+" ";
            Query query = session.createQuery(Hql);
            list = query.list();
            transaction.commit();
        }catch (Exception e){
            e.getMessage();
            transaction.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<Object> findAllByPara(String sql, Object object) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Object> list = new ArrayList<Object>();
        try{
            Query query = session.createQuery(sql);
            list = query.list();
            transaction.commit();
        }catch (Exception e){
            e.getMessage();
            transaction.rollback();
        }finally {
            session.close();
        }
        return list;
    }




}
