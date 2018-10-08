package com.lix.dao.Impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtYhWxDao;
import com.lix.entity.XtYhWx;
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
 * @time : 0:042018/9/7
 * @modify by :
 */
@Component("xtYhWxDao")
public class XtYhWxDaoImpl  implements XtYhWxDao {

    private Session session;
    private Transaction transaction;
    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void save(XtYhWx xtYhWx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(xtYhWx);
            transaction.commit();
           // session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void update(XtYhWx xtYhWx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(xtYhWx);
            transaction.commit();
//            session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(XtYhWx xtYhWx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(xtYhWx);
            transaction.commit();
//            session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public XtYhWx findById(XtYhWx xtYhWx) {
       XtYhWx xtYhWx1 = new XtYhWx();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            xtYhWx1 = (XtYhWx) session.byId(xtYhWx.getSkey());
            transaction.commit();
//            session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }

        return xtYhWx1;
    }

    @Override
    public List<XtYhWx> findAll(XtYhWx xtYhWx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<XtYhWx> xtYhWxList = new ArrayList<XtYhWx>();
        String Hql = "from XtYhWx t where   t.bz1 = '" + Constants.XT_YH_WX_YX + "'";
        if(!StringUtils.isEmpty(xtYhWx.getBz2())){
            Hql +="  and t.bz2 = '" + xtYhWx.getBz2() + "' ";
        }

        if(!StringUtils.isEmpty(xtYhWx.getBz3())){
            Hql +="  and t.bz3 = '" + xtYhWx.getBz3() + "' ";
        }

        try{
            Query query = session.createQuery(Hql);
            xtYhWxList = query.list();
            transaction.commit();
            session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }

        return xtYhWxList;
    }

    @Override
    public XtYhWx findByOpenId(XtYhWx xtYhWx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        XtYhWx xtYhWx1 = new XtYhWx();
        String Hql = "from XtYhWx t where t.openid = '" + xtYhWx.getOpenid() + "' and t.bz1 = '" + Constants.XT_YH_WX_YX + "'";
        try{
           Query query = session.createQuery(Hql);
           xtYhWx1 = (XtYhWx) query.getSingleResult();
            transaction.commit();
            //session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }

        return xtYhWx1;
    }
}
