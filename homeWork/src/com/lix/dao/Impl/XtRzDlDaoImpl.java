package com.lix.dao.Impl;

import com.boyang.core.util.StringUtils;
import com.lix.dao.XtRzDlDao;
import com.lix.entity.XtRzDl;
import com.lix.entity.vo.XtDlRzVO;
import com.lix.util.Page;
import com.lix.service.impl.queryWithPage;
import com.lix.util.SysUnitUtil;
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
 * @time : 13:292017/12/13
 * @modify by :
 */
@Component("xtRzDlDao")
public class XtRzDlDaoImpl implements XtRzDlDao {

    private Session session;
    private Transaction transaction;

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void addYhDlRz(XtRzDl xtRzDl) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(xtRzDl);
            transaction.commit();
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }

    }

    @Override
    public void deleteYhDlRz(XtRzDl xtRzDl) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(xtRzDl);
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
    public List<XtDlRzVO> getAllYhDlRz(XtDlRzVO xtDlRzVO) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "from XtRzDl  where yxzt = '1' ";
        List<XtDlRzVO> list = new ArrayList<XtDlRzVO>();

        if(!StringUtils.isEmpty(xtDlRzVO.getSkey())){
            Hql += " and skey = "+xtDlRzVO.getSkey()+" ";
        }
        if(!StringUtils.isEmpty(xtDlRzVO.getUserId())){
            Hql += " and userId = "+xtDlRzVO.getUserId()+" ";
        }
        try{
            Query query = session.createQuery(Hql);
            list = query.list();
            transaction.commit();
            session.flush();
        }catch (Exception e){
            e.getMessage();
            transaction.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public XtRzDl getXtGlRzByParam(XtRzDl xtRzDl) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = "from XtRzDl where yxzt = '1' ";
        if(!StringUtils.isEmpty(xtRzDl.getSkey())){
            Hql += " and skey = '"+xtRzDl.getSkey()+"' ";
        }
        if(!StringUtils.isEmpty(xtRzDl.getUserId())){
            Hql += " and userId = '"+xtRzDl.getUserId()+"' ";
        }
        if(!StringUtils.isEmpty(xtRzDl.getIpAddress())){
            Hql += " and ipAddress like '" + xtRzDl.getIpAddress() +  "'  ";
        }
        if(!StringUtils.isEmpty(xtRzDl.getLoginTime())){
            Hql += " and loginTime = '" + xtRzDl.getLoginTime() +  "'   ";
        }

        XtRzDl xtRzDl1 = new XtRzDl();
//        XtDlRzVO xtDlRzVO = new XtDlRzVO();
        try{
            Query query = session.createQuery(Hql);
//            xtDlRzVO = (XtDlRzVO)query.getSingleResult();
           xtRzDl1 = (XtRzDl)query.getSingleResult();
            transaction.commit();
            session.flush();
        }catch (Exception e){
            e.getMessage();
            transaction.rollback();
        }finally {
            session.close();
        }
        return xtRzDl1;
    }

    @Override
    public Page getAllXtRzDlByParam(XtDlRzVO xtDlRzVO, Page page) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hql = " from XtRzDl  where yxzt = '1' ";
        List<XtDlRzVO> list = new ArrayList<XtDlRzVO>();
        List<XtDlRzVO> countList = new ArrayList<XtDlRzVO>();
        if(!StringUtils.isEmpty(xtDlRzVO.getUnitKey())){
            Hql += " and unitKey like '"+ SysUnitUtil.getRightDome(xtDlRzVO.getUnitKey()) +"%' ";
        }
        if(!StringUtils.isEmpty(xtDlRzVO.getSkey())){
            Hql += " and skey = '"+xtDlRzVO.getSkey()+"' ";
        }
        if(!StringUtils.isEmpty(xtDlRzVO.getUserId())){
            Hql += " and userId = '"+xtDlRzVO.getUserId()+"' ";
        }
        if(!StringUtils.isEmpty(xtDlRzVO.getUserName())){
            Hql += " and userName like '%"+xtDlRzVO.getUserName()+"%' ";
        }
        if(!StringUtils.isEmpty(xtDlRzVO.getIpAddress())){
            Hql += " and ipAddress like '%"+xtDlRzVO.getIpAddress()+"%' ";
        }
        if(!StringUtils.isEmpty(xtDlRzVO.getStartTime())){
            Hql += " and loginTime >  '"+xtDlRzVO.getStartTime()+"' ";
        }
        if(!StringUtils.isEmpty(xtDlRzVO.getEndTime())){
            Hql += " and loginTime <  '"+xtDlRzVO.getEndTime()+"' ";
        }
        Hql += " order by loginTime desc  ";
        try{
            Query query = session.createQuery(Hql);
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
}
