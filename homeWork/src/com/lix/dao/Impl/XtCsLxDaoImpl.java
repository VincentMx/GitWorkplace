package com.lix.dao.Impl;

import com.boyang.core.mapper.UserRowMapper;
import com.lix.dao.XtCsDao;
import com.lix.dao.XtCsLxDao;
import com.lix.entity.XtCsLx;
import com.lix.entity.vo.XtCsLxVO;
import com.lix.entity.vo.XtCsVO;
import com.lix.util.Page;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 14:512017/12/27
 * @modify by :
 *
 */
@Component("xtCsLxDao")
public class XtCsLxDaoImpl implements XtCsLxDao {


    private Session session;
    private Transaction transaction;
    @Resource
    private SessionFactory sessionFactory;



    @Override
    public Page getAllXtCsWithPage(XtCsLxVO xtCsLxVO, Page page) {

        String Sql = "from XtCsLx where yxzt = '1' ";
        if(!StringUtils.isEmpty(xtCsLxVO.getName())){
            Sql += " and name like '%"+ xtCsLxVO.getName() +"%'  ";
        }
        if(!StringUtils.isEmpty(xtCsLxVO.getCode())){
            Sql += " and code like '%"+ xtCsLxVO.getCode() +"%'  ";
        }
        if(!StringUtils.isEmpty(xtCsLxVO.getDescr())){
            Sql += " and descr like '%"+ xtCsLxVO.getDescr() +"%' ";
        }
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(Sql);
            page.setTotalCount(query.list().size());
            query.setFirstResult(page.getStart());
            query.setMaxResults(page.getPageSize());
            page.setData(query.list());
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
    public List<XtCsLx> findAllXtCsLx(XtCsLxVO xtCsLxVO) {
        List<XtCsLx> list = new ArrayList<XtCsLx>();
        String Hql =  " from XtCsLx where 1 = 1";
        if(!StringUtils.isEmpty(xtCsLxVO.getName())){
            Hql += " and name like '%"+ xtCsLxVO.getName() +"%'  ";
        }
        if(!StringUtils.isEmpty(xtCsLxVO.getCode())){
            Hql += " and code = '"+ xtCsLxVO.getCode() +"'  ";
        }
        if(!StringUtils.isEmpty(xtCsLxVO.getDescr())){
            Hql += " and descr like '%"+ xtCsLxVO.getDescr() +"%' ";
        }
        if(StringUtils.isEmpty(xtCsLxVO.getYxzt())){
            Hql += " and yxzt = '1'  ";
        }else{
            Hql += " and yxzt = '" + xtCsLxVO.getYxzt()  +  "'  ";
        }

        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(Hql);
            list = query.list();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }

        return list;
    }

    @Override
    public XtCsLx getXtCsLxBySkey(String skey) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        XtCsLx xtCsLx = new XtCsLx();
        String Hql = " from XtCsLx  WHERE yxzt = '1'";
        if(!StringUtils.isEmpty(skey)){
            Hql += " and skey = '" + skey +  "'  ";
        }
        try{
            Query query = session.createQuery(Hql);
           xtCsLx = (XtCsLx) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return xtCsLx;
    }

    @Override
    public void deleteXtCsLx(XtCsLx xtCsLx) {
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(xtCsLx);
            transaction.commit();
            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void saveXtCsLx(XtCsLx xtCsLx) {
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
           session.save(xtCsLx);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateXtCsLx(XtCsLx xtCsLx) {
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
           session.update(xtCsLx);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public XtCsLx getXtCsLxByPara(XtCsLxVO xtCsLxVO) {
        XtCsLx xtCsLx = new XtCsLx();
        String Hql = " from XtCsLx  WHERE yxzt = '1'";
        if(!StringUtils.isEmpty(xtCsLxVO.getSkey())){
            Hql += " and skey = '" + xtCsLxVO.getSkey() +  "'  ";
        }
        if(!StringUtils.isEmpty(xtCsLxVO.getName())){
            Hql += " and name like '%" + xtCsLxVO.getName() +  "%'  ";
        }
        if(!StringUtils.isEmpty(xtCsLxVO.getCode())){
            Hql += " and code = '" + xtCsLxVO.getCode() + "'  ";
        }
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(Hql);
            xtCsLx = (XtCsLx) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return xtCsLx;
    }
}
