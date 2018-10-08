package com.lix.dao.Impl;

import com.lix.dao.XtYhDao;
import com.lix.entity.Xt_yh;
import com.lix.entity.vo.XtYhVO;
import com.lix.util.Page;
import com.lix.util.SysUnitUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 23:292017/11/29
 * @modify by :
 */
@Component("xtYhDao")
public class XtYhDaoImpl implements XtYhDao {

    private Session session;
    private Transaction transaction;
    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void saveYhInfo(Xt_yh xt_yh) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(xt_yh);
            transaction.commit();
            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Xt_yh> findAllXtYh(Xt_yh xt_yh) {
        List<Xt_yh> list = new ArrayList<Xt_yh>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = " from Xt_yh  ";
        try {
            Query query = session.createQuery(Hql);
            list = query.list();
            transaction.commit();
            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public void updateXtYhInfo(Xt_yh xt_yh) {
         session = sessionFactory.openSession();
         transaction = session.beginTransaction();
         try{
             session.update(xt_yh);
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
    public Xt_yh findYhInfoById(String skey) {
        Xt_yh xt_yh = new Xt_yh();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            String Hql = " from Xt_yh where skey = '"+skey+"'  ";
            Query query = session.createQuery(Hql);
            xt_yh = (Xt_yh) query.getSingleResult();
            transaction.commit();
//            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return xt_yh;
    }

    @Override
    public Xt_yh findXtYhByPara(Xt_yh xt_yh) {
        Xt_yh xt_yh1 = new Xt_yh();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            String Hql = " from Xt_yh  where flag = '1' ";
            if (!StringUtils.isEmpty(xt_yh.getId())  ){
                Hql += "  and id = '"+xt_yh.getId()+"'  ";
            }
            if (!StringUtils.isEmpty(xt_yh.getPassword())){
                Hql += " and password = '"+xt_yh.getPassword()+"' ";
            }
            if (!StringUtils.isEmpty(xt_yh.getName())){
                Hql += " and name = '"+xt_yh.getName()+"'  ";
            }

            Hql += " order by regtime desc  ";
            Query query = session.createQuery(Hql);
             List<String> list =  query.list();
            if(list.size()  > 0 ){
                xt_yh1 = (Xt_yh) query.getSingleResult();
            }else{
                xt_yh1 = null;
            }

            transaction.commit();
//            session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return xt_yh1;
    }

    @Override
    public void deleteXtYh(Xt_yh xt_yh) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(xt_yh);
            transaction.commit();
            session.flush();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public Page getAllXtYh(Page page, XtYhVO xtYhVO) {

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        StringBuffer Hql = new StringBuffer( "  from Xt_yh where flag = '1' ");
        if(!StringUtils.isEmpty(xtYhVO.getUnit())){
            Hql.append(" and   unit like '" + SysUnitUtil.getRightDome(xtYhVO.getUnit()) +  "%'  ");
        }
        if(!StringUtils.isEmpty(xtYhVO.getName())){
            Hql.append(" and   name like '%" + xtYhVO.getName() +  "%'  ");
        }
        if(!StringUtils.isEmpty(xtYhVO.getPhone())){
            Hql.append(" and   phone like '%" + xtYhVO.getPhone() +  "%'  ");
        }
        if(!StringUtils.isEmpty(xtYhVO.getAddress())){
            Hql.append(" and   address like '%" + xtYhVO.getAddress() +  "%'  ");
        }
        if(!StringUtils.isEmpty(xtYhVO.getEmail())){
            Hql.append(" and   email like '%" + xtYhVO.getEmail() +  "%'  ");
        }
        if(!StringUtils.isEmpty(xtYhVO.getLastip())){
            Hql.append(" and   lastip like '%" + xtYhVO.getLastip() +  "%'  ");
        }
        if(!StringUtils.isEmpty(xtYhVO.getBz())){
            Hql.append(" and   lastip like '%" + xtYhVO.getBz() +  "%'  ");
        }
        if(!StringUtils.isEmpty(xtYhVO.getStartTime())){
            Hql.append(" and   regtime > '" + xtYhVO.getStartTime() +  "'  ");
        }
        if(!StringUtils.isEmpty(xtYhVO.getEndTime())){
            Hql.append(" and   regtime < '" + xtYhVO.getEndTime() +  "'  ");
        }
        Hql.append(" order by regtime desc  ");
        try {
            Query query = session.createQuery(Hql.toString());
            page.setTotalCount(query.list().size());
            query.setFirstResult(page.getStart());
            query.setMaxResults(page.getPageSize());
            page.setData(query.list());
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return page;
    }

    @Override
    public Xt_yh findById(String id, String unit) {
        Xt_yh xt_yh = new Xt_yh();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            String Hql = "  from Xt_yh where flag = '1' ";
            if(!StringUtils.isEmpty(unit)){
                Hql += " and   unit like '" + SysUnitUtil.getRightDome(unit) +  "%'  ";
            }
            if (!StringUtils.isEmpty(id)){
                Hql += " and id = '" + id +  "' ";
            }
             Query query = session.createQuery(Hql);
            xt_yh = (Xt_yh) query.getSingleResult();
            transaction.commit();
//            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return xt_yh;
    }
}
