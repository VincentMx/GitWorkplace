package com.lix.dao.Impl.orderImpl;

import com.lix.dao.order.orderDao;
import com.lix.entity.XtTcDdXx;
import com.lix.util.Page;
import org.apache.commons.lang.StringUtils;
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
 * @time : 14:212018/9/20
 * @modify by :
 */
public class orderDaoImpl implements orderDao {

    private Session session;
    private Transaction transaction;

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void save(XtTcDdXx xtTcDdXx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(xtTcDdXx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(XtTcDdXx xtTcDdXx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(xtTcDdXx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void update(XtTcDdXx xtTcDdXx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(xtTcDdXx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public List<XtTcDdXx> findAll(XtTcDdXx xtTcDdXx) {
        List<XtTcDdXx> list = new ArrayList<XtTcDdXx>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from XtTcDdXx where 1 = 1 ";
        if (!StringUtils.isEmpty(xtTcDdXx.getJylsh())){
            Hql += "  and t.jylsh = '" + xtTcDdXx.getJylsh() +  "' ";
        }
        if (!StringUtils.isEmpty(xtTcDdXx.getOrderNo())){
            Hql += "  and t.orderNo = '" + xtTcDdXx.getOrderNo() +  "' ";
        }
        if (!StringUtils.isEmpty(xtTcDdXx.getJfHh())){
            Hql += "  and t.jfHh = '" + xtTcDdXx.getJfHh() +  "' ";
        }
        if (!StringUtils.isEmpty(xtTcDdXx.getJfShbh())){
            Hql += "  and t.jfShbh = '" + xtTcDdXx.getJfShbh() +  "' ";
        }
        if (!StringUtils.isEmpty(xtTcDdXx.getDdzt())){
            Hql += "  and t.ddzt = '" + xtTcDdXx.getDdzt() +  "' ";
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
    public XtTcDdXx findById(XtTcDdXx xtTcDdXx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        XtTcDdXx xtTcDdXx1 = new XtTcDdXx();
        try{
            String Hql = "   from XtTcDdXx  where orderNo = '"+ xtTcDdXx.getOrderNo() +"'";
            Query query = session.createQuery(Hql);
            xtTcDdXx1 = (XtTcDdXx) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }

        return xtTcDdXx1;
    }

    @Override
    public XtTcDdXx findByParam(XtTcDdXx xtTcDdXx) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        XtTcDdXx xtTcDdXx1 = new XtTcDdXx();
        String Hql = "   from XtTcDdXx t where  1 = 1";
        if (!StringUtils.isEmpty(xtTcDdXx.getJylsh())){
            Hql += "  and t.jylsh = '" + xtTcDdXx.getJylsh() +  "' ";
        }
        if (!StringUtils.isEmpty(xtTcDdXx.getOrderNo())){
            Hql += "  and t.orderNo = '" + xtTcDdXx.getOrderNo() +  "' ";
        }

        try{
            Query query = session.createQuery(Hql);
            xtTcDdXx1 = (XtTcDdXx) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }

        return xtTcDdXx1;
    }

    @Override
    public Page findAllWithPage(Page page, XtTcDdXx xtTcDdXx) {
        List<XtTcDdXx> list = new ArrayList<XtTcDdXx>();
        List<XtTcDdXx> countList = new ArrayList<XtTcDdXx>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from XtTcDdXx where 1 = 1  ";
        if (!StringUtils.isEmpty(xtTcDdXx.getJylsh())){
            Hql += "  and t.jylsh = '" + xtTcDdXx.getJylsh() +  "' ";
        }
        if (!StringUtils.isEmpty(xtTcDdXx.getOrderNo())){
            Hql += "  and t.orderNo = '" + xtTcDdXx.getOrderNo() +  "' ";
        }
        if (!StringUtils.isEmpty(xtTcDdXx.getJfHh())){
            Hql += "  and t.jfHh = '" + xtTcDdXx.getJfHh() +  "' ";
        }
        if (!StringUtils.isEmpty(xtTcDdXx.getJfShbh())){
            Hql += "  and t.jfShbh = '" + xtTcDdXx.getJfShbh() +  "' ";
        }
        if (!StringUtils.isEmpty(xtTcDdXx.getDdzt())){
            Hql += "  and t.ddzt = '" + xtTcDdXx.getDdzt() +  "' ";
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


}
