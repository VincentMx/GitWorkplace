package com.lix.dao.Impl;

import com.boyang.core.mapper.UserRowMapper;
import com.lix.dao.XtCsDao;
import com.lix.entity.XtCs;
import com.lix.entity.vo.XtCsVO;
import com.lix.util.Page;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lix
 * @desc :
 * @time : 14:512017/12/27
 * @modify by :
 */
@Component("xtCsDao")
public class XtCsDaoImpl implements XtCsDao {


    private Session session;
    private Transaction transaction;

    private  JdbcTemplate jdbcTemplateXxxt;

    public JdbcTemplate getJdbcTemplateXxxt() {
        return jdbcTemplateXxxt;
    }

    public void setJdbcTemplateXxxt(JdbcTemplate jdbcTemplateXxxt) {
        this.jdbcTemplateXxxt = jdbcTemplateXxxt;
    }

    @Resource
    private SessionFactory sessionFactory;



    @Override
    public void add(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public Object getById(String id, Object o) {
        return null;
    }

    @Override
    public List<Object> findAll(Object object) {
        return null;
    }

    @Override
    public List<Object> findAllByPara(String sql, Object object) {
        return null;
    }


    @Override
    public Page getAllXtCsWithPage(XtCsVO xtCsVO, Page page) {

        String Sql = "from XtCs  where 1 = 1";
        if(!StringUtils.isEmpty(xtCsVO.getName())){
            Sql += " and name like '%"+ xtCsVO.getName() +"%'  ";
        }
        if(!StringUtils.isEmpty(xtCsVO.getTypecode())){
            Sql += " and typecode = '"+ xtCsVO.getTypecode() +"'  ";
        }
        if(!StringUtils.isEmpty(xtCsVO.getValue())){
            Sql += " and value like '%"+ xtCsVO.getValue() +"%' ";
        }
        if(!StringUtils.isEmpty(xtCsVO.getStartTime())){
            Sql += " and creattime > '"+ xtCsVO.getStartTime() +"' ";
        }
        if(!StringUtils.isEmpty(xtCsVO.getEndTime())){
            Sql += " and creattime < '"+ xtCsVO.getEndTime() +"' ";
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
    public List<XtCsVO> findAllXtCsByPara(XtCsVO xtCsVO) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<XtCsVO> list = new ArrayList<XtCsVO>();
        String Sql =  "  from XtCs where yxzt = '1' ";
        if(!StringUtils.isEmpty(xtCsVO.getName())){
            Sql += " and a.name like '%"+ xtCsVO.getName() +"%'  ";
        }
        if(!StringUtils.isEmpty(xtCsVO.getTypecode())){
            Sql += " and a.typecode = '"+ xtCsVO.getTypecode() +"'  ";
        }
        if(!StringUtils.isEmpty(xtCsVO.getValue())){
            Sql += " and value like '%"+ xtCsVO.getValue() +"%' ";
        }
        if(!StringUtils.isEmpty(xtCsVO.getStartTime())){
            Sql += " and creattime > '"+ xtCsVO.getStartTime() +"' ";
        }
        if(!StringUtils.isEmpty(xtCsVO.getEndTime())){
            Sql += " and creattime < '"+ xtCsVO.getEndTime() +"' ";
        }

        try{
            Query query = session.createQuery(Sql);
            list = query.list();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }


        return list;
    }

    @Override
    public XtCsVO getXtCsVoBySkey(String skey) {
        XtCsVO xtCsVO = new XtCsVO();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql =  " from XtCs where yxzt = '1'";
        Hql += " and skey = '"+skey+"'  ";
        try{
            Query query = session.createQuery(Hql);
            xtCsVO = (XtCsVO) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return xtCsVO;
    }

    @Override
    public XtCs getXtCsBySkey(String skey) {
        XtCs xtCs = new XtCs();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql =  " from XtCs  where yxzt = '1' and skey = '"+skey+"'";
        try{
            Query query = session.createQuery(Hql);
            xtCs = (XtCs) query.getSingleResult();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return xtCs;
    }

    @Override
    public void saveOrUpdateXtCs(XtCs xtCs, String type) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            if ("save".equals(type)){
                session.save(xtCs);
            }else if("update".equals(type)){
                session.update(xtCs);
            }
            transaction.commit();
            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteXtCs(XtCs xtCs) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(xtCs);
            transaction.commit();
            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }
}
