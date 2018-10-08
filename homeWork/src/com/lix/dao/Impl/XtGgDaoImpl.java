package com.lix.dao.Impl;

import cn.lix.constants.Constants;
import com.lix.dao.XtGgDao;
import com.lix.entity.XtGg;
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
 * @desc :系统公告数据操作层
 * @time : 15:062018/9/27
 * @modify by :
 */
@Component("xtGgDao")
public class XtGgDaoImpl implements XtGgDao {


    private Session session;
    private Transaction transaction;

    @Resource
    private SessionFactory sessionFactory;



    @Override
    public void save(XtGg xtGg) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(xtGg);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void update(XtGg xtGg) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(xtGg);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(XtGg xtGg) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(xtGg);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public XtGg findById(XtGg xtGg) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        XtGg xtGg1 = new XtGg();
        try{
            String Hql = "   from XtGg  where skey = '"+ xtGg.getSkey() +"'";
            Query query = session.createQuery(Hql);
            xtGg1 = (XtGg) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }

        return xtGg1;
    }

    @Override
    public Page findWithPage(Page page, XtGg xtGg) {
        List<XtGg> list = new ArrayList<XtGg>();
        List<XtGg> countList = new ArrayList<XtGg>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from XtGg t where 1 = 1  ";
        if(!StringUtils.isEmpty(xtGg.getFlag())){
            Hql += " and   t.flag = '" +  xtGg.getFlag()  + "' ";
        }

        if(!StringUtils.isEmpty(xtGg.getGgbt())){
            Hql += " and t.ggbt like '%" +  xtGg.getGgbt()  + "%' ";
        }

        if(!StringUtils.isEmpty(xtGg.getGgnr())){
            Hql += " and t.ggnr like '%" +  xtGg.getGgnr()  + "%' ";
        }

        Hql += "order by t.fbsj desc ";
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
    public List<XtGg> findAllXtGg(XtGg xtGg) {
        List<XtGg> list = new ArrayList<XtGg>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "  from XtGg t where t.flag != '" + Constants.XT_GG_SC + "' ";

        if(!StringUtils.isEmpty(xtGg.getGgbt())){
            Hql += " and t.ggbt like '%"  + xtGg.getGgbt() + "%'  ";
        }

        if(!StringUtils.isEmpty(xtGg.getGgnr())){
            Hql += " and t.ggnr like '%"  + xtGg.getGgnr() + "%'  ";
        }
        Hql += "order by t.fbsj desc";
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
    public List<XtGg> fingLimitXtggxx(XtGg xtGg , int size) {

        List<XtGg> list = new ArrayList<XtGg>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "from XtGg t where t.flag = '" + Constants.XT_GG_FB + "' ";

        if(!StringUtils.isEmpty(xtGg.getGgbt())){
            Hql += " and t.ggbt like '%"  + xtGg.getGgbt() + "%'  ";
        }

        if(!StringUtils.isEmpty(xtGg.getGgnr())){
            Hql += " and t.ggnr like '%"  + xtGg.getGgnr() + "%'  ";
        }

        Hql += "order by t.fbsj desc";
        try{
            Query query = session.createQuery(Hql);
            query.setMaxResults(size);
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
}
