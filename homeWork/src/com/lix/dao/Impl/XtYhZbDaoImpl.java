package com.lix.dao.Impl;

import com.lix.dao.XtYhZbDao;
import com.lix.entity.XtYhZb;
import com.lix.entity.vo.XtYhZbVO;
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
 * @desc : 账本数据操作信息
 * @time : 15:022018/10/3
 * @modify by :
 */
@Component("xtZbDao")
public class XtYhZbDaoImpl implements XtYhZbDao {


    private Session session;
    private Transaction transaction;
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(XtYhZb xtYhZb) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(xtYhZb);
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
    public void update(XtYhZb xtYhZb) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.update(xtYhZb);
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
    public void delete(XtYhZb xtYhZb) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(xtYhZb);
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
    public XtYhZb findById(XtYhZb xtYhZb) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        XtYhZb xtYhZb1 = new XtYhZb();
        try{
            String Hql = "  from XtYhZb t where t.skey = '" + xtYhZb.getSkey() + "'";
            Query query = session.createQuery(Hql);
            xtYhZb1 = (XtYhZb) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return xtYhZb1;
    }

    @Override
    public Page findYhZbWithPage(Page page, XtYhZbVO xtYhZb) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        StringBuffer Hql = new StringBuffer(" from XtYhZb  where 1 = 1 ");
        List<XtYhZbVO> list = new ArrayList<XtYhZbVO>();
        List<XtYhZbVO> countList = new ArrayList<XtYhZbVO>();
        try{
        if(!com.boyang.core.util.StringUtils.isEmpty(xtYhZb.getSkey())){
            Hql.append(" and skey = '"+xtYhZb.getSkey()+"' ");
        }
        if(!com.boyang.core.util.StringUtils.isEmpty(xtYhZb.getYhskey())){
            Hql.append(" and yhskey = '"+xtYhZb.getYhskey()+"' ");
        }
      /*  if( xtYhZb.getZxje() != 0.0 ){
            Hql.append(" and xfje > '"+xtYhZb.getZxje()+"' ");
        }
        if(xtYhZb.getZdje() != 0.0){
            Hql.append(" and xfje < '"+xtYhZb.getZdje()+"' ");
        }*/
        if(!com.boyang.core.util.StringUtils.isEmpty(xtYhZb.getXfdd())){
            Hql.append(" and xfdd like '%"+xtYhZb.getXfdd()+"%' ");
        }
        if(!com.boyang.core.util.StringUtils.isEmpty(xtYhZb.getStartTime())){
            Hql.append(" and xfsj >  '"+xtYhZb.getStartTime()+"' ");
        }
        if(!com.boyang.core.util.StringUtils.isEmpty(xtYhZb.getEndTime())){
            Hql.append(" and xfsj <  '"+xtYhZb.getEndTime()+"' ");
        }
        Hql.append(" order by xfsj desc  ");

            Query query = session.createQuery(Hql.toString());
            countList = query.list();
            query.setFirstResult(page.getStart());
            query.setMaxResults(page.getPageSize());
            list = query.list();
            page.setTotalCount(countList.size());
            page.setList(list);
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
    public List<XtYhZbVO> findByParam(XtYhZbVO xtYhZb) {
        List<XtYhZbVO> list = new ArrayList<XtYhZbVO>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        StringBuffer Hql = new StringBuffer(" from XtYhZb  where yxzt = '1' ");
        if(xtYhZb.getZxje() != 0 ){
            Hql.append(" and xfje > '"+xtYhZb.getZxje()+"' ");
        }
        if(xtYhZb.getZdje() != 0){
            Hql.append(" and xfje < '"+xtYhZb.getZdje()+"' ");
        }
        if(!com.boyang.core.util.StringUtils.isEmpty(xtYhZb.getXfdd())){
            Hql.append(" and xfdd like '%"+xtYhZb.getXfdd()+"%' ");
        }
        if(!com.boyang.core.util.StringUtils.isEmpty(xtYhZb.getStartTime())){
            Hql.append(" and xfsj >  '"+xtYhZb.getStartTime()+"' ");
        }
        if(!com.boyang.core.util.StringUtils.isEmpty(xtYhZb.getEndTime())){
            Hql.append(" and xfsj <  '"+xtYhZb.getEndTime()+"' ");
        }
        Hql.append(" order by xfsj desc  ");

        try{
            Query query = session.createQuery(Hql.toString());
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
    public XtYhZb findByParams(XtYhZbVO xtYhZb) {

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        XtYhZb xtYhZb1 = new XtYhZb();
        String Hql = "  from XtYhZb t where t.skey = '" + xtYhZb.getSkey() + "'";
        if(!StringUtils.isEmpty(xtYhZb.getYhskey())){
            Hql += "  and  t.yhskey = '" + xtYhZb.getYhskey() + "' ";
        }

        try{
            Query query = session.createQuery(Hql);
            xtYhZb1 = (XtYhZb) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return xtYhZb1;
    }
}
