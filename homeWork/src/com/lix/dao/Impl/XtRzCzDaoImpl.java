package com.lix.dao.Impl;

import com.boyang.core.util.StringUtils;
import com.lix.dao.XtRzCzDao;
import com.lix.entity.XtRzCz;
import com.lix.entity.vo.XtRzCzVO;
import com.lix.util.Page;
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
 * @time : 14:452017/12/16
 * @modify by :
 */

@Component("xtRzCzDao")
public class XtRzCzDaoImpl implements XtRzCzDao {

    private Session session;
    private Transaction transaction;

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void addXtCzRz(XtRzCz xtRzCz) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.save(xtRzCz);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
             transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void DeleteXtRzCz(XtRzCz xtRzCz) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try{
            session.delete(xtRzCz);
            transaction.commit();
//            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public List<XtRzCzVO> findAllXtRzCz(XtRzCzVO xtRzCzVO) {
        List<XtRzCzVO> list  = new ArrayList<XtRzCzVO>();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        String Hal = "from XtRzCz ";
        try{
             Query query =  session.createQuery(Hal);
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
    public XtRzCz getXtRzCzByParams(XtRzCzVO xtRzCzVO) {
        XtRzCz xtRzCz = new XtRzCz();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        StringBuffer Hal = new StringBuffer("from XtRzCz WHERE yxzt = '1' ");
        if(!StringUtils.isEmpty(xtRzCzVO.getSkey())){
            Hal.append(" and skey = "+xtRzCzVO.getSkey()+"  ");
        }
        if(!StringUtils.isEmpty(xtRzCzVO.getUserId())){
            Hal.append(" and user_id = "+xtRzCzVO.getUserId()+"  ");
        }
        try{
            Query query =  session.createQuery(Hal.toString());
            xtRzCz = (XtRzCz) query.getSingleResult();
            transaction.commit();
            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return xtRzCz;
    }

    @Override
    public XtRzCz getXtRzCzByPara(XtRzCz xtRzCz) {
        XtRzCz xtRzCz1 = new XtRzCz();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        StringBuffer Hal = new StringBuffer("from XtRzCz WHERE yxzt = '1' ");
        if(!StringUtils.isEmpty(xtRzCz.getSkey())){
            Hal.append(" and skey = '"+xtRzCz.getSkey()+"'  ");
        }
        if(!StringUtils.isEmpty(xtRzCz.getUserId())){
            Hal.append(" and user_id = '"+xtRzCz.getUserId()+"'  ");
        }
        try{
            Query query =  session.createQuery(Hal.toString());
            xtRzCz1 = (XtRzCz) query.getSingleResult();
            transaction.commit();
//            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return xtRzCz1;
    }

    @Override
    public Page getAllXtCzRzByParam(XtRzCzVO xtRzCzVO, Page page) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        StringBuffer Hal = new StringBuffer("from XtRzCz where yxzt = '1'  ");
        if(!StringUtils.isEmpty(xtRzCzVO.getUnitKey())){
            Hal.append(" and unitKey like '" + SysUnitUtil.getRightDome(xtRzCzVO.getUnitKey()) + "%'   ");
        }
        if(!StringUtils.isEmpty(xtRzCzVO.getOperateType())){
            Hal.append(" and operateType = '" + xtRzCzVO.getOperateType() + "'  ");
        }
        if(!StringUtils.isEmpty(xtRzCzVO.getOperateName())){
            Hal.append(" and operateName like '%" + xtRzCzVO.getOperateName() + "%'  ");
        }
        if(!StringUtils.isEmpty(xtRzCzVO.getOperateCondition())){
            Hal.append(" and operateCondition like '%" + xtRzCzVO.getOperateCondition() + "%'  ");
        }
        if(!StringUtils.isEmpty(xtRzCzVO.getUserId())){
            Hal.append(" and userId = '" + xtRzCzVO.getUserId() + "'  ");
        }
        if(!StringUtils.isEmpty(xtRzCzVO.getUserName())){
            Hal.append(" and userName like '%" + xtRzCzVO.getUserName() +  "%' ");
        }
        if(!StringUtils.isEmpty(xtRzCzVO.getStartTime())){
            Hal.append("  and operateTime > '" + xtRzCzVO.getStartTime()  + "'  ");
        }
        if(!StringUtils.isEmpty(xtRzCzVO.getEndTime())){
            Hal.append("  and operateTime < '"  + xtRzCzVO.getEndTime() +  "'   ");
        }
        Hal.append(" order by operateTime desc  ");
        try{
            Query query =  session.createQuery(Hal.toString());
            page.setTotalCount(query.list().size());
            query.setMaxResults(page.getPageSize());
            query.setFirstResult(page.getStart());
            page.setData(query.list());
            transaction.commit();
//            session.flush();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return page;
    }
}
